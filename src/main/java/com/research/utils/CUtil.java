package com.research.utils;

import com.research.constant.WebConstant;
import com.research.exception.TipException;
import com.research.model.Vo.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CUtil {
    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 返回当前登录用户
     *
     * @return
     */
    public static User getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (User) session.getAttribute(WebConstant.USER_SESSION_KEY);
    }

    /**
     * 返回当前登录用户
     *
     * @return
     */
    public static Integer getToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return -1;
        }
        User user =  (User) session.getAttribute(WebConstant.USER_SESSION_KEY);
        if(user == null){
            return -1;
        }
        return user.getId();
    }

    public static void setLoginUser(User user,HttpServletRequest request){
        request.getSession().setAttribute(WebConstant.USER_SESSION_KEY,user);
    }

    public static void logout(HttpServletRequest request){
        request.getSession().removeAttribute(WebConstant.USER_SESSION_KEY);
    }

    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static Date getTime(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(time);
        }catch (ParseException pe){
            throw new TipException("请输入正确的日期格式");
        }
        return date;
    }

    public static String getUserFileUrl(HttpServletRequest request){
        String uDir = "1234";
        if(request !=null){
            User user = getLoginUser(request);
            uDir=user==null?uDir:user.getAccount();
        }
        return WebConstant.FILE_LOCATIONS+File.separator+uDir;
    }

    /**
     * 中检材料保存路径
     * @param request
     * @return
     */
    public static String getInspUrl(HttpServletRequest request){
        String uDir = "1234";
        if(request !=null){
            User user = getLoginUser(request);
            uDir=user==null?uDir:user.getAccount();
        }
        return WebConstant.FILE_LOCATIONS+File.separator+uDir+"_inspection";
    }

    public static String getCloUrl(HttpServletRequest request){
        String uDir = "1234";
        if(request !=null){
            User user = getLoginUser(request);
            uDir=user==null?uDir:user.getAccount();
        }
        return WebConstant.FILE_LOCATIONS+File.separator+uDir+"_closure";
    }
}

package com.research.controlller.admin;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.ErrorException;
import com.research.exception.TipException;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.service.UserService;
import com.research.utils.CUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    InstitutionMapper IM;
    @Autowired
    OrganizationMapper OM;

    @GetMapping("list")
    public String userList(Model m, HttpServletRequest request){
        m.addAttribute("list",userMapper.selectByExample(new UserExample()));
        m.addAttribute("roleList",roleMapper.selectByExample(new RoleExample()));
        m.addAttribute("insList",IM.selectByExample(new InstitutionExample()));
        m.addAttribute("orgList",OM.selectByExample(new OrganizationExample()));
        return "admin/user/list";
    }

    @PostMapping("add")
    @ResponseBody
    public RestResponseBo add(Model m, HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        if(user == null)
            throw new TipException();
        if(!user.getRole().equals(WebConstant.ROLE_5))
            throw new TipException("权限不足");
        userService.signup(request);
        return RestResponseBo.ok();
    }

    @GetMapping("edit_page")
    public String edit_page(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null) throw new TipException();
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("user",user);
        return "admin/user/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    public RestResponseBo edit(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        String role = request.getParameter("role");
        int roleId1;
        if(role.equals(WebConstant.ROLE_5))
            roleId1=5;
        else if(role.equals(WebConstant.ROLE_4))
            roleId1=4;
        else if (role.equals(WebConstant.ROLE_3))
            roleId1=3;
        else if (role.equals(WebConstant.ROLE_2))
            roleId1=2;
        else if (role.equals(WebConstant.ROLE_1))
            roleId1=1;
        else
            roleId1=0;
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        user.setRoleId(roleId1);
        userMapper.updateByPrimaryKey(user);
        if(id==null)
            throw new TipException();
        userService.updateUser(Integer.valueOf(id),request);
        return RestResponseBo.ok();
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponseBo delete(@RequestBody JSONObject js, HttpServletRequest request){
        if(!js.containsKey("id"))
            throw new TipException();
        User user = CUtil.getLoginUser(request);
        if(user == null)
            throw new TipException();
        if(!user.getRole().equals(WebConstant.ROLE_5))
            throw new TipException("权限不足");
        String id = js.getString("id");
        userMapper.deleteByPrimaryKey(Integer.valueOf(id));
        return RestResponseBo.ok();
    }

    /**
     * 注册用户的审核列表和审核接口
     *
     * 审核不通过的用户直接删除
     * @param m
     * @param request
     * @return
     */
    @GetMapping("audit")
    public String audit(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        String audit = request.getParameter("audit");
        if(id!=null){
            User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
            if(audit.equals("yes")){
                user.setState(WebConstant.USER_STATE_1);
                userMapper.updateByPrimaryKeySelective(user);
            }else{
                userMapper.deleteByPrimaryKey(Integer.valueOf(id));
            }
        }
        UserExample ue = new UserExample();
        ue.createCriteria().andStateEqualTo(WebConstant.USER_STATE_0);
        m.addAttribute("list",userMapper.selectByExample(ue));
        return "admin/user/audit";
    }

    @GetMapping("modifyPW_page")
    public String modifyPWPage(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        if(id==null){
            return "admin/user/user_password";
        }
        m.addAttribute("user",user);
//        m.addAttribute("Userid",user.getId());
        return "admin/user/user_password";
    }

//    @GetMapping("modifyPW_page1")
//    public String modifyPWPage1(Model m,HttpServletRequest request){
//        User user = CUtil.getLoginUser(request);
//        Integer id = user.getId();
//        if(id==null){
//            return "admin/user/user_password";
//        }
//        m.addAttribute("user",user);
////        m.addAttribute("Userid",user.getId());
//        return "admin/user/user_password";
//    }
//
//    @PostMapping("modifyPW")
//    @ResponseBody
//    public RestResponseBo modifyPW(Model m,HttpServletRequest request){
//        String id = request.getParameter("Userid");
//        if(id==null){
//            throw new TipException();
//        }
//        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
//        String oldPW = request.getParameter("oldPassword");
//        if(!user.getPassword().equals(CUtil.MD5encode(oldPW))){
//            return RestResponseBo.fail("密码不正确");
//        }
//        String pw = request.getParameter("password");
//        String pw2 = request.getParameter("password2");
//        if(!pw.equals(pw2)){
//            return RestResponseBo.fail("前后密码不一致");
//        }
//        user.setPassword(CUtil.MD5encode(pw));
//        userMapper.updateByPrimaryKeySelective(user);
//        return RestResponseBo.ok();
//    }

}

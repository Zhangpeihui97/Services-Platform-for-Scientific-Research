package com.research.interceptor;

import com.research.constant.WebConstant;
import com.research.model.Vo.User;
import com.research.utils.CUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BaseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        User user = CUtil.getLoginUser(request);
        if(uri.startsWith("/login")||uri.startsWith("/signup")||uri.startsWith("/test")){
            return true;
        }

        if (uri.startsWith("/admin")) {
            if(null != user && !user.getRole().equals(WebConstant.ROLE_0)){
                return true;
            }
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        /**
         * 普通用户操作
         */
        if(user!=null){
            return true;
        }

        response.sendRedirect(request.getContextPath() + "/login");
        return false;

//        return true;
    }
}

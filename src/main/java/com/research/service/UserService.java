package com.research.service;


import com.research.model.Bo.Member;
import com.research.model.Vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    boolean login(String username, String password, HttpServletRequest request);
    boolean signup(HttpServletRequest request);
    List<User> findAllUser();
    User findUserByName(String username);
    void updateUser(Integer id,HttpServletRequest request);
    boolean checkUserInfo(User user);
}

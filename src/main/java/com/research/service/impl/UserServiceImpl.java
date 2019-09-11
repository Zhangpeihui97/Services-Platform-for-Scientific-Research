package com.research.service.impl;

import com.research.constant.WebConstant;
import com.research.dao.InstitutionUserMapper;
import com.research.dao.OrganizationUserMapper;
import com.research.dao.UserMapper;
import com.research.exception.TipException;
import com.research.model.Vo.*;
import com.research.service.UserService;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper UM;
    @Autowired
    InstitutionUserMapper IUM;
    @Autowired
    OrganizationUserMapper OUM;
    @Override
    public boolean login(String account, String password, HttpServletRequest request) {
        UserExample UE = new UserExample();
        UE.createCriteria().andAccountEqualTo(account);
        List<User> list = UM.selectByExample(UE);
        if(list.size()!=1){
            throw  new TipException("请输入正确的用户名");
        }
        User user = list.get(0);
        String pw = CUtil.MD5encode(password);
        if(!pw.equals(user.getPassword())){
            throw new TipException("请检查密码");
        }
        CUtil.setLoginUser(user,request);
        User user2 = CUtil.getLoginUser(request);
        return true;
    }

    @Override
    @Transactional
    public boolean signup(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
//        String roleId = request.getParameter("roleId");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String searchDir = request.getParameter("searchDir");
        String politics = request.getParameter("politics");
        String degree = request.getParameter("degree");
        String state = request.getParameter("state");
        String role = request.getParameter("role");
        String orgId = request.getParameter("org");
        String insId = request.getParameter("ins");

        int roleId;
        if(role.equals(WebConstant.ROLE_5))
            roleId=5;
        else if(role.equals(WebConstant.ROLE_4))
            roleId=4;
        else if (role.equals(WebConstant.ROLE_3))
            roleId=3;
        else if (role.equals(WebConstant.ROLE_2))
            roleId=2;
        else if (role.equals(WebConstant.ROLE_1))
            roleId=1;
        else
            roleId=0;

        User user = new User();
        user.setAccount(account);
        user.setPassword(CUtil.MD5encode(password));
        user.setName(name);
        user.setRoleId(roleId);
        user.setAge(age==null?0:Integer.valueOf(age));
        user.setSex(sex==null?"男":sex);
        user.setSearchDir(searchDir==null?"":searchDir);
        user.setPolitics(politics==null?"":politics);
        user.setDegree(degree==null?"":degree);
        user.setState(state==null?WebConstant.USER_STATE_0:state);
        user.setRole(role==null?WebConstant.ROLE_0:role);


        if(account==null||account.isEmpty()){
            throw new TipException("账号不能为空");
        }
        if(password==null||password.isEmpty()){
            throw new TipException("密码不能为空");
        }
        if(insId==null||insId.isEmpty()){
            throw new TipException("机构单位不能为空");
        }
        UserExample ue = new UserExample();
        ue.createCriteria().andAccountEqualTo(account);
        List list = UM.selectByExample(ue);
        if(list.size()!=0){
            throw new TipException("账户已存在");
        }
        checkUserInfo(user);
        UM.insertSelective(user);

        OrganizationUser ou = new OrganizationUser();
        ou.setOrgId(Integer.valueOf(orgId));
        ou.setUserId(user.getId());
        ou.setUserName(name);
        OUM.insertSelective(ou);

        InstitutionUser iu = new InstitutionUser();
        iu.setId(Integer.valueOf(insId));
        iu.setUserId(user.getId());
        //iu.setUserId(user.getId());
        IUM.insertSelective(iu);
        return true;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public User findUserByName(String username) {
        UserExample ue = new UserExample();
        ue.createCriteria().andNameEqualTo(username);
        List<User> users = UM.selectByExample(ue);
        return users.get(0);
    }

    @Override
    public void updateUser(Integer id, HttpServletRequest request) {
        User user = UM.selectByPrimaryKey(id);
        if(user == null)
            throw new TipException("不存在该用户");
        String name = request.getParameter("name");
        String roleId = request.getParameter("roleId");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String searchDir = request.getParameter("searchDir");
        String politics = request.getParameter("politics");
        String degree = request.getParameter("degree");
        String state = request.getParameter("state");
        String role = request.getParameter("role");

        user.setName(name==null?user.getName():name);
        user.setRoleId(roleId==null?user.getRoleId():Integer.valueOf(roleId));
        user.setAge(age==null?user.getAge():Integer.valueOf(age));
        user.setSex(sex==null?user.getSex():sex);
        user.setSearchDir(searchDir==null?user.getSearchDir():searchDir);
        user.setPolitics(politics==null?user.getPolitics():politics);
        user.setDegree(degree==null?user.getDegree():degree);
        user.setState(state==null?user.getState():state);
        user.setRole(role==null?user.getRole():role);

        checkUserInfo(user);
        UM.updateByPrimaryKeySelective(user);
    }

    @Override
    public boolean checkUserInfo(User user) {
        if(user.getState()!=null){
            if(!user.getState().equals(WebConstant.USER_STATE_0)&&!
                    user.getState().equals(WebConstant.USER_STATE_1)){
                throw new TipException("用户状态信息有误");
            }
        }
        if(user.getSex()!=null){
            if(!user.getSex().equals("男")&&!user.getSex().equals("女")){
                throw new TipException("用户性别信息有误");
            }
        }
        if(user.getRole()!=null){
            String role = user.getRole();
            if(!role.equals(WebConstant.ROLE_5)&&
                    !role.equals(WebConstant.ROLE_4)&&
                    !role.equals(WebConstant.ROLE_3)&&
                    !role.equals(WebConstant.ROLE_2)&&
                    !role.equals(WebConstant.ROLE_1)&&
                    !role.equals(WebConstant.ROLE_0)){
                throw new TipException("用户身份信息有误");
            }
        }
        return true;
    }
}

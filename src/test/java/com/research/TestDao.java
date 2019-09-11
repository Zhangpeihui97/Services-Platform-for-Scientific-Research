package com.research;

import com.research.configuration.Entry;
import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.model.Vo.*;
import com.research.service.ProjectService;
import com.research.service.UserService;
import com.research.utils.CUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)

public class TestDao {
    @Autowired
    UserMapper userMapper;
    @Autowired
    InstitutionUserMapper institutionUserMapper;
    @Autowired
    InstitutionProjectMapper institutionProjectMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PaperOrganizationMapper paperOrganizationMapper;
    @Autowired
    ProjectOrganizationMapper projectOrganizationMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    CountMonthMapper countMonthMapper;
    @Autowired
    ProjectService projectService;
    @Autowired
    PatentMapper patentMapper;
    @Before
    public void save(){
        Role role = new Role();
        role.setNameCh("等级4");
        role.setNameEn("level1");
        int id = roleMapper.insertSelective(role);
//        System.out.println(id);
//        System.out.println(role.getId());
        roleMapper.deleteByPrimaryKey(id);
    }
    @Test
    public void test(){
//        RoleExample rolee = new RoleExample();
//        rolee.createCriteria().andNameChEqualTo("等级4");
//    List<Role> list = roleMapper.selectByExample(rolee);
//    int id = list.get(0).getId();
//    System.out.println(id);
//    roleMapper.deleteByPrimaryKey(id);

//        int id=2;
//        InstitutionUserExample iue = new InstitutionUserExample();
//        iue.createCriteria().andIdEqualTo(id);
//        InstitutionProjectExample ipe = new InstitutionProjectExample();
//        ipe.createCriteria().andInstitutionIdEqualTo(id);
//        int userNum = institutionUserMapper.countByExample(iue);
//        int projectNum = institutionProjectMapper.countByExample(ipe);
//        System.out.println(userNum);
//        System.out.println(projectNum);

//        int id=3;
//        PaperOrganizationExample pae  = new PaperOrganizationExample();
//        pae.createCriteria().andOidEqualTo(id);
//        int paperNum = paperOrganizationMapper.countByExample(pae);
//        System.out.println(paperNum);

//          int id=3;
//          ProjectOrganizationExample poe = new ProjectOrganizationExample();
//          poe.createCriteria().andOidEqualTo(id);
//          int projectNum = projectOrganizationMapper.countByExample(poe);
//          System.out.println(projectNum);

//        List<CountMonth> countMonthList = countMonthMapper.selectByExample(new CountMonthExample());
//        CountMonth countMonth = countMonthList.get(0);
//
//        System.out.println(countMonth.getPnum());
//        System.out.println(countMonth.getCnum());
//        System.out.println(countMonth.getImnum());
//        System.out.println(countMonth.getOmnum());

//        UserExample ue = new UserExample();
//        ue.createCriteria().andStateEqualTo(WebConstant.USER_STATE_0);
//        int num = userMapper.countByExample(ue);
//        System.out.println(num);
//        User user = new User();
//        user.setRoleId(3);
//        int pnumd=0;
//        if(user.getRoleId()==3)
//        {
////            List list = projectService.getS0();
//            if(projectService.getS0()==null)
//            {
//                System.out.println(pnumd);
//            }
////            pnumd = projectService.getS0().size();
//            System.out.println(projectService.getS0().size());
//        }
//        else if(user.getRoleId()==4)
//        {
//            if(projectService.getS1()==null)
//            {
//                System.out.println(pnumd);
//            }
//            System.out.println(projectService.getS1().size());
//        }
//        System.out.println(pnumd);

//        if(user.getRoleId() == 3||user.getRole().equals(WebConstant.ROLE_3)){
//            m.addAttribute("pList",projectService.getS8());
//        }else if(user.getRoleId() == 4||user.getRole().equals(WebConstant.ROLE_4)){
//            m.addAttribute("pList",projectService.getS3());
//        }
//        if(user.getRoleId()==3)
//        {
////            List list = projectService.getS0();
//            if(projectService.getS8()==null)
//                System.out.println(pnumd);
//            else
//                System.out.println(projectService.getS8().size());
//        }
//        else if(user.getRoleId()==4)
//        {
//            if(projectService.getS8()==null)
//                System.out.println(pnumd);
//            else
//                System.out.println(projectService.getS8().size());
//        }
//        else
//            System.out.println(pnumd);
////        }
//        int pid=2;
//        ProjectOrganizationExample poe = new ProjectOrganizationExample();
//        ProjectOrganizationExample.Criteria criteria = poe.createCriteria();
////        criteria.andOidEqualTo(pok.getOid());
//        criteria.andPidEqualTo(pid);
//        projectOrganizationMapper.deleteByExample(poe);
//        ProjectOrganizationKey projectOrganizationKey = new ProjectOrganizationKey();
//        projectOrganizationKey.setPid(2);
//        projectOrganizationKey.setOid(2);
//        projectOrganizationMapper.insert(projectOrganizationKey);
//        String role=""
//        int roleId;
//        if(role.equals(WebConstant.ROLE_5))
//            roleId=5;
//        else if(role.equals(WebConstant.ROLE_4))
//            roleId=4;
//        else if (role.equals(WebConstant.ROLE_3))
//            roleId=3;
//        else if (role.equals(WebConstant.ROLE_2))
//            roleId=2;
//        else if (role.equals(WebConstant.ROLE_1))
//            roleId=1;
//        else
//            roleId=0;
//        int id=2;
//        int roleId1=2;
//        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
//        user.setRoleId(roleId1);
//        userMapper.updateByPrimaryKey(user);
    }
    @After
    public void after(){

    }
}

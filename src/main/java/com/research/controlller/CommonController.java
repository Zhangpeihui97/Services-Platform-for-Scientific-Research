package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.TipException;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.service.InsService;
import com.research.service.ProjectService;
import com.research.service.SystemService;
import com.research.service.UserService;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class CommonController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    InsService insService;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SystemService SS;
    @Autowired
    CountMonthMapper countMonthMapper;
    @Autowired
    CountYearMapper countYearMapper;
    @Autowired
    ProjectService projectService;
    @Autowired
    PatentMapper patentMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    ArtworkMapper artworkMapper;
    @Autowired
    IdentificationMapper identificationMapper;
    @Autowired
    CopyrightMapper copyrightMapper;
    @Autowired
    StandardMapper standardMapper;

    @GetMapping(value = {"","index","home"})
    public String index(Model m,HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        home1(m,request,user);
        m.addAttribute("token", CUtil.getToken(request));
        return "home";
    }

    @GetMapping(value = {"login","logout"})
    public String login(Model m,HttpServletRequest request){
        CUtil.logout(request);
        m.addAttribute("token",1);
        return "login";
    }

    //todo remeberME,
    @ResponseBody
    @PostMapping("login")
    public RestResponseBo login(String account,
                        @RequestParam String password,
                        HttpServletRequest request,
                        Model m){
        boolean flag = userService.login(account,password,request);
        if(flag){
            return RestResponseBo.ok();
        }
        else return RestResponseBo.fail("请检查账号名和密码");
    }

    @GetMapping("index")
    public String index(HttpServletRequest request,Model m){
//        String user = (String)request.getSession().getAttribute(WebConstant.USER_SESSION_KEY);
//        m.addAttribute("user",user);
        return "home";
    }

    //todo 密码加密md5
    @GetMapping("signup")
    public String signup(Model modle){
        modle.addAttribute("insList",insService.getAll());
        modle.addAttribute("orgList",organizationMapper.selectByExample(new OrganizationExample()));
        modle.addAttribute("roleList",roleMapper.selectByExample(new RoleExample()));
        return "signup";
    }

    //todo test
    /**
     * 注册
     * @return
     * @author syq
     */
    @PostMapping("signup")
    @ResponseBody
    public RestResponseBo signup(HttpServletRequest request){
        if(userService.signup(request)){
            return RestResponseBo.ok();
        }
        return RestResponseBo.fail("注册失败");
    }

    @GetMapping("user_edit_page")
    public String edit_page(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null||Integer.valueOf(id)==-1)
            return "login";
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("user",user);
        return "user/edit";
    }

    @PostMapping("user_edit")
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


    @GetMapping("user/modifyPW_page1")
    public String modifyPWPage1(Model m,HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        Integer id = user.getId();
        if(id==null){
            return "admin/user/user_password";
        }
        m.addAttribute("user",user);
//        m.addAttribute("Userid",user.getId());
        return "admin/user/user_password";
    }

    @PostMapping("user/modifyPW")
    @ResponseBody
    public RestResponseBo modifyPW(Model m,HttpServletRequest request){
        String id = request.getParameter("Userid");
        if(id==null){
            throw new TipException();
        }
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        String oldPW = request.getParameter("oldPassword");
        if(!user.getPassword().equals(CUtil.MD5encode(oldPW))){
            return RestResponseBo.fail("密码不正确");
        }
        String pw = request.getParameter("password");
        String pw2 = request.getParameter("password2");
        if(!pw.equals(pw2)){
            return RestResponseBo.fail("前后密码不一致");
        }
        user.setPassword(CUtil.MD5encode(pw));
        userMapper.updateByPrimaryKeySelective(user);
        return RestResponseBo.ok();
    }


    public String home1(Model m,HttpServletRequest request,User user){
        //系统信息
        List<Message> syslisthome = SS.getSystemMessage(user);
        m.addAttribute("syslisthome",syslisthome);

        //消息与预警
        List<Message> listhome = SS.getUserMessage(user);
        m.addAttribute("listhome",listhome);

        //科研动态近一个月项目、资金
        List<CountMonth> countMonthList = countMonthMapper.selectByExample(new CountMonthExample());
        CountMonth countMonth = countMonthList.get(0);
        m.addAttribute("pNum",countMonth.getPnum());
        m.addAttribute("cNum",countMonth.getCnum());
        m.addAttribute("imNum",countMonth.getImnum());
        m.addAttribute("omNum",countMonth.getOmnum());

        //科研动态近一年项目、资金
        List<CountYear> countYearList = countYearMapper.selectByExample(new CountYearExample());
        CountYear countYear = countYearList.get(0);
        m.addAttribute("pNumy",countYear.getPnumy());
        m.addAttribute("cNumy",countYear.getCnumy());
        m.addAttribute("imNumy",countYear.getImnumy());
        m.addAttribute("omNumy",countYear.getOmnumy());

        //科研动态近一个月/一年科研人员
        UserExample ue = new UserExample();
        ue.createCriteria();
        int unum = userMapper.countByExample(ue);
        int unumy = unum;
        m.addAttribute("uNum",unum);
        m.addAttribute("uNumy",unumy);

        //我的科研
        //科研成果
        int paperNum = paperMapper.countByExample(new PaperExample());
        int achievementNum = achievementMapper.countByExample(new AchievementExample());
        int artworkNum =artworkMapper.countByExample(new ArtworkExample());
        int reportNum = reportMapper.countByExample(new ReportExample());
        int identificationNum = identificationMapper.countByExample(new IdentificationExample());
        int totalNum = paperNum+achievementNum+artworkNum+reportNum+identificationNum;
        m.addAttribute("totalNum",totalNum);

        //知识产权
        int patentNum = patentMapper.countByExample(new PatentExample());
        int copyNum = copyrightMapper.countByExample(new CopyrightExample());
        int standNum = standardMapper.countByExample(new StandardExample());
        int totalNum1 = patentNum+copyNum+standNum;
        m.addAttribute("totalNum1",totalNum1);

        //我的事务
        //待审核人员
        UserExample ue1 = new UserExample();
        ue1.createCriteria().andStateEqualTo(WebConstant.USER_STATE_0);
        int unumd = userMapper.countByExample(ue1);
        m.addAttribute("uNumd",unumd);

        //待审核项目
        int pnumd=0;
        if(user.getRoleId()==3)
        {
            if(projectService.getS0()==null)
                m.addAttribute("pNumd",pnumd);
            else
                m.addAttribute("pNumd",projectService.getS0().size());
        }
        else if(user.getRoleId()==4)
        {
            if(projectService.getS1()==null)
                m.addAttribute("pNumd",pnumd);
            else
                m.addAttribute("pNumd",projectService.getS1().size());
        }
        else
            m.addAttribute("pNumd",pnumd);

        //待审核项目变更
        int pnumd1=0;
        if(user.getRoleId()==3)
        {
            if(projectService.getS8()==null)
                m.addAttribute("pNumd1",pnumd1);
            else
                m.addAttribute("pNumd1",projectService.getS8().size());
        }
        else if(user.getRoleId()==4)
        {
            if(projectService.getS8()==null)
                m.addAttribute("pNumd1",pnumd1);
            else
                m.addAttribute("pNumd1",projectService.getS3().size());
        }
        else
            m.addAttribute("pNumd1",pnumd1);

        //待审核合同
        int cnumd=0;
        if(user.getRoleId()==3)
        {
            if(projectService.getC0()==null)
                m.addAttribute("cNumd",cnumd);
            else
                m.addAttribute("cNumd",projectService.getC0().size());
        }
        else if(user.getRoleId()==4)
        {
            if(projectService.getC1()==null)
                m.addAttribute("cNumd",cnumd);
            else
                m.addAttribute("cNumd",projectService.getC1().size());
        }
        else
            m.addAttribute("cNumd",cnumd);

        //待审核合同变更
        int cnumd1=0;
        if(user.getRoleId()==3)
        {
            if(projectService.getC8()==null)
                m.addAttribute("cNumd1",cnumd1);
            else
                m.addAttribute("cNumd1",projectService.getC8().size());
        }
        else if(user.getRoleId()==4)
        {
            if(projectService.getC3()==null)
                m.addAttribute("cNumd1",cnumd1);
            else
                m.addAttribute("cNumd1",projectService.getC3().size());
        }
        else
            m.addAttribute("cNumd1",cnumd1);

        //待审核科研论文paperNumd
        int paperNumd=0;
        if(user.getRoleId()==3||user.getRoleId()==4)
        {
            PaperExample me = new PaperExample();
            me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
            if(paperMapper.selectByExample(me)==null)
                m.addAttribute("paperNumd",paperNumd);
            else
                m.addAttribute("paperNumd",paperMapper.selectByExample(me).size());
        }
        else
            m.addAttribute("paperNumd",paperNumd);

        //待审核著作iNumd
        int iNumd=0;
        if(user.getRoleId()==3||user.getRoleId()==4)
        {
            AchievementExample ae = new AchievementExample();
            ae.createCriteria().andStateEqualTo(WebConstant.STATE_0);
            if(achievementMapper.selectByExample(ae)==null)
                m.addAttribute("iNumd",iNumd);
            else
                m.addAttribute("iNumd",achievementMapper.selectByExample(ae).size());
        }
        else
            m.addAttribute("iNumd",iNumd);

        //待审核专利
        int patentNumd=0;
        if(user.getRoleId()==3||user.getRoleId()==4)
        {
            PatentExample pe = new PatentExample();
            pe.createCriteria().andStateEqualTo(WebConstant.STATE_0);
            if(patentMapper.selectByExample(pe)==null)
                m.addAttribute("patentNumd",patentNumd);
            else
                m.addAttribute("patentNumd",patentMapper.selectByExample(pe).size());
        }
        else
            m.addAttribute("patentNumd",patentNumd);
        return "home";
    }
}

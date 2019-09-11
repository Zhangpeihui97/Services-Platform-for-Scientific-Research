package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.model.Vo.*;
import com.research.service.ProjectService;
import com.research.service.SystemService;
import com.research.service.UserService;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    UserService userService;
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

    @RequestMapping("login")
    public String login(Model m,HttpServletRequest request){
        User user = userMapper.selectByPrimaryKey(1);
        CUtil.setLoginUser(user,request);
        home1(m,request,user);
        return "home";
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
    @RequestMapping("login2")
    public String login2(Model m,HttpServletRequest request){
        User user = userMapper.selectByPrimaryKey(1);
        user.setRoleId(3);
        CUtil.setLoginUser(user,request);
        home1(m,request,user);
        return "home";
    }

    @RequestMapping("login3")
    public String login3(Model m,HttpServletRequest request){
        User user = userMapper.selectByPrimaryKey(1);
        user.setRoleId(4);
        CUtil.setLoginUser(user,request);
        home1(m,request,user);
        return "home";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        CUtil.logout(request);
        return "home";
    }

    @RequestMapping("home")//首页
    public String home(Model m,HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        home1(m,request,user);
        return "home";
    }

//    @RequestMapping("home")//首页
//    public String home(Model m){
//        m.addAttribute("pNum","30");
//        return "home";}

    @RequestMapping("science")//我的科研
    public String science(Model m,HttpServletRequest request){
        //科研人员
        UserExample ue = new UserExample();
        ue.createCriteria();
        int unumy = userMapper.countByExample(ue);
        m.addAttribute("uNumy",unumy);
        //科研项目、科研经费
        List<CountYear> countYearList = countYearMapper.selectByExample(new CountYearExample());
        CountYear countYear = countYearList.get(0);
        m.addAttribute("pNumy",countYear.getPnumy());
        m.addAttribute("imNumy",countYear.getImnumy());
        m.addAttribute("cNumy",countYear.getCnumy());
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
        return "system/science";}

    @RequestMapping("person")//科研人员界面
    public String person(Model m,HttpServletRequest request){
        if(request.getParameter("id")!=null){
            m.addAttribute("name","jjj");
            m.addAttribute("hide",false);
        }

        return "system/person";}
    @RequestMapping("person_audit")//科研人员审核界面
    public String person_audit(){return "system/person_audit";}
    @RequestMapping("organization")//组织机构界面
    public String organization(){return "system/organization";}
    @RequestMapping("organization_edit")//组织机构修改界面
    public String organization_edit(){return "system/organization_edit";}
    @RequestMapping("institutions")//研究机构界面
    public String institutions(){return "system/institutions";}
    @RequestMapping("institutions_edit")//研究机构修改界面
    public String institutions_edit(){return "system/institutions_edit";}

}

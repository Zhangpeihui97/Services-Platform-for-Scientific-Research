package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.TipException;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("research")
public class ResearchController extends BaseController{
    //注入持久层
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    IdentificationMapper identificationMapper;
    @Autowired
    ArtworkMapper artworkMapper;

    /**
     * 用于处理请求增加论文成果的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("paper_add_page")
    public String paperAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "research_result/paper/add";
    }
    //接收提交的表单信息
    @PostMapping("paper_add")
    @ResponseBody
    public RestResponseBo paperAdd(Model m,
                                     String name,
                                     String unit,
                                     String author,
                                     String date,
                                     String discipline,
                                     String disciplineF,
                                     HttpServletRequest request){
        Paper paper = new Paper();
        paper.setName(name);
        paper.setUnit(unit);
        paper.setAuthor(author);
        paper.setDiscipline(discipline);
        paper.setDisciplineF(disciplineF);
        paper.setTimeFormular(date);
        paper.setState(WebConstant.STATE_0);
        paperMapper.insertSelective(paper);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 论文成果列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("paper_list")
    public String meetingList(Model m,
                              HttpServletRequest request){
        List<Paper> list = paperMapper.selectByExample(new PaperExample());
        m.addAttribute("list",list);
        return "research_result/paper/list";
    }

    /**
     * 返回论文成果list，同时如果有提交id参数过来就删除对应的论文成果
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("paper_delete")
    public String paperDelete(Model m,
                                HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        paperMapper.deleteByPrimaryKey(id);
        List<Paper> list = paperMapper.selectByExample(new PaperExample());
        m.addAttribute("list",list);
        return "research_result/paper/list";
    }

    /**
     * 论文成果审核，根据不同角色通过审核，论文成果状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("paper_audit")
    public String paperAudit(Model m,
                               HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Paper paper = paperMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                paper.setState(WebConstant.STATE_1);
            }else{
                paper.setState(WebConstant.STATE_2);
            }
            paperMapper.updateByPrimaryKey(paper);
        }
        PaperExample me = new PaperExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Paper> list = paperMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "research_result/paper/audit_list";
    }

    /**
     * 返回选中id对应的论文成果内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("paper_edit")
    public String paperEdit(Model m,
                              HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Paper paper = paperMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("paper",paper);
        return "research_result/paper/edit";
    }

    /**
     * 修改论文成果信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param author
     * @param discipline
     * @param disciplineF
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("paper_edit")
    @ResponseBody
    public RestResponseBo paperEdit(Model m,
                                      String name,
                                      String unit,
                                      String author,
                                      String date,
                                      String discipline,
                                      String disciplineF,
                                      String id,
                                      HttpServletRequest request){
        Paper paper = paperMapper.selectByPrimaryKey(Integer.valueOf(id));
        paper.setName(name);
        paper.setUnit(unit);
        paper.setAuthor(author);
        paper.setTimeFormular(date);
        paper.setDiscipline(discipline);
        paper.setDisciplineF(disciplineF);
        paper.setState(WebConstant.STATE_0);
        paperMapper.updateByPrimaryKey(paper);
        return RestResponseBo.ok();
    }

    /**
     * 用于处理请求增加研究报告的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("report_add_page")
    public String reportAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "research_result/report/add";
    }
    //接收提交的表单信息
    @PostMapping("report_add")
    @ResponseBody
    public RestResponseBo reportAdd(Model m,
                                   String name,
                                   String unit,
                                   String type,
                                   String author,
                                   String date,
                                   String disciplineF,
                                   String project,
                                   HttpServletRequest request){
        Report report = new Report();
        report.setName(name);
        report.setUnit(unit);
        report.setType(type);
        report.setAuthor(author);
        report.setTimeFormular(date);
        report.setDisciplineF(disciplineF);
        report.setProject(project);
        report.setState(WebConstant.STATE_0);
        reportMapper.insertSelective(report);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 研究报告列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("report_list")
    public String reportList(Model m,
                              HttpServletRequest request){
        List<Report> list = reportMapper.selectByExample(new ReportExample());
        m.addAttribute("list",list);
        return "research_result/report/list";
    }

    /**
     * 返回研究报告list，同时如果有提交id参数过来就删除对应的研究报告
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("report_delete")
    public String reportDelete(Model m,
                              HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        reportMapper.deleteByPrimaryKey(id);
        List<Report> list = reportMapper.selectByExample(new ReportExample());
        m.addAttribute("list",list);
        return "research_result/report/list";
    }

    /**
     * 研究报告审核，根据不同角色通过审核，研究报告状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("report_audit")
    public String reportAudit(Model m,
                             HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Report report = reportMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                report.setState(WebConstant.STATE_1);
            }else{
                report.setState(WebConstant.STATE_2);
            }
            reportMapper.updateByPrimaryKey(report);
        }
        ReportExample me = new ReportExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Report> list = reportMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "research_result/report/audit_list";
    }

    /**
     * 返回选中id对应的研究报告内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("report_edit")
    public String reportEdit(Model m,
                            HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Report report = reportMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("report",report);
        return "research_result/report/edit";
    }

    /**
     * 修改研究报告信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param type
     * @param author
     * @param date
     * @param disciplineF
     * @param project
     * @param id
     * @param request
     * @return
     */
    @PostMapping("report_edit")
    @ResponseBody
    public RestResponseBo reportEdit(Model m,
                                     String name,
                                     String unit,
                                     String type,
                                     String author,
                                     String date,
                                     String disciplineF,
                                     String project,
                                     String id,
                                     HttpServletRequest request){
        Report report = reportMapper.selectByPrimaryKey(Integer.valueOf(id));
        report.setName(name);
        report.setUnit(unit);
        report.setType(type);
        report.setAuthor(author);
        report.setTimeFormular(date);
        report.setDisciplineF(disciplineF);
        report.setProject(project);
        report.setState(WebConstant.STATE_0);
        reportMapper.updateByPrimaryKey(report);
        return RestResponseBo.ok();
    }

    /**
     * 用于处理请求增加鉴定成果的界面，model是存放要传递给页面数据的容器
     * @param m
     * @return
     */
    @GetMapping("achievement_add_page")
    public String achievementAdd(Model m){
        return "research_result/achievement/add";
    }
    //接收提交的表单信息
    @PostMapping("achievement_add")
    @ResponseBody
    public RestResponseBo achievementAdd(Model m,
                                  String name,
                                  String unit,
                                  String author,
                                  String type,
                                  String date,
                                  HttpServletRequest request){
        Achievement achievement = new Achievement();
        achievement.setName(name);
        achievement.setUnit(unit);
        achievement.setAuthor(author);
        achievement.setType(type);
        achievement.setTimeFormular(date);
        achievement.setState(WebConstant.STATE_0);
        achievementMapper.insertSelective(achievement);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 著作成果列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("achievement_list")
    public String achievementList(Model m,
                           HttpServletRequest request){
        List<Achievement> list = achievementMapper.selectByExample(new AchievementExample());
        m.addAttribute("list",list);
        return "research_result/achievement/list";
    }

    /**
     * 返回著作成果list，同时如果有提交id参数过来就删除对应的著作成果
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("achievement_delete")
    public String achievementDelete(Model m,
                             HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        achievementMapper.deleteByPrimaryKey(id);
        List<Achievement> list = achievementMapper.selectByExample(new AchievementExample());
        m.addAttribute("list",list);
        return "research_result/achievement/list";
    }

    /**
     * 著作成果审核，根据不同角色通过审核，著作成果状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("achievement_audit")
    public String achievementAudit(Model m,
                            HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Achievement achievement = achievementMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                achievement.setState(WebConstant.STATE_1);
            }else{
                achievement.setState(WebConstant.STATE_2);
            }
            achievementMapper.updateByPrimaryKey(achievement);
        }
        AchievementExample me = new AchievementExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Achievement> list = achievementMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "research_result/achievement/audit_list";
    }

    /**
     * 返回选中id对应的著作成果内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("achievement_edit")
    public String achievementEdit(Model m,
                           HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Achievement achievement = achievementMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("achievement",achievement);
        return "research_result/achievement/edit";
    }

    /**
     * 修改著作成果信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param author
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("achievement_edit")
    @ResponseBody
    public RestResponseBo achievementEdit(Model m,
                                          String name,
                                          String unit,
                                          String author,
                                          String type,
                                          String date,
                                          String id,
                                   HttpServletRequest request){
        Achievement achievement= achievementMapper.selectByPrimaryKey(Integer.valueOf(id));
        achievement.setName(name);
        achievement.setUnit(unit);
        achievement.setAuthor(author);
        achievement.setTimeFormular(date);
        achievement.setType(type);
        achievement.setState(WebConstant.STATE_0);
        achievementMapper.updateByPrimaryKey(achievement);
        return RestResponseBo.ok();
    }

    /**
     * 用于处理请求增加鉴定成果的界面，model是存放要传递给页面数据的容器
     * @param m
     * @return
     */
    @GetMapping("identification_add_page")
    public String identificationAdd(Model m){
        return "research_result/identification/add";
    }
    //接收提交的表单信息
    @PostMapping("identification_add")
    @ResponseBody
    public RestResponseBo identificationAdd(Model m,
                                         String name,
                                         String unit,
                                         String author,
                                         String type,
                                         String date,
                                         HttpServletRequest request){
        Identification identification = new Identification();
        identification.setName(name);
        identification.setUnit(unit);
        identification.setAuthor(author);
        identification.setType(type);
        identification.setTimeFormular(date);
        identification.setState(WebConstant.STATE_0);
        identificationMapper.insertSelective(identification);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 鉴定成果列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("identification_list")
    public String identificationList(Model m,
                                  HttpServletRequest request){
        List<Identification> list = identificationMapper.selectByExample(new IdentificationExample());
        m.addAttribute("list",list);
        return "research_result/identification/list";
    }

    /**
     * 返回鉴定成果list，同时如果有提交id参数过来就删除对应的鉴定成果
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("identification_delete")
    public String identificationDelete(Model m,
                                    HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        identificationMapper.deleteByPrimaryKey(id);
        List<Identification> list = identificationMapper.selectByExample(new IdentificationExample());
        m.addAttribute("list",list);
        return "research_result/identification/list";
    }

    /**
     * 鉴定成果审核，根据不同角色通过审核，鉴定成果状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("identification_audit")
    public String identificationAudit(Model m,
                                   HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Identification identification  = identificationMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                identification.setState(WebConstant.STATE_1);
            }else{
                identification.setState(WebConstant.STATE_2);
            }
            identificationMapper.updateByPrimaryKey(identification);
        }
        IdentificationExample me = new IdentificationExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Identification> list = identificationMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "research_result/identification/audit_list";
    }

    /**
     * 返回选中id对应的鉴定成果内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("identification_edit")
    public String identificationEdit(Model m,
                                  HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Identification identification = identificationMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("identification",identification);
        return "research_result/identification/edit";
    }

    /**
     * 修改鉴定成果信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param author
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("identification_edit")
    @ResponseBody
    public RestResponseBo identificationdit(Model m,
                                          String name,
                                          String unit,
                                          String author,
                                          String type,
                                          String date,
                                          String id,
                                          HttpServletRequest request){
        Identification identification= identificationMapper.selectByPrimaryKey(Integer.valueOf(id));
        identification.setName(name);
        identification.setUnit(unit);
        identification.setAuthor(author);
        identification.setTimeFormular(date);
        identification.setType(type);
        identification.setState(WebConstant.STATE_0);
        identificationMapper.updateByPrimaryKey(identification);
        return RestResponseBo.ok();
    }

    /**
     * 用于处理请求增加艺术成果的界面，model是存放要传递给页面数据的容器
     * @param m
     * @return
     */
    @GetMapping("artwork_add_page")
    public String artworkAdd(Model m){
        return "research_result/artwork/add";
    }
    //接收提交的表单信息
    @PostMapping("artwork_add")
    @ResponseBody
    public RestResponseBo artworkAdd(Model m,
                                         String name,
                                         String unit,
                                         String author,
                                         String type,
                                         String date,
                                         HttpServletRequest request){
        Artwork artwork = new Artwork();
        artwork.setName(name);
        artwork.setUnit(unit);
        artwork.setAuthor(author);
        artwork.setType(type);
        artwork.setTimeFormular(date);
        artwork.setState(WebConstant.STATE_0);
        artworkMapper.insertSelective(artwork);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 艺术成果列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("artwork_list")
    public String artworkList(Model m,
                                  HttpServletRequest request){
        List<Artwork> list = artworkMapper.selectByExample(new ArtworkExample());
        m.addAttribute("list",list);
        return "research_result/artwork/list";
    }

    /**
     * 返回艺术成果list，同时如果有提交id参数过来就删除对应的艺术成果
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("artwork_delete")
    public String artworkDelete(Model m,
                                    HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        artworkMapper.deleteByPrimaryKey(id);
        List<Artwork> list = artworkMapper.selectByExample(new ArtworkExample());
        m.addAttribute("list",list);
        return "research_result/artwork/list";
    }

    /**
     * 艺术成果审核，根据不同角色通过审核，艺术成果状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("artwork_audit")
    public String artworkAudit(Model m,
                                   HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Artwork artwork = artworkMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                artwork.setState(WebConstant.STATE_1);
            }else{
                artwork.setState(WebConstant.STATE_2);
            }
            artworkMapper.updateByPrimaryKey(artwork);
        }
        ArtworkExample me = new ArtworkExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Artwork> list = artworkMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "research_result/artwork/audit_list";
    }

    /**
     * 返回选中id对应的著作成果内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("artwork_edit")
    public String artworkEdit(Model m,
                                  HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Artwork artwork = artworkMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("artwork",artwork);
        return "research_result/artwork/edit";
    }

    /**
     * 修改艺术成果信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param author
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("artwork_edit")
    @ResponseBody
    public RestResponseBo artworkEdit(Model m,
                                          String name,
                                          String unit,
                                          String author,
                                          String type,
                                          String date,
                                          String id,
                                          HttpServletRequest request){
        Artwork artwork= artworkMapper.selectByPrimaryKey(Integer.valueOf(id));
        artwork.setName(name);
        artwork.setUnit(unit);
        artwork.setAuthor(author);
        artwork.setTimeFormular(date);
        artwork.setType(type);
        artwork.setState(WebConstant.STATE_0);
        artworkMapper.updateByPrimaryKey(artwork);
        return RestResponseBo.ok();
    }

}

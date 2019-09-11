package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.CopyrightMapper;
import com.research.dao.PatentMapper;
import com.research.dao.StandardMapper;
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
@RequestMapping("intellectual")
public class IntellectualController extends BaseController{
    //注入持久层
    @Autowired
    PatentMapper patentMapper;
    @Autowired
    CopyrightMapper copyrightMapper;
    @Autowired
    StandardMapper standardMapper;

    /**
     * 用于处理请求增加专利的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("patent_add_page")
    public String patentAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "intellectual_property/patent/add";
    }
    //接收提交的表单信息
    @PostMapping("patent_add")
    @ResponseBody
    public RestResponseBo patentAdd(Model m,
                                     String name,
                                     String unit,
                                     String inventor,
                                     String type,
                                     String statep,
                                     HttpServletRequest request){
        Patent patent = new Patent();
        patent.setName(name);
        patent.setType(type);
        patent.setUnit(unit);
        patent.setInventor(inventor);
        patent.setStateP(statep);
        patent.setState(WebConstant.STATE_0);
        patentMapper.insertSelective(patent);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 专利列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("patent_list")
    public String patentList(Model m,
                              HttpServletRequest request){
        List<Patent> list = patentMapper.selectByExample(new PatentExample());
        m.addAttribute("list",list);
        return "intellectual_property/patent/list";
    }

    /**
     * 返回专利list，同时如果有提交id参数过来就删除对应的专利
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("patent_delete")
    public String patentDelete(Model m,
                                HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        patentMapper.deleteByPrimaryKey(id);
        List<Patent> list = patentMapper.selectByExample(new PatentExample());
        m.addAttribute("list",list);
        return "intellectual_property/patent/list";
    }

    /**
     * 专利审核，根据不同角色通过审核，专利状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("patent_audit")
    public String patentAudit(Model m,
                               HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Patent patent = patentMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                patent.setState(WebConstant.STATE_1);
            }else{
                patent.setState(WebConstant.STATE_2);
            }
            patentMapper.updateByPrimaryKey(patent);
        }
        PatentExample me = new PatentExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Patent> list = patentMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "intellectual_property/patent/audit_list";
    }

    /**
     * 返回选中id对应的专利内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("patent_edit")
    public String patentEdit(Model m,
                              HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Patent patent = patentMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("patent",patent);
        return "intellectual_property/patent/edit";
    }

    /**
     * 修改专利信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param stateP
     * @param inventor
     * @param type
     * @param id
     * @param request
     * @return
     */
    @PostMapping("patent_edit")
    @ResponseBody
    public RestResponseBo patentEdit(Model m,
                                      String name,
                                      String unit,
                                      String inventor,
                                      String type,
                                      String stateP,
                                      String id,
                                      HttpServletRequest request){
        Patent patent = patentMapper.selectByPrimaryKey(Integer.valueOf(id));
        patent.setName(name);
        patent.setType(type);
        patent.setUnit(unit);
        patent.setInventor(inventor);
        patent.setStateP(stateP);
        patent.setState(WebConstant.STATE_0);
        patentMapper.updateByPrimaryKey(patent);
        return RestResponseBo.ok();
    }


    /**
     * 用于处理请求增加著作权的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("copyright_add_page")
    public String copyrightAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "intellectual_property/copyright/add";
    }
    //接收提交的表单信息
    @PostMapping("copyright_add")
    @ResponseBody
    public RestResponseBo copyrightAdd(Model m,
                                    Integer number,
                                    String name,
                                    String unit,
                                    String type,
                                    String author,
                                    String date,
                                    HttpServletRequest request){
        Copyright copyright = new Copyright();
        copyright.setName(name);
        copyright.setType(type);
        copyright.setUnit(unit);
        copyright.setAuthor(author);
        copyright.setNumber(number);
        copyright.setTimeFormular(date);
        copyright.setState(WebConstant.STATE_0);
        copyrightMapper.insertSelective(copyright);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 著作权列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("copyright_list")
    public String copyrightList(Model m,
                             HttpServletRequest request){
        List<Copyright> list = copyrightMapper.selectByExample(new CopyrightExample());
        m.addAttribute("list",list);
        return "intellectual_property/copyright/list";
    }

    /**
     * 返回著作权list，同时如果有提交id参数过来就删除对应的著作权
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("copyright_delete")
    public String copyrightDelete(Model m,
                               HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        copyrightMapper.deleteByPrimaryKey(id);
        List<Copyright> list = copyrightMapper.selectByExample(new CopyrightExample());
        m.addAttribute("list",list);
        return "intellectual_property/copyright/list";
    }

    /**
     * 著作权审核，根据不同角色通过审核，著作状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("copyright_audit")
    public String copyrightAudit(Model m,
                              HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Copyright copyright = copyrightMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                copyright.setState(WebConstant.STATE_1);
            }else{
                copyright.setState(WebConstant.STATE_2);
            }
            copyrightMapper.updateByPrimaryKey(copyright);
        }
        CopyrightExample me = new CopyrightExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Copyright> list = copyrightMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "intellectual_property/copyright/audit_list";
    }

    /**
     * 返回选中id对应的著作权内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("copyright_edit")
    public String copyrightEdit(Model m,
                                HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Copyright copyright = copyrightMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("copyright",copyright);
        return "intellectual_property/copyright/edit";
    }

    /**
     * 修改著作权信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param number
     * @param author
     * @param type
     * @param id
     * @param request
     * @return
     */
    @PostMapping("copyright_edit")
    @ResponseBody
    public RestResponseBo copyrightEdit(Model m,
                                        Integer number,
                                        String name,
                                        String unit,
                                        String type,
                                        String author,
                                        String date,
                                        String id,
                                        HttpServletRequest request){
        Copyright copyright = copyrightMapper.selectByPrimaryKey(Integer.valueOf(id));
        copyright.setName(name);
        copyright.setType(type);
        copyright.setUnit(unit);
        copyright.setAuthor(author);
        copyright.setNumber(number);
        copyright.setTimeFormular(date);
        copyright.setState(WebConstant.STATE_0);
        copyrightMapper.updateByPrimaryKey(copyright);
        return RestResponseBo.ok();
    }

    /**
     * 用于处理请求增加标准的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("standard_add_page")
    public String standardAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "intellectual_property/standard/add";
    }
    //接收提交的表单信息
    @PostMapping("standard_add")
    @ResponseBody
    public RestResponseBo standardAdd(Model m,
                                    String name,
                                    String unit,
                                    String type,
                                    String author,
                                    String state,
                                    HttpServletRequest request){
        Standard standard = new Standard();
        standard.setName(name);
        standard.setUnit(unit);
        standard.setType(type);
        standard.setAuthor(author);
        standard.setState(state);
        standard.setState(WebConstant.STATE_0);
        standardMapper.insertSelective(standard);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 专利列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("standard_list")
    public String standardList(Model m,
                             HttpServletRequest request){
        List<Standard> list = standardMapper.selectByExample(new StandardExample());
        m.addAttribute("list",list);
        return "intellectual_property/standard/list";
    }

    /**
     * 返回标准list，同时如果有提交id参数过来就删除对应的标准
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("standard_delete")
    public String standardDelete(Model m,
                               HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        standardMapper.deleteByPrimaryKey(id);
        List<Standard> list = standardMapper.selectByExample(new StandardExample());
        m.addAttribute("list",list);
        return "intellectual_property/standard/list";
    }

    /**
     * 标准审核，根据不同角色通过审核，标准状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("standard_audit")
    public String standardAudit(Model m,
                              HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Standard standard = standardMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                standard.setState(WebConstant.STATE_1);
            }else{
                standard.setState(WebConstant.STATE_2);
            }
            standardMapper.updateByPrimaryKey(standard);
        }
        StandardExample me = new StandardExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Standard> list = standardMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "intellectual_property/standard/audit_list";
    }

    /**
     * 返回选中id对应的标准内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("standard_edit")
    public String standardEdit(Model m,
                             HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Standard standard = standardMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("standard",standard);
        return "intellectual_property/standard/edit";
    }

    /**
     * 修改专利信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param state
     * @param author
     * @param type
     * @param id
     * @param request
     * @return
     */
    @PostMapping("standard_edit")
    @ResponseBody
    public RestResponseBo standardEdit(Model m,
                                     String name,
                                     String unit,
                                     String author,
                                     String type,
                                     String state,
                                     String id,
                                     HttpServletRequest request){
        Standard standard = standardMapper.selectByPrimaryKey(Integer.valueOf(id));
        standard.setName(name);
        standard.setType(type);
        standard.setUnit(unit);
        standard.setAuthor(author);
        standard.setState(state);
        standard.setState(WebConstant.STATE_0);
        standardMapper.updateByPrimaryKey(standard);
        return RestResponseBo.ok();
    }
}

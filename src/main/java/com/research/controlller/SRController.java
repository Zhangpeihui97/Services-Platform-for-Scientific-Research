package com.research.controlller;

import com.research.dao.SciStatisticsMapper;
import com.research.dao.SocStatisticMapper;
import com.research.exception.TipException;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Bo.SciStatisticBo;
import com.research.model.Bo.SocStatisticBo;
import com.research.model.Vo.SciStatistics;
import com.research.model.Vo.SciStatisticsExample;
import com.research.model.Vo.SocStatistic;
import com.research.model.Vo.SocStatisticExample;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sr")
public class SRController {
    @Autowired
    SciStatisticsMapper SSM;
    @Autowired
    SocStatisticMapper SOSM;

    @GetMapping("basic")//科技统计基础表
    public  String basic(){return "scientific_social/scientific_basic";}
    @PostMapping("basic")
    @ResponseBody
    public RestResponseBo addBasic(String education,
                                   String unit,
                                   String research,
                                   String institution,
                                   String name,
                                   HttpServletRequest request){
        SciStatistics ss = new SciStatistics();
        ss.setDate(new Date());
        ss.setEducation(education);
        ss.setUnit(unit);
        ss.setInstitution(institution);
        ss.setName(name);
        ss.setResearch(research);
        SSM.insert(ss);
        return RestResponseBo.ok();
    }
    @GetMapping("summary")//科技统计汇总表
    public  String summary(Model m){
        List<SciStatistics> list = SSM.selectByExample(new SciStatisticsExample());
        m.addAttribute("list",SciStatisticBo.praseList(list));
        return "scientific_social/scientific_summary";}
    @GetMapping("sciInfo")//科技统计汇总表
    public  String sciInfo(Model m,HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        if(id == null) {
            throw new TipException("非法访问");
        }
        SciStatistics sci = SSM.selectByPrimaryKey(id);
//        List<SciStatistics> list = SSM.selectByExample(new SciStatisticsExample());
        m.addAttribute("sci",sci);
        return "scientific_social/scientific_info";
    }
    @GetMapping("s_basic")//社科统计基础表
    public  String sbasic(){return "scientific_social/social_basic";}

    @PostMapping("s_basic")
    @ResponseBody
    public RestResponseBo addSBasic(String education,
                                   String unit,
                                   String research,
                                   String name,
                                   String degree,
                                   String state,
                                   HttpServletRequest request){
        SocStatistic ss = new SocStatistic();
        ss.setDate(new Date());
        ss.setEducation(education);
        ss.setUnit(unit);
        ss.setName(name);
        ss.setResearch(research);
        ss.setDegree(degree);
        ss.setState(state);
        SOSM.insertSelective(ss);
        return RestResponseBo.ok();
    }
    @GetMapping("socInfo")//科技统计汇总表
    public  String socInfo(Model m,HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        if(id == null) {
            throw new TipException("非法访问");
        }
        SocStatistic soc = SOSM.selectByPrimaryKey(id);
//        List<SocStatistic> list = SSM.selectByExample(new SocStatisticExample());
        m.addAttribute("soc",soc);
        return "scientific_social/social_info";
    }
    @RequestMapping("s_summary")//社科统计汇总表
    public  String ssummary(Model m){
        List<SocStatistic> list = SOSM.selectByExample(new SocStatisticExample());
        m.addAttribute("list",SocStatisticBo.praseList(list));
        return "scientific_social/social_summary";
    }
    @RequestMapping("sci")//科研报表
    public String sci(){return "scientific_social/scientific_reports";}
    @RequestMapping("contract")//合同一览表
    public String contract(){return "scientific_social/contract_info";}
    @GetMapping("mul_query")//综合插叙条件
    public String mulQuery(){
        return "scientific_social/mul_query";
    }

    //todo query
    @GetMapping("mul_result")//综合查询结果
    public String mulResult(Model m,
                            HttpServletRequest request){
        m.addAttribute("test","test");
        String s=request.getParameter("firstLevel");
        return "scientific_social/mul_result";
    }

}

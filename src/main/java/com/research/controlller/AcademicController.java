package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.AmeetingMapper;
import com.research.dao.MeetingMapper;
import com.research.dao.TalkMapper;
import com.research.exception.TipException;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.TileObserver;
import java.util.List;

@Controller
@RequestMapping("academic")
public class AcademicController extends BaseController {
    //注入持久层
    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    TalkMapper talkMapper;
    @Autowired
    AmeetingMapper ameetingMapper;

    /**
     * 用于处理请求增加会议的界面，model是存放要传递给页面数据的容器
     */
    @GetMapping("meeting_add_page")
    public String meetingAddPage(Model m){

        m.addAttribute("fuck","fuck");
        System.out.println("in");
        return "academic_exchange/host_meeting/add";
    }
    //接收提交的表单信息
    @PostMapping("meeting_add")
    @ResponseBody
    public RestResponseBo meetingAdd(Model m,
                                     String name,
                                     String unit,
                                     String position,
                                     String type,
                                     String date,
                                     HttpServletRequest request){
        Meeting meeting = new Meeting();
        meeting.setName(name);
        meeting.setTimeS(CUtil.getTime(date));
        meeting.setType(type);
        meeting.setUnit(unit);
        meeting.setPosition(position);
        meeting.setTimeFormular(date);
        meeting.setState(WebConstant.STATE_0);
        meetingMapper.insertSelective(meeting);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 会议列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("meeting_list")
    public String meetingList(Model m,
                              HttpServletRequest request){
        List<Meeting> list = meetingMapper.selectByExample(new MeetingExample());
        m.addAttribute("list",list);
        return "academic_exchange/host_meeting/list";
    }

    /**
     * 返回会议list，同时如果有提交id参数过来就删除对应的会议
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("meeting_delete")
    public String meetingDelete(Model m,
                                HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        meetingMapper.deleteByPrimaryKey(id);
        List<Meeting> list = meetingMapper.selectByExample(new MeetingExample());
        m.addAttribute("list",list);
        return "academic_exchange/host_meeting/list";
    }

    /**
     * 会议审核，根据不同角色通过审核，会议状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("meeting_audit")
    public String meetingAudit(Model m,
                               HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Meeting meeting = meetingMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                meeting.setState(WebConstant.STATE_1);
            }else{
                meeting.setState(WebConstant.STATE_2);
            }
            meetingMapper.updateByPrimaryKey(meeting);
        }
        MeetingExample me = new MeetingExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Meeting> list = meetingMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "academic_exchange/host_meeting/audit_list";
    }

    /**
     * 返回选中id对应的会议内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("meeting_edit")
    public String meetingEdit(Model m,
                               HttpServletRequest request){
        String id = request.getParameter("id");
       if(id==null) throw new TipException();
       Meeting meeting = meetingMapper.selectByPrimaryKey(Integer.valueOf(id));
       m.addAttribute("meeting",meeting);
       return "academic_exchange/host_meeting/edit";
    }

    /**
     * 修改会议信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param position
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("meeting_edit")
    @ResponseBody
    public RestResponseBo meetingEdit(Model m,
                                     String name,
                                     String unit,
                                     String position,
                                     String type,
                                     String date,
                                     String id,
                                     HttpServletRequest request){
        Meeting meeting = meetingMapper.selectByPrimaryKey(Integer.valueOf(id));
        meeting.setName(name);
        meeting.setTimeS(CUtil.getTime(date));
        meeting.setType(type);
        meeting.setUnit(unit);
        meeting.setPosition(position);
        meeting.setTimeFormular(date);
        meeting.setState(WebConstant.STATE_0);
        meetingMapper.updateByPrimaryKey(meeting);
        return RestResponseBo.ok();
    }


    /**
     * 用于处理请求增加学术讲座的界面，model是存放要传递给页面数据的容器
     * @param m
     * @return
     */
    @GetMapping("talk_add_page")
    public String talkAdd(Model m){
        return "academic_exchange/academic_talk/add";
    }
    //接收提交的表单信息
    @PostMapping("talk_add")
    @ResponseBody
    public RestResponseBo talkAdd(Model m,
                                      String name,
                                      String unit,
                                      String type,
                                      String date,
                                      String speaker,
                                      HttpServletRequest request){
        Talk talk = new Talk();
        talk.setName(name);
        talk.setTimeS(CUtil.getTime(date));
        talk.setType(type);
        talk.setUnit(unit);
        talk.setSpeaker(speaker);
        talk.setTimeFormular(date);
        talk.setState(WebConstant.STATE_0);
        talkMapper.insertSelective(talk);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 学术讲座列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("talk_list")
    public String talkList(Model m,
                               HttpServletRequest request){
        List<Talk> list = talkMapper.selectByExample(new TalkExample());
        m.addAttribute("list",list);
        return "academic_exchange/academic_talk/list";
    }

    /**
     * 返回学术讲座list，同时如果有提交id参数过来就删除对应的学术讲座
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("talk_delete")
    public String talkDelete(Model m,
                                 HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        talkMapper.deleteByPrimaryKey(id);
        List<Talk> list = talkMapper.selectByExample(new TalkExample());
        m.addAttribute("list",list);
        return "academic_exchange/academic_talk/list";
    }

    /**
     * 学术讲座审核，根据不同角色通过审核，学术讲座状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("talk_audit")
    public String talkAudit(Model m,
                                HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Talk talk = talkMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                talk.setState(WebConstant.STATE_1);
            }else{
                talk.setState(WebConstant.STATE_2);
            }
            talkMapper.updateByPrimaryKey(talk);
        }
        TalkExample me = new TalkExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Talk> list = talkMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "academic_exchange/academic_talk/audit_list";
    }

    /**
     * 返回选中id对应的学术讲座内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("talk_edit")
    public String talkEdit(Model m,
                               HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Talk talk = talkMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("talk",talk);
        return "academic_exchange/academic_talk/edit";
    }

    /**
     * 修改学术讲座信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param speaker
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("talk_edit")
    @ResponseBody
    public RestResponseBo talkEdit(Model m,
                                       String name,
                                       String unit,
                                       String type,
                                       String date,
                                       String speaker,
                                       String id,
                                       HttpServletRequest request){
        Talk talk = talkMapper.selectByPrimaryKey(Integer.valueOf(id));
        talk.setName(name);
        talk.setTimeS(CUtil.getTime(date));
        talk.setType(type);
        talk.setUnit(unit);
        talk.setSpeaker(speaker);
        talk.setTimeFormular(date);
        talk.setState(WebConstant.STATE_0);
        talkMapper.updateByPrimaryKey(talk);
        return RestResponseBo.ok();
    }


    /**
    *用于处理请求增加参加会议的界面，model是存放要传递给页面数据的容器
    */
    @GetMapping("ameeting_add_page")
    public String ameetingAdd(Model m){
        return "academic_exchange/attend_meeting/add";
    }
    //接收提交的表单信息
    @PostMapping("ameeting_add")
    @ResponseBody
    public RestResponseBo ameetingAdd(Model m,
                                     String name,
                                     String unit,
                                     String participant,
                                     String type,
                                     String date,
                                     HttpServletRequest request){
        Ameeting ameeting = new Ameeting();
        ameeting.setName(name);
        ameeting.setTimeS(CUtil.getTime(date));
        ameeting.setType(type);
        ameeting.setUnit(unit);
        ameeting.setParticipant(participant);
        ameeting.setTimeFormular(date);
        ameeting.setState(WebConstant.STATE_0);
        ameetingMapper.insertSelective(ameeting);//存入数据库
        return RestResponseBo.ok();
    }

    /**
     * 参加会议列表
     * @param m
     * @param request
     * @return
     */
    @GetMapping("ameeting_list")
    public String ameetingList(Model m,
                              HttpServletRequest request){
        List<Ameeting> list = ameetingMapper.selectByExample(new AmeetingExample());
        m.addAttribute("list",list);
        return "academic_exchange/attend_meeting/list";
    }

    /**
     * 返回参加参加会议list，同时如果有提交id参数过来就删除对应的参加会议
     *
     * 还需要权限验证
     * 还可以将功能做成独立页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("ameeting_delete")
    public String ameetingDelete(Model m,
                                HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        ameetingMapper.deleteByPrimaryKey(id);
        List<Ameeting> list = ameetingMapper.selectByExample(new AmeetingExample());
        m.addAttribute("list",list);
        return "academic_exchange/attend_meeting/list";
    }

    /**
     * 会议审核，根据不同角色通过审核，参加会议状态应该有相对应的变化
     * 不过需求分析又没说不同状态有什么作用或者区别
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("ameeting_audit")
    public String ameetingAudit(Model m,
                               HttpServletRequest request){
        String ids = request.getParameter("id");
        if(ids!=null){
            Integer id = Integer.valueOf(ids);
            Ameeting ameeting = ameetingMapper.selectByPrimaryKey(id);
            String mes = request.getParameter("audit");
            if(mes.equals("yes")){
                ameeting.setState(WebConstant.STATE_1);
            }else{
                ameeting.setState(WebConstant.STATE_2);
            }
            ameetingMapper.updateByPrimaryKey(ameeting);
        }
        AmeetingExample me = new AmeetingExample();
        me.createCriteria().andStateEqualTo(WebConstant.STATE_0);
        List<Ameeting> list = ameetingMapper.selectByExample(me);
        m.addAttribute("list",list);
        return "academic_exchange/attend_meeting/audit_list";
    }

    /**
     * 返回选中id对应的参加会议内容
     * @param m
     * @param request
     * @return
     */
    @GetMapping("ameeting_edit")
    public String ameetingEdit(Model m,
                              HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null) throw new TipException();
        Ameeting ameeting = ameetingMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("ameeting",ameeting);
        return "academic_exchange/attend_meeting/edit";
    }

    /**
     * 修改参加会议信息的接口，绑定信息然后daoupdate
     * @param m
     * @param name
     * @param unit
     * @param participant
     * @param type
     * @param date
     * @param id
     * @param request
     * @return
     */
    @PostMapping("ameeting_edit")
    @ResponseBody
    public RestResponseBo ameetingEdit(Model m,
                                      String name,
                                      String participant,
                                      String unit,
                                      String type,
                                      String date,
                                      String id,
                                      HttpServletRequest request){
        Ameeting ameeting = ameetingMapper.selectByPrimaryKey(Integer.valueOf(id));
        ameeting.setName(name);
        ameeting.setTimeS(CUtil.getTime(date));
        ameeting.setType(type);
        ameeting.setUnit(unit);
        ameeting.setParticipant(participant);
        ameeting.setTimeFormular(date);
        ameeting.setState(WebConstant.STATE_0);
        ameetingMapper.updateByPrimaryKey(ameeting);
        return RestResponseBo.ok();
    }
}

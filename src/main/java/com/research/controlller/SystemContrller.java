package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.TipException;
import com.research.model.Bo.InsBo;
import com.research.model.Bo.OriUserBo;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.service.ProjectService;
import com.research.service.SystemService;
import com.research.utils.CUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("system")
public class SystemContrller extends BaseController{
    @Autowired
    SystemService SS;
    @Autowired
    MessageMapper MM;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    OrganizationUserMapper organizationUserMapper;
    @Autowired
    ProjectOrganizationMapper projectOrganizationMapper;
    @Autowired
    PaperOrganizationMapper paperOrganizationMapper;
    @Autowired
    InstitutionMapper institutionMapper;
    @Autowired
    InstitutionUserMapper institutionUserMapper;
    @Autowired
    InstitutionProjectMapper institutionProjectMapper;
    @Autowired
    UserMapper UM;
    @Autowired
    CountMonthMapper countMonthMapper;
    @Autowired
    CountYearMapper countYearMapper;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserMapper userMapper;

    @GetMapping("role_add")
    public String roleAdd(Model m){
        return "System_maintenance/role_add";
    }

    @GetMapping("message")
    public String message(Model m, HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        if(user ==null) {
            throw new TipException("请登录");
        }
        List<Message> list = SS.getUserMessage(user);
        m.addAttribute("list",list);
        return "system/message";
    }

    /**
     *获取消息详细情况
     * @param m
     * @param request
     * @return
     */
    @GetMapping("message1")
    public String message1(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        if(null==id) throw new TipException();
        Message mes = MM.selectByPrimaryKey(Integer.valueOf(id));
        mes.setState(WebConstant.MES_STATE_1);
        MM.updateByPrimaryKey(mes);
        m.addAttribute("mes",mes);
        return "system/message1";
    }

    @GetMapping("message_rm")
    public String  messageRm(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(null==id) throw new TipException();
        MM.deleteByPrimaryKey(Integer.valueOf(id));
        List<Message> list = SS.getUserMessage(CUtil.getLoginUser(request));
        m.addAttribute("list",list);
        return "system/message";
    }

    @GetMapping("system_message")
    public String sysMessage(Model m, HttpServletRequest request){
        User user = CUtil.getLoginUser(request);
        if(user ==null) {
            throw new TipException("请登录");
        }
        List<Message> list = SS.getSystemMessage(user);
        m.addAttribute("list",list);
        return "system/system_message";
    }

    @GetMapping("sys_message1")
    public String sysMessage1(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        if(null==id) throw new TipException();
        Message mes = MM.selectByPrimaryKey(Integer.valueOf(id));
        mes.setState(WebConstant.MES_STATE_1);
        MM.updateByPrimaryKey(mes);
        m.addAttribute("mes",mes);
        return "system/system_message1";
    }

    @GetMapping("sys_message_rm")
    public String  sysMessageRm(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(null==id) throw new TipException();
        MM.deleteByPrimaryKey(Integer.valueOf(id));
        List<Message> list = SS.getSystemMessage(CUtil.getLoginUser(request));
        m.addAttribute("list",list);
        return "system/system_message";
    }

    @GetMapping("organization_list")
    public String organizationList(Model m,HttpServletRequest request)
    {
        List<Organization> list= organizationMapper.selectByExample(new OrganizationExample());
        List<OriUserBo> list2= new ArrayList<>();
        for(Organization org:list){
            int id = org.getId();
            OrganizationUserExample oue = new OrganizationUserExample();
            oue.createCriteria().andOrgIdEqualTo(id);
            ProjectOrganizationExample poe = new ProjectOrganizationExample();
            poe.createCriteria().andOidEqualTo(id);
            PaperOrganizationExample pae  = new PaperOrganizationExample();
            pae.createCriteria().andOidEqualTo(id);
            int userNum = organizationUserMapper.countByExample(oue);
            int projectNum = projectOrganizationMapper.countByExample(poe);
            int paperNum = paperOrganizationMapper.countByExample(pae);
            //int userNum = organizationUserMapper.countUserByOrganization(id);
            //int projectNum = organizationUserMapper.countProjectByOrganization(id);
            // int paperNum = organizationUserMapper.countPaperByOrganization(id);
//            int num = organizationUserMapper.countByOrganization(oue);
            OriUserBo ou = new OriUserBo(org,userNum,projectNum,paperNum);
            list2.add(ou);
        }
        m.addAttribute("organization_list",list2);
        // m.addAttribute("organizationUser_list", organizationUserMapper.countByExample(new OrganizationUserExample()));
        //m.addAttribute("projectOrganization_list", projectOrganizationMapper.selectByExample(new ProjectOrganizationExample()));
        return "system/organization";
    }

    @PostMapping("addOrganization")
    @ResponseBody
    public RestResponseBo addOrganization(String name,String type,String leaderName){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setType(type);
        organization.setLeaderName(leaderName);
        //organizationMapper.insertSelective(organization);
        SS.addOrganization(organization);
        return RestResponseBo.ok();
    }

    @GetMapping("organization_edit_page")
    public String organization_edit_page(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null) throw new TipException();
        Organization organization = organizationMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("organization",organization);
        List<User> userList= userMapper.selectByExample(new UserExample());
        m.addAttribute("userList",userList);
        return "system/organization_edit";
    }

    @PostMapping("organization_edit")
    @ResponseBody
    public RestResponseBo organization_edit(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
       // String userIdstr = request.getParameter("userId");

        if(id==null)
            throw new TipException();
        SS.updateOrganization(Integer.valueOf(id),request);
        return RestResponseBo.ok();
    }

    @PostMapping("deleteOrganization")
    @ResponseBody
    public RestResponseBo deleteOrganization(@RequestBody JSONObject js, HttpServletRequest request){
        String id = js.getString("id");
        organizationMapper.deleteByPrimaryKey(Integer.valueOf(id));
        return RestResponseBo.ok();
    }

    @GetMapping("institutions_list")
    public String institutionList(Model m,HttpServletRequest request)
    {
        List<Institution> list= institutionMapper.selectByExample(new InstitutionExample());
        List<InsBo> list2= new ArrayList<>();
        for(Institution institution:list){
            int id = institution.getId();
            InstitutionUserExample iue = new InstitutionUserExample();
            iue.createCriteria().andIdEqualTo(id);
            InstitutionProjectExample ipe = new InstitutionProjectExample();
            ipe.createCriteria().andInstitutionIdEqualTo(id);
            int userNum = institutionUserMapper.countByExample(iue);
            int projectNum = institutionProjectMapper.countByExample(ipe);
            InsBo insBo = new InsBo(institution,userNum,projectNum);
            list2.add(insBo);
        }
        m.addAttribute("institutions_list",list2);
        return "system/institutions";
    }

    @PostMapping("addInstitution")
    @ResponseBody
    public RestResponseBo addInstitution(String name,String type,String introduction,String lule,String device,String communication){
        Institution institution = new Institution();
        institution.setName(name);
        institution.setType(type);
        institution.setIntroduction(introduction);
        institution.setLule(lule);
        institution.setDevice(device);
        institution.setCommunication(communication);
        SS.addInstitution(institution);
        return RestResponseBo.ok();
    }

    @GetMapping("institutions_edit_page")
    public String institution_edit_page(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null) throw new TipException();
        Institution institution = institutionMapper.selectByPrimaryKey(Integer.valueOf(id));
        m.addAttribute("institution",institution);
        return "system/institutions_edit";
    }

    @PostMapping("institutions_edit")
    @ResponseBody
    public RestResponseBo institution_edit(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null)
            throw new TipException();
        SS.updateInstitution(Integer.valueOf(id),request);
        return RestResponseBo.ok();
    }

    @PostMapping("deleteInstitutions")
    @ResponseBody
    public RestResponseBo deleteInstitution(@RequestBody JSONObject js, HttpServletRequest request){
        String id = js.getString("id");
        institutionMapper.deleteByPrimaryKey(Integer.valueOf(id));
        return RestResponseBo.ok();
    }
}

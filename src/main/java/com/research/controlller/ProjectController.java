package com.research.controlller;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.TipException;
import com.research.model.Bo.Member;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.service.ProjectService;
import com.research.service.UserService;
import com.research.utils.CUtil;
import com.research.utils.FileUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{
    @Autowired
    InstitutionMapper institutionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    ProjectInspectionMapper PIM;
    @Autowired
    ClosureMapper CM;
    @Autowired
    ProjectCarryOverMapper PCM;
    @Autowired
    ContractMapper COM;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    ProjectOrganizationMapper projectOrganizationMapper;

    @GetMapping("apply")
    public String projectApp(Model m){
        List<Institution> list  = institutionMapper.selectByExample(new InstitutionExample());
        List<Organization> orgList  = organizationMapper.selectByExample(new OrganizationExample());
        List<User> userList = userMapper.selectByExample(new UserExample());
        m.addAttribute("insList",list);
        m.addAttribute("Users",userList);
        m.addAttribute("orgList",orgList);
        return "project/project_application";
    }

    /**
     * 项目立项，同时也是修改
     * @param name
     * @param leader
     * @param budget
     * @param ins
     * @param level
     * @param member
     * @param file
     * @param request
     * @return
     */
    //todo 测试接口
    @PostMapping("/apply")
    @ResponseBody
    public RestResponseBo apply(@RequestParam("projectName") String name,
                               @RequestParam("projectId") String number,
                               @RequestParam("projectLeader") String leader,
                               @RequestParam("budget") String budget,
                               @RequestParam("ins") String ins,
                               String level,
                               String[] member,
                               @RequestParam("projectFile") MultipartFile file,
                                HttpServletRequest request){
        Project project = new Project();
        project.setBudget(Integer.valueOf(budget));
        project.setNumber(number);
        project.setInstitution(ins);
        project.setLever(level);
        project.setLeader(leader);
        project.setName(name);
        project.setApplyTime(CUtil.getTime());
        project.setState(WebConstant.PROJECT_STATE_0);
        if(request.getParameter("isChange")!=null){
            project.setId(Integer.valueOf(request.getParameter("id")));
            project.setState(WebConstant.PROJECT_STATE_8);
        }

        User user = CUtil.getLoginUser(request);
        String path = CUtil.getUserFileUrl(request);

        String orgId = request.getParameter("org");
        String insId = request.getParameter("ins");
        ProjectOrganizationKey pok = new ProjectOrganizationKey();
        pok.setOid(Integer.valueOf(orgId));
        InstitutionProjectKey ipk = new InstitutionProjectKey();
        ipk.setInstitutionId(Integer.valueOf(insId));

        projectService.addProject(project,pok,ipk,member,file,path);
        return RestResponseBo.ok();
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("pList",projectService.getAll());
        return "project/project_list";
    }

    @GetMapping("audit")
    public String audit(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        String op =request.getParameter("op");
        User user = CUtil.getLoginUser(request);
        if(id != null) {
            String state=WebConstant.PROJECT_STATE_2;
            if(user.getRoleId()==3||user.getRole().equals(WebConstant.ROLE_3)){//如果是学院要审核的就查S0，不然查学院审核完的
                if(op.equals("yes"))
                {state=WebConstant.PROJECT_STATE_1;}
                else if(op.equals("no")){
                    state=WebConstant.STATE_3;
                }
            }
            else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
                if(op.equals("yes"))
                {
                    state=WebConstant.PROJECT_STATE_2;
                    //System.out.println(op);
                }
                else if(op.equals("no")){
                    state=WebConstant.STATE_4;
                    //System.out.println(op);
                }
            }
            //System.out.println(op);
            //System.out.println(state);
            projectService.audit(Integer.valueOf(id),state);
        }

        /*
        学院领导就审核立项的，学校领导就审核学院通过的项目
         */
        if(user.getRoleId() == 3||user.getRole().equals(WebConstant.ROLE_3)){
            m.addAttribute("pList",projectService.getS0());
        }else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
            m.addAttribute("pList",projectService.getS1());
        }
//        if(id != null) {
//            User user = CUtil.getLoginUser(request);
//            String state=WebConstant.PROJECT_STATE_2;
//            if(user!=null){
//                if(user.getRoleId()==3){//如果是学院要审核的就查S0，不然查学院审核完的
//                    state=WebConstant.PROJECT_STATE_1;
//                    m.addAttribute("pList",projectService.getS0());
//                }else {
//                    m.addAttribute("pList",projectService.getS1());
//                }
//            }else{//for test
//                m.addAttribute("pList",projectService.getS2());
//            }
//            projectService.audit(Integer.valueOf(id),state);
//        }else{
//            m.addAttribute("pList",projectService.getS0());
//        }
        return "project/project_audit";
    }

    /**
     * 项目列表
     * @param model
     * @return
     */
    @GetMapping("change_list")
    public String cLlist(Model model){
        model.addAttribute("pList",projectService.getS2());
        return "project/project_list";
    }

    /**
     * 要修改的项目界面
     * @param model
     * @param request
     * @return
     */
    @GetMapping("change")
    public String cp(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null){
            throw new TipException("请添加需要修改的项目id");
        }
        Project p = projectService.getOne(Integer.valueOf(id));

        List<Member> member = projectService.getMember(p.getId());
        List<Institution> inss  = institutionMapper.selectByExample(new InstitutionExample());
        List<Organization> orgs  = organizationMapper.selectByExample(new OrganizationExample());

        model.addAttribute("project",p);
        model.addAttribute("members",member);
        model.addAttribute("insList",inss);
        model.addAttribute("orgList",orgs);
        return "project/change";
    }

    /**
     * 项目修改的审核界面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("change_audit")
    public String cAudit(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        String op = request.getParameter("op");
        User user = CUtil.getLoginUser(request);
        if(id != null) {
            String state=WebConstant.PROJECT_STATE_2;
            if(user.getRoleId()==3||user.getRole().equals(WebConstant.ROLE_3)){//如果是学院要审核的就查S0，不然查学院审核完的
                if(op.equals("yes")) {
                    state = WebConstant.PROJECT_STATE_3;
                }
                else if(op.equals("no")){
                    state =WebConstant.STATE_3;
                }
            }
            else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
                if(op.equals("yes")) {
                    state = WebConstant.PROJECT_STATE_4;
                }
                else if(op.equals("no")){
                    state =WebConstant.STATE_4;
                }
            }
            projectService.audit(Integer.valueOf(id),state);
        }

        /*
        学院领导就审核立项的，学校领导就审核学院通过的项目
         */
        if(user.getRoleId() == 3||user.getRole().equals(WebConstant.ROLE_3)){
            m.addAttribute("pList",projectService.getS8());
        }else if(user.getRoleId() == 4||user.getRole().equals(WebConstant.ROLE_4)){
            m.addAttribute("pList",projectService.getS3());
        }
//        if(id != null) {
//            User user = CUtil.getLoginUser(request);
//            String state=WebConstant.PROJECT_STATE_2;
//            if(user!=null){
//                if(user.getRoleId()==3){
//                    state=WebConstant.PROJECT_STATE_3;
//                    m.addAttribute("pList",projectService.getS8());
//                }else {
//                    m.addAttribute("pList",projectService.getS3());
//                }
//            }else{//for test
//                m.addAttribute("pList",projectService.getS8());
//            }
//            projectService.audit(Integer.valueOf(id),state);
//        }else{
//            m.addAttribute("pList",projectService.getS8());
//        }
        return "project/change_audit";
    }

    /**
     * 审核查看页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("inspection")
    public String inspection(Model m,HttpServletRequest request){
        String pid = request.getParameter("pid");
        if(pid!=null){
            String inspId = request.getParameter("inspId");
            projectService.audit(Integer.valueOf(pid),WebConstant.PROJECT_STATE_7);
            projectService.reInsp(Integer.valueOf(inspId));
        }
        m.addAttribute("inspList",projectService.getInspections());
        m.addAttribute("projectList",projectService.getInspProject());
        return "project/inspection";
    }

    @PostMapping("addInspection")
    @ResponseBody
    public RestResponseBo addInspection(String pid,String name,String startTime,
                                        String endTime){
        ProjectInspection pi = new ProjectInspection();
        pi.setPid(Integer.valueOf(pid));
        pi.setName(name);
        pi.setStarttime(CUtil.getTime(startTime));
        pi.setEndtime(CUtil.getTime(endTime));
        pi.setState(WebConstant.PROJECT_STATE_5);
        projectService.addInsp(pi);
        return RestResponseBo.ok();
    }

    @GetMapping("inspQuery")
    public String inspQuery(Model m,HttpServletRequest request){
        m.addAttribute("inspList",projectService.getInspections());
        return "project/inspection_query";
    }

    @PostMapping("inspFile")
    @ResponseBody
    public RestResponseBo inspFile(Model m,String id,MultipartFile file,HttpServletRequest request) throws IOException {
        ProjectInspection pi = PIM.selectByPrimaryKey(Integer.valueOf(id));
        pi.setFileurl(FileUtil.save(file,CUtil.getInspUrl(request)));
        pi.setState(WebConstant.PROJECT_STATE_6);
        PIM.updateByPrimaryKey(pi);
        return RestResponseBo.ok();
    }

    @GetMapping("getInspFile")
    @ResponseBody
    public ResponseEntity<byte[]> getInspFile(HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        ProjectInspection pi = PIM.selectByPrimaryKey(Integer.valueOf(id));
        String url = pi.getFileurl();
        File file = new File(url);
        if (url == null || url.equals("") ||
                !file.exists()) {
            throw new TipException("非法路径");
        }
        byte[] body;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    /**
     * 结项查看页面
     * @param m
     * @param request
     * @return
     */
    @GetMapping("closure")
    public String closure(Model m,HttpServletRequest request){
        String pid = request.getParameter("pid");
        if(pid!=null){
            String id = request.getParameter("id");
            projectService.audit(Integer.valueOf(pid),WebConstant.PROJECT_STATE_10);
            projectService.reClosure(Integer.valueOf(id));
        }
        m.addAttribute("cloList",projectService.getClosures());
        m.addAttribute("projectList",projectService.getCloProject());
        return "project/closure";
    }

    @PostMapping("addClosure")
    @ResponseBody
    public RestResponseBo addClosure(String pid,String name,String startTime,
                                        String endTime){
        Closure c = new Closure();
        c.setPid(Integer.valueOf(pid));
        c.setName(name);
        c.setStarttime(CUtil.getTime(startTime));
        c.setEndtime(CUtil.getTime(endTime));
        c.setState(WebConstant.PROJECT_STATE_9);
        projectService.addClosure(c);
        return RestResponseBo.ok();
    }

    @GetMapping("cloQuery")
    public String cloQuery(Model m,HttpServletRequest request){
        m.addAttribute("cloList",projectService.getClosures());
        return "project/closure_query";
    }

    @PostMapping("cloFile")
    @ResponseBody
    public RestResponseBo cloFile(Model m,String id,MultipartFile file,HttpServletRequest request) throws IOException {
        Closure c = CM.selectByPrimaryKey(Integer.valueOf(id));
        c.setFileurl(FileUtil.save(file,CUtil.getCloUrl(request)));
        c.setState(WebConstant.PROJECT_STATE_11);
        CM.updateByPrimaryKey(c);
        return RestResponseBo.ok();
    }

    @GetMapping("getCloFile")
    @ResponseBody
    public ResponseEntity<byte[]> getCloFile(HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        Closure c = CM.selectByPrimaryKey(Integer.valueOf(id));
        String url = c.getFileurl();
        File file = new File(url);
        if (url == null || url.equals("") ||
                !file.exists()) {
            throw new TipException("非法路径");
        }
        byte[] body;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @GetMapping("/project_carried_over")
    public String carried_over_list(Model model){
        model.addAttribute("cList",projectService.getCarryOver());
        return "project/project_carried_over";
    }

    @GetMapping("write")
    public String wp(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null){
            throw new TipException("请添加需要修改的项目id");
        }
        ProjectCarryOver p = projectService.getOne1(Integer.valueOf(id));
        //Project pc =projectService.getOne(Integer.valueOf(id));
        model.addAttribute("project",p);
        return "project/write";
    }

    @PostMapping("/addOperate1")
    @ResponseBody
    public RestResponseBo addOperate1(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null)
            throw new TipException();
        projectService.updateProject(Integer.valueOf(id),request);
        return RestResponseBo.ok();
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponseBo delete(@RequestBody JSONObject js, HttpServletRequest request){
        String id = js.getString("id");
        PCM.deleteByPrimaryKey(Integer.valueOf(id));
        return RestResponseBo.ok();
    }

    @GetMapping("/project_carry_over")
    public String carry_over_list(Model m,HttpServletRequest request){
        m.addAttribute("coList",projectService.getS10());
        return "project/project_carry_over";
    }


    @PostMapping("delete1")
    @ResponseBody
    public RestResponseBo delete1(@RequestBody JSONObject js){
        String id = js.getString("id");
        projectService.audit(Integer.valueOf(id),WebConstant.PROJECT_STATE_12);
        PCM.deleteByPrimaryKey(Integer.valueOf(id));
        return RestResponseBo.ok();
    }

    @GetMapping("operate")
    public String op(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        //System.out.println(id);
            if(id!=null){
            projectService.audit(Integer.valueOf(id),WebConstant.PROJECT_STATE_12);
        }
        m.addAttribute("pLIst",projectService.getAll());
        return "project/operate";
    }

    /**
     * 项目结转操作接口
     * @param lid
     * @param sid
     * @param leader
     * @param money
     * @param date
     * @return
     */
    @PostMapping("addOperate")
    @ResponseBody
    public RestResponseBo addOperate(String name,String institution,String lid,
                                     String sid,
                                     String leader,
                                     String money,
                                     String date){
        ProjectCarryOver p = new ProjectCarryOver();
        p.setName(name);
        p.setInstitution(institution);
        p.setlId(Integer.valueOf(lid));
        p.setsId(Integer.valueOf(sid));
        p.setLeader(leader);
        p.setMoney(Integer.valueOf(money));
        p.setDate(date);
        PCM.insertSelective(p);
        return RestResponseBo.ok();
    }


    @GetMapping("contract")
    public String contract(Model m,HttpServletRequest request){

        m.addAttribute("conList",projectService.getContract());
        m.addAttribute("projectList",projectService.getAll1());
        return "project/contract_management";
    }

    @PostMapping("/addContract")
    @ResponseBody
    public RestResponseBo addContract(String cid,String name,String leader,
                                        String cType,String planType,String effectiveDate){
        Contract c = new Contract();
        c.setCid(Integer.valueOf(cid));
        c.setName(name);
        c.setLeader(leader);
        c.setcType(cType);
        c.setPlantype(planType);
        c.setEffectiveDate(effectiveDate);
        c.setState(WebConstant.PROJECT_STATE_0);
        projectService.addContract(c);
        //COM.insertSelective(c);
        return RestResponseBo.ok();
    }

    @GetMapping("edit1")
    public String ep(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        if(id == null){
            throw new TipException("请添加需要修改的项目id");
        }
        Contract p = projectService.getOne2(Integer.valueOf(id));
        //Project pc =projectService.getOne(Integer.valueOf(id));
        model.addAttribute("contract",p);
        return "project/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public RestResponseBo edit(Model m, HttpServletRequest request){
        String id = request.getParameter("id");
        if(id==null)
            throw new TipException();
        //String state =WebConstant.PROJECT_STATE_8;
        projectService.updateContract(Integer.valueOf(id),request);
        return RestResponseBo.ok();
    }

    @GetMapping("contract_audit")
    public String coAudit(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        String op = request.getParameter("op");
        User user = CUtil.getLoginUser(request);
        if(id != null) {
            String state=WebConstant.PROJECT_STATE_2;
            if(user.getRoleId()==3||user.getRole().equals(WebConstant.ROLE_3)){//如果是学院要审核的就查S0，不然查学院审核完的
                if(op.equals("yes")) {
                    state = WebConstant.PROJECT_STATE_1;
                }
                else if(op.equals("no")){
                    state =WebConstant.STATE_3;
                }
            }
            else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
                if(op.equals("yes")) {
                    state = WebConstant.PROJECT_STATE_2;
                }
                else if(op.equals("no")){
                    state =WebConstant.STATE_4;
                }
            }
            projectService.audit1(Integer.valueOf(id),state);
        }

        /*
        学院领导就审核立项的，学校领导就审核学院通过的项目
         */
        if(user.getRoleId() == 3||user.getRole().equals(WebConstant.ROLE_3)){
            m.addAttribute("pList",projectService.getC0());
        }else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
            m.addAttribute("pList",projectService.getC1());
        }
        return "project/contract_audit";
    }

    @GetMapping("contract_change_audit")
    public String ccAudit(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        String op = request.getParameter("op");
        User user = CUtil.getLoginUser(request);
        if(id != null) {
            String state=WebConstant.PROJECT_STATE_2;
            if(user.getRoleId()==3||user.getRole().equals(WebConstant.ROLE_3)){//如果是学院要审核的就查S0，不然查学院审核完的
               if(op.equals("yes")) {
                   state = WebConstant.PROJECT_STATE_3;
               }
                else if(op.equals("no")){
                    state =WebConstant.STATE_3;
                }
            }
            else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
                if(op.equals("yes")) {
                    state = WebConstant.PROJECT_STATE_4;
                }
                else if(op.equals("no")){
                    state =WebConstant.STATE_4;
                }
            }
            projectService.audit1(Integer.valueOf(id),state);
        }

        /*
        学院领导就审核立项的，学校领导就审核学院通过的项目
         */
        if(user.getRoleId() == 3||user.getRole().equals(WebConstant.ROLE_3)){
            m.addAttribute("pList",projectService.getC8());
        }else if(user.getRoleId()==4||user.getRole().equals(WebConstant.ROLE_4)){
            m.addAttribute("pList",projectService.getC3());
        }
        return "project/contract_change_audit";
    }
}

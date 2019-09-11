package com.research.service.impl;

import com.research.constant.WebConstant;
import com.research.dao.*;
import com.research.exception.TipException;
import com.research.model.Bo.Member;
import com.research.model.Vo.*;
import com.research.service.ProjectService;
import com.research.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectUserMapper PUMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProjectInspectionMapper PIM;
    @Autowired
    ClosureMapper CM;
    @Autowired
    ProjectCarryOverMapper PCM;
    @Autowired
    ContractMapper COM;
    @Autowired
    InstitutionProjectMapper institutionProjectMapper;
    @Autowired
    ProjectOrganizationMapper projectOrganizationMapper;


    @Override
    @Transactional
    public String addProject(Project project,ProjectOrganizationKey pok,InstitutionProjectKey ipk, String[] member, MultipartFile file,String dir){
        try {
            if(file!=null) {
                String url = FileUtil.save(file, dir);
                project.setResulturl(url);
            }
        }catch (IOException ioe){
//            ioe.printStackTrace();
//            throw new TipException("文件保存失败");不抛出了,修改需要用到
        }
        if(project.getId()==null)
            projectMapper.insert(project);
        else
            projectMapper.updateByPrimaryKeySelective(project);

        int id = project.getId();
        //先删除相同项目的成员
        ProjectUserExample pue = new ProjectUserExample();
        pue.createCriteria().andProjectIdEqualTo(id);
        PUMapper.deleteByExample(pue);
        for(int i=0;i<member.length;i++){
            ProjectUser pu = new ProjectUser();
            pu.setProjectId(id);
            pu.setUserId(Integer.valueOf(member[i]));
            PUMapper.insert(pu);
        }
        //先删除关联表内容
        ProjectOrganizationExample poe = new ProjectOrganizationExample();
        ProjectOrganizationExample.Criteria criteria = poe.createCriteria();
//        criteria.andOidEqualTo(pok.getOid());
        criteria.andPidEqualTo(id);
        projectOrganizationMapper.deleteByExample(poe);
//        ProjectOrganizationKey projectOrganizationKey = new ProjectOrganizationKey();
//        projectOrganizationKey.setPid(project.getId());
//        projectOrganizationKey.setOid(pok.getOid());
        pok.setPid(id);
        projectOrganizationMapper.insert(pok);

        InstitutionProjectExample ipe = new InstitutionProjectExample();
        InstitutionProjectExample.Criteria criteria1 =ipe.createCriteria();
        criteria1.andProjectIdEqualTo(id);
        institutionProjectMapper.deleteByExample(ipe);
//        InstitutionProjectKey institutionProjectKey = new InstitutionProjectKey();
//        institutionProjectKey.setInstitutionId(ipk.getInstitutionId());
//        institutionProjectKey.setProjectId(ipk.getProjectId());
        ipk.setProjectId(id);
        institutionProjectMapper.insert(ipk);

        return "成功";
    }

    @Override
    public void reInsp(Integer inspId) {
        PIM.deleteByPrimaryKey(inspId);
    }


    @Override
    public void addInsp(ProjectInspection pi) {
        PIM.insert(pi);
    }


    @Override
    public List<Project> getAll() {
        return projectMapper.selectByExample(new ProjectExample());
    }

    @Override
    public List<Contract> getAll1() {
        return COM.selectByExample(new ContractExample());
    }

    @Override
    public Project getOne(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProjectCarryOver getOne1(Integer id) {
        return PCM.selectByPrimaryKey(id);
    }

    @Override
    public Contract getOne2(Integer id){
        return COM.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> getInspProject() {
        ProjectExample PE = new ProjectExample();
        PE.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_2);
        return projectMapper.selectByExample(PE);
    }

    @Override
    public List<Contract> getConProject(){
        ContractExample CE = new ContractExample();
        CE.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_2);
        return COM.selectByExample(CE);
    }

    @Override
    public List<ProjectInspection> getInspections() {
        ProjectInspectionExample PIE = new ProjectInspectionExample();
        return PIM.selectByExample(PIE);
    }

    @Override
    public List<Contract> getContract() {
        ContractExample CE = new ContractExample();
        return COM.selectByExample(CE);
    }

    @Override
    public List<ProjectCarryOver> getCarryOver() {
        ProjectCarryOverExample PCE = new ProjectCarryOverExample();
        return PCM.selectByExample(PCE);
    }

    @Override
    public void addClosure(Closure c) {
        CM.insert(c);
    }

    @Override
    public void reClosure(Integer id) {
        CM.deleteByPrimaryKey(id);
    }

    @Override
    public void addContract(Contract c) {
        COM.insert(c);
    }

    @Override
    public List<Closure> getClosures() {
        ClosureExample ce = new ClosureExample();
        return CM.selectByExample(ce);
    }

    @Override
    public List<Project> getCloProject() {
        ProjectExample PE = new ProjectExample();
        PE.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_7);
        return projectMapper.selectByExample(PE);
    }

    @Override
    public List<Member> getMember(Integer id) {
        ProjectUserExample pue = new ProjectUserExample();
        pue.createCriteria().andProjectIdEqualTo(id);
        List<ProjectUser> list = PUMapper.selectByExample(pue);

        //取出所有用户列表
        List<Member> member = new ArrayList<>();
        List<User> userList = userMapper.selectByExample(new UserExample());
        for(User user:userList){
            member.add(new Member(id,user.getName(),user.getId()));
        }
        //把属于当前project的放入
        Map<Integer,String> map = new HashMap<>();
        for(ProjectUser pu:list){
            map.put(pu.getUserId(),"in");
        }
        //根据map修改belgon
        for(Member mem:member){
            if(map.get(mem.getUid())!=null){
                mem.setBe(true);
            }
        }
        return member;
    }

    @Override
    public List<Project> getS0() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_0);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS1() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_1);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS2() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_2);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS3() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_3);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS4() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_4);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS5() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_5);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS8() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_8);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS6() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_6);
        return projectMapper.selectByExample(pe);
    }

    @Override
    public List<Project> getS10() {
        ProjectExample pe = new ProjectExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_10);
        return projectMapper.selectByExample(pe);
    }


    @Override
    public List<Contract> getC0() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_0);
        return COM.selectByExample(pe);
    }

    @Override
    public List<Contract> getC1() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_1);
        return COM.selectByExample(pe);
    }

    @Override
    public List<Contract> getC2() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_2);
        return COM.selectByExample(pe);
    }

    @Override
    public List<Contract> getC3() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_3);
        return COM.selectByExample(pe);
    }

    @Override
    public List<Contract> getC4() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_4);
        return COM.selectByExample(pe);
    }

    @Override
    public List<Contract> getC8() {
        ContractExample pe = new ContractExample();
        pe.createCriteria().andStateEqualTo(WebConstant.PROJECT_STATE_8);
        return COM.selectByExample(pe);
    }

    @Override
    public void audit(Integer id,String state) {
        Project p = projectMapper.selectByPrimaryKey(id);
        if(p==null) throw new TipException("非法id");
        p.setState(state);
        projectMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public void audit1(Integer id,String state) {
        Contract p = COM.selectByPrimaryKey(id);
        if(p==null) throw new TipException("非法id");
        p.setState(state);
        COM.updateByPrimaryKeySelective(p);
    }

    @Override
    public void updateProject(Integer id, HttpServletRequest request) {
        ProjectCarryOver pc = PCM.selectByPrimaryKey(id);
        if(pc == null)
            throw new TipException("不存在该项目");
        String name = request.getParameter("name");
        String institution = request.getParameter("institution");
        String lid = request.getParameter("lid");
        String sid = request.getParameter("sid");
        String leader = request.getParameter("leader");
        String date = request.getParameter("date");

        pc.setName(name==null?pc.getName():name);
        pc.setInstitution(institution==null?pc.getInstitution():institution);
        pc.setlId(lid==null?pc.getlId():Integer.valueOf(lid));
        pc.setsId(sid==null?pc.getsId():Integer.valueOf(sid));
        pc.setLeader(leader==null?pc.getLeader():leader);
        pc.setDate(date==null?pc.getDate():date);
        PCM.updateByPrimaryKeySelective(pc);
    }

    @Override
    public void updateContract(Integer id, HttpServletRequest request){
        Contract pc = COM.selectByPrimaryKey(id);
        if(pc == null)
            throw new TipException("不存在该项目");
        String name = request.getParameter("name");
        String cid = request.getParameter("cid");
        String leader = request.getParameter("leader");
        String cType = request.getParameter("cType");
        String planType = request.getParameter("planType");
        String effectiveDate = request.getParameter("effectiveDate");
        //String state = request.getParameter("state");
        String state=WebConstant.PROJECT_STATE_8;

        pc.setName(name==null?pc.getName():name);
        pc.setCid(cid==null?pc.getCid():Integer.valueOf(cid));
        pc.setLeader(leader==null?pc.getLeader():leader);
        pc.setcType(cType ==null?pc.getcType():cType);
        pc.setPlantype(planType ==null?pc.getPlantype():planType);
        pc.setEffectiveDate(effectiveDate==null?pc.getEffectiveDate():effectiveDate);
        pc.setState(state ==null?pc.getState():state);
        COM.updateByPrimaryKeySelective(pc);
    }

}

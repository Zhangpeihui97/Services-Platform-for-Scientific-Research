package com.research.service;

import com.research.model.Bo.Member;
import com.research.model.Vo.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ProjectService {
    public String addProject(Project project,ProjectOrganizationKey pok,InstitutionProjectKey ipk,String[] member, MultipartFile file,String dir);

    void addInsp(ProjectInspection pi);

    void reInsp(Integer inspId);

    public List<Project> getAll();

    public List<Contract> getAll1();

    Project getOne(Integer id);

    ProjectCarryOver getOne1(Integer id);

    Contract getOne2(Integer id);

    List<ProjectInspection> getInspections();

    public List<Contract> getContract();

    List<Project> getInspProject();

    List<Contract> getConProject();

    List<ProjectCarryOver> getCarryOver();

    void addClosure(Closure pi);

    void reClosure(Integer id);

    void addContract(Contract c);

    List<Closure> getClosures();

    List<Project> getCloProject();

    List<Member> getMember(Integer id);

    List<Project> getS0();

    List<Project> getS1();

    List<Project> getS2();

    List<Project> getS3();

    List<Project> getS4();

    List<Project> getS5();

    List<Project> getS6();

    List<Project> getS8();

    List<Project> getS10();

    List<Contract> getC0();

    List<Contract> getC1();

    List<Contract> getC2();

    List<Contract> getC3();

    List<Contract> getC4();

    List<Contract> getC8();
    /**
     * 修改项目状态，用于审核等各种
     * @param id
     * @param state
     */
    void audit(Integer id,String state);

    void audit1(Integer id,String state);

    void updateProject(Integer id, HttpServletRequest request);

    void updateContract(Integer id, HttpServletRequest request);
}

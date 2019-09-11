package com.research.model.Bo;

import com.research.model.Vo.Organization;

public class OriUserBo extends Organization {
    private int userNum ;
    private int projectNum;
    private int paperNum;
    public OriUserBo(){}
    public OriUserBo(Organization org,int userNumber,int projectNumber,int paperNumber)
    {
        this.userNum = userNumber;
        this.projectNum = projectNumber;
        this.paperNum = paperNumber;
        this.setId(org.getId());
        this.setName(org.getName());
        this.setType(org.getType());
        this.setLeaderId(org.getLeaderId());
        this.setLeaderName(org.getLeaderName());
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public int getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public Integer getLeaderId() {
        return super.getLeaderId();
    }

    @Override
    public void setLeaderId(Integer leaderId) {
        super.setLeaderId(leaderId);
    }

    @Override
    public String getLeaderName() {
        return super.getLeaderName();
    }

    @Override
    public void setLeaderName(String leaderName) {
        super.setLeaderName(leaderName);
    }
}

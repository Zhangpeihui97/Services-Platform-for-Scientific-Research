package com.research.model.Vo;

public class ProjectFund {
    private Integer id;

    private Integer fid;

    private Integer fmoney;

    private Integer ftotalmoney;

    private String fpaymentunit;

    private String fdate;

    private String name;

    private String lever;

    private String number;

    private String leader;

    private Integer budget;

    private String startTime;

    private String endTime;

    private String applyTime;

    private String institution;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFmoney() {
        return fmoney;
    }

    public void setFmoney(Integer fmoney) {
        this.fmoney = fmoney;
    }

    public Integer getFtotalmoney() {
        return ftotalmoney;
    }

    public void setFtotalmoney(Integer ftotalmoney) {
        this.ftotalmoney = ftotalmoney;
    }

    public String getFpaymentunit() {
        return fpaymentunit;
    }

    public void setFpaymentunit(String fpaymentunit) {
        this.fpaymentunit = fpaymentunit == null ? null : fpaymentunit.trim();
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate == null ? null : fdate.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever == null ? null : lever.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime == null ? null : applyTime.trim();
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
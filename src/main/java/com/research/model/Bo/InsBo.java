package com.research.model.Bo;

import com.research.model.Vo.Institution;

public class InsBo extends Institution{
    private int userNum ;
    private int projectNum;
    public InsBo(){}
    public InsBo(Institution institution, int userNumber, int projectNumber)
    {
        this.userNum = userNumber;
        this.projectNum = projectNumber;
        this.setId(institution.getId());
        this.setName(institution.getName());
        this.setType(institution.getType());
        this.setIntroduction(institution.getIntroduction());
        this.setLule(institution.getLule());
        this.setDevice(institution.getDevice());
        this.setCommunication(institution.getCommunication());
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
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
    public String getIntroduction() {
        return super.getIntroduction();
    }

    @Override
    public void setIntroduction(String introduction) {
        super.setIntroduction(introduction);
    }

    @Override
    public String getLule() {
        return super.getLule();
    }

    @Override
    public void setLule(String lule) {
        super.setLule(lule);
    }

    @Override
    public String getDevice() {
        return super.getDevice();
    }

    @Override
    public void setDevice(String device) {
        super.setDevice(device);
    }

    @Override
    public String getCommunication() {
        return super.getCommunication();
    }

    @Override
    public void setCommunication(String communication) {
        super.setCommunication(communication);
    }
}

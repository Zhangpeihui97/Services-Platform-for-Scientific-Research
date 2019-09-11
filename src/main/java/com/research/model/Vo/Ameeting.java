package com.research.model.Vo;

import java.util.Date;

public class Ameeting {
    private Integer id;

    private String name;

    private String participant;

    private String unit;

    private String type;

    private String timeFormular;

    private String state;

    private Date timeS;

    private Date timeE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTimeFormular() {
        return timeFormular;
    }

    public void setTimeFormular(String timeFormular) {
        this.timeFormular = timeFormular == null ? null : timeFormular.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getTimeS() {
        return timeS;
    }

    public void setTimeS(Date timeS) {
        this.timeS = timeS;
    }

    public Date getTimeE() {
        return timeE;
    }

    public void setTimeE(Date timeE) {
        this.timeE = timeE;
    }
}
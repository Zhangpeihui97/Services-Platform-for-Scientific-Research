package com.research.model.Vo;


public class Pstate {
    private Integer id;

    private String stateCh;

    private String stateEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateCh() {
        return stateCh;
    }

    public void setStateCh(String stateCh) {
        this.stateCh = stateCh == null ? null : stateCh.trim();
    }

    public String getStateEn() {
        return stateEn;
    }

    public void setStateEn(String stateEn) {
        this.stateEn = stateEn == null ? null : stateEn.trim();
    }
}
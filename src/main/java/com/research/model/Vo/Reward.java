package com.research.model.Vo;

public class Reward {
    private Integer id;

    private String baseInfo;

    private String baseClass;

    private String baseResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo == null ? null : baseInfo.trim();
    }

    public String getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(String baseClass) {
        this.baseClass = baseClass == null ? null : baseClass.trim();
    }

    public String getBaseResult() {
        return baseResult;
    }

    public void setBaseResult(String baseResult) {
        this.baseResult = baseResult == null ? null : baseResult.trim();
    }
}
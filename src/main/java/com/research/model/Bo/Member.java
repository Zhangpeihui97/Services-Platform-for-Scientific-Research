package com.research.model.Bo;

/**
 * 返回用户列表，并标明那些是项目成员的
 */
public class Member {
    private Integer uid;
    private String name;
    private Integer pId;
    private boolean be = false;

    public Member(Integer id,String name){
        this.pId=id;
        this.name=name;
    }

    public Member(Integer id,String name,Integer uid){
        this.uid=uid;
        this.pId=id;
        this.name=name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public boolean isBe() {
        return be;
    }

    public void setBe(boolean be) {
        this.be = be;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}

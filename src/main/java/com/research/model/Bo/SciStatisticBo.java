package com.research.model.Bo;

import com.research.model.Vo.SciStatistics;
import com.research.utils.CUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SciStatisticBo extends SciStatistics {
    private String date;

    /**
     * Vo会变化，在这里绑定
     */
    public SciStatisticBo(){}
    public SciStatisticBo(SciStatistics sci){
        this.date=CUtil.getTime(sci.getDate());
        this.setId(sci.getId());
        this.setDate(sci.getDate());
        this.setEducation(sci.getEducation());
        this.setInstitution(sci.getInstitution());
        this.setName(sci.getName());
        this.setResearch(sci.getResearch());
        this.setUnit(sci.getResearch());
    }

    public String getDateFormal(){
        return this.date;
    }

    public static List<SciStatisticBo> praseList(List<SciStatistics> ssList){
        List<SciStatisticBo> list = new ArrayList<>();
        for(SciStatistics ss:ssList){
            list.add(new SciStatisticBo(ss));
        }
        return list;
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
    public String getEducation() {
        return super.getEducation();
    }

    @Override
    public void setEducation(String education) {
        super.setEducation(education);
    }

    @Override
    public String getUnit() {
        return super.getUnit();
    }

    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    @Override
    public String getResearch() {
        return super.getResearch();
    }

    @Override
    public void setResearch(String research) {
        super.setResearch(research);
    }

    @Override
    public String getInstitution() {
        return super.getInstitution();
    }

    @Override
    public void setInstitution(String institution) {
        super.setInstitution(institution);
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
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(Date date) {
        super.setDate(date);
    }
}

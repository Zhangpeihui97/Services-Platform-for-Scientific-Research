package com.research.model.Bo;

import com.research.dao.SocStatisticMapper;
import com.research.model.Vo.SocStatistic;
import com.research.utils.CUtil;

import java.util.ArrayList;
import java.util.List;

public class SocStatisticBo extends SocStatistic {
    private String date;

    /**
     * Vo会变化，在这里绑定
     */
    public SocStatisticBo(){}
    public SocStatisticBo(SocStatistic soc){
        this.date=CUtil.getTime(soc.getDate());
        this.setId(soc.getId());
        this.setDate(soc.getDate());
        this.setEducation(soc.getEducation());
        this.setInstitution(soc.getInstitution());
        this.setName(soc.getName());
        this.setResearch(soc.getResearch());
        this.setUnit(soc.getResearch());
        this.setDegree(soc.getDegree());
        this.setState(soc.getState());
    }

    public String getDateFormal(){
        return this.date;
    }

    public static List<SocStatisticBo> praseList(List<SocStatistic> ssList){
        List<SocStatisticBo> list = new ArrayList<>();
        for(SocStatistic ss:ssList){
            list.add(new SocStatisticBo(ss));
        }
        return list;
    }
}

package com.research.service.impl;

import com.research.constant.WebConstant;
import com.research.dao.MessageMapper;
import com.research.model.Vo.*;
import com.research.dao.InstitutionMapper;
import com.research.dao.OrganizationMapper;
import com.research.exception.TipException;
import com.research.service.SystemService;
import com.research.utils.CUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.AAShapePipe;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    MessageMapper MM;
    @Autowired
    OrganizationMapper OM;
    @Autowired
    InstitutionMapper IM;

    @Override
    public void addUserMes(String title,String message, Integer id) {
        Message mes = new Message();
        mes.setType(WebConstant.MES_TYPE_0);
        mes.setContent(message);
        mes.setState(WebConstant.MES_STATE_0);
        mes.setTime(new Date());
        mes.setUserid(id);
        mes.setTimeformat(CUtil.getTime());
        mes.setTitle(title);
        MM.insert(mes);
    }

    public void addSystemMes(String title,String message, Integer id) {
        Message mes = new Message();
        mes.setType(WebConstant.MES_TYPE_1);
        mes.setContent(message);
        mes.setState(WebConstant.MES_STATE_0);
        mes.setTime(new Date());
        mes.setUserid(id);
        mes.setTimeformat(CUtil.getTime());
        mes.setTitle(title);
        MM.insert(mes);
    }

    @Override
    public List<Message> getUserMessage(User user) {
        MessageExample me = new MessageExample();
        MessageExample.Criteria c = me.createCriteria();
        c.andUseridEqualTo(user.getId());
        c.andTypeEqualTo(WebConstant.MES_TYPE_0);
        return MM.selectByExample(me);
    }

    @Override
    public List<Message> getSystemMessage(User user) {
        MessageExample me = new MessageExample();
        MessageExample.Criteria c = me.createCriteria();
        c.andTypeEqualTo(WebConstant.MES_TYPE_1);
        return MM.selectByExample(me);
    }

    @Override
    public List<Organization> findAllOrganization(){return null;}

    @Override
    public void addOrganization(Organization organization){OM.insert(organization); }

    @Override
    public void updateOrganization(Integer id, HttpServletRequest request) {
        Organization organization = OM.selectByPrimaryKey(id);
        if(organization == null)
            throw new TipException("不存在该组织机构");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String leaderName = request.getParameter("leaderName");


        organization.setName(name==null?organization.getName():name);
        organization.setType(type==null?organization.getType():type);
        organization.setLeaderName(leaderName==null?organization.getLeaderName():leaderName);
        OM.updateByPrimaryKeySelective(organization);
    }

    @Override
    public List<Institution> findAllInstitution(){return null;}

    @Override
    public void addInstitution(Institution institution){IM.insert(institution); }

    @Override
    public void updateInstitution(Integer id, HttpServletRequest request) {
        Institution institution = IM.selectByPrimaryKey(id);
        if(institution == null)
            throw new TipException("不存在该科研平台");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String introduction = request.getParameter("introduction");
        String lule = request.getParameter("lule");
        String device = request.getParameter("device");
        String communication = request.getParameter("communication");

        institution.setName(name==null?institution.getName():name);
        institution.setType(type==null?institution.getType():type);
        institution.setIntroduction(introduction==null?institution.getIntroduction():introduction);
        institution.setLule(lule==null?institution.getLule():lule);
        institution.setDevice(device==null?institution.getDevice():device);
        institution.setCommunication(communication==null?institution.getCommunication():communication);

        IM.updateByPrimaryKeySelective(institution);

    }
}

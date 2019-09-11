package com.research.service;

import com.research.model.Vo.Message;
import com.research.model.Vo.User;
import com.research.model.Vo.Organization;
import com.research.model.Vo.Institution;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SystemService {
    public void addUserMes(String title,String message, Integer id);

    List<Message> getUserMessage(User user);

    public void addSystemMes(String title,String message, Integer id);

    public List<Message> getSystemMessage(User user);

    List<Organization> findAllOrganization();

    void addOrganization(Organization organization);

    void updateOrganization(Integer id, HttpServletRequest request);

    List<Institution> findAllInstitution();

    void addInstitution(Institution institution);

    void updateInstitution(Integer id, HttpServletRequest request);
}

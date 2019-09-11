package com.research.service.impl;

import com.research.dao.InstitutionMapper;
import com.research.model.Vo.Institution;
import com.research.model.Vo.InstitutionExample;
import com.research.service.InsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsServiceImpl implements InsService {
    @Autowired
    InstitutionMapper IM;
    @Override
    public List<Institution> getAll() {
        return IM.selectByExample(new InstitutionExample());
    }
}

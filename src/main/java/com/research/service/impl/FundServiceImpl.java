package com.research.service.impl;

import com.research.dao.FundMapper;
import com.research.dao.IncomeMapper;
import com.research.dao.OutcomeMapper;
import com.research.dao.ProjectMapper;
import com.research.exception.ErrorException;
import com.research.exception.TipException;
import com.research.model.Vo.Fund;
import com.research.model.Vo.Income;
import com.research.model.Vo.Outcome;
import com.research.model.Vo.Project;
import com.research.service.FundService;
import com.research.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FundServiceImpl implements FundService {

    @Autowired
    ProjectService projectService;
    @Autowired
    IncomeMapper incomeMapper;
    @Autowired
    FundMapper fundMapper;
    @Autowired
    OutcomeMapper outcomeMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    @Transactional
    public void income(Income income) {
        Fund fund = fundMapper.selectByPrimaryKey(income.getFid());
        if(fund.getMoney()<income.getMoney()){
            throw new TipException("金额超过到款金额");
        }
        fund.setMoney(fund.getMoney()-income.getMoney());
        fundMapper.updateByPrimaryKey(fund);
        incomeMapper.insert(income);

        Project project=projectMapper.selectByPrimaryKey(income.getPid());
        project.setMoney(project.getMoney()+income.getMoney());
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    @Transactional
    public void outcome(Outcome outcome) {
        Project project = projectMapper.selectByPrimaryKey(outcome.getPid());
        if(project.getMoney()<outcome.getMoney()){
            throw new ErrorException();
        }
        project.setMoney(project.getMoney()-outcome.getMoney());
        projectMapper.updateByPrimaryKeySelective(project);
        outcomeMapper.insertSelective(outcome);
    }
}

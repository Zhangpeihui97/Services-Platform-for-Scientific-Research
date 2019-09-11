package com.research.controlller.admin;

import com.research.dao.*;
import com.research.model.Bo.RestResponseBo;
import com.research.model.Vo.*;
import com.research.service.FundService;
import com.research.service.ProjectService;
import com.research.utils.CUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/fund")
public class FundController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    FundMapper fundMapper;
    @Autowired
    IncomeMapper incomeMapper;
    @Autowired
    OutcomeMapper outcomeMapper;
    @Autowired
    ProjectFundMapper PFM;
    @Autowired
    FundService fundService;
    @Autowired
    ProjectIncomeMapper PIM;
    @Autowired
    ProjectOutcomeMapper POM;

    /**
     * 增加到账资金的页面
     * @param m
     * @return
     */
    @GetMapping("fund_page")
    public String fund(Model m){
        m.addAttribute("pLIst",projectService.getAll());
        return "admin/fund/project_funds";
    }

    /**
     * 资金到账增加接口
     * @param pId
     * @param paymentUnit
     * @param money
     * @param date
     * @param request
     * @return
     */
    @PostMapping("fund_add")
    @ResponseBody
    public RestResponseBo fund(String pId,
                               String paymentUnit,
                               String money,
                               String date,
                               HttpServletRequest request){
        Fund fund = new Fund();
        fund.setPid(Integer.valueOf(pId));
        fund.setMoney(Integer.valueOf(money));
        fund.setPaymentUnit(paymentUnit);
        fund.setDate(date);

        fundMapper.insertSelective(fund);
        return RestResponseBo.ok();
    }

    /**
     * 到账列表页面
     * 同时如果有参数过来的话就作为增加到款的接口
     *
     *      * 还需要权限验证
     *      * 还可以将功能做成独立页面
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("fund_list")
    public String incomeList(Model m,HttpServletRequest request){
        //todo 权限验证
        String pId = request.getParameter("pId");
        String operator = request.getParameter("operator");
        String money = request.getParameter("money");
        String fId = request.getParameter("fId");
        String payment = request.getParameter("paymentUnit");
        if(fId!=null){
            Income income1 = new Income();
            income1.setPid(Integer.valueOf(pId));
            income1.setOperator(operator);
            income1.setMoney(Integer.valueOf(money));
            income1.setFid(Integer.valueOf(fId));
            income1.setDate(CUtil.getTime());
            income1.setPaymentUnit(payment);
            fundService.income(income1);
        }

        m.addAttribute("list",PFM.selectByExample(new ProjectFundExample()));
        return "admin/fund/fund_list";
    }


    /**
     * 到狂列表页面，有打印功能
     * @param m
     * @return
     */
    @GetMapping("income")
    public String income(Model m){
        m.addAttribute("list",PIM.selectByExample(new ProjectIncomeExample()));
        return "admin/fund/income_list";
    }

    /**
     * 打印页面具体信息
     * @param m
     * @param request
     * @return
     */
    @GetMapping("printing")
    public String printing(Model m,HttpServletRequest request){
        String id = request.getParameter("id");
        ProjectIncomeExample pie = new ProjectIncomeExample();
        pie.createCriteria().andIdEqualTo(Integer.valueOf(id));
        ProjectIncome pi = PIM.selectByExample(pie).get(0);
        m.addAttribute("income",pi);
        m.addAttribute("number",pi.getId()+"-"+pi.getNumber());
        m.addAttribute("date",CUtil.getTime());
        return "admin/fund/printing";
    }

    /**
     * 项目资金列表，有支出登记接口
     *
     *      * 还需要权限验证
     *      * 还可以将功能做成独立页面
     *
     * @param m
     * @param request
     * @return
     */
    @GetMapping("outcome")
    public String outcome(Model m,HttpServletRequest request){
        String pId = request.getParameter("pId");
        String applyUser = request.getParameter("applyUser");
        String money = request.getParameter("money");
        String purpose = request.getParameter("purpose");

        if(pId!=null){
            Outcome outcome = new Outcome();
            outcome.setApplyUser(applyUser);
            outcome.setPid(Integer.valueOf(pId));
            outcome.setMoney(Integer.valueOf(money));
            outcome.setPurpose(purpose);
            outcome.setDate(CUtil.getTime());
            fundService.outcome(outcome);
        }

        m.addAttribute("pLIst",projectService.getAll());
        return "admin/fund/outcome_registration";
    }

    @GetMapping("outcomeList")
    public String outcomeList(Model m,HttpServletRequest request){
        m.addAttribute("pList",POM.selectByExample(new ProjectOutcomeExample()));
        return "admin/fund/outcome";
    }

//    @PostMapping("income")
//    @ResponseBody
//    public RestResponseBo income(Model m,@RequestBody JSONObject js,
//                         HttpServletRequest request){
//
//        System.out.println(js.get("pId"));
//        System.out.println(js.get("name"));
//        return RestResponseBo.ok();
//    }
}

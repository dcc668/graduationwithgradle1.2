package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.service.PaperService;
import com.example.graduation.vo.MoneyItemInfoList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/projectItem")
public class ProjectItemController {
    private Logger log = Logger.getLogger(ProjectItemController.class);
    @Autowired
    private PaperService paperService;


    //项目明细
    @RequestMapping("/moneyItemInfoAddView")
    public String moneyItemInfoAddView(Model model) {
        return "/projectItem/moneyItemInfoAddView";
    }
    //预算明细
    @RequestMapping("/preMoneyItemInfoAddView")
    public String preMoneyItemInfoAddView(Model model) {
        return "/projectItem/preMoneyItemInfoAddView";
    }
    @RequestMapping(value = "/moneyItemInfoAdd", method = RequestMethod.POST)
    public String moneyItemInfoAdd(MoneyItemInfoList moneyItemInfoList, HttpServletRequest req) {
        System.out.println("------------->"+ JSONObject.toJSONString(moneyItemInfoList.getItems()));
        String sum=req.getParameter("sum");
        System.out.println("sum:"+sum);
        return "/projectitem/moneyItemInfoAddView";
    }


}


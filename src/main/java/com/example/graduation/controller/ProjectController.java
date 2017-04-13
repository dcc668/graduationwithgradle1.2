package com.example.graduation.controller;

import com.example.graduation.service.PaperService;
import com.example.graduation.vo.MoneyItemInfoList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private Logger log = Logger.getLogger(ProjectController.class);
    @Autowired
    private PaperService paperService;

    //项目明细
    @RequestMapping("/moneyItemInfoAddView")
    public String moneyItemInfoAddView(Model model) {
        return "/project/moneyItemInfoAddView";
    }

    @RequestMapping("/moneyItemInfoAdd")
    public String moneyItemInfoAdd(MoneyItemInfoList items) {
        return "/project/moneyItemInfoAddView";
    }


}


package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.service.PaperService;
import com.example.graduation.vo.ProjectInfoList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private Logger log = Logger.getLogger(ProjectController.class);
    @Autowired
    private PaperService paperService;

    //项目明细
    @RequestMapping("/projectInfoAddView")
    public String moneyItemInfoAddView(Model model) {
        return "/project/projectInfoAddView";
    }

    @RequestMapping(value = "/projectInfoAddView", method = RequestMethod.POST)
    public String moneyItemInfoAdd(ProjectInfoList projectInfoList) {
        System.out.println("------------->"+ JSONObject.toJSONString(projectInfoList.getTc()));
        return "/project/moneyItemInfoAddView";
    }


}


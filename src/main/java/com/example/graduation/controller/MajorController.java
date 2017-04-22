package com.example.graduation.controller;

import com.example.graduation.model.Major;
import com.example.graduation.service.MajorService;
import com.example.graduation.vo.MajorInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {
    private Logger log = Logger.getLogger(MajorController.class);
    @Autowired
    private MajorService majorService;
    //专业管理
    //添加
    @RequestMapping("/addMajorView")
    public String addMajorView(@ModelAttribute MajorInfo majorInfo) {
        System.out.println("addMajorView");
        return "/major/addMajorView";
    }

    @RequestMapping(value = "/addMajor", method = RequestMethod.POST)
    public String addMajor(@ModelAttribute MajorInfo majorInfo) {
        Major tea = new Major();
        tea.setMajorId(majorInfo.getMajorId());
        tea.setMajorName(majorInfo.getMajorName());
        majorService.add(tea);
        return "/main/Success";
    }

    //查询
    @RequestMapping("/queryMajorView")
    public String queryMajorView(Model model, @ModelAttribute MajorInfo majorInfo) {
        List<Major> teas = (List<Major>) majorService.findAll();
        List<MajorInfo> teaInfs = new ArrayList<MajorInfo>();
        for (Major tea : teas) {
            MajorInfo teaInf = new MajorInfo();
            teaInf.setMajorId(tea.getMajorId());
            teaInf.setMajorName(tea.getMajorName());
            teaInfs.add(teaInf);
        }
        model.addAttribute("teaInfs", teaInfs);
        return "/major/queryMajorView";
    }

    //更新
    @RequestMapping(value = "/updateMajorView/{tId}", method = RequestMethod.GET)
    public String updateMajorView(Model model, @ModelAttribute MajorInfo majorInfo, @PathVariable("tId") int tId) {
        Major tea = majorService.findById(tId);
        majorInfo.setMajorId(tea.getMajorId());
        majorInfo.setMajorName(tea.getMajorName());
        model.addAttribute("majorInfo", majorInfo);
        return "/major/updateMajorView";
    }

    @RequestMapping(value = "/updateMajor", method = RequestMethod.POST)
    public String updateMajor(@ModelAttribute MajorInfo majorInfo) {
        Major tea = new Major();
        tea.setMajorId(majorInfo.getMajorId());
        tea.setMajorName(majorInfo.getMajorName());
        majorService.update(tea);
        return "/main/Success";
    }

    //删除
    @RequestMapping(value = "/deleteMajor/{tId}")
    public String deleteMajor(@PathVariable("tId") int tId, @ModelAttribute MajorInfo majorInfo) {
        majorService.deleteById(tId);
        return "/main/Success";
    }


}


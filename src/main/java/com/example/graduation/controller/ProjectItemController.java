package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.model.Paper;
import com.example.graduation.model.Project;
import com.example.graduation.service.MoneyItemService;
import com.example.graduation.service.ProjectService;
import com.example.graduation.vo.MoneyItemInfo;
import com.example.graduation.vo.MoneyItemInfoList;
import com.example.graduation.vo.Page;
import com.example.graduation.vo.PaperInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/projectItem")
public class ProjectItemController {
    private Logger log = Logger.getLogger(ProjectItemController.class);
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MoneyItemService moneyItemService;
    //项目明细 添加
    @RequestMapping("/projectItemInfoAddView")
    public String projectItemInfoAddView(Model model) {

        return "/projectItem/projectItemInfoAddView";
    }
    @RequestMapping(value = "/projectItemInfoAdd", method = RequestMethod.POST)
    public String projectItemInfoAdd(MoneyItemInfoList moneyItemInfoList, HttpServletRequest req) {
        System.out.println("------------->"+ JSONObject.toJSONString(moneyItemInfoList.getItems()));
        String sum=req.getParameter("sum");
        System.out.println("sum:"+sum);
        return "/projectItem/projectItemInfoAddView";
    }

    //项目明细 更新
    @RequestMapping("/projectItemInfoUpdateView/{prId}")
    public String projectItemInfoUpdateView(@PathVariable Integer prId,Model model,HttpServletRequest request) {
        String currentPage = request.getParameter("currentPage");
        Project pro = projectService.findById(prId);
        if(pro==null){
            log.info("项目不存在");
            model.addAttribute("msg", "项目不存在");
            return "error/Failure";
        } else {
            Page paperPage = new Page();
            //总记录
            List<MoneyItem> tcss = moneyItemService.getMoneyItemsByPrId(prId);
            if (tcss != null) {
                Integer count = tcss.size();
                paperPage.setAllRecord(count);
            }
            List<MoneyItem> tcs = null;
            if (currentPage != null) {
                log.info("-----------Paper分页----------前台currentPage------->" + currentPage);
                paperPage.setCurrentPage(Integer.parseInt(currentPage));
            } else {
                paperPage.setCurrentPage(1);
            }
            tcs = moneyItemService.getMoneyItemsByPrIdAndPage(prId, paperPage);
            log.info("-----------List<MoneyItem>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "支出明细为空");
                return "error/Failure";
            }
            MoneyItem tc = tcs.get(0);
            //应传PaperInfo ，当paper与PaperInfo不一致时，需从新组装PaperInfo
            MoneyItemInfo pi = new MoneyItemInfo();
                pi.setItemName(tc.getItemName());
                pi.setMark(tc.getMark());
                pi.setSumMoney(tc.getSumMoney());
                pi.setTeId(tc.getTeId());
                pi.setMoId(tc.getMoId());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = tc.getTime();
                if (date != null) {
                    String parse = sdf.format(date);
                    pi.setTime(parse);
                }
            model.addAttribute("item", pi);


            //其余明细
            List<Paper> subTcs = tcs.subList(1, tcs.size());
            List<PaperInfo> pais = new ArrayList<PaperInfo>();
            for (Paper pa : subTcs) {
                PaperInfo pai = new PaperInfo();
                pai.setPaId(pa.getPaId());
                pai.setPaPageNum(pa.getPaPageNum());
                pai.setPaName(pa.getPaName());
                String path1=pa.getFilePath();
                if(path1==null||"".equals(path1.trim())) {
                    pai.setFilePath(null);
                }else{
                    pai.setFilePath(path1);
                }
                pai.setMark(pa.getMark());
                pai.setPaHostUnit(pa.getPaHostUnit());
                pai.setPaPublicationName(pa.getPaPublicationName());
                pai.setPaPublicationNO(pa.getPaPublicationNO());
                Date date1 = pa.getPaStartTime();
                if (date1 != null) {
                    String str = sdf.format(date1);
                    pai.setPaStartTime(str);
                }
                pai.setPaState(pa.getPaState());
                if (pa.getTeacher() != null) {
                    pai.setTeId(pa.getTeacher().getTeId());
                }
                pais.add(pai);
            }
            model.addAttribute("paperInfos", pais);
            model.addAttribute("page", paperPage);
            return "/paper/paperInfoUpdateView";
        }






        return "/projectItem/projectItemInfoUpdateView";
    }

    //预算明细
    @RequestMapping("/preMoneyItemInfoAddView")
    public String preMoneyItemInfoAddView(Model model) {
        return "/projectItem/preMoneyItemInfoAddView";
    }



}


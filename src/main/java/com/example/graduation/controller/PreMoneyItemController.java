package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.PreMoneyItem;
import com.example.graduation.model.Project;
import com.example.graduation.service.PreMoneyItemService;
import com.example.graduation.service.ProjectService;
import com.example.graduation.vo.PreMoneyItemInfo;
import com.example.graduation.vo.PreMoneyItemInfoList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/preProjectItem")
public class PreMoneyItemController {
    private Logger log = Logger.getLogger(PreMoneyItemController.class);
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PreMoneyItemService preMoneyItemService;
    //預算明細 添加
    @RequestMapping("/preProjectItemInfoAddView")
    public String preProjectItemInfoAddView(Model model) {

        return "/projectItems/preProjectItemInfoAddView";
    }

    //預算明細 更新
    @RequestMapping("/preProjectItemInfoUpdateView/{prId}")
    public String preProjectItemInfoUpdateView(@PathVariable Integer prId,Model model,HttpServletRequest request) {
        Project pro = projectService.findById(prId);
        if(pro==null){
            log.info("项目不存在");
            model.addAttribute("msg", "项目不存在");
            return "error/Failure";
        } else {
            List<PreMoneyItem> tcs = preMoneyItemService.getPreMoneyItemsByPrId(prId);
            model.addAttribute("project",pro);
            log.info("-----------List<PreMoneyItem>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "当前项目支出明细为空,请添加明细");
                return "/projectItems/preProjectItemInfoAddView";
            }
            //明细
            List<PreMoneyItemInfo> pais = new ArrayList<PreMoneyItemInfo>();
            for (PreMoneyItem tc : tcs) {
                PreMoneyItemInfo pi = new PreMoneyItemInfo();
                pi.setItemName(tc.getItemName());
                pi.setMark(tc.getMark());
                pi.setSumMoney(tc.getSumMoney());
                pi.setPreId(tc.getPreId());
                pais.add(pi);
            }
            model.addAttribute("items",pais);
            return "/projectItems/preProjectItemInfoUpdateView";
        }
    }
    //支出明细提交
    @RequestMapping(value = "/submitProjectItemInfo", method = RequestMethod.POST)
    public String submitProjectItemInfo(PreMoneyItemInfoList moneyItemInfoList, HttpServletRequest req, Model model) {
        System.out.println("-------支出明细提交-------->"+ JSONObject.toJSONString(moneyItemInfoList.getItems()));
        String sum=req.getParameter("sum");
        String prId=req.getParameter("prId");
        String errormsg="部分支出明细存储失败：\n";
        boolean isRight=true;
        Project pro = projectService.findById(Integer.parseInt(prId));
        List<PreMoneyItemInfo> items = moneyItemInfoList.getItems();
        if(!CollectionUtils.isEmpty(items)&&pro!=null){
            for(PreMoneyItemInfo mii:items){
                //預算明細名称，金额，支出人，用途说明 都不为空时，明细项才有效
                String itemName = mii.getItemName();
                String mark = mii.getMark();
                Double sumMoney = mii.getSumMoney();
                Integer moId = mii.getPreId();
                if(!StringUtils.isEmpty(itemName)&&!StringUtils.isEmpty(mark)&&sumMoney!=null) {
                    PreMoneyItem mi = null;
                    if (moId != null && moId > 0) {//更新
                        mi = preMoneyItemService.findById(mii.getPreId());
                        System.out.print("------------>moId:" + moId);
                    } else {//添加
                        mi = new PreMoneyItem();
                    }
                    mi.setProject(pro);
                    mi.setSumMoney(sumMoney);
                    mi.setItemName(itemName);
                    mi.setMark(mark);
                    if (moId != null && moId > 0) {//更新
                        log.info("-------------PreMoneyItem---------更新-------------" + mi.toString());
                        preMoneyItemService.update(mi);
                    } else {//添加
                        log.info("-------------PreMoneyItem---------添加-------------" + mi.toString());
                        preMoneyItemService.add(mi);
                    }
                }else if(StringUtils.isEmpty(mark)&&sumMoney==null){

                }else{
                    errormsg=errormsg+itemName+" 信息不全;\n";
                    isRight=false;
                }
            }
        }else{
            errormsg=errormsg+"项目不存在或者支出明细为空！\n";
            isRight=false;
        }

        if (isRight) {
            //更新科研项目 金额
            pro.setPrMoney(Double.parseDouble(sum));
            projectService.update(pro);
            return "/main/Success";
        } else {
            Double sum2 = preMoneyItemService.calculateSumMoneyByPrId(Integer.parseInt(prId));
            pro.setPrMoney(sum2);
            projectService.update(pro);
            model.addAttribute("msg", errormsg);
            return "/error/Failure";
        }
    }
}


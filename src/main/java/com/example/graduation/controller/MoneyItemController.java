package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.model.Project;
import com.example.graduation.service.MoneyItemService;
import com.example.graduation.service.ProjectService;
import com.example.graduation.vo.MoneyItemInfo;
import com.example.graduation.vo.MoneyItemInfoList;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/projectItem")
public class MoneyItemController {
    private Logger log = Logger.getLogger(MoneyItemController.class);
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MoneyItemService moneyItemService;
    //项目明细 添加
    @RequestMapping("/projectItemInfoAddView")
    public String projectItemInfoAddView(Model model) {

        return "/projectItems/projectItemInfoAddView";
    }

    //项目明细 更新
    @RequestMapping("/projectItemInfoUpdateView/{prId}")
    public String projectItemInfoUpdateView(@PathVariable Integer prId,Model model,HttpServletRequest request) {
        Project pro = projectService.findById(prId);
        if(pro==null){
            log.info("项目不存在");
            model.addAttribute("msg", "项目不存在");
            return "error/Failure";
        } else {
            List<MoneyItem> tcs = moneyItemService.getMoneyItemsByPrId(prId);
            model.addAttribute("project",pro);
            log.info("-----------List<MoneyItem>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "当前项目支出明细为空,请添加明细");
                return "/projectItems/projectItemInfoAddView";
            }
            //明细
            List<MoneyItemInfo> pais = new ArrayList<MoneyItemInfo>();
            for (MoneyItem tc : tcs) {
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
                pais.add(pi);
            }
            String []names=new String[]{
                    "办公用品,水","水电费","租赁费","资料,书报,检索","材料费","印刷费，版面"
                    ,"咨询费,评审","加工费","管理费","邮寄费，话费，网费","协助费"
                    ,"招待费","车费，过路费，油费","维修费","差旅费","助研费"
                    ,"出国费","设备费购置","科研津贴","会议费","其他专用费"
                    ,"反聘费","计算，测试，分析费","保密，保健费","其他设计费","试验费"
            };
            Set<Integer> hasValue=new HashSet<>();
            for(MoneyItemInfo mii:pais){
                String name=mii.getItemName();
                for(int i=0;i<names.length;i++){
                    if(names[i].equals(name)) {
                        model.addAttribute("items" + i, mii);
                        System.out.print("----------->items[" + i + "]"+":"+JSONObject.toJSONString(mii));
                        hasValue.add(i);
                    }
                }
            }
            //没有值的传""
            for(int i=0;i<names.length;i++){
                if(!hasValue.contains(i)){
                    model.addAttribute("items"+ i, new MoneyItemInfo());
                    System.out.print("----------->items[" + i + "]"+": 为空");
                }
            }
            return "/projectItems/projectItemInfoUpdateView";
        }
    }
    //支出明细提交
    @RequestMapping(value = "/submitProjectItemInfo", method = RequestMethod.POST)
    public String submitProjectItemInfo(MoneyItemInfoList moneyItemInfoList, HttpServletRequest req,Model model) {
        System.out.println("-------支出明细提交-------->"+ JSONObject.toJSONString(moneyItemInfoList.getItems()));
        String sum=req.getParameter("sum");
        String prId=req.getParameter("prId");
        String errormsg="部分支出明细存储失败：\n";
        boolean isRight=true;
        Project pro = projectService.findById(Integer.parseInt(prId));
        List<MoneyItemInfo> items = moneyItemInfoList.getItems();
        if(!CollectionUtils.isEmpty(items)&&pro!=null){
            for(MoneyItemInfo mii:items){
                //项目明细名称，金额，支出人，用途说明 都不为空时，明细项才有效
                String itemName = mii.getItemName();
                Integer teId = mii.getTeId();
                String mark = mii.getMark();
                Double sumMoney = mii.getSumMoney();
                Integer moId = mii.getMoId();
                if(!StringUtils.isEmpty(itemName)&&!StringUtils.isEmpty(mark)&&teId!=null&&sumMoney!=null) {
                    MoneyItem mi = null;
                    if (moId != null && moId > 0) {//更新
                        mi = moneyItemService.findById(mii.getMoId());
                        System.out.print("------------>moId:" + moId);
                    } else {//添加
                        mi = new MoneyItem();
                    }
                    mi.setProject(pro);
                    mi.setTeId(teId);
                    mi.setSumMoney(sumMoney);
                    mi.setItemName(itemName);
                    mi.setMark(mark);
                    String time = mii.getTime();
                    if (!StringUtils.isEmpty(time)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date parse = sdf.parse(time);
                            mi.setTime(parse);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (moId != null && moId > 0) {//更新
                        log.info("-------------MoneyItem---------更新-------------" + mi.toString());
                        moneyItemService.update(mi);
                    } else {//添加
                        log.info("-------------MoneyItem---------添加-------------" + mi.toString());
                        moneyItemService.add(mi);
                    }
                }else if(StringUtils.isEmpty(mark)&&teId==null&&sumMoney==null){

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
            Double sum2 = moneyItemService.calculateSumMoneyByPrId(Integer.parseInt(prId));
            pro.setPrMoney(sum2);
            projectService.update(pro);
            model.addAttribute("msg", errormsg);
            return "/error/Failure";
        }
    }
}


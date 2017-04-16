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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

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

        return "/projectItems/projectItemInfoAddView";
    }
    @RequestMapping(value = "/projectItemInfoAdd", method = RequestMethod.POST)
    public String projectItemInfoAdd(MoneyItemInfoList moneyItemInfoList, HttpServletRequest req) {
        System.out.println("------------->"+ JSONObject.toJSONString(moneyItemInfoList.getItems()));
        String sum=req.getParameter("sum");
        System.out.println("sum:"+sum);
        return "/projectItems/projectItemInfoAddView";
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
            List<MoneyItem> tcs = moneyItemService.getMoneyItemsByPrId(prId);
            log.info("-----------List<MoneyItem>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "支出明细为空");
                return "error/Failure";
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
                    ,"出国费","设备费购置","科研津贴","会议费","其他"
                    ,"反聘费","计算，测试，分析费","保密，保健费","其他","试验费"
            };
            Set<Integer> hasValue=new HashSet<>();
            for(MoneyItemInfo mii:pais){
                String name=mii.getItemName();
                for(int i=0;i<names.length;i++){
                    if(names[i].equals(name)) {
                        model.addAttribute("items[" + i + "]", mii);
                        hasValue.add(i);
                    }
                }
            }
            //没有值的传""
            for(int i=0;i<names.length;i++){
                if(!hasValue.contains(i)){
                    model.addAttribute("items[" + i + "]", "");
                }
            }
            return "/projectItems/projectItemInfoUpdateView";
        }
    }

    //预算明细
    @RequestMapping("/preMoneyItemInfoAddView")
    public String preMoneyItemInfoAddView(Model model) {
        return "/projectItems/preMoneyItemInfoAddView";
    }



}


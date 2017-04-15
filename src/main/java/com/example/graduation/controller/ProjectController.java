package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.Project;
import com.example.graduation.model.Teacher;
import com.example.graduation.model.TeacherProject;
import com.example.graduation.service.ProjectService;
import com.example.graduation.service.TeacherProjectService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.vo.Page;
import com.example.graduation.vo.ProjectInfo;
import com.example.graduation.vo.ProjectInfoList;
import com.example.graduation.vo.SCI;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private Logger log = Logger.getLogger(ProjectController.class);
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TeacherProjectService teacherProjectService;
    @Autowired
    private TeacherService teacherService;
    //批量导出
    //所有选中
    private Set<Integer> allPaIds;
    //当前选中和未选中的
    private Set<String> paIds;

    //@PostConstruct当bean加载完之后，就会执行init方法，并且将list实例化；
    @PostConstruct
    public void init() {
        allPaIds = new HashSet<Integer>();
        paIds = new HashSet<String>();
    }

    //项目管理
    @RequestMapping("/projectInfoAddView")
    public String projectInfoAddView(Model model) {
        ProjectInfo pi = new ProjectInfo();
        //获取当前用户
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj != null) {
            Integer currentUserId = Integer.parseInt((String) obj);
            pi.setTeId(currentUserId);
        } else {
            model.addAttribute("msg", "还没登录，请登录！");
            return "/error/Failure";
        }
        model.addAttribute("projectInfo", pi);
        return "/project/projectInfoAddView";
    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    @RequestMapping("/projectInfoUpdateView")
    public String projectInfoUpdateView(Model model, HttpServletRequest request) {
        String error=updateViewData(model,request);
        if(!StringUtils.isEmpty(error)) {
            return error;
        }
        return "/project/projectInfoUpdateView";
    }
    //项目，项目预算，项目明细展示
    @RequestMapping("/moneyItemInfoManageView")
    public String moneyItemInfoManageView(Model model,HttpServletRequest request) {
        String error=updateViewData(model,request);
        if(!StringUtils.isEmpty(error)) {
            return error;
        }
        return "/projectitem/moneyItemInfoManageView";
    }

    private String updateViewData(Model model,HttpServletRequest request) {
        String currentPage = request.getParameter("currentPage");
        //获取当前用户
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj == null) {
            log.info("当前用户不存在");
            model.addAttribute("msg", "当前用户不存在");
            return "error/Failure";
        } else {
            Page projectPage = new Page();
            Integer currentUserId = Integer.parseInt((String) obj);
            //总记录
            List<Project> tcss = projectService.getProjectsByTeId(currentUserId);
            if (tcss != null) {
                Integer count = tcss.size();
                projectPage.setAllRecord(count);
            }
            List<Project> tcs = null;
            if (currentPage != null) {
                log.info("-----------Project分页----------前台currentPage------->" + currentPage);
                projectPage.setCurrentPage(Integer.parseInt(currentPage));
                tcs = projectService.getProjectsByTeIdAndPage(currentUserId, projectPage);
            } else {
                projectPage.setCurrentPage(1);
                tcs = projectService.getProjectsByTeIdAndPage(currentUserId, projectPage);
            }
            log.info("-----------List<Project>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "论文为空");
                return "error/Failure";
            }
            Project tci = tcs.get(0);
            //应传ProjectInfo ，当project与ProjectInfo不一致时，需从新组装ProjectInfo
            ProjectInfo tc = convertToInfo(tci);
            model.addAttribute("projectInfo", tc);
            //其余
            List<Project> subTcs = tcs.subList(1, tcs.size());
            List<ProjectInfo> pais = new ArrayList<ProjectInfo>();
            for (Project pa : subTcs) {
                ProjectInfo pai = convertToInfo(pa);
                pais.add(pai);
            }
            model.addAttribute("projectInfos", pais);
            model.addAttribute("page", projectPage);
        }
        return null;
    }

    //提交
    @RequestMapping(value = "/submitProjectInfo", method = RequestMethod.POST)
    public String submitProjectInfo(ProjectInfoList projectInfoList, HttpServletResponse res, Model model) throws ParseException {
        System.out.println("---------------->" + JSONObject.toJSONString(projectInfoList.getTc()));
        List<ProjectInfo> tcis = projectInfoList.getTc();
        boolean isRight = true;
        String msg = "";
        for (ProjectInfo tci : tcis) {
            if (tci.getPrId() != 0) {//第1条数据无效
                Project tc = null;
                if(tci.getPrId() == -1){
                    tc = new Project();
                }else{
                    tc =projectService.findById(tci.getPrId());
                }
                tc.setTeId(tci.getTeId());
                Integer num = tci.getPrDate();
                tc.setPrDate(num);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = tci.getPrEndTime();
                if (!StringUtils.isEmpty(str)) {
                    Date parse = sdf.parse(str);
                    tc.setPrEndTime(parse);
                }
                String str2 = tci.getPrStartTime();
                if (!StringUtils.isEmpty(str2)) {
                    Date parse = sdf.parse(str2);
                    tc.setPrStartTime(parse);
                }

                tc.setPrMoney(tci.getPrMoney());
                tc.setPrName(tci.getPrName());
                tc.setPrPreMoney(tci.getPrPreMoney());
                tc.setPrResultInfo(tci.getPrResultInfo());
                tc.setPrSource(tci.getPrSource());
                tc.setPrState(tci.getPrState());
                tc.setPrUsefulMoney(tci.getPrUsefulMoney());

                String members = tci.getMembers();
                String[] teIds = members.split(",");
                if (tci.getPrId() == -1) {//添加
                    log.info("-------------Project---------添加-------------" + tc.toString());
                    Integer prId=(Integer)projectService.add(tc);
                    Project pro = projectService.findById(prId);
                    //添加 TeacherProject表
                    for(String id:teIds){
                        TeacherProject tp=new TeacherProject();
                            Teacher te = teacherService.findById(Integer.parseInt(id));
                            tp.setTeacher(te);
                            tp.setProject(pro);
                        teacherProjectService.add(tp);
                    }
                } else {//更新
                    Project pro = projectService.findById(tci.getPrId());
                    log.info("-------------Project---------更新-------------" + tc.toString());
                    projectService.update(tc);
                    //更新 TeacherProject表
                    //删除
                    List<TeacherProject> tps = teacherProjectService.findByProjectId(tci.getPrId());
                    OK:
                    for(TeacherProject tp:tps){
                        Integer teId=tp.getTeacher().getTeId();
                        for(String id:teIds){
                            if(Integer.parseInt(id)==teId){
                                continue OK;
                            }
                        }
                        teacherProjectService.deleteById(tp.getTpId());
                    }
                    //添加新增
                    for(String id:teIds){
                        TeacherProject tp = teacherProjectService.findByPrIdAndTeId(tci.getPrId(), Integer.parseInt(id));
                        if(tp==null){
                            TeacherProject tp2=new TeacherProject();
                            Teacher te = teacherService.findById(Integer.parseInt(id));
                                tp2.setTeacher(te);
                                tp2.setProject(pro);
                            teacherProjectService.add(tp2);
                        }
                    }
                }
            }
        }
        if (isRight) {
            return "/main/Success";
        } else {
            model.addAttribute("msg", msg);
            return "/error/Failure";
        }
    }



    //删除
    @RequestMapping(value = "/delProject", method = RequestMethod.POST)
    public void delProject(HttpServletRequest req, HttpServletResponse res) {
        String prId = req.getParameter("prId");
        log.info("------------paId------------>" + prId);
        if (!StringUtils.isEmpty(prId)) {
            PrintWriter writer = null;
            JSONObject json = new JSONObject();
            try {
                projectService.deleteById(Integer.parseInt(prId));
                writer = res.getWriter();
                json.put("res", 1);
                writer.write(json.toJSONString());
                writer.flush();
            } catch (IOException e) {
                json.put("res", 0);
                json.put("msg", "删除失败！" + e.getMessage());
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } else {
            log.info("---------->要删除的prId为空！");
        }
    }

//    @RequestMapping("/exportToExcelView")
//    public String exportToExcelView(HttpServletRequest request, HttpServletResponse res, Model model) {
//        String currentPage = request.getParameter("currentPage");
//        //获取当前用户
//        Object obj = SecurityUtils.getSubject().getPrincipal();
//        if (obj == null) {
//            log.info("当前用户不存在");
//            model.addAttribute("msg", "当前用户不存在");
//            return "error/Failure";
//        } else {
//            paIds.clear();//1.用于部分导出
//            Page projectPage = new Page();
//            projectPage.setLineSize(6);
//            Integer currentUserId = Integer.parseInt((String) obj);
//            //总记录
//            List<Project> tcss = projectService.getProjectsByTeId(currentUserId);
//            if (tcss != null) {
//                Integer count = tcss.size();
//                projectPage.setAllRecord(count);
//            }
//            List<Project> tcs = null;
//            if (currentPage != null) {
//                log.info("-----------Project分页----------前台currentPage------->" + currentPage);
//                projectPage.setCurrentPage(Integer.parseInt(currentPage));
//                tcs = projectService.getProjectsByTeIdAndPage(currentUserId, projectPage);
//            } else {
//                projectPage.setCurrentPage(1);
//                tcs = projectService.getProjectsByTeIdAndPage(currentUserId, projectPage);
//            }
//            log.info("-----------List<Project>----------------->" + JSONObject.toJSONString(tcs));
//            if (CollectionUtils.isEmpty(tcs)) {
//                model.addAttribute("msg", "论文为空");
//                return "error/Failure";
//            }
//            //全部论文
//            List<ProjectInfo> pais = new ArrayList<ProjectInfo>();
//            for (Project pa : tcs) {
//                ProjectInfo pai = new ProjectInfo();
//                pai.setPaId(pa.getPaId());
//                paIds.add(pa.getPaId() + "");    //2.用于部分导出
//                pai.setPaPageNum(pa.getPaPageNum());
//                pai.setPaName(pa.getPaName());
//                String path = pa.getFilePath();
//                if (path == null || "".equals(path.trim())) {
//                    pai.setFilePath(null);
//                } else {
//                    pai.setFilePath(path);
//                }
//                pai.setMark(pa.getMark());
//                pai.setPaHostUnit(pa.getPaHostUnit());
//                pai.setPaPublicationName(pa.getPaPublicationName());
//                pai.setPaPublicationNO(pa.getPaPublicationNO());
//                Date date1 = pa.getPaStartTime();
//                if (date1 != null) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    String str = sdf.format(date1);
//                    pai.setPaStartTime(str);
//                }
//                pai.setPaState(pa.getPaState());
//                if (pa.getTeacher() != null) {
//                    pai.setTeId(pa.getTeacher().getTeId());
//                }
//                pais.add(pai);
//            }
//            model.addAttribute("projectInfos", pais);
//            model.addAttribute("page", projectPage);
//            model.addAttribute("allPaIds", allPaIds);
//            return "/project/exportToExcelView";
//        }
//    }

//    @RequestMapping("/execute")
//    public String execute(@RequestParam(value = "paId", required = false) String[] paId, HttpServletRequest request, HttpServletResponse res, Model model) {
//        log.info("----------------------execute---------->" + JSONObject.toJSONString(paId));
//        Set<String> unChecked = new HashSet<>();
//        if (!CollectionUtils.isEmpty(paIds) && paId != null) {
//            ok:
//            for (String id : paIds) {
//                for (String checked : paId) {
//                    allPaIds.add(Integer.parseInt(checked.trim()));
//                    if (id.trim().equals(checked.trim())) {
//                        continue ok;
//                    }
//                }
//                unChecked.add(id.trim());
//            }
//        }
//        if (!CollectionUtils.isEmpty(paIds) && paId == null) {
//            for (String id : paIds) {
//                unChecked.add(id.trim());
//            }
//        }
//        //删除没选的
//        if (!CollectionUtils.isEmpty(unChecked)) {
//            for (String unch : unChecked) {
//                Integer val = Integer.parseInt(unch.trim());
//                if (allPaIds.contains(val)) {
//                    allPaIds.remove(val);
//                }
//            }
//        }
//        log.info("----------------------paIds---------->" + JSONObject.toJSONString(paIds));
//        log.info("----------------------allPaIds---------->" + JSONObject.toJSONString(allPaIds));
//        return exportToExcelView(request, res, model);
//    }

//    @RequestMapping("/submitExportToExcel")
//    public String submitExportToExcel(@RequestParam(value = "paId", required = false) String[] paId, HttpServletRequest request, HttpServletResponse response, Model model) {
//        //保存已选
//        execute(paId, request, response, model);
//        Integer[] ids = allPaIds.toArray(new Integer[]{});
//        if (ids.length > 0) {
//            List<Project> projects = projectService.getProjectsByIds(ids);
//            HSSFWorkbook hssf = ToExcelUtils.toExcelFile(projects, "论文汇总表", Teacher.class);
//            String fileName = "project";
//            OutputStream out = null;
//            try {
//                out = response.getOutputStream();
//                response.setContentType("application/ms-excel;charset=UTF-8");
//                response.setHeader("Content-Disposition", "attachment;filename="
//                        .concat(String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8"))));
//                hssf.write(out);
//            } catch (IOException e) {
//                System.out.println("输出流错误");
//                e.printStackTrace();
//            } finally {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            model.addAttribute("msg", "请勾选要导出的论文！");
//            return "/error/Failure";
//        }
//        return null;
//    }
//
//    @RequestMapping("/submitAllExportToExcel")
//    public void submitAllExportToExcel(HttpServletResponse response) {
//        Collection<Project> projects = projectService.findAll();
//        HSSFWorkbook hssf = ToExcelUtils.toExcelFile(projects, "论文汇总表", Teacher.class);
//        String fileName = "allprojects";
//        OutputStream out = null;
//        try {
//            out = response.getOutputStream();
//            response.setContentType("application/ms-excel;charset=UTF-8");
//            response.setHeader("Content-Disposition", "attachment;filename="
//                    .concat(String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8"))));
//            hssf.write(out);
//        } catch (IOException e) {
//            System.out.println("输出流错误");
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @RequestMapping("/projectStatistcsView")
    public String projectStatistcsView(Model model) {
        return "/project/projectStatisticsView";
    }

    @RequestMapping("/projectStatistcsAjax")
    public void projectStatistcsAjax(HttpServletResponse res) {
        //统计的年份
        String[] years = new String[]{"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"};
        //索引期刊索引
        String[] scis = new String[]{"SCI", "EI", "ISTP", "SSCI", "CSCD", "other"};
        List<SCI> indexs = new ArrayList<>();
        for (String str : scis) {
            SCI sci = new SCI();
            sci.setName(str);
            List<Integer> counts = new ArrayList<>();
            for (String year : years) {
                Integer count = projectService.getProjectsCountByStateAndYear(str, year);
                counts.add(count);
            }
            sci.setData(counts);
            indexs.add(sci);
        }
        String yearJson = Arrays.toString(years);
        String indexJson = JSONObject.toJSONString(indexs);
        PrintWriter writer = null;
        JSONObject json = new JSONObject();
        json.put("years", yearJson);
        json.put("idxs", indexJson);
        System.out.println("====================================" + json.toJSONString());
        try {
            writer = res.getWriter();
            writer.write(json.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }


    private ProjectInfo convertToInfo(Project tci){
        ProjectInfo tc = new ProjectInfo();
        tc.setPrId(tci.getPrId());
        tc.setTeId(tci.getTeId());
        Integer num = tci.getPrDate();
        tc.setPrDate(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=tci.getPrEndTime();
        if (date!=null) {
            String parse = sdf.format(date);
            tc.setPrEndTime(parse);
        }
        Date date2=tci.getPrStartTime();
        if (date2!=null) {
            String parse = sdf.format(date2);
            tc.setPrStartTime(parse);
        }

        tc.setPrMoney(tci.getPrMoney());
        tc.setPrName(tci.getPrName());
        tc.setPrPreMoney(tci.getPrPreMoney());
        tc.setPrResultInfo(tci.getPrResultInfo());
        tc.setPrSource(tci.getPrSource());
        tc.setPrState(tci.getPrState());
        tc.setPrUsefulMoney(tci.getPrUsefulMoney());

        //获取项目成员
        List<TeacherProject> tps = teacherProjectService.findByProjectId(tci.getPrId());
        if(!CollectionUtils.isEmpty(tps)) {
            String ids="";
            for (TeacherProject tp:tps) {
                ids=ids+tp.getTeacher().getTeId()+",";
            }
            ids=ids.substring(0,ids.length()-1);
            tc.setMembers(ids);
        }
        return tc;
    }



}


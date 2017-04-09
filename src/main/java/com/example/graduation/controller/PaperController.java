package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.Paper;
import com.example.graduation.model.Teacher;
import com.example.graduation.service.PaperService;
import com.example.graduation.service.TeacherCourseService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.util.ToExcelUtils;
import com.example.graduation.vo.Page;
import com.example.graduation.vo.PaperInfo;
import com.example.graduation.vo.PaperInfoList;
import com.example.graduation.vo.SCI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 使用SpringMVC的时候，如果想要在Controller中定义一个全局变量，并且实现在不同用户访问程序的时候，所得到的全局变量不一样的（线程安全的），这个时候就可以用Spring的注解@Scope来实现：
 */
@Controller
@Scope("session")
@RequestMapping("/paper")
public class PaperController {
    private Logger log = Logger.getLogger(PaperController.class);
    @Autowired
    private PaperService paperService;
    @Autowired
    private TeacherCourseService teacherCourseService;
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

    //教学情况管理
    @RequestMapping("/paperInfoAddView")
    public String paperInfoAddView(Model model) {
        PaperInfo pi = new PaperInfo();
        pi.setPaId(-1);
        //获取当前用户
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj != null) {
            Integer currentUserId = Integer.parseInt((String) obj);
            pi.setTeId(currentUserId);
        } else {
            model.addAttribute("msg", "还没登录，请登录！");
            return "/error/Failure";
        }
        model.addAttribute("paperInfo", pi);
        return "paper/paperInfoAddView";
    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    @RequestMapping("/paperInfoUpdateView")
    public String paperInfoUpdateView(Model model, HttpServletRequest request) {
        String currentPage = request.getParameter("currentPage");
        //获取当前用户
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj == null) {
            log.info("当前用户不存在");
            model.addAttribute("msg", "当前用户不存在");
            return "error/Failure";
        } else {
            Page paperPage = new Page();
            Integer currentUserId = Integer.parseInt((String) obj);
            //总记录
            List<Paper> tcss = paperService.getPapersByTeId(currentUserId);
            if (tcss != null) {
                Integer count = tcss.size();
                paperPage.setAllRecord(count);
            }
            List<Paper> tcs = null;
            if (currentPage != null) {
                log.info("-----------Paper分页----------前台currentPage------->" + currentPage);
                paperPage.setCurrentPage(Integer.parseInt(currentPage));
                tcs = paperService.getPapersByTeIdAndPage(currentUserId, paperPage);
            } else {
                paperPage.setCurrentPage(1);
                tcs = paperService.getPapersByTeIdAndPage(currentUserId, paperPage);
            }
            log.info("-----------List<Paper>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "论文为空");
                return "error/Failure";
            }
            Paper tc = tcs.get(0);
            //应传PaperInfo ，当paper与PaperInfo不一致时，需从新组装PaperInfo
            PaperInfo pi = new PaperInfo();
            pi.setPaId(tc.getPaId());
            pi.setPaPageNum(tc.getPaPageNum());
            pi.setPaName(tc.getPaName());
            String path=tc.getFilePath();
            if(path==null||"".equals(path.trim())) {
                pi.setFilePath(null);
            }else{
                pi.setFilePath(path);
            }
            pi.setMark(tc.getMark());
            pi.setPaHostUnit(tc.getPaHostUnit());
            pi.setPaPublicationName(tc.getPaPublicationName());
            pi.setPaPublicationNO(tc.getPaPublicationNO());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = tc.getPaStartTime();
            if (date != null) {
                String parse = sdf.format(date);
                pi.setPaStartTime(parse);
            }
            pi.setPaState(tc.getPaState());
            if (tc.getTeacher() != null) {
                pi.setTeId(tc.getTeacher().getTeId());
            }
            model.addAttribute("paperInfo", pi);
            //其余论文
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
    }

    //提交
    @RequestMapping(value = "/submitPaperInfo", method = RequestMethod.POST)
    public String submitPaperInfo(PaperInfoList paperInfoList, HttpServletResponse res, Model model) throws ParseException {
        System.out.println("---------------->" + JSONObject.toJSONString(paperInfoList.getTc()));
        List<PaperInfo> tcis = paperInfoList.getTc();
        boolean isRight = true;
        String msg = "";
        for (PaperInfo tci : tcis) {
            if (tci.getPaId() != 0) {//第1条数据无效
                Paper tc = new Paper();
                tc.setPaPublicationNO(tci.getPaPublicationNO());
                tc.setPaState(tci.getPaState());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = tci.getPaStartTime();
                if (!StringUtils.isEmpty(str)) {
                    Date parse = sdf.parse(str);
                    tc.setPaStartTime(parse);
                }
                tc.setPaPublicationName(tci.getPaPublicationName());
                String path=tci.getFilePath();
                if(path==null||"".equals(path.trim())) {
                    tc.setFilePath(null);
                }else{
                    tc.setFilePath(path);
                }
                tc.setMark(tci.getMark());
                tc.setPaHostUnit(tci.getPaHostUnit());
                tc.setPaName(tci.getPaName());
                tc.setPaPageNum(tci.getPaPageNum());
                //获取当前用户
                Object obj = SecurityUtils.getSubject().getPrincipal();
                if (obj == null) {
                    log.info("当前用户不存在");
                    model.addAttribute("msg", "当前用户不存在");
                    return "error/Failure";
                } else {
                    Teacher tea = teacherService.findById(Integer.parseInt((String) obj));
                    tc.setTeacher(tea);
                }
                if (tci.getPaId() == -1) {//添加
                    log.info("-------------Paper---------添加-------------" + tc.toString());
                    paperService.add(tc);
                } else {//更新
                    tc.setPaId(tci.getPaId());
                    log.info("-------------Paper---------更新-------------" + tc.toString());
                    paperService.update(tc);
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
    @RequestMapping(value = "/delPaper", method = RequestMethod.POST)
    public void delPaper(HttpServletRequest req, HttpServletResponse res) {
        String paId = req.getParameter("paId");
        log.info("------------paId------------>" + paId);
        if (!StringUtils.isEmpty(paId)) {
            PrintWriter writer = null;
            JSONObject json = new JSONObject();
            try {
                paperService.deleteById(Integer.parseInt(paId));
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
            log.info("---------->要删除的tcId为空！");
        }
    }

    @RequestMapping("/exportToExcelView")
    public String exportToExcelView(HttpServletRequest request, HttpServletResponse res, Model model) {
        String currentPage = request.getParameter("currentPage");
        //获取当前用户
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj == null) {
            log.info("当前用户不存在");
            model.addAttribute("msg", "当前用户不存在");
            return "error/Failure";
        } else {
            paIds.clear();//1.用于部分导出
            Page paperPage = new Page();
            paperPage.setLineSize(6);
            Integer currentUserId = Integer.parseInt((String) obj);
            //总记录
            List<Paper> tcss = paperService.getPapersByTeId(currentUserId);
            if (tcss != null) {
                Integer count = tcss.size();
                paperPage.setAllRecord(count);
            }
            List<Paper> tcs = null;
            if (currentPage != null) {
                log.info("-----------Paper分页----------前台currentPage------->" + currentPage);
                paperPage.setCurrentPage(Integer.parseInt(currentPage));
                tcs = paperService.getPapersByTeIdAndPage(currentUserId, paperPage);
            } else {
                paperPage.setCurrentPage(1);
                tcs = paperService.getPapersByTeIdAndPage(currentUserId, paperPage);
            }
            log.info("-----------List<Paper>----------------->" + JSONObject.toJSONString(tcs));
            if (CollectionUtils.isEmpty(tcs)) {
                model.addAttribute("msg", "论文为空");
                return "error/Failure";
            }
            //全部论文
            List<PaperInfo> pais = new ArrayList<PaperInfo>();
            for (Paper pa : tcs) {
                PaperInfo pai = new PaperInfo();
                pai.setPaId(pa.getPaId());
                paIds.add(pa.getPaId() + "");    //2.用于部分导出
                pai.setPaPageNum(pa.getPaPageNum());
                pai.setPaName(pa.getPaName());
                String path=pa.getFilePath();
                if(path==null||"".equals(path.trim())) {
                    pai.setFilePath(null);
                }else{
                    pai.setFilePath(path);
                }
                pai.setMark(pa.getMark());
                pai.setPaHostUnit(pa.getPaHostUnit());
                pai.setPaPublicationName(pa.getPaPublicationName());
                pai.setPaPublicationNO(pa.getPaPublicationNO());
                Date date1 = pa.getPaStartTime();
                if (date1 != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
            model.addAttribute("allPaIds", allPaIds);
            return "/paper/exportToExcelView";
        }
    }

    @RequestMapping("/execute")
    public String execute(@RequestParam(value = "paId", required = false) String[] paId, HttpServletRequest request, HttpServletResponse res, Model model) {
        log.info("----------------------execute---------->" + JSONObject.toJSONString(paId));
        Set<String> unChecked = new HashSet<>();
        if (!CollectionUtils.isEmpty(paIds) && paId != null) {
            ok:
            for (String id : paIds) {
                for (String checked : paId) {
                    allPaIds.add(Integer.parseInt(checked.trim()));
                    if (id.trim().equals(checked.trim())) {
                        continue ok;
                    }
                }
                unChecked.add(id.trim());
            }
        }
        if (!CollectionUtils.isEmpty(paIds) && paId == null) {
            for (String id : paIds) {
                unChecked.add(id.trim());
            }
        }
        //删除没选的
        if (!CollectionUtils.isEmpty(unChecked)) {
            for (String unch : unChecked) {
                Integer val = Integer.parseInt(unch.trim());
                if (allPaIds.contains(val)) {
                    allPaIds.remove(val);
                }
            }
        }
        log.info("----------------------paIds---------->" + JSONObject.toJSONString(paIds));
        log.info("----------------------allPaIds---------->" + JSONObject.toJSONString(allPaIds));
        return exportToExcelView(request, res, model);
    }

    @RequestMapping("/submitExportToExcel")
    public String submitExportToExcel(@RequestParam(value = "paId", required = false) String[] paId, HttpServletRequest request, HttpServletResponse response, Model model) {
        //保存已选
        execute(paId, request, response, model);
        Integer[] ids = allPaIds.toArray(new Integer[]{});
        if(ids.length>0) {
            List<Paper> papers = paperService.getPapersByIds(ids);
            HSSFWorkbook hssf = ToExcelUtils.toExcelFile(papers, "论文汇总表", Teacher.class);
            String fileName = "paper";
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                response.setContentType("application/ms-excel;charset=UTF-8");
                response.setHeader("Content-Disposition", "attachment;filename="
                        .concat(String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8"))));
                hssf.write(out);
            } catch (IOException e) {
                System.out.println("输出流错误");
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            model.addAttribute("msg","请勾选要导出的论文！");
            return "/error/Failure";
        }
        return null;
    }

    @RequestMapping("/submitAllExportToExcel")
    public void submitAllExportToExcel(HttpServletResponse response) {
        Collection<Paper> papers = paperService.findAll();
        HSSFWorkbook hssf = ToExcelUtils.toExcelFile(papers, "论文汇总表", Teacher.class);
        String fileName = "allpapers";
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.setContentType("application/ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(fileName + ".xls", "UTF-8"))));
            hssf.write(out);
        } catch (IOException e) {
            System.out.println("输出流错误");
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/paperStatistcsView")
    public String paperStatistcsView(Model model){
        return "/paper/paperStatisticsView";
    }
    @RequestMapping(name="/paperStatistcsAjax")
    public void paperStatistcsAjax(HttpServletResponse res){
        System.out.println("====================================");
        //统计的年份
        String []years= new String[]{"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
        //索引期刊索引
        String [] scis=new String[]{"SCI","EI","ISTP","SSCI","CSCD","other"};
        List<SCI> indexs=new ArrayList<>();
        for(String str:scis) {
            SCI sci = new SCI();
            sci.setName(str);
            List<Integer> counts=new ArrayList<>();
            for (String year : years) {
                Integer count = paperService.getPapersCountByStateAndYear(str, year);
                counts.add(count);
            }
            sci.setData(counts);
            indexs.add(sci);
        }
        String yearJson = Arrays.toString(years);
        String indexJson = JSONObject.toJSONString(indexs);
        PrintWriter writer = null;
        try {
            writer = res.getWriter();
            writer.write(indexJson);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


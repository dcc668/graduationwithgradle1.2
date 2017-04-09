package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.*;
import com.example.graduation.service.*;
import com.example.graduation.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/main")
public class SystemController {
    private static Logger log = Logger.getLogger(SystemController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TitleReviewInforService titleReviewInforService;
    @Autowired
    private TitleService titleService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private TeacherStudentService teacherStudentService;
    @Autowired
    private ReviewerService reviewerService;

    //主页面
    @RequestMapping("/home")
    public String home() {
        return "main/home";
    }

    //文件上传
    @RequestMapping("/fileUploadDownload/fileUploadView")
    public String fileUploadView() {
        return "main/fileUploadDownload/fileUploadView";
    }

    @RequestMapping(value="/fileUploadDownload/fileUpload", method = RequestMethod.POST)
    public void fileUpload(@RequestParam("file") MultipartFile file, HttpServletResponse res) {
        log.info("---------------------------------> file upload....");

        if (!file.isEmpty()) {
            PrintWriter writer = null;
            JSONObject json = new JSONObject();
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload\\"
                        + file.getOriginalFilename();

                File pathFile = new File(filePath);
                if (!pathFile.exists()) {
                    //文件夹不存 创建文件
                    pathFile.mkdirs();
                }

                // 转存文件
                System.out.println("文件转存路径：======" + filePath);
                file.transferTo(pathFile);
                //返回处理结果
                writer = res.getWriter();
                json.put("res", 1);
                json.put("filePath","upload\\"+ file.getOriginalFilename());
                writer.write(json.toJSONString());
                writer.flush();

            } catch (Exception e) {
                json.put("res", 0);
                json.put("msg", "上传失败！"+e.getMessage());
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }

    //文件下载
    @RequestMapping("/fileUploadDownload/downloadFileView")
    public String downloadFileView(Model model, HttpServletRequest request) {
        List<String> fileNames = new ArrayList<String>();
        String downLoadPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File file = new File(downLoadPath);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                fileNames.add(f.getName());
            }
        } else {
            System.out.println("/main/fileUploadDownload/downloadFileView++--------->没有文件");
        }
        model.addAttribute("fileNames", fileNames);
        return "main/fileUploadDownload/downloadFileView";
    }


    @RequestMapping("/fileUploadDownload/downloadFile")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response, @RequestParam("fileName") String fileName) throws Exception {
        System.out.println("downloadFile===========" + fileName);

        String storeName = fileName;
        String contentType = "application/octet-stream";


        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        //获取下载文件路径
        String downLoadPath = request.getSession().getServletContext().getRealPath("/") + "upload/" + storeName;

        //获取文件的长度
        long fileLength = new File(downLoadPath).length();

        //设置文件输出类型
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(storeName.getBytes("utf-8"), "ISO8859-1"));
        //设置输出长度
        response.setHeader("Content-Length", String.valueOf(fileLength));
        //获取输入流
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));
        //输出流
        bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[2048];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        //关闭流
        bis.close();
        bos.close();

        return "main/Success";
    }

    //	根据文件路径获取文件名
    private String getFileName(String filePath)
            throws UnsupportedEncodingException {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        String Agent = request.getHeader("User-Agent");
        if (null != Agent) {
            Agent = Agent.toLowerCase();
            if (Agent.indexOf("firefox") != -1) {
                fileName = new String(fileName.getBytes(), "iso8859-1");
            } else if (Agent.indexOf("msie") != -1) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            }
        }
        return fileName;
    }


    //系统管理
    @RequestMapping("/systemManage")
    public String systemManage() {
        return "main/systemManage";
    }

    //显示未通过的课题
    @RequestMapping("/toReview")
    public String toReview(Model model, @ModelAttribute TitleReviewInfo titleReviewInfo) {

        List<TitleReviewInfor> tri = (List<TitleReviewInfor>) titleReviewInforService.findNotReview();
        List<TitleReviewInfo> trInfo = new ArrayList<TitleReviewInfo>();
        for (TitleReviewInfor triObj : tri) {
            TitleReviewInfo tri1 = new TitleReviewInfo();
            tri1.setTrId(triObj.getTrId());
            tri1.setReviewState(triObj.getReviewState());
            tri1.setReviewSuggestion(triObj.getReviewSuggestion());
            tri1.setTerm(triObj.getTerm());
            tri1.setTitleExamine(triObj.getTitleExamine());
            Title ti = triObj.getTitle();
            tri1.setTitleId(ti.getTitleId());
            tri1.setTitleName(ti.getTitleName());
            trInfo.add(tri1);
        }
        model.addAttribute("triList", trInfo);
        return "main/toReview";
    }

    //审核 并通过
    @RequestMapping("/permitPass/{titleId}")
    public String permitPass(@PathVariable("titleId") int titleId) {
        System.out.println("=====permitPass============");
        TitleReviewInfor tri = titleReviewInforService.findById(titleId);
        tri.setReviewState("通过");
        titleReviewInforService.update(tri);
        return "main/Success";
    }

    //审核 不通过
    @RequestMapping("/main/permitFail/{titleId}")
    public String permitFail(@PathVariable("titleId") int titleId) {
        System.out.println("=====permitFail============");
        TitleReviewInfor tri = titleReviewInforService.findById(titleId);
        tri.setReviewState("通不过");
        titleReviewInforService.update(tri);
        return "main/Success";
    }


    //教师立题入口
    @RequestMapping("/teacher/teaCreateTitleView")
    public String teaCreateTitleView(@ModelAttribute TitleInfo titleInfo) {
        return "teacher/teaCreateTitleView";
    }

    @RequestMapping("/teacher/teaCreateTitle")
    public String teaCreateTitle(@ModelAttribute TitleInfo titleInfo) {
        Title t = new Title();
        t.setTerm(titleInfo.getTerm());
        t.setTitleId(titleInfo.getTitleId());
        t.setTitleName(titleInfo.getTitleName());
        t.setTitleProperty(titleInfo.getTitleProperty());
        t.setTitleType(titleInfo.getTitleType());
        t.setTitleSource(titleInfo.getTitleSource());
        t.setNeedStuNum(titleInfo.getNeedStuNum());
        t.setNowStuNum(0);
        Major major = majorService.findById(titleInfo.getMajorId());
        t.setMajor(major);
        Teacher teacher = teacherService.findById(titleInfo.gettId());
        t.setTeacher(teacher);
        titleService.add(t);
        //添加题目后，对评审信息初步设置
        TitleReviewInfor reif = new TitleReviewInfor();
        reif.setTrId(t.getTitleId());//默认id与题目Id相同
        reif.setTerm(titleInfo.getTerm());
        reif.setTitleExamine("相似度");
        reif.setReviewState("审核中");
        reif.setReviewSuggestion("无");
        reif.setTitle(t);
        titleReviewInforService.add(reif);
        return "main/Success";
    }

    //学生选题入口
    @RequestMapping("/student/stuChooseTitleView")
    public String stuChooseTitle(Model model, @ModelAttribute TitleInfo titleInfo) {


        //展示已通过审核的题目
        List<TitleReviewInfor> tri = (List<TitleReviewInfor>) titleReviewInforService.findDoneReview();
        List<TitleReviewInfo> trInfo = new ArrayList<TitleReviewInfo>();
        for (TitleReviewInfor triObj : tri) {
            TitleReviewInfo tri1 = new TitleReviewInfo();
            tri1.setTrId(triObj.getTrId());
            tri1.setReviewState(triObj.getReviewState());
            tri1.setReviewSuggestion(triObj.getReviewSuggestion());
            tri1.setTerm(triObj.getTerm());
            tri1.setTitleExamine(triObj.getTitleExamine());
            Title ti = triObj.getTitle();
            tri1.setTitleId(ti.getTitleId());
            tri1.setTitleName(ti.getTitleName());
            tri1.setNeedStuNum(ti.getNeedStuNum());
            tri1.setNowStuNum(ti.getNowStuNum());
            trInfo.add(tri1);
        }

        System.out.println("=======传到页面的数据=========大小：" + trInfo.size());
        model.addAttribute("triList", trInfo);

        return "main/student/stuChooseTitleView";
    }


    //执行选择题目操作
    @RequestMapping("/student/stuChooseTitle/{titleId}")
    public String stuChooseTitle(@PathVariable("titleId") int titleId) {
        System.out.println("=====stuChooseTitle============");
        //获取当前用户
//		Student stu=null;
//	     Integer  currentUserId=Integer.parseInt( (String) SecurityUtils.getSubject().getPrincipal());
//	        if( currentUserId != null ) {
//	        	System.out.println("1获取当前用户 id"+currentUserId);
//	             stu= studentService.findById(currentUserId);
//	            System.out.println("2获取当前用户 name"+stu.getsName());
//	            if(stu.getTitle()!=null){
//	            	return "main/student/hasChoosedFailure";
//	            }
//	        }
//	        else{
//	        	System.out.println("没用户");
//	        }
//
//
//
//		Title title1=titleService.findById(titleId);
//		if(title1.getNeedStuNum()<=title1.getNowStuNum()){
//			return"main/student/chooseFailure";
//		}else{
//		        //当前用户完成选题
//		       stu.setTitle(title1);
//		       studentService.update(stu);
//		       //更新题目中人数
//				title1.setNowStuNum(title1.getNowStuNum()+1);
//				titleService.update(title1);
//		}
        return "main/Success";
    }


    //统计学生选课情况
    @RequestMapping("/statisticsShooseView")
    public String statisticsShooseView() {
        return "main/statisticsShooseView";
    }

    @RequestMapping("/statisticsShoose/{i}")
    public String statisticsShoose(@PathVariable("i") int i, Model model) {
        System.out.println("statisticsShoose======I" + i);
        List<StudentInfo> stusNot = new ArrayList<StudentInfo>();
        List<StudentInfo> stusDone = new ArrayList<StudentInfo>();

        int shooseDone = 0;//统计比例
        int shooseNot = 0;

        List<Student> stus = (List<Student>) studentService.findAll();
        for (Student stu : stus) {
//			if(stu.getTitle()==null){
            shooseNot++;
            StudentInfo std = new StudentInfo();
            std.setId(stu.getsId());
            std.setsClass(stu.getsClass());
            std.setsMail(stu.getsMail());
            std.setsName(stu.getsName());
            std.setsTel(stu.getsTel());
            Major major = stu.getMajor();
            String majorName = major.getMajorName();
            System.out.println("statisticsShoose1=====majorName:" + majorName);
            std.setMajorName(majorName);
//					String titleName=stu.getTitle().getTitleName();
//			System.out.println("statisticsShoose2=====titleName:"+titleName);
            std.setTitleName("没选");

            stusNot.add(std);
//			}else{
            shooseDone++;
            StudentInfo std1 = new StudentInfo();
            std1.setId(stu.getsId());
            std1.setsClass(stu.getsClass());
            std1.setsMail(stu.getsMail());
            std1.setsName(stu.getsName());
            std1.setsTel(stu.getsTel());
//				String majorName=stu.getMajor().getMajorName();
            System.out.println("statisticsShoose3=====majorName:" + majorName);
//				std1.setMajorName(majorName);
//				String titleName=stu.getTitle().getTitleName();
//				System.out.println("statisticsShoose4=====titleName:"+titleName);
//				std1.setTitleName(titleName);

            stusDone.add(std1);
        }
//		}
        System.out.println("statisticsShoose==Not1=====count:" + stusNot.size());
        System.out.println("statisticsShoose==done2=====count:" + stusDone.size());
        switch (i) {
            case 0:
                model.addAttribute("stusNot", stusNot);
                return "main/statisticsShooseNot";
            case 1:
                model.addAttribute("stusDone", stusDone);
                return "main/statisticsShooseDone";
            case 2:
                model.addAttribute("shooseDone", shooseDone);
                model.addAttribute("shooseNot", shooseNot);
                return "main/showAsChart";
            default:
                break;
        }
        return null;

    }


//统计各课题的余量

    @RequestMapping("/statisticsTitleMarginView")
    public String statisticsTitleMarginView(Model model, @ModelAttribute TitleInfo titleInfo) {
        System.out.println("statisticsTitleMarginView============");
        int marginSum = 0;//总余量
        List<TitleInfo> titInfs = new ArrayList<TitleInfo>();
        List<Title> titles = (List<Title>) titleService.findAll();
        System.out.println("statisticsTitleMarginView============2");

        for (Title tit : titles) {
            if (tit.getNowStuNum() < tit.getNeedStuNum()) {
                marginSum += (tit.getNeedStuNum() - tit.getNowStuNum());
                TitleInfo titInfo = new TitleInfo();
                titInfo.setMargin(tit.getNeedStuNum() - tit.getNowStuNum());
                titInfo.setMajorId(tit.getMajor().getMajorId());
                titInfo.setNeedStuNum(tit.getNeedStuNum());
                titInfo.setTerm(tit.getTerm());
                titInfo.settId(tit.getTeacher().getTeId());
                titInfo.setTitleId(tit.getTitleId());
                titInfo.setTitleName(tit.getTitleName());
                titInfo.setTitleProperty(tit.getTitleProperty());
                titInfo.setTitleSource(tit.getTitleSource());
                titInfo.setTitleType(tit.getTitleType());
                titInfs.add(titInfo);
            }
        }
        model.addAttribute("titInfs", titInfs);
//			model.addAttribute("titInfs", titInfs);

        return "main/statisticsTitleMarginView";
    }

    //教师评分
    @RequestMapping("/teacher/directiveTeaGradeView")
    public String directiveTeaGradeView(@ModelAttribute TeacherStudentInfo teacherStudentInfo) {
        System.out.println("directiveTeaGradeView=======");

        return "main/teacher/directiveTeaGradeView";
    }

    @RequestMapping("teacher/directiveTeaGrade")
    public String directiveTeaGrade(@ModelAttribute TeacherStudentInfo teacherStudentInfo) {
        System.out.println("directiveTeaGrade=========");
        TeacherStudent t = new TeacherStudent();
        t.setScore(teacherStudentInfo.getScore());
        Student stu = new Student();
        stu.setsId(teacherStudentInfo.getsId());
        t.setStudent(stu);
        Teacher tea = new Teacher();
        tea.setTeId(teacherStudentInfo.gettId());
        t.setTeacher(tea);
        teacherStudentService.add(t);
        //学生成绩更新
        int scoreSum = 0;
        int count = 0;
        List<Integer> scores = teacherStudentService.queryScore(teacherStudentInfo.getsId());
        for (int i = 0; i < scores.size(); i++) {
//				Pattern pattern=Pattern.compile("[0-9]*");
//				Matcher mat=pattern.matcher(scores.get(i).toString());
//				if(mat.matches()){
            scoreSum += scores.get(i).intValue();
            count++;
        }
//			}
        if (count != 0) {
            Student newStu = studentService.findById(teacherStudentInfo.getsId());
            studentService.update(newStu);
        }
        System.out.println("systemController=======成绩更新==scoreSum:count" + scoreSum + ":" + count);
        return "main/Success";
    }


    //教师管理
    @RequestMapping("/teacher/manageTeacherView")
    public String manageTeacherView(@ModelAttribute TeacherInfo teacherInfo) {
        System.out.println("manageTeacherView");

        return "main/teacher/manageTeacherView";
    }

    //添加
    @RequestMapping("/teacher/addTeacherView")
    public String addTeacherView(@ModelAttribute TeacherInfo teacherInfo) {
        System.out.println("addTeacherView");
        return "main/teacher/addTeacherView";
    }

    @RequestMapping(value = "/teacher/addTeacher", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute TeacherInfo teacherInfo) {
        System.out.println("addTeacher");
        Teacher tea = new Teacher();
        tea.setTeId(teacherInfo.getTeId());
        tea.setTePassword(teacherInfo.getTePassword());
        tea.setTeAddr(teacherInfo.getTeAddr());
//			tea.setTitle(title);
        tea.setTeMail(teacherInfo.getTeMail());
        tea.setTeName(teacherInfo.getTeName());
        tea.setTeTel(teacherInfo.getTeTel());
        tea.setTeSex(teacherInfo.getTeSex());
        tea.setTeQQ(teacherInfo.getTeQQ());
        tea.setTePosition(teacherInfo.getTePosition());
        teacherService.add(tea);

        return "main/Success";
    }

    //查询
    @RequestMapping("/teacher/queryTeacherView")
    public String queryTeacherView(Model model, @ModelAttribute TeacherInfo teacherInfo) {
        System.out.println("queryTeacherView=======");
        List<Teacher> teas = (List<Teacher>) teacherService.findAll();
        List<TeacherInfo> teaInfs = new ArrayList<TeacherInfo>();
        for (Teacher tea : teas) {
            TeacherInfo teaInf = new TeacherInfo();
            teaInf.setTeId(tea.getTeId());
            teaInf.setTeMail(tea.getTeMail());
            teaInf.setTeName(tea.getTeName());
            teaInf.setTePosition(tea.getTePosition());
            teaInf.setTeQQ(tea.getTeQQ());
            teaInf.setTeSex(tea.getTeSex());
            teaInf.setTeTel(tea.getTeTel());
            teaInfs.add(teaInf);
        }
        model.addAttribute("teaInfs", teaInfs);
        return "main/teacher/queryTeacherView";
    }

    //更新
    @RequestMapping(value = "/teacher/updateTeacherView/{tId}", method = RequestMethod.GET)
    public String updateTeacherView(Model model, @ModelAttribute TeacherInfo teacherInfo, @PathVariable("tId") int tId) {
        System.out.println("updateTeacherView=====tId:" + tId);
        Teacher tea = teacherService.findById(tId);
        teacherInfo.setTeId(tea.getTeId());
        teacherInfo.setTePassword(tea.getTePassword());
        teacherInfo.setTeMail(tea.getTeMail());
        teacherInfo.setTeName(tea.getTeName());
        teacherInfo.setTePosition(tea.getTePosition());
        teacherInfo.setTeQQ(tea.getTeQQ());
        teacherInfo.setTeSex(tea.getTeSex());
        teacherInfo.setTeAddr(tea.getTeAddr());
        teacherInfo.setTeTel(tea.getTeTel());
        model.addAttribute("teacherInfo", teacherInfo);
        return "main/teacher/updateTeacherView";
    }

    @RequestMapping(value = "/teacher/updateTeacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute TeacherInfo teacherInfo) {
        Teacher tea = new Teacher();
        tea.setTeId(teacherInfo.getTeId());
        tea.setTePassword(teacherInfo.getTePassword());
        tea.setTeAddr(teacherInfo.getTeAddr());
//			tea.setTeitle(title);
        tea.setTeMail(teacherInfo.getTeMail());
        tea.setTeName(teacherInfo.getTeName());
        tea.setTeTel(teacherInfo.getTeTel());
        tea.setTeSex(teacherInfo.getTeSex());
        tea.setTeQQ(teacherInfo.getTeQQ());
        tea.setTePosition(teacherInfo.getTePosition());
        teacherService.update(tea);

        return "main/Success";
    }

    //删除
    @RequestMapping(value = "/teacher/deleteTeacher/{tId}")
    public String deleteTeacher(@PathVariable("tId") int tId, @ModelAttribute TeacherInfo teacherInfo) {
        System.out.println("deleteTeacher=====tId:" + tId);
        teacherService.deleteById(tId);
        return "main/Success";
    }

    //=================================================
//学生管理
    @RequestMapping("/student/manageStudentView")
    public String manageStudentView(@ModelAttribute StudentInfo studentInfo) {
        System.out.println("manageStudentView");
        return "main/student/manageStudentView";
    }

    //添加
    @RequestMapping("/student/addStudentView")
    public String addStudentView(@ModelAttribute StudentInfo studentInfo) {
        System.out.println("addStudentView");
        return "main/student/addStudentView";
    }

    @RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute StudentInfo studentInfo) {
        System.out.println("addStudent");
        Student tea = new Student();
        tea.setsId(studentInfo.getId());
        tea.setPassword(studentInfo.getsPassword());
        tea.setsClass(studentInfo.getsClass());
        tea.setsMail(studentInfo.getsMail());
        tea.setsName(studentInfo.getsName());
        tea.setsTel(studentInfo.getsTel());
        tea.setsSex(studentInfo.getsSex());
        tea.setsQQ(studentInfo.getsQQ());
        Major major = new Major();
        major.setMajorId(studentInfo.getMajorId());
        tea.setMajor(major);
        studentService.add(tea);

        return "main/Success";
    }

    //查询
    @RequestMapping("/student/queryStudentView")
    public String queryStudentView(Model model, @ModelAttribute StudentInfo studentInfo) {
        System.out.println("queryStudentView=======");
        List<Student> teas = (List<Student>) studentService.findAll();
        List<StudentInfo> teaInfs = new ArrayList<StudentInfo>();
        for (Student tea : teas) {
            StudentInfo teaInf = new StudentInfo();
            teaInf.setId(tea.getsId());
            teaInf.setsPassword(tea.getPassword());
            teaInf.setsClass(tea.getsClass());
            teaInf.setsMail(tea.getsMail());
            teaInf.setsName(tea.getsName());
            teaInf.setsTel(tea.getsTel());
            teaInf.setsSex(tea.getsSex());
            teaInf.setsQQ(tea.getsQQ());
            teaInf.setMajorId(tea.getMajor().getMajorId());
            teaInfs.add(teaInf);
        }
        model.addAttribute("teaInfs", teaInfs);
        return "main/student/queryStudentView";
    }

    //更新
    @RequestMapping(value = "/student/updateStudentView/{tId}", method = RequestMethod.GET)
    public String updateStudentView(Model model, @ModelAttribute StudentInfo studentInfo, @PathVariable("tId") int tId) {
        System.out.println("updateStudentView=====tId:" + tId);
        Student tea = studentService.findById(tId);
        studentInfo.setId(tea.getsId());
        studentInfo.setsPassword(tea.getPassword());
        studentInfo.setsClass(tea.getsClass());
        studentInfo.setsMail(tea.getsMail());
        studentInfo.setsName(tea.getsName());
        studentInfo.setsTel(tea.getsTel());
        studentInfo.setsSex(tea.getsSex());
        studentInfo.setsQQ(tea.getsQQ());
        studentInfo.setMajorId(tea.getMajor().getMajorId());
        model.addAttribute("studentInfo", studentInfo);
        return "main/student/updateStudentView";
    }

    @RequestMapping(value = "/student/updateStudent", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute StudentInfo studentInfo) {
        Student tea = new Student();
        tea.setsId(studentInfo.getId());
        tea.setPassword(studentInfo.getsPassword());
        tea.setsClass(studentInfo.getsClass());
        tea.setsMail(studentInfo.getsMail());
        tea.setsName(studentInfo.getsName());
        tea.setsTel(studentInfo.getsTel());
        tea.setsSex(studentInfo.getsSex());
        tea.setsQQ(studentInfo.getsQQ());
        Major major = new Major();
        major.setMajorId(studentInfo.getMajorId());
        tea.setMajor(major);
        studentService.update(tea);

        return "main/Success";
    }

    //删除
    @RequestMapping(value = "/student/deleteStudent/{tId}")
    public String deleteStudent(@PathVariable("tId") int tId, @ModelAttribute StudentInfo studentInfo) {
        System.out.println("deleteStudent=====tId:" + tId);
        studentService.deleteById(tId);
        return "main/Success";
    }


    //=================================================
//专业管理
    @RequestMapping("/major/manageMajorView")
    public String manageMajorView(@ModelAttribute MajorInfo majorInfo) {
        System.out.println("manageMajorView");
        return "main/major/manageMajorView";
    }

    //添加
    @RequestMapping("/major/addMajorView")
    public String addMajorView(@ModelAttribute MajorInfo majorInfo) {
        System.out.println("addMajorView");
        return "main/major/addMajorView";
    }

    @RequestMapping(value = "/major/addMajor", method = RequestMethod.POST)
    public String addMajor(@ModelAttribute MajorInfo majorInfo) {
        System.out.println("addMajor");
        Major tea = new Major();
        tea.setMajorId(majorInfo.getMajorId());
        tea.setMajorName(majorInfo.getMajorName());
        majorService.add(tea);
        return "main/Success";
    }

    //查询
    @RequestMapping("/major/queryMajorView")
    public String queryMajorView(Model model, @ModelAttribute MajorInfo majorInfo) {
        System.out.println("queryMajorView=======");
        List<Major> teas = (List<Major>) majorService.findAll();
        List<MajorInfo> teaInfs = new ArrayList<MajorInfo>();
        for (Major tea : teas) {
            MajorInfo teaInf = new MajorInfo();
            teaInf.setMajorId(tea.getMajorId());
            teaInf.setMajorName(tea.getMajorName());
            teaInfs.add(teaInf);
        }
        model.addAttribute("teaInfs", teaInfs);
        return "main/major/queryMajorView";
    }

    //更新
    @RequestMapping(value = "/major/updateMajorView/{tId}", method = RequestMethod.GET)
    public String updateMajorView(Model model, @ModelAttribute MajorInfo majorInfo, @PathVariable("tId") int tId) {
        System.out.println("updateMajorView=====tId:" + tId);
        Major tea = majorService.findById(tId);
        majorInfo.setMajorId(tea.getMajorId());
        majorInfo.setMajorName(tea.getMajorName());
        model.addAttribute("majorInfo", majorInfo);
        return "main/major/updateMajorView";
    }

    @RequestMapping(value = "/major/updateMajor", method = RequestMethod.POST)
    public String updateMajor(@ModelAttribute MajorInfo majorInfo) {
        Major tea = new Major();
        tea.setMajorId(majorInfo.getMajorId());
        tea.setMajorName(majorInfo.getMajorName());
        majorService.update(tea);

        return "main/Success";
    }

    //删除
    @RequestMapping(value = "/major/deleteMajor/{tId}")
    public String deleteMajor(@PathVariable("tId") int tId, @ModelAttribute MajorInfo majorInfo) {
        System.out.println("deleteMajor=====tId:" + tId);
        majorService.deleteById(tId);
        return "main/Success";
    }

    //=================================================
//评审员管理
    @RequestMapping("/reviewer/manageReviewerView")
    public String manageReviewerView(@ModelAttribute ReviewerInfo reviewerInfo) {
        System.out.println("manageReviewerView");
        return "main/reviewer/manageReviewerView";
    }

    //添加
    @RequestMapping("/reviewer/addReviewerView")
    public String addReviewerView(@ModelAttribute ReviewerInfo reviewerInfo) {
        System.out.println("addReviewerView");
        return "main/reviewer/addReviewerView";
    }

    @RequestMapping(value = "/reviewer/addReviewer", method = RequestMethod.POST)
    public String addReviewer(@ModelAttribute ReviewerInfo reviewerInfo) {
        System.out.println("addReviewer");
        Reviewer tea = new Reviewer();
        tea.setRevId(reviewerInfo.getRevId());
        tea.setRevName(reviewerInfo.getRevName());
        reviewerService.add(tea);
        return "main/Success";
    }

    //查询
    @RequestMapping("/reviewer/queryReviewerView")
    public String queryReviewerView(Model model, @ModelAttribute ReviewerInfo reviewerInfo) {
        System.out.println("queryReviewerView=======");
        List<Reviewer> teas = (List<Reviewer>) reviewerService.findAll();
        List<ReviewerInfo> teaInfs = new ArrayList<ReviewerInfo>();
        for (Reviewer tea : teas) {
            ReviewerInfo teaInf = new ReviewerInfo();
            teaInf.setRevId(tea.getRevId());
            teaInf.setRevName(tea.getRevName());
            teaInfs.add(teaInf);
        }
        model.addAttribute("teaInfs", teaInfs);
        return "main/reviewer/queryReviewerView";
    }

    //更新
    @RequestMapping(value = "/reviewer/updateReviewerView/{tId}", method = RequestMethod.GET)
    public String updateReviewerView(Model model, @ModelAttribute ReviewerInfo reviewerInfo, @PathVariable("tId") int tId) {
        System.out.println("updateReviewerView=====tId:" + tId);
        Reviewer tea = reviewerService.findById(tId);
        reviewerInfo.setRevId(tea.getRevId());
        reviewerInfo.setRevName(tea.getRevName());
        model.addAttribute("reviewerInfo", reviewerInfo);
        return "main/reviewer/updateReviewerView";
    }

    @RequestMapping(value = "/reviewer/updateReviewer", method = RequestMethod.POST)
    public String updateReviewer(@ModelAttribute ReviewerInfo reviewerInfo) {
        Reviewer tea = new Reviewer();
        tea.setRevId(reviewerInfo.getRevId());
        tea.setRevName(reviewerInfo.getRevName());
        reviewerService.update(tea);

        return "main/Success";
    }

    //删除
    @RequestMapping(value = "/reviewer/deleteReviewer/{tId}")
    public String deleteReviewer(@PathVariable("tId") int tId, @ModelAttribute ReviewerInfo reviewerInfo) {
        System.out.println("deleteReviewer=====tId:" + tId);
        reviewerService.deleteById(tId);
        return "main/Success";
    }

    //题目相识度检测
    @RequestMapping(value = "/titleCheck")
    public String titleCheck() {
        System.out.println("-------还  未  实现----------------");
        return "main/Success";
    }

}

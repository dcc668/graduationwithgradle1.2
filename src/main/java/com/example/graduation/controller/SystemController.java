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
    private MajorService majorService;
    @Autowired
    private TeacherStudentService teacherStudentService;

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

    //题目相识度检测
    @RequestMapping(value = "/titleCheck")
    public String titleCheck() {
        System.out.println("-------还  未  实现----------------");
        return "main/Success";
    }

}

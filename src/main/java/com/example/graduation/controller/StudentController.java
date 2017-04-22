package com.example.graduation.controller;

import com.example.graduation.model.Major;
import com.example.graduation.model.Student;
import com.example.graduation.service.MajorService;
import com.example.graduation.service.StudentService;
import com.example.graduation.vo.StudentInfo;
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
@RequestMapping("/student")
public class StudentController {
    private Logger log = Logger.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    //学生管理
    //添加
    @RequestMapping("/addStudentView")
    public String addStudentView(@ModelAttribute StudentInfo studentInfo) {
        return "/student/addStudentView";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute StudentInfo studentInfo,Model model) {
        Student tea = new Student();
        tea.setsId(studentInfo.getId());
        tea.setPassword(studentInfo.getsPassword());
        tea.setsClass(studentInfo.getsClass());
        tea.setsMail(studentInfo.getsMail());
        tea.setsName(studentInfo.getsName());
        tea.setsTel(studentInfo.getsTel());
        tea.setsSex(studentInfo.getsSex());
        tea.setsQQ(studentInfo.getsQQ());
        Integer majorId = studentInfo.getMajorId();
        boolean isRight=false;
        if(majorId>0){
            Major major = majorService.findById(majorId);
            if(major!=null){
                tea.setMajor(major);
                isRight=true;
            }
        }
        if(!isRight){
            model.addAttribute("msg","专业编号不合法，没找到相应的专业");
            return "/error/Failure";
        }
        studentService.add(tea);

        return "/main/Success";
    }

    //查询
    @RequestMapping("/queryStudentView")
    public String queryStudentView(Model model, @ModelAttribute StudentInfo studentInfo) {
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
        return "/student/queryStudentView";
    }

    //更新
    @RequestMapping(value = "/updateStudentView/{tId}", method = RequestMethod.GET)
    public String updateStudentView(Model model, @ModelAttribute StudentInfo studentInfo, @PathVariable("tId") int tId) {
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
        return "/student/updateStudentView";
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
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

        return "/main/Success";
    }

    //删除
    @RequestMapping(value = "/deleteStudent/{tId}")
    public String deleteStudent(@PathVariable("tId") int tId, @ModelAttribute StudentInfo studentInfo) {
        studentService.deleteById(tId);
        return "/main/Success";
    }


}


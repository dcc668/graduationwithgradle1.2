package com.example.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.Course;
import com.example.graduation.model.StudentCourse;
import com.example.graduation.model.Teacher;
import com.example.graduation.model.TeacherCourse;
import com.example.graduation.service.CourseService;
import com.example.graduation.service.TeacherCourseService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.util.Constants;
import com.example.graduation.vo.Page;
import com.example.graduation.vo.TeacherCourseInfo;
import com.example.graduation.vo.TeacherCourseInfoList;
import com.example.graduation.vo.TeacherInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	private Logger log= Logger.getLogger(TeacherController.class);
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private TeacherService teacherService;
	//教学情况管理
	@RequestMapping("/teaTeachInfoAddView")
	public String teaTeachInfoAddView(Model model){
		//获取计通学院的所有课程
		List<Course> courses = courseService.findBySchool(Constants.SCHOOL);
		TeacherInfo teacherInfo=new TeacherInfo();
		teacherInfo.setCourses(courses);
		model.addAttribute("teacher",teacherInfo);
		TeacherCourseInfo teaCoInfo=new TeacherCourseInfo();
			Course co=courses.get(0);
			teaCoInfo.setTcId(-1);
			teaCoInfo.setTerm("春");
			teaCoInfo.setType("理论教学");
			teaCoInfo.setCoName(String.valueOf(co.getCoNO()));
			teaCoInfo.setCoTime(co.getCoTime());
			teaCoInfo.setCoScore(co.getCoScore());
			teaCoInfo.setHouseNum(0);
			teaCoInfo.setCo2Language(co.getCo2Language());
		int notPassNum=0;
		Set<StudentCourse> studentCourse = co.getStudentCourse();
		//not pass num
		for(StudentCourse sc:studentCourse){
			Integer score = sc.getScore();
			if(score<60){
				notPassNum++;
			}
		}
		teaCoInfo.setStuNum(studentCourse.size());
		teaCoInfo.setNotPassNum(notPassNum);
		model.addAttribute("teaCoInfo",teaCoInfo);
		return "teacher/teaTeachInfoAddView";
	}

	/**
	 * 更新
	 * @param model
	 * @return
     */
	@RequestMapping("/teaTeachInfoUpdateView")
	public String teaTeachInfoUpdateView(Model model,HttpServletRequest request){
		String currentPage = request.getParameter("currentPage");
		//获取计通学院的所有课程
		List<Course> courses = courseService.findBySchool(Constants.SCHOOL);
		TeacherInfo teacherInfo=new TeacherInfo();
		teacherInfo.setCourses(courses);
		model.addAttribute("teacher",teacherInfo);
		//获取当前用户
		Object obj = SecurityUtils.getSubject().getPrincipal();
		if(obj==null) {
			log.info("当前用户不存在");
			model.addAttribute("msg", "当前用户不存在");
			return "error/Failure";
		}else{
			Page teacherCoursePage=new Page();
			Integer currentUserId = Integer.parseInt((String) obj);
			//总记录
			List<TeacherCourse> tcss = teacherCourseService.findByTeacherId(currentUserId);
			if(tcss!=null) {
				Integer count = tcss.size();
				teacherCoursePage.setAllRecord(count);
			}
			List<TeacherCourse> tcs=null;
			if(currentPage!=null){
				log.info("-----------TeacherCourse分页----------前台currentPage------->"+currentPage);
				teacherCoursePage.setCurrentPage(Integer.parseInt(currentPage));
				tcs = teacherCourseService.findByTeacherIdAndPage(currentUserId,teacherCoursePage);
			}else {
				teacherCoursePage.setCurrentPage(1);
				tcs = teacherCourseService.findByTeacherIdAndPage(currentUserId,teacherCoursePage);
			}
			log.info("-----------List<TeacherCourse>----------------->" + JSONObject.toJSONString(tcs));
			if(CollectionUtils.isEmpty(tcs)){
				model.addAttribute("msg", "教学情况信息为空");
				return "error/Failure";
			}
			TeacherCourse tc = tcs.get(0);
			TeacherCourseInfo teaCoInfo = new TeacherCourseInfo();
				teaCoInfo.setTcId(tc.getTcId());
				teaCoInfo.setTerm(tc.getTerm());
				teaCoInfo.setType(tc.getType());
				Course cs = tc.getCourse();
				teaCoInfo.setCoName(String.valueOf(cs.getCoNO()));
				teaCoInfo.setCoTime(cs.getCoTime());
				teaCoInfo.setCoScore(cs.getCoScore());
				teaCoInfo.setHouseNum(tc.getHouseNum());
				teaCoInfo.setMark(tc.getMark());
				teaCoInfo.setCo2Language(cs.getCo2Language());
			int notPassNum = 0;
			Set<StudentCourse> studentCourse = cs.getStudentCourse();
			//not pass num
			for (StudentCourse sc : studentCourse) {
				Integer score = sc.getScore();
				if (score < 60) {
					notPassNum++;
				}
			}
			teaCoInfo.setStuNum(studentCourse.size());
			teaCoInfo.setNotPassNum(notPassNum);
			//第一条教师教学情况
			model.addAttribute("teaCoInfo", teaCoInfo);
			//其余教师教学情况
			List<TeacherCourse> subTcs = tcs.subList(1, tcs.size());
			List<TeacherCourseInfo> tcis=new ArrayList<>();
			for(TeacherCourse tcEO:subTcs){
				TeacherCourseInfo tci=new TeacherCourseInfo();
					tci.setTcId(tcEO.getTcId());
					tci.setTerm(tcEO.getTerm());
					tci.setType(tcEO.getType());
					Course course = tcEO.getCourse();
					tci.setCoName(String.valueOf(course.getCoNO()));
					tci.setCoTime(course.getCoTime());
					tci.setCoScore(course.getCoScore());
					tci.setHouseNum(tcEO.getHouseNum());
					tci.setMark(tcEO.getMark());
					tci.setCo2Language(course.getCo2Language());
				int noPassNum = 0;
				Set<StudentCourse> scs = course.getStudentCourse();
				//not pass num
				for (StudentCourse sc : scs) {
					Integer score = sc.getScore();
					if (score < 60) {
						noPassNum++;
					}
				}
				tci.setStuNum(scs.size());
				tci.setNotPassNum(noPassNum);
				tcis.add(tci);
			}
			model.addAttribute("teaCoInfos", tcis);
			model.addAttribute("page",teacherCoursePage);
			return "/teacher/teaTeachInfoUpdateView";
		}
	}

	//异步获取教学情况课程信息
	@RequestMapping("/getCourseInfo")
	public void getCourseInfo(HttpServletRequest request, HttpServletResponse res){
		String coNOStr = request.getParameter("coNO");
		System.out.println(coNOStr);
		if(!StringUtils.isEmpty(coNOStr)) {
			Integer coNO = Integer.parseInt(coNOStr);
			System.out.println(coNO);
			PrintWriter pw = null;
			try {
				pw = res.getWriter();
				JSONObject json = new JSONObject();
				//获取计通学院的所有课程
				List<Course> courses = courseService.findBySchool(Constants.SCHOOL);
				//选coNO课程的学生数量
				Integer stuNum=0;
				//课程学时
				Integer coTime=0;
				//课程学分
				Double coScore=0.0;
				//not pass num
				Integer notPassNum=0;
				//2 language
				Boolean co2Language=false;
				if(!CollectionUtils.isEmpty(courses)) {
					for (Course co : courses) {
						if (coNO.equals(co.getCoNO())) {
							Set<StudentCourse> studentCourse = co.getStudentCourse();
							if(!CollectionUtils.isEmpty(studentCourse)){
								stuNum=studentCourse.size();
							}
							coTime=co.getCoTime();
							coScore=co.getCoScore();
							co2Language=co.getCo2Language();
							//not pass num
							for(StudentCourse sc:studentCourse){
								Integer score = sc.getScore();
								if(score<60){
									notPassNum++;
								}
							}
						}
					}
				}
				json.put("stuNum",stuNum);
				json.put("coTime",coTime);
				json.put("coScore",coScore);
				json.put("notPassNum",notPassNum);
				json.put("co2Language",co2Language);
				pw.write(json.toJSONString());
				pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
		}
	}
	//教学情况提交
	@RequestMapping(value = "/submitTeachInfo",method = RequestMethod.POST)
	public String submitTeachInfo(TeacherCourseInfoList teacherCourseInfoList, HttpServletResponse res,Model model){
		for(TeacherCourseInfo tci:teacherCourseInfoList.getTc()){
			System.out.println("---------------->"+ tci.toString());
		}
		List<TeacherCourseInfo> tcis = teacherCourseInfoList.getTc();
		boolean isRight=true;
		String msg="";
		for (TeacherCourseInfo tci:tcis){
			if(tci.getTcId()!=0){//第1条数据无效
				TeacherCourse tc=new TeacherCourse();
					tc.setStuNum(tci.getStuNum());
					Course course = courseService.findById(Integer.parseInt(tci.getCoName()));
						course.setCo2Language(tci.getCo2Language());
						course.setCoScore(tci.getCoScore());
						course.setCoTime(tci.getCoTime());
					tc.setCourse(course);
					tc.setNotPassNum(tci.getNotPassNum());
					tc.setHouseNum(tci.getHouseNum());
					tc.setMark(tci.getMark());
					String id = (String) SecurityUtils.getSubject().getPrincipal();
					Teacher teacher = teacherService.findById(Integer.parseInt(id));
					tc.setTerm(tci.getTerm());
					tc.setTeacher(teacher);
					tc.setType(tci.getType());
				if(tci.getTcId()==-1){//添加
					log.info("-------------TeacherCourse---------添加-------------"+tc.toString());
					//检查课程是否录入
					List<TeacherCourse> tcs = teacherCourseService.findByTeacherId(Integer.parseInt(id));
					for(TeacherCourse tcc:tcs){
						if((tcc.getCourse().getCoNO()).equals(tci.getCoName())){
							msg=msg+"你已经对该课程（"+tcc.getCourse().getCoName()+"）进行录入，请选择更新按钮。 \n";
							isRight=false;
						}
					}
					teacherCourseService.add(tc);
				}else{//更新
					tc.setTcId(tci.getTcId());
					log.info("-------------TeacherCourse---------更新-------------"+tc.toString());
					teacherCourseService.update(tc);
				}
			}
		}
		if(isRight) {
			return "/main/Success";
		}else{
			model.addAttribute("msg",msg);
			return "/error/Failure";
		}
	}
	//教学情况删除
	@RequestMapping(value = "/delTeacherCourse",method = RequestMethod.POST)
	public void delTeacherCourse(HttpServletRequest req, HttpServletResponse res){
		String tcId = req.getParameter("tcId");
		log.info("---------------delTeacherCourse-------------tcId------------>"+tcId);
		if(!StringUtils.isEmpty(tcId)){
			PrintWriter writer =null;
			JSONObject json=new JSONObject();
			try {
				teacherCourseService.deleteById(Integer.parseInt(tcId));
				writer =res.getWriter();
					json.put("res",1);
				writer.write(json.toJSONString());
				writer.flush();
			} catch (IOException e) {
				json.put("res",0);
				json.put("msg","删除失败！"+e.getMessage());
			}finally {
				if(writer!=null){
					writer.close();
				}
			}
		}else{
			log.info("---------->要删除的tcId为空！");
		}
	}

//	@RequestMapping(value = "/teacherCoursePage",method = RequestMethod.POST)
//	public String teacherCoursePage(Model model,Page page){
//		if(page!=null){
//			//获取计通学院的所有课程
//			List<Course> courses = courseService.findBySchool(Constants.SCHOOL);
//			TeacherInfo teacherInfo=new TeacherInfo();
//			teacherInfo.setCourses(courses);
//			model.addAttribute("teacher",teacherInfo);
//			//获取当前用户
//			Object obj = SecurityUtils.getSubject().getPrincipal();
//			if(obj==null) {
//				log.info("当前用户不存在");
//				model.addAttribute("msg", "当前用户不存在");
//				return "error/Failure";
//			}else {
//				Integer currentUserId = Integer.parseInt((String) obj);
//				List<TeacherCourse> tcs = teacherCourseService.findByTeacherIdAndPage(currentUserId,page);
//				log.info("---------------------------->" + JSONObject.toJSONString(tcs));
//				if (CollectionUtils.isEmpty(tcs)) {
//					model.addAttribute("msg", "教学情况信息为空");
//					return "error/Failure";
//				}
//				TeacherCourse tc = tcs.get(0);
//				Course co = tc.getCourse();
//				TeacherCourseInfo teaCoInfo = new TeacherCourseInfo();
//				teaCoInfo.setTcId(tc.getTcId());
//				teaCoInfo.setTerm(tc.getTerm());
//				teaCoInfo.setType(tc.getType());
//				Course cs = tc.getCourse();
//				teaCoInfo.setCoName(String.valueOf(cs.getCoNO()));
//				teaCoInfo.setCoTime(cs.getCoTime());
//				teaCoInfo.setCoScore(cs.getCoScore());
//				teaCoInfo.setHouseNum(tc.getHouseNum());
//				teaCoInfo.setMark(tc.getMark());
//				teaCoInfo.setCo2Language(cs.getCo2Language());
//				int notPassNum = 0;
//				Set<StudentCourse> studentCourse = co.getStudentCourse();
//				//not pass num
//				for (StudentCourse sc : studentCourse) {
//					Integer score = sc.getScore();
//					if (score < 60) {
//						notPassNum++;
//					}
//				}
//				teaCoInfo.setStuNum(studentCourse.size());
//				teaCoInfo.setNotPassNum(notPassNum);
//				//第一条教师教学情况
//				model.addAttribute("teaCoInfo", teaCoInfo);
//				//其余教师教学情况
//				List<TeacherCourse> subTcs = tcs.subList(1, tcs.size());
//				List<TeacherCourseInfo> tcis = new ArrayList<>();
//				for (TeacherCourse tcEO : subTcs) {
//					TeacherCourseInfo tci = new TeacherCourseInfo();
//					tci.setTcId(tcEO.getTcId());
//					tci.setTerm(tcEO.getTerm());
//					tci.setType(tcEO.getType());
//					Course course = tcEO.getCourse();
//					tci.setCoName(String.valueOf(course.getCoNO()));
//					tci.setCoTime(course.getCoTime());
//					tci.setCoScore(course.getCoScore());
//					tci.setHouseNum(tcEO.getHouseNum());
//					tci.setMark(tcEO.getMark());
//					tci.setCo2Language(course.getCo2Language());
//					int noPassNum = 0;
//					Set<StudentCourse> scs = course.getStudentCourse();
//					//not pass num
//					for (StudentCourse sc : scs) {
//						Integer score = sc.getScore();
//						if (score < 60) {
//							noPassNum++;
//						}
//					}
//					tci.setStuNum(scs.size());
//					tci.setNotPassNum(noPassNum);
//					tcis.add(tci);
//				}
//				model.addAttribute("teaCoInfos", tcis);
//				return "teacher/teaTeachInfoUpdateView";
//			}
//		}else{
//			log.info("-------------------------->page 为空");
//		}
//	}
}

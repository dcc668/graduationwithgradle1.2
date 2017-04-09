package junitTest;

import com.example.graduation.service.PaperService;
import com.example.graduation.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestPaper {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PaperService ss = (PaperService) ac.getBean("paperServiceImp");
		TeacherService teacherService = (TeacherService) ac.getBean("teacherServiceImp");

		//添加
		//Teacher添加
//		Teacher te1=teacherService.findById(1);
//		Teacher te2=teacherService.findById(2);
//		Teacher te3=teacherService.findById(3);
//		Teacher te4=teacherService.findById(4);
//		Teacher te5=teacherService.findById(5);
//		Teacher te6=teacherService.findById(6);
//		Teacher te7=teacherService.findById(7);
//		Teacher te8=teacherService.findById(8);
//
//		Paper pa1 = new Paper();
//		pa1.setTeacher(te1);
//		pa1.setPaHostUnit("xx1有限公司");
//		pa1.setPaName("论文1");
//		pa1.setPaPageNum(3);
//		pa1.setPaPublicationName("出版名称1");
//		pa1.setPaStartTime(new Date());
//		pa1.setPaState("已完成");
//		pa1.setPaPublicationNO("NO122791");
//		ss.add(pa1);
//
//		Paper pa2 = new Paper();
//		pa2.setTeacher(te1);
//		pa2.setPaHostUnit("xx1有限公司");
//		pa2.setPaName("论文2");
//		pa2.setPaPageNum(3);
//		pa2.setPaPublicationName("出版名称1");
//		pa2.setPaStartTime(new Date());
//		pa2.setPaState("已完成");
//		pa2.setPaPublicationNO("NO122792");
//		ss.add(pa2);
//
//		Paper pa3 = new Paper();
//		pa3.setTeacher(te2);
//		pa3.setPaHostUnit("xx1有限公司");
//		pa3.setPaName("论文3");
//		pa3.setPaPageNum(3);
//		pa3.setPaPublicationName("出版名称1");
//		pa3.setPaStartTime(new Date());
//		pa3.setPaState("已完成");
//		pa3.setPaPublicationNO("NO122793");
//		ss.add(pa3);
//
//		Paper pa4 = new Paper();
//		pa4.setTeacher(te2);
//		pa4.setPaHostUnit("xx1有限公司");
//		pa4.setPaName("论文4");
//		pa4.setPaPageNum(3);
//		pa4.setPaPublicationName("出版名称1");
//		pa4.setPaStartTime(new Date());
//		pa4.setPaState("已完成");
//		pa4.setPaPublicationNO("NO122794");
//		ss.add(pa4);
//
//		Paper pa5 = new Paper();
//		pa5.setTeacher(te2);
//		pa5.setPaHostUnit("xx1有限公司");
//		pa5.setPaName("论文5");
//		pa5.setPaPageNum(5);
//		pa5.setPaPublicationName("出版名称1");
//		pa5.setPaStartTime(new Date());
//		pa5.setPaState("已完成");
//		pa5.setPaPublicationNO("NO122795");
//		ss.add(pa5);
//
//		Paper pa6 = new Paper();
//		pa6.setTeacher(te4);
//		pa6.setPaHostUnit("xx1有限公司");
//		pa6.setPaName("论文6");
//		pa6.setPaPageNum(6);
//		pa6.setPaPublicationName("出版名称1");
//		pa6.setPaStartTime(new Date());
//		pa6.setPaState("已完成");
//		pa6.setPaPublicationNO("NO122796");
//		ss.add(pa6);
//
//		Paper pa7 = new Paper();
//		pa7.setTeacher(te5);
//		pa7.setPaHostUnit("xx1有限公司");
//		pa7.setPaName("论文7");
//		pa7.setPaPageNum(3);
//		pa7.setPaPublicationName("出版名称1");
//		pa7.setPaStartTime(new Date());
//		pa7.setPaState("已完成");
//		pa7.setPaPublicationNO("NO122797");
//		ss.add(pa7);
//
//		Paper pa8 = new Paper();
//		pa8.setTeacher(te6);
//		pa8.setPaHostUnit("xx1有限公司");
//		pa8.setPaName("论文8");
//		pa8.setPaPageNum(5);
//		pa8.setPaPublicationName("出版名称8");
//		pa8.setPaStartTime(new Date());
//		pa8.setPaState("已完成");
//		pa8.setPaPublicationNO("NO122798");
//		ss.add(pa8);
//
//		Paper pa9 = new Paper();
//		pa9.setTeacher(te6);
//		pa9.setPaHostUnit("xx9有限公司");
//		pa9.setPaName("论文9");
//		pa9.setPaPageNum(3);
//		pa9.setPaPublicationName("出版名称9");
//		pa9.setPaStartTime(new Date());
//		pa9.setPaState("已完成");
//		pa9.setPaPublicationNO("NO122799");
//		ss.add(pa9);
//
//
//		Paper pa10 = new Paper();
//		pa10.setTeacher(te6);
//		pa10.setPaHostUnit("xx10有限公司");
//		pa10.setPaName("论文10");
//		pa10.setPaPageNum(3);
//		pa10.setPaPublicationName("出版名称10");
//		pa10.setPaStartTime(new Date());
//		pa10.setPaState("已完成");
//		pa10.setPaPublicationNO("NO122710");
//		ss.add(pa10);
//
//		Paper pa11 = new Paper();
//		pa11.setTeacher(te7);
//		pa11.setPaHostUnit("xx11有限公司");
//		pa11.setPaName("论文11");
//		pa11.setPaPageNum(4);
//		pa11.setPaPublicationName("出版名称11");
//		pa11.setPaStartTime(new Date());
//		pa11.setPaState("已完成");
//		pa11.setPaPublicationNO("NO122711");
//		ss.add(pa11);
//
//		Paper pa12 = new Paper();
//		pa12.setTeacher(te7);
//		pa12.setPaHostUnit("xx12有限公司");
//		pa12.setPaName("论文12");
//		pa12.setPaPageNum(5);
//		pa12.setPaPublicationName("出版名称12");
//		pa12.setPaStartTime(new Date());
//		pa12.setPaState("已完成");
//		pa12.setPaPublicationNO("NO122712");
//		ss.add(pa12);
//
//		Paper pa13 = new Paper();
//		pa13.setTeacher(te7);
//		pa13.setPaHostUnit("xx13有限公司");
//		pa13.setPaName("论文13");
//		pa13.setPaPageNum(3);
//		pa13.setPaPublicationName("出版名称13");
//		pa13.setPaStartTime(new Date());
//		pa13.setPaState("已完成");
//		pa13.setPaPublicationNO("NO122713");
//		ss.add(pa13);
//
//		Paper pa14 = new Paper();
//		pa14.setTeacher(te8);
//		pa14.setPaHostUnit("xx14有限公司");
//		pa14.setPaName("论文14");
//		pa14.setPaPageNum(4);
//		pa14.setPaPublicationName("出版名称14");
//		pa14.setPaStartTime(new Date());
//		pa14.setPaState("已完成");
//		pa14.setPaPublicationNO("NO122714");
//		ss.add(pa14);
//		Collection<Paper> data = ss.findAll();
//		ToExcelUtils.toExcelFile(data,"E:\\paper.xls","论文汇总表", Teacher.class);


		System.out.println("----------------------->count:"+ss.getPapersCountByStateAndYear("SCI","2016"));
	}


}

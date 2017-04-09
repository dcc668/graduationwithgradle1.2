package junitTest;

import com.example.graduation.dao.TitleDAO;
import com.example.graduation.model.Title;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestTitle {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
//		TitleService ss=(TitleService) ac.getBean("titleServiceImp");
		TitleDAO ss=(TitleDAO) ac.getBean("titleDAOImp");
//		SubTitle byId1 = ss.getSubTitleId(1221);
		Title byId = ss.getTitleById(1221);
		System.out.println("------------->"+byId.getTitleName());

//
//		Title  re=new Title();
//			re.setTitleId(1221);
//				Major major=new Major();
//				major.setMajorId(1221);
//			re.setMajor(major);
//			Teacher te=new Teacher();
//				te.setTeId(1221);
//			re.setTeacher(te);
//			re.setTerm("2015春");
//			re.setTitleName("毕业设计管理系统");
//			re.setTitleProperty("软件");
//			re.setTitleSource("软件学院");
//			re.setTitleType("管理");
//			re.setNeedStuNum(3);
//			re.setNowStuNum(0);
//			ss.add(re);
//
//
//			Title  re2=new Title();
//			re2.setTitleId(1222);
//			Major major12=new Major();
//			major12.setMajorId(1222);
//			re2.setMajor(major12);
//			Teacher te12=new Teacher();
//			te12.setTeId(1222);
//			re2.setTeacher(te12);
//			re2.setTerm("2015春");
//			re2.setTitleName("库存管理系统");
//			re2.setTitleProperty("软件");
//			re2.setTitleSource("软件学院");
//			re2.setTitleType("管理");
//			re2.setNeedStuNum(2);
//			re2.setNowStuNum(0);
//			ss.add(re2);
//
//			Title  re3=new Title();
//			re3.setTitleId(1223);
//			Major major13=new Major();
//			major13.setMajorId(1223);
//			re3.setMajor(major13);
//			Teacher te13=new Teacher();
//			te13.setTeId(1223);
//			re3.setTeacher(te13);
//			re3.setTerm("2015春");
//			re3.setTitleName("国电信息统计系统");
//			re3.setTitleProperty("软件");
//			re3.setTitleSource("软件学院");
//			re3.setTitleType("统计");
//			re3.setNeedStuNum(1);
//			re3.setNowStuNum(0);
//			ss.add(re3);
//
//			Title  re4=new Title();
//			re4.setTitleId(1224);
//			Major major14=new Major();
//			major14.setMajorId(1224);
//			re4.setMajor(major14);
//			Teacher te14=new Teacher();
//			te14.setTeId(1224);
//			re4.setTeacher(te14);
//			re4.setTerm("2015春");
//			re4.setTitleName("网上销售系统");
//			re4.setTitleProperty("网站");
//			re4.setTitleSource("软件学院");
//			re4.setTitleType("销售");
//			re4.setNeedStuNum(3);
//			re4.setNowStuNum(0);
//			ss.add(re4);
//
//			Title  re5=new Title();
//			re5.setTitleId(1225);
//			Major major15=new Major();
//			major15.setMajorId(1225);
//			re5.setMajor(major15);
//			Teacher te15=new Teacher();
//			te15.setTeId(1225);
//			re5.setTeacher(te15);
//			re5.setTerm("2015春");
//			re5.setTitleName("网上销售系统");
//			re5.setTitleProperty("网站");
//			re5.setTitleSource("软件学院");
//			re5.setTitleType("销售");
//			re5.setNeedStuNum(3);
//			re5.setNowStuNum(2);
//			ss.add(re5);
		
//			Title  re4=new Title();
//			re4.setTitleId(1224);
//			Major major14=new Major();
//			major14.setMajorId(1224);
//			re4.setMajor(major14);
//			Teacher te14=new Teacher();
//			te14.settId(1224);
//			re4.setTeacher(te14);
//			re4.setTerm("2015春");
//			re4.setTitleName("网上销售系统");
//			re4.setTitleProperty("网站");
//			re4.setTitleSource("软件学院");
//			re4.setTitleType("销售");
//			re.setNeedStuNum(3);
//			re.setNowStuNum(0);
//			ss.add(re4);
//
		
		
		
		
	}

}

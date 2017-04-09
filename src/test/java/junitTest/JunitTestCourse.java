package junitTest;

import com.example.graduation.model.Course;
import com.example.graduation.service.CourseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JunitTestCourse {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		CourseService ts=(CourseService) ac.getBean("courseServiceImp");
	
		//Course添加
		Course tea=new Course();
			tea.setCo2Language(true);
			tea.setCoName("计算机网络");
			tea.setCoNO(112323);
			tea.setCoScore(1.5);
			tea.setCoTime(45);
			tea.setCoType("必修");
			tea.setSchool("计通学院");
		ts.add(tea);

		Course tea2=new Course();
		tea2.setCo2Language(true);
		tea2.setCoName("软件工程1");
		tea2.setCoNO(122323);
		tea2.setCoScore(2.5);
		tea2.setCoTime(35);
		tea2.setCoType("必修");
		tea2.setSchool("计通学院");
		ts.add(tea2);

		Course tea3=new Course();
		tea3.setCo2Language(true);
		tea3.setCoName("UML");
		tea3.setCoNO(132366);
		tea3.setCoScore(2.0);
		tea3.setCoTime(45);
		tea3.setCoType("必修");
		tea3.setSchool("计通学院");
		ts.add(tea3);

		Course tea4=new Course();
		tea4.setCo2Language(false);
		tea4.setCoName("Java");
		tea4.setCoNO(142356);
		tea4.setCoScore(3.0);
		tea4.setCoTime(65);
		tea4.setCoType("必修");
		tea4.setSchool("计通学院");
		ts.add(tea4);


		Course tea5=new Course();
		tea5.setCo2Language(false);
		tea5.setCoName("C++");
		tea5.setCoNO(152366);
		tea5.setCoScore(2.0);
		tea5.setCoTime(45);
		tea5.setCoType("必修");
		tea5.setSchool("计通学院");
		ts.add(tea5);


		Course tea6=new Course();
		tea6.setCo2Language(true);
		tea6.setCoName("编译原理");
		tea6.setCoNO(162366);
		tea6.setCoScore(2.0);
		tea6.setCoTime(45);
		tea6.setCoType("必修");
		tea6.setSchool("计通学院");
		ts.add(tea6);
//


		List<Course> cou= ts.findBySchool("计通学院");
		System.out.println(cou.size());



//
//		List<Course> tea=ts.findByName("小东");
//			System.out.println("======"+tea.size());
//			System.out.println("======"+tea.get(0).gettName());
//
//
//







//
//		//��ѯ����
//		Course t=ts.findById(1221);
//		System.out.println("Name:"+t.gettName());
////		���Id��ѯ
//		Integer  []ids={1221,1222,1223};
//		List<Course> t=(List<Course>)ts.findByIds(ids);
//		System.out.println("size:"+t.size());
//
		//����
//		Course te4=new Course();
//		te4.settAddr("�Ϻ�");
//		te4.setId(1226);
//		te4.setTeMail("240@qq.com");
//		te4.setTeName("����2");
//		te4.setTePosition("������");
//		te4.setTeQQ("565438");
//		te4.setTeSex("Ů");
//		te4.setTeTel("18393494149");
//		ts.add(te4);
		
		//��ҳ
//		List<Course> all=(List<Course>)ts.findAll();
//		int page=1;
//		int pageCount;
//		if(all.size()%2==0){pageCount=all.size()/2;}
//		else{pageCount=all.size()/2+1;}
//		
//		for(int i=0;i<pageCount;i++){
//			List<Course> part=(List<Course>)ts.findAllAndPage(2*i, 2);
//			for(Course t:part){
//				System.out.println("----------------");
//				System.out.println("name:"+t.gettName());
//				System.out.println("��"+page+"ҳ");
//			}
//			page++;
//		}
		//ɾ�����
////		ts.deleteById(1226);
//	
//		List<Course> tea=new ArrayList<Course>();
//			tea.add(te);
//			tea.add(te1);
//			tea.add(te2);
//		ts.deleteByCollection(tea);
		
		
	}

}

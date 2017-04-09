package junitTest;

import com.example.graduation.model.Major;
import com.example.graduation.model.Student;
import com.example.graduation.service.MajorService;
import com.example.graduation.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JunitTestStudent {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService ss=(StudentService) ac.getBean("studentServiceImp");
		MajorService ms=(MajorService) ac.getBean("majorServiceImp");
		//添加
		Student stu=new Student();
			Major major=ms.findById(1);
			stu.setMajor(major);
			stu.setsClass("class1");
			stu.setsMail("110@qq.com");
			stu.setsName("李竟");
			stu.setsQQ("582128");
			stu.setsSex("男");
			stu.setsTel("18893494142");
			stu.setPassword("1990");
			ss.add(stu);

			Student stu1=new Student();
				Major major1=ms.findById(2);
			stu1.setMajor(major1);
			stu1.setsClass("class2");
			stu1.setsMail("120@qq.com");
			stu1.setsName("张三");
			stu1.setsQQ("582128");
			stu1.setsSex("男");
			stu1.setsTel("18893494142");
			stu1.setPassword("1991");
			ss.add(stu1);

			Student stu2=new Student();
				Major major2=ms.findById(3);
			stu2.setMajor(major2);
			stu2.setsClass("class3");
			stu2.setsMail("130@qq.com");
			stu2.setsName("王五");
			stu2.setsQQ("682128");
			stu2.setsSex("女");
			stu2.setsTel("18893494142");
			stu2.setPassword("1992");
			ss.add(stu2);

			Student stu3=new Student();
				Major major3=ms.findById(4);
			stu3.setMajor(major3);
			stu3.setsClass("class1");
			stu3.setsMail("140@qq.com");
			stu3.setsName("李四");
			stu3.setsQQ("582128");
			stu3.setsSex("男");
			stu3.setsTel("18893494142");
			stu3.setPassword("1993");
			ss.add(stu3);

			Student stu4=new Student();
				Major major4=ms.findById(5);
			stu4.setMajor(major4);
			stu4.setsClass("class2");
			stu4.setsMail("110@qq.com");
			stu4.setsName("赵六");
			stu4.setsQQ("182128");
			stu4.setsSex("女");
			stu4.setsTel("18893494142");
			stu4.setPassword("1994");
			ss.add(stu4);

			Student stu5=new Student();
				Major major5=ms.findById(1);
			stu5.setMajor(major5);
			stu5.setsClass("class1");
			stu5.setsMail("110@qq.com");
			stu5.setsName("dcc111");
			stu5.setsQQ("582128");
			stu5.setsSex("女");
			stu5.setsTel("18893494142");
			stu5.setPassword("111");
			ss.add(stu5);

		Student stu6=new Student();
		Major major6=ms.findById(2);
		stu6.setMajor(major6);
		stu6.setsClass("class1");
		stu6.setsMail("110@qq.com");
		stu6.setsName("郑悦2");
		stu6.setsQQ("582128");
		stu6.setsSex("男");
		stu6.setsTel("18893494142");
		stu6.setPassword("1990");
		ss.add(stu6);

		Student stu7=new Student();
		Major major7=ms.findById(3);
		stu7.setMajor(major7);
		stu7.setsClass("class2");
		stu7.setsMail("120@qq.com");
		stu7.setsName("张三2");
		stu7.setsQQ("582128");
		stu7.setsSex("男");
		stu7.setsTel("18893494142");
		stu7.setPassword("1991");
		ss.add(stu7);

		Student stu8=new Student();
		Major major8=ms.findById(4);
		stu8.setMajor(major8);
		stu8.setsClass("class3");
		stu8.setsMail("130@qq.com");
		stu8.setsName("李达2");
		stu8.setsQQ("682128");
		stu8.setsSex("女");
		stu8.setsTel("18893494142");
		stu8.setPassword("1992");
		ss.add(stu8);

		Student stu9=new Student();
		Major major9=ms.findById(5);
		stu9.setMajor(major9);
		stu9.setsClass("class1");
		stu9.setsMail("140@qq.com");
		stu9.setsName("李四2");
		stu9.setsQQ("582128");
		stu9.setsSex("男");
		stu9.setsTel("18893494142");
		stu9.setPassword("1993");
		ss.add(stu9);

		Student stu10=new Student();
		Major major10=ms.findById(1);
		stu10.setMajor(major10);
		stu10.setsClass("class2");
		stu10.setsMail("110@qq.com");
		stu10.setsName("赵六2");
		stu10.setsQQ("182128");
		stu10.setsSex("女");
		stu10.setsTel("18893494142");
		stu10.setPassword("1994");
		ss.add(stu10);

		Student stu11=new Student();
		Major major11=ms.findById(2);
		stu11.setMajor(major11);
		stu11.setsClass("class1");
		stu11.setsMail("110@qq.com");
		stu11.setsName("dcc222");
		stu11.setsQQ("582128");
		stu11.setsSex("女");
		stu11.setsTel("18893494142");
		stu11.setPassword("111");
		ss.add(stu11);

//
//
//






//			
			
		
		
//		//��ѯ����
//			Student t=ss.findById(1221);
//		System.out.println("Name:"+t.getsName());
//		���Id��ѯ
//		Integer  []ids={1221,1222,1223};
//		List<Teacher> t=(List<Teacher>)ts.findByIds(ids);
//		System.out.println("size:"+t.size());
//		
		//����
//		Teacher te4=new Teacher();
//		te4.settAddr("�Ϻ�");
//		te4.setId(1226);
//		te4.settMail("240@qq.com");
//		te4.settName("����2");
//		te4.settPosition("������");
//		te4.settQQ("565438");
//		te4.settSex("Ů");
//		te4.settTel("18393494149");
//		ts.update(te4);
		
		//查找分页
		List<Student> all=(List<Student>)ss.findAll();
		System.out.println("JunitTest------findAll"+all.size());
//		int page=1;
//		int pageCount;
//		if(all.size()%2==0){pageCount=all.size()/2;}
//		else{pageCount=all.size()/2+1;}
//		
//		for(int i=0;i<pageCount;i++){
//			List<Teacher> part=(List<Teacher>)ts.findAllAndPage(2*i, 2);
//			for(Teacher t:part){
//				System.out.println("----------------");
//				System.out.println("name:"+t.gettName());
//				System.out.println("��"+page+"ҳ");
//			}
//			page++;
//		}
		//ɾ�����
////		ts.deleteById(1226);
//	
//		List<Teacher> tea=new ArrayList<Teacher>();
//			tea.add(te);
//			tea.add(te1);
//			tea.add(te2);
//		ts.deleteByCollection(tea);
		
//		ss.findByName("成成");
	}

}

package junitTest;

import com.example.graduation.model.Teacher;
import com.example.graduation.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestTeacher {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherService ts=(TeacherService) ac.getBean("teacherServiceImp");
	
		//Teacher添加
		Teacher tea=new Teacher();
			tea.setTeAddr("上海");
			tea.setTeMail("140@qq.com");
			tea.setTeName("张三");
			tea.setTePosition("院长");
			tea.setTeQQ("465438");
			tea.setTeSex("男");
			tea.setTeTel("18193494142");
			tea.setTePassword("123");
		ts.add(tea);

		Teacher te=new Teacher();
		te.setTeAddr("上海");
		te.setTeMail("140@qq.com");
		te.setTeName("李四");
		te.setTePosition("院长");
		te.setTeQQ("565438");
		te.setTeSex("男");
		te.setTeTel("18393494142");
		te.setTePassword("123");
		ts.add(te);

		Teacher te1=new Teacher();
		te1.setTeAddr("北京");
		te1.setTeMail("140@qq.com");
		te1.setTeName("王五");
		te1.setTePosition("副院长");
		te1.setTeQQ("565438");
		te1.setTeSex("女");
		te1.setTeTel("18393494142");
		te1.setTePassword("123");
		ts.add(te1);

		Teacher te2=new Teacher();
		te2.setTeAddr("北京");
		te2.setTeMail("150@qq.com");
		te2.setTeName("赵六");
		te2.setTePosition("副院长");
		te2.setTeQQ("565438");
		te2.setTeSex("男");
		te2.setTeTel("18393494142");
		te2.setTePassword("123");
		ts.add(te2);

		Teacher te3=new Teacher();
		te3.setTeAddr("上海");
		te3.setTeMail("150@qq.com");
		te3.setTeName("王二");
		te3.setTePosition("秘书");
		te3.setTeQQ("565438");
		te3.setTeSex("女");
		te3.setTeTel("18393494142");
		te3.setTePassword("123");
		ts.add(te3);

		Teacher te4=new Teacher();
		te4.setTeAddr("上海");
		te4.setTeMail("140@qq.com");
		te4.setTeName("郑悦");
		te4.setTePosition("教授");
		te4.setTeQQ("565438");
		te4.setTeSex("女");
		te4.setTeTel("18393494142");
		te4.setTePassword("123");
		ts.add(te4);

		Teacher t=new Teacher();
		t.setTeAddr("新疆");
		t.setTeMail("140@qq.com");
		t.setTeName("周总");
		t.setTePosition("院长");
		t.setTeQQ("565438");
		t.setTeSex("女");
		t.setTeTel("18393494142");
		t.setTePassword("123");
		ts.add(t);

		Teacher t1=new Teacher();
		t1.setTeAddr("新疆");
		t1.setTeMail("140@qq.com");
		t1.setTeName("李晓");
		t1.setTePosition("院长");
		t1.setTeQQ("565438");
		t1.setTeSex("女");
		t1.setTeTel("18393494142");
		t1.setTePassword("123");
		ts.add(t1);


//
//		List<Teacher> tea=ts.findByName("小东");
//			System.out.println("======"+tea.size());
//			System.out.println("======"+tea.get(0).gettName());
//
//
//







//
//		//��ѯ����
//		Teacher t=ts.findById(1221);
//		System.out.println("Name:"+t.gettName());
////		���Id��ѯ
//		Integer  []ids={1221,1222,1223};
//		List<Teacher> t=(List<Teacher>)ts.findByIds(ids);
//		System.out.println("size:"+t.size());
//
		//����
//		Teacher te4=new Teacher();
//		te4.settAddr("�Ϻ�");
//		te4.setId(1226);
//		te4.setTeMail("240@qq.com");
//		te4.setTeName("����2");
//		te4.setTePosition("������");
//		te4.setTeQQ("565438");
//		te4.setTeSex("Ů");
//		te4.setTeTel("18393494149");
//		ts.update(te4);
		
		//��ҳ
//		List<Teacher> all=(List<Teacher>)ts.findAll();
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
		
		
	}

}

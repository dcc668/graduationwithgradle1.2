package junitTest;

import com.example.graduation.model.Project;
import com.example.graduation.model.Teacher;
import com.example.graduation.model.TeacherProject;
import com.example.graduation.service.ProjectService;
import com.example.graduation.service.TeacherProjectService;
import com.example.graduation.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestTeacherProject {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherProjectService ts=(TeacherProjectService) ac.getBean("teacherProjectServiceImp");
		TeacherService teacherService=(TeacherService) ac.getBean("teacherServiceImp");
		ProjectService projectService=(ProjectService) ac.getBean("projectServiceImp");


		//添加
		//Teacher添加
		Teacher te1=teacherService.findById(1);
		Teacher te2=teacherService.findById(2);
		Teacher te3=teacherService.findById(3);
		Teacher te4=teacherService.findById(4);
		Teacher te5=teacherService.findById(5);
		Teacher te6=teacherService.findById(6);
		Teacher t7=teacherService.findById(7);
		Teacher t8=teacherService.findById(8);


		Project pro=projectService.findById(1);
		Project pro2=projectService.findById(2);
		Project pro3=projectService.findById(3);
		Project pro4=projectService.findById(4);

		TeacherProject  tp=new TeacherProject();
		tp.setProject(pro);
		tp.setTeacher(te1);
		ts.add(tp);

		TeacherProject  tp2=new TeacherProject();
		tp2.setProject(pro);
		tp2.setTeacher(te2);
		ts.add(tp2);

		TeacherProject  tp3=new TeacherProject();
		tp3.setProject(pro);
		tp3.setTeacher(te3);
		ts.add(tp3);


		TeacherProject  tp4=new TeacherProject();
		tp4.setProject(pro2);
		tp4.setTeacher(te4);
		ts.add(tp4);

		TeacherProject  tp5=new TeacherProject();
		tp5.setProject(pro2);
		tp5.setTeacher(te5);
		ts.add(tp5);

		TeacherProject  tp6=new TeacherProject();
		tp6.setProject(pro2);
		tp6.setTeacher(te6);
		ts.add(tp6);

		TeacherProject  tp7=new TeacherProject();
		tp7.setProject(pro2);
		tp7.setTeacher(te1);
		ts.add(tp7);

		TeacherProject  tp8=new TeacherProject();
		tp8.setProject(pro2);
		tp8.setTeacher(te2);
		ts.add(tp8);



		TeacherProject  tp9=new TeacherProject();
		tp9.setProject(pro3);
		tp9.setTeacher(te3);
		ts.add(tp9);

		TeacherProject  tp10=new TeacherProject();
		tp10.setProject(pro3);
		tp10.setTeacher(te4);
		ts.add(tp10);

		TeacherProject  tp11=new TeacherProject();
		tp11.setProject(pro3);
		tp11.setTeacher(te5);
		ts.add(tp11);



		TeacherProject  tp12=new TeacherProject();
		tp12.setProject(pro4);
		tp12.setTeacher(te6);
		ts.add(tp12);

		TeacherProject  tp13=new TeacherProject();
		tp13.setProject(pro4);
		tp13.setTeacher(te1);
		ts.add(tp13);


		TeacherProject  tp14=new TeacherProject();
		tp14.setProject(pro4);
		tp14.setTeacher(te3);
		ts.add(tp14);

		TeacherProject  tp15=new TeacherProject();
		tp15.setProject(pro4);
		tp15.setTeacher(te5);
		ts.add(tp15);






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
		//���
////		ts.deleteById(1226);
//	
//		List<Teacher> tea=new ArrayList<Teacher>();
//			tea.add(te);
//			tea.add(te1);
//			tea.add(te2);
//		ts.deleteByCollection(tea);
		
		
	}

}

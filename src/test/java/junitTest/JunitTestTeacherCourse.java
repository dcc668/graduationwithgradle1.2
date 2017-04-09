package junitTest;

import com.example.graduation.model.TeacherCourse;
import com.example.graduation.service.CourseService;
import com.example.graduation.service.TeacherCourseService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.vo.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:beans.xml"})
//@Transactional
public class JunitTestTeacherCourse {
//	@Autowired
//	private CourseService courseService;
//	@Autowired
//	private TeacherService teacherService;
//	@Autowired
//	private TeacherCourseService teacherCourseService;

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherCourseService teacherCourseService=(TeacherCourseService) ac.getBean("teacherCourseServiceImp");
		TeacherService teacherService=(TeacherService) ac.getBean("teacherServiceImp");
		CourseService courseService=(CourseService) ac.getBean("courseServiceImp");

		Integer count = teacherCourseService.findByTeacherId(1).size();
		Page page=new Page();
			page.setLineSize(3);
			page.setAllRecord(count);
			page.setCurrentPage(2);
		List<TeacherCourse> tcs = teacherCourseService.findByTeacherIdAndPage(1, page);
		for(TeacherCourse tc:tcs){
			System.out.println("-------->"+tc.toString());
		}

		//Teacher添加
//		Teacher te1=teacherService.findById(1);
//		Teacher te2=teacherService.findById(2);
//		Teacher te3=teacherService.findById(3);
//		Teacher te4=teacherService.findById(4);
//		Teacher te5=teacherService.findById(5);
//		Teacher te6=teacherService.findById(6);
//		Teacher t7=teacherService.findById(7);
//		Teacher t8=teacherService.findById(8);
//
//		Course tea=courseService.findById(1);
//		Course tea2=courseService.findById(2);
//		Course tea3=courseService.findById(3);
//		Course tea4=courseService.findById(4);
//		Course tea5=courseService.findById(5);
//		Course tea6=courseService.findById(6);
//
//
//		//获取计通学院的所有课程
//		List<Course> courses = courseService.findBySchool(Constants.SCHOOL);
//		TeacherCourseInfo teaCoInfo=new TeacherCourseInfo();
//		Course co=courses.get(0);
//		int notPassNum=0;
//		Set<StudentCourse> studentCourse = co.getStudentCourse();
//		//not pass num
//		for(StudentCourse sc:studentCourse){
//			Integer score = sc.getScore();
//			if(score<60){
//				notPassNum++;
//			}
//		}
//
//		TeacherCourse tc1=new TeacherCourse();
//			tc1.setCourse(tea);
//			tc1.setTeacher(te1);
//			tc1.setHouseNum(2);//班级批次
//			tc1.setNotPassNum(notPassNum);
//			tc1.setStuNum(studentCourse.size());
//			tc1.setTerm("春");
//			tc1.setType("理论教学");
//		teacherCourseService.add(tc1);
//
//		TeacherCourse tc2=new TeacherCourse();
//		tc2.setCourse(tea2);
//		tc2.setTeacher(te2);
//		tc2.setHouseNum(3);//班级批次
//		tc2.setNotPassNum(notPassNum);
//		tc2.setStuNum(studentCourse.size());
//		tc2.setTerm("春");
//		tc2.setType("理论教学");
//		teacherCourseService.add(tc2);
//
//		TeacherCourse tc3=new TeacherCourse();
//		tc3.setCourse(tea3);
//		tc3.setTeacher(te3);
//		tc3.setHouseNum(2);//班级批次
//		tc3.setNotPassNum(notPassNum);
//		tc3.setStuNum(studentCourse.size());
//		tc3.setTerm("春");
//		tc3.setType("理论教学");
//		teacherCourseService.add(tc3);
//
//		TeacherCourse tc4=new TeacherCourse();
//		tc4.setCourse(tea4);
//		tc4.setTeacher(te4);
//		tc4.setHouseNum(2);//班级批次
//		tc4.setNotPassNum(notPassNum);
//		tc4.setStuNum(studentCourse.size());
//		tc4.setTerm("春");
//		tc4.setType("理论教学");
//		teacherCourseService.add(tc4);
//
//		TeacherCourse tc5=new TeacherCourse();
//		tc5.setCourse(tea5);
//		tc5.setTeacher(te5);
//		tc5.setHouseNum(2);//班级批次
//		tc5.setNotPassNum(notPassNum);
//		tc5.setStuNum(studentCourse.size());
//		tc5.setTerm("春");
//		tc5.setType("理论教学");
//		teacherCourseService.add(tc5);
//
//		TeacherCourse tc6=new TeacherCourse();
//		tc6.setCourse(tea6);
//		tc6.setTeacher(te6);
//		tc6.setHouseNum(2);//班级批次
//		tc6.setNotPassNum(notPassNum);
//		tc6.setStuNum(studentCourse.size());
//		tc6.setTerm("春");
//		tc6.setType("理论教学");
//		teacherCourseService.add(tc6);


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
//		Teacher te4=teacherService.findById(1221);
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
//
//		List<TeacherCourse> tcs = teacherCourseService.findByTeacherId(1221);
//		System.out.println(JSONObject.toJSONString(tcs));
	}

}

package junitTest;

import com.example.graduation.model.Student;
import com.example.graduation.model.Teacher;
import com.example.graduation.model.TeacherStudent;
import com.example.graduation.service.StudentService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.service.TeacherStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestTeacherStudent {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TeacherStudentService ts=(TeacherStudentService) ac.getBean("teacherStudentServiceImp");
		TeacherService teacherService=(TeacherService) ac.getBean("teacherServiceImp");
		StudentService stus=(StudentService) ac.getBean("studentServiceImp");


		//Teacher添加
		Teacher te1=teacherService.findById(1);
		Teacher te2=teacherService.findById(2);
		Teacher te3=teacherService.findById(3);
		Teacher te4=teacherService.findById(4);
		Teacher te5=teacherService.findById(5);
		Teacher te6=teacherService.findById(6);
		Teacher te7=teacherService.findById(7);
		Teacher te8=teacherService.findById(8);


		Student stu=stus.findById(1);
		Student stu1=stus.findById(2);
		Student stu2=stus.findById(3);
		Student stu3=stus.findById(4);
		Student stu4=stus.findById(5);
		Student stu5=stus.findById(6);
		Student stu7=stus.findById(7);
		Student stu8=stus.findById(8);
		Student stu9=stus.findById(9);
		Student stu10=stus.findById(10);
		Student stu11=stus.findById(11);
		Student stu12=stus.findById(12);

		TeacherStudent tea=new TeacherStudent();
			tea.setScore(95);
			tea.setStudent(stu);
			tea.setTeacher(te1);
		ts.add(tea);
		
		TeacherStudent tea1=new TeacherStudent();
		tea1.setScore(96);
		tea1.setStudent(stu1);
		tea1.setTeacher(te2);
		ts.add(tea1);
		
		TeacherStudent tea2=new TeacherStudent();
		tea2.setScore(95);
		tea2.setStudent(stu2);
		tea2.setTeacher(te3);
		ts.add(tea2);
		
		TeacherStudent tea3=new TeacherStudent();
		tea3.setScore(95);
		tea3.setStudent(stu3);
		tea3.setTeacher(te4);
		ts.add(tea3);
		
		TeacherStudent tea4=new TeacherStudent();
		tea4.setScore(95);
		tea4.setStudent(stu4);
		tea4.setTeacher(te5);
		ts.add(tea4);
//		
		TeacherStudent tea5=new TeacherStudent();
		tea5.setScore(95);
		tea5.setStudent(stu5);
		tea5.setTeacher(te6);
		ts.add(tea5);

		TeacherStudent tea6=new TeacherStudent();
		tea6.setScore(95);
		tea6.setStudent(stu7);
		tea6.setTeacher(te7);
		ts.add(tea6);

		TeacherStudent tea7=new TeacherStudent();
		tea7.setScore(95);
		tea7.setStudent(stu8);
		tea7.setTeacher(te8);
		ts.add(tea7);

		TeacherStudent tea8=new TeacherStudent();
		tea8.setScore(95);
		tea8.setStudent(stu9);
		tea8.setTeacher(te8);
		ts.add(tea8);
		
		TeacherStudent tea9=new TeacherStudent();
		tea9.setScore(95);
		tea9.setStudent(stu10);
		tea9.setTeacher(te1);
		ts.add(tea9);
		
		
	}

}

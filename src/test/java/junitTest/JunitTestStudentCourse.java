package junitTest;

import com.example.graduation.model.Course;
import com.example.graduation.model.Student;
import com.example.graduation.model.StudentCourse;
import com.example.graduation.service.CourseService;
import com.example.graduation.service.StudentCourseService;
import com.example.graduation.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestStudentCourse {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentCourseService ss=(StudentCourseService) ac.getBean("studentCourseServiceImp");
		StudentService stus=(StudentService) ac.getBean("studentServiceImp");
		CourseService courseService=(CourseService) ac.getBean("courseServiceImp");

		//添加
		Student stu=stus.findById(1221);
			Student stu1=stus.findById(1);
			Student stu2=stus.findById(2);
			Student stu3=stus.findById(3);
			Student stu4=stus.findById(4);
			Student stu5=stus.findById(5);
		Student stu7=stus.findById(6);
		Student stu8=stus.findById(7);
		Student stu9=stus.findById(8);
		Student stu10=stus.findById(9);
		Student stu11=stus.findById(10);
		Student stu12=stus.findById(11);



		Course tea=courseService.findById(1);
		Course tea2=courseService.findById(2);
		Course tea3=courseService.findById(3);
		Course tea4=courseService.findById(4);
		Course tea5=courseService.findById(5);
		Course tea6=courseService.findById(6);



		StudentCourse sc=new StudentCourse();
		sc.setCourse(tea);
		sc.setStudent(stu);
		sc.setScore(96);
		ss.add(sc);

		StudentCourse sc2=new StudentCourse();
		sc2.setCourse(tea2);
		sc2.setStudent(stu2);
		sc2.setScore(92);
		ss.add(sc2);

		StudentCourse sc3=new StudentCourse();
		sc3.setCourse(tea3);
		sc3.setStudent(stu3);
		sc3.setScore(93);
		ss.add(sc3);

		StudentCourse sc4=new StudentCourse();
		sc4.setCourse(tea4);
		sc4.setStudent(stu4);
		sc4.setScore(94);
		ss.add(sc4);

		StudentCourse sc5=new StudentCourse();
		sc5.setCourse(tea5);
		sc5.setStudent(stu5);
		sc5.setScore(95);
		ss.add(sc5);

		StudentCourse sc6=new StudentCourse();
		sc6.setCourse(tea6);
		sc6.setStudent(stu);
		sc6.setScore(96);
		ss.add(sc6);

		StudentCourse sc7=new StudentCourse();
		sc7.setCourse(tea);
		sc7.setStudent(stu7);
		sc7.setScore(57);
		ss.add(sc7);

		StudentCourse sc8=new StudentCourse();
		sc8.setCourse(tea2);
		sc8.setStudent(stu8);
		sc8.setScore(98);
		ss.add(sc8);

		StudentCourse sc9=new StudentCourse();
		sc9.setCourse(tea3);
		sc9.setStudent(stu9);
		sc9.setScore(99);
		ss.add(sc9);

		StudentCourse sc10=new StudentCourse();
		sc10.setCourse(tea5);
		sc10.setStudent(stu10);
		sc10.setScore(79);
		ss.add(sc10);

		StudentCourse sc11=new StudentCourse();
		sc11.setCourse(tea4);
		sc11.setStudent(stu11);
		sc11.setScore(49);
		ss.add(sc11);

		StudentCourse sc12=new StudentCourse();
		sc12.setCourse(tea2);
		sc12.setStudent(stu12);
		sc12.setScore(9);
		ss.add(sc12);

	}

}

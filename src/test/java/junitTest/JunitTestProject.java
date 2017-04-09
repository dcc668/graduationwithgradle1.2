package junitTest;

import com.example.graduation.model.Project;
import com.example.graduation.service.ProjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class JunitTestProject {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ProjectService ts = (ProjectService) ac.getBean("projectServiceImp");

		Project pro=new Project();
			pro.setPrDate(90);
			pro.setPrMoney(31000.5);
			pro.setPrName("科研项目1");
			pro.setPrSource("xx1有限公司");
			pro.setPrState("已完成");
			pro.setPrStartTime(new Date());
		ts.add(pro);

		Project pro2=new Project();
		pro2.setPrDate(70);
		pro2.setPrMoney(71000.5);
		pro2.setPrName("科研项目2");
		pro2.setPrSource("xx2有限公司");
		pro2.setPrState("已完成");
		pro2.setPrStartTime(new Date());
		ts.add(pro2);

		Project pro3=new Project();
		pro3.setPrDate(50);
		pro3.setPrMoney(21000.5);
		pro3.setPrName("科研项目3");
		pro3.setPrSource("xx3有限公司");
		pro3.setPrState("已完成");
		pro3.setPrStartTime(new Date());
		ts.add(pro3);

		Project pro4=new Project();
		pro4.setPrDate(190);
		pro4.setPrMoney(231000.5);
		pro4.setPrName("科研项目4");
		pro4.setPrSource("xx4有限公司");
		pro4.setPrState("已完成");
		pro4.setPrStartTime(new Date());
		ts.add(pro4);


	}
}

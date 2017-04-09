package junitTest;

import com.example.graduation.model.Major;
import com.example.graduation.service.MajorService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestMajor {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		MajorService ss=(MajorService) ac.getBean("majorServiceImp");

		Major  re=new Major();
		re.setMajorName("软件工程");
			ss.add(re);
		Major  re1=new Major();
		re1.setMajorName("计算机科学技术");
			ss.add(re1);
		Major  re2=new Major();
		re2.setMajorName("物联网");
			ss.add(re2);
		Major  re3=new Major();
		re3.setMajorName("通信");
			ss.add(re3);
		Major  re4=new Major();
			re4.setMajorName("给水排水");
			ss.add(re4);
			
//			Major ma=ss.findById(1001);
//			System.out.println("Major name:"+ma.getMajorName());
		
//		���Id��ѯ
		//ʧ�� size=0
//		Integer  []ids={1001,1002,1003};
//		List<Major> t=(List<Major>)ss.findByIds(ids);
//		System.out.println("size:"+t.size());
//		
		//����
//			Major  re4=new Major();
//			re4.setMajorId(1004);
//			re4.setMajorName("֪ʶ��Ȩ");
//		ss.update(re4);
//		
		//��ҳ
//		List<Major> all=(List<Major>)ss.findAll();
//		int page=1;
//		int pageCount;
//		if(all.size()%2==0){pageCount=all.size()/2;}
//		else{pageCount=all.size()/2+1;}
//		
//		for(int i=0;i<pageCount;i++){
//			List<Major> part=(List<Major>)ss.findAllAndPage(2*i, 2);
//			for(Major t:part){
//				System.out.println("----------------");
//				System.out.println("name:"+t.getMajorName());
//				System.out.println("��"+page+"ҳ");
//			}
//			page++;
//		}
			
		//ɾ�����
//		ss.deleteById(1004);
//	
//		List<Major> tea=new ArrayList<Major>();
//			tea.add(re1);
//			tea.add(re2);
//			tea.add(re);
//		ss.deleteByCollection(tea);
		
		
	}

}

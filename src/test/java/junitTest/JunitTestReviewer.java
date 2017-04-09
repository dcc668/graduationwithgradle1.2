package junitTest;

import com.example.graduation.model.Reviewer;
import com.example.graduation.service.ReviewerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestReviewer {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		ReviewerService ss=(ReviewerService) ac.getBean("reviewerServiceImp");
	
		//��Ӳ���

			Reviewer  re=new Reviewer();
			re.setRevId(1221);
			re.setRevName("挺峰");
				ss.add(re);
			Reviewer  re1=new Reviewer();
			re1.setRevId(1222);
			re1.setRevName("子怡");
			ss.add(re1);
			
			Reviewer  re2=new Reviewer();
			re2.setRevId(1223);
			re2.setRevName("娜姐");
			ss.add(re2);
			
			Reviewer  re3=new Reviewer();
			re3.setRevId(1224);
			re3.setRevName("过儿");
			ss.add(re3);
			
			Reviewer  re4=new Reviewer();
			re4.setRevId(1225);
			re4.setRevName("小华");
			ss.add(re4);

//		//��ѯ����
//		Reviewer t=ss.findById(1222);
//		System.out.println("Name:"+t.getRevName());
////		���Id��ѯ
//		Integer  []ids={1221,1222,1223};
//		List<Reviewer> t=(List<Reviewer>)ss.findByIds(ids);
//		System.out.println("size:"+t.size());
		
		//����

//			Reviewer  re4=new Reviewer();
//			re4.setRevId(1224);
//			re4.setRevName("��ҵ������ϵͳ");
////			
//		ss.update(re4);
		
		//��ҳ
//		List<Reviewer> all=(List<Reviewer>)ss.findAll();
//		int page=1;
//		int pageCount;
//		if(all.size()%2==0){pageCount=all.size()/2;}
//		else{pageCount=all.size()/2+1;}
//		
//		for(int i=0;i<pageCount;i++){
//			List<Reviewer> part=(List<Reviewer>)ss.findAllAndPage(2*i, 2);
//			for(Reviewer t:part){
//				System.out.println("----------------");
//				System.out.println("name:"+t.getRevName());
//				System.out.println("��"+page+"ҳ");
//			}
//			page++;
//		}
		//ɾ�����
//		ss.deleteById(1222);
//	
//		List<Reviewer> tea=new ArrayList<Reviewer>();
//			tea.add(re2);
//			tea.add(re3);
//		ss.deleteByCollection(tea);
		
		
	}

}

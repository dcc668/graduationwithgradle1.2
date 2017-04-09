package junitTest;

import com.example.graduation.model.Reviewer;
import com.example.graduation.model.Title;
import com.example.graduation.model.TitleReviewInfor;
import com.example.graduation.service.TitleReviewInforService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTestReviewerInfor {

	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TitleReviewInforService ss=(TitleReviewInforService) ac.getBean("titleReviewInforServiceImp");
	
		//注意：title和title评审信息表为一对一，主外键一致

		
		TitleReviewInfor re=new  TitleReviewInfor();
		re.setTrId(1221);
		re.setTerm("2015春");
		re.setTitleExamine("相似度通过");
		re.setReviewSuggestion("无");
		re.setReviewState("审核中");
			Title ti1=new Title();
			ti1.setTitleId(1221);
		re.setTitle(ti1);
			Reviewer  review1=new Reviewer();
			review1.setRevId(1221);
		re.setReviewer(review1);
		ss.add(re);
		
		TitleReviewInfor re2=new  TitleReviewInfor();
		re2.setTrId(1222);
		re2.setTerm("2015春");
		re2.setTitleExamine("相似度通过");
		re2.setReviewSuggestion("无");
		re2.setReviewState("审核中");
			Title ti2=new Title();
			ti2.setTitleId(1222);
		re2.setTitle(ti2);
			Reviewer  review2=new Reviewer();
			review2.setRevId(1222);
		re2.setReviewer(review2);
		ss.add(re2);
		
		TitleReviewInfor re3=new  TitleReviewInfor();
		re3.setTrId(1223);
		re3.setTerm("2015春");
		re3.setTitleExamine("相似度通过");
		re3.setReviewSuggestion("无");
		re3.setReviewState("审核中");
		Title ti3=new Title();
		ti3.setTitleId(1223);
		re3.setTitle(ti3);
		Reviewer  review3=new Reviewer();
		review3.setRevId(1223);
		re3.setReviewer(review3);
		ss.add(re3);
		
		TitleReviewInfor re4=new  TitleReviewInfor();
		re4.setTrId(1224);
		re4.setTerm("2015春");
		re4.setTitleExamine("相似度通过");
		re4.setReviewSuggestion("无");
		re4.setReviewState("通过");
		Title ti4=new Title();
		ti4.setTitleId(1224);
		re4.setTitle(ti4);
		Reviewer  review4=new Reviewer();
		review4.setRevId(1224);
		re4.setReviewer(review4);
		ss.add(re4);
		
		TitleReviewInfor re5=new  TitleReviewInfor();
		re5.setTrId(1225);
		re5.setTerm("2015春");
		re5.setTitleExamine("相似度通过");
		re5.setReviewSuggestion("无");
		re5.setReviewState("通过");
		Title ti5=new Title();
		ti5.setTitleId(1225);
		re5.setTitle(ti5);
		Reviewer  review5=new Reviewer();
		review5.setRevId(1225);
		re5.setReviewer(review5);
		ss.add(re5);
//		
	
			
			
			
			
//			TitleReviewInfor re1=new  TitleReviewInfor();
//			re1.setTrId(1001);
//			re1.setTerm("2015����");
//			re1.setTitleExamine("��ʶ��ͨ��");
//			re1.setReviewSuggestion("�� ");
//			re1.setReviewState("ͨ��");
//			Title ti2=new Title();
//			ti2.setTitleId(1002);
//			re.setTitle(ti2);
//			ss.add(re1);
			
			
			
		//通过Id查找
//		TitleReviewInfor t=ss.findById(1222);
//		System.out.println("id:"+t.getTrId());
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
		
		
//		List<TitleReviewInfor>tri=(List<TitleReviewInfor>)ss.findNotReview();
//		System.out.println("======="+tri.size());
	}

}

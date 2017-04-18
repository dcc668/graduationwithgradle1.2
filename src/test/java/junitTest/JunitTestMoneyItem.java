package junitTest;

import com.alibaba.fastjson.JSONObject;
import com.example.graduation.model.MoneyItem;
import com.example.graduation.service.MoneyItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
@Transactional
public class JunitTestMoneyItem {
	@Autowired
	private  MoneyItemService moneyItemService;

	@Test
	public void test(){
		List<MoneyItem> moneyItemsByPrId = moneyItemService.getMoneyItemsByPrId(1001);
		System.out.println("--------List<MoneyItem>-------->"+ JSONObject.toJSONString(moneyItemsByPrId));
	}

}

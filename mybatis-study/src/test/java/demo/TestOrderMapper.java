package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.dao.OrderMapper;
import demo.entity.Order;
import demo.entity.OrderDetail;
import demo.entity.OrderUser;

public class TestOrderMapper {
	private OrderMapper orderMapper;
	private Logger log = LoggerFactory.getLogger(TestOrderMapper.class);
	
	@Before
	public void setUpBefore() throws IOException{
		InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		orderMapper = sqlSession.getMapper(OrderMapper.class);
				
	}
	
	@Test
	public void testSelectOrderUserByOrderNumber(){
		OrderUser orerUser = orderMapper.selectOrderUserByOrderNumber("201807010001");
		log.info(orerUser.toString());
		System.out.println(orerUser);
	}
	
	@Test
	public void testSelectOrderByOrderNumber(){
		Order orderUser = orderMapper.selectOrderByOrderNumber("201807010001");
		log.info(orderUser.getUser().toString());
		log.info(orderUser.toString());
	}
	
	@Test
	public void testSelectOrderWithOrderDetailByOrderNumber(){
		Order orderUser = orderMapper.selectOrderWithOrderDetailByOrderNumber("201807010001");
		log.info("==============> " + orderUser.toString());
		//List<OrderDetail> orderDetailList = orderUser.getOrderDetailList();
//		for (OrderDetail orderDetail : orderDetailList) {
//			System.out.println(orderDetail);
//		}
//		int size = orderDetailList.size();
//		System.out.println("size :  " + size);
	}
	
	@Test
	public void testSelectOrderWithODAndItemByOrderNumber(){
		Order order = orderMapper.selectOrderWithODAndItemByOrderNumber("201807010001");
		log.info(order.toString());
	}
	
}

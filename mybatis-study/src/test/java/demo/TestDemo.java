package demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import demo.dao.UserDao;
import demo.dao.UserDaoImpl;
import demo.entity.User;

public class TestDemo {
	private SqlSession sqlSession;

	@Before
	public void setUp() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// ´´½¨SessionÊµÀý
		sqlSession = sqlSessionFactory.openSession();

		
	}
	
	@Test
	public void testSelect(){
		UserDao ud = new UserDaoImpl(sqlSession);
		User user = ud.queryUserById(2);
		System.out.println(user);
	}
	
	

}

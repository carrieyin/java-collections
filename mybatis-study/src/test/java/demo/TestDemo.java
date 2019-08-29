package demo;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.dao.UserDao;
import demo.dao.UserDaoImpl;
import demo.entity.User;

public class TestDemo {
	private SqlSession sqlSession;
	private UserDao ud;
	private Logger logger = LoggerFactory.getLogger(TestDemo.class) ;

	@Before
	public void setUp() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// ´´½¨SessionÊµÀý
		sqlSession = sqlSessionFactory.openSession();
		ud = new UserDaoImpl(sqlSession);		
	}
	
	@Test
	public void testSelect(){		
		User user = ud.queryUserById(2);
		logger.info(user.toString());
	}
	
	@Test
	public void testSelectAll(){
		List<User> queryUserAll = ud.queryUserAll();
		for (User user : queryUserAll) {
			//System.out.println(user);
			logger.info(user.toString());
		}
	}
	
	@Test
	public void testUpdateUser() throws ParseException{
		User u = new User();
		u.setId("2");
		u.setAge(13);
		u.setName("zhangsan");
		u.setPassword("789");
		u.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29"));
		u.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29").toString());
		ud.updateUser(u);
		sqlSession.commit();
	}
	
	@Test
	public void insertUser() throws ParseException{
		User u = new User();
		u.setId("3");
		u.setAge(18);
		u.setName("6333");
		u.setPassword("888");
		u.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29"));
		u.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29").toString());
		ud.insertUser(u);
		sqlSession.commit();
	}

}

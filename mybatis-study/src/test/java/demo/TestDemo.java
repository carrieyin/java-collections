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
		// 创建Session实例
		sqlSession = sqlSessionFactory.openSession();
		//ud = new UserDaoImpl(sqlSession);
		ud = sqlSession.getMapper(UserDao.class);
	}
	
	@Test
	public void testSelect(){
		User user = ud.queryUserById(4);
		//select xml中id必须与接口中的一致
		//User user = ud.queryOneUser(4);
		System.out.println(user.getClass().getName());
		//List<User> users = ud.queryUserById(2);
		/*for(User user:users){
			System.out.println(user);
		}*/
		
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll(){
		List<User> queryUserAll = ud.queryUserAll();
		for (User user : queryUserAll) {
			logger.info(user.toString());
		}
	}
	
	@Test
	public void testUpdateUser() throws ParseException{
		User u = new User();
		u.setId("2");
		u.setAge(13);
		u.setName("zhangsan");
		u.setUserName("test");
		u.setPassword("9999999");
		u.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29"));
		ud.updateUser(u);
		sqlSession.commit();
	}
	
	@Test
	public void insertUser() throws ParseException{
		User u = new User();
		u.setAge(18);
		u.setName("6333");
		u.setPassword("888");
		u.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-29"));
		ud.insertUser(u);
		sqlSession.commit();
	}

	@Test
	public void deleteUser(){
		User u = new User();
		ud.deleteUser("2");
		sqlSession.commit();
	}
}

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

import demo.dao.UserMapper;
import demo.entity.User;

public class TestMyBatisConfig {
	private UserMapper userMapper;
	private Logger logger = LoggerFactory.getLogger(TestMyBatisConfig.class);
	
	@Before
	public void setUp() throws IOException{
		InputStream resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession openSession = sessionFactory.openSession(true);
		userMapper = openSession.getMapper(UserMapper.class);
	}

	@Test
	public void testSelectAll(){
		List<User> userList = userMapper.queryUserAll();
		for(User user: userList){
			logger.info(user.toString());
		}
	}
	
	@Test
	public void testSelectone(){
		User u = userMapper.queryUserByID("5");
		logger.info(u.toString());
	}
}

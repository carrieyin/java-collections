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
	//for cache test
	private SqlSession openSession;
	SqlSessionFactory sessionFactory;
	private Logger logger = LoggerFactory.getLogger(TestMyBatisConfig.class);
	
	@Before
	public void setUp() throws IOException{
		InputStream resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		openSession = sessionFactory.openSession(true);
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
	
	@Test
	public void testSelectbyName(){
		List<User> userList = userMapper.queryUserListByName(null);
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	@Test
	public void testSelectByNameOrage(){
		List<User> userList = userMapper.queryUserByNameOrAge("", 18);
		List<User> ul = userMapper.queryUserByNameOrAge("", 18);
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	@Test
	public void testSelectByNameandAge(){
		List<User> userList = userMapper.queryUserByNameAndAge("鹏程", 18);
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	@Test
	public void testSelectbyIds(){
		
		List<User> userList = userMapper.queryUserInArrays(new String[]{"1","5"});
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	//测试缓存 ? 此处二级缓存未生效(调用setUp缓存不生效)？？
	@Test
	public void testCached() throws IOException{
		List<User> ul = userMapper.queryUserByNameOrAge("", 18);
		//openSession.clearCache();
		openSession.close();
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//List<User> list = userMapper.queryUserByNameOrAge("", 18);
		/*User user=new User();
	    user.setName("美女");
	    user.setId("1");
	    userMapper.updateUser(user);*/
	    
	    List<User> ulist = mapper.queryUserByNameOrAge("", 18);
	}
	
	
	
}

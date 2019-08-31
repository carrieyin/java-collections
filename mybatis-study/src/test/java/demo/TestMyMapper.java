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

import com.mysql.jdbc.log.LogFactory;

import demo.dao.UserMapper;
import demo.entity.User;
//https://blog.csdn.net/hellozpc/article/details/80878563
public class TestMyMapper {
	private UserMapper userMapper;
	private Logger logger = LoggerFactory.getLogger(TestMyMapper.class);
	
	@Before
	public void setBefore() throws IOException{
		//get config
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//create sqlsession factory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//get sqlSession
		SqlSession openSession = sqlSessionFactory.openSession(true);
		
		//get dao 
		userMapper = openSession.getMapper(UserMapper.class);
		
	}
	
	@Test
	public void testLogin(){
		User loginUser = userMapper.login("zpc", "123456");
		System.out.println(loginUser);
		logger.info(loginUser.toString());
		
	}
	
	@Test 
	public void testqueryUserByTableName(){
		List<User> queryUserByTable = userMapper.queryUserByTable("tb_user");
		for(User u: queryUserByTable){
			System.out.println(u);
		}
	}

	@Test
	public void testQueryUserByID(){
		User u = userMapper.queryUserByID("5");
	    logger.info(u.toString());
	}
	
	@Test
	public void testQueryUserAll(){
		List<User> userList = userMapper.queryUserAll();
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	@Test
	public void testInsertUser() throws ParseException{
		User user = new User("test", "root", "ydd", 20, 0, new SimpleDateFormat("yyyy-MM-dd").parse("1990-09-09"));
		userMapper.insertUser(user);
	}
	
	@Test
	public void testDelUserByID(){
		userMapper.deleteUserById(3);
	}
	
	@Test
	public void testUpdate() throws ParseException{
		User user = new User("6","test", "root", "ydd", 20, 0, new SimpleDateFormat("yyyy-MM-dd").parse("1990-09-09"));
		userMapper.updateUser(user);
	}
}

package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.dao.UserMapper;
import demo.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	private Logger log = LoggerFactory.getLogger(UserMapper.class);
	
	@Test
	public void testQueryAll(){
		List<User> users = userMapper.queryUserAll() ;
		System.out.println(users);
	}
	
	@Test
	public void testQueryUserById(){
		User user = userMapper.queryUserById(2);
		log.info(user.toString());
		
	}
	
	@Test
	public void testInsertUser() throws ParseException{
		User user = new User();
		user.setAge(30);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-08-09"));
		user.setName("Ð¡ºì");
		user.setPassword("789");
		user.setSex(1);
		user.setUserName("hong_test");
		
		userMapper.insertUser(user);
		
	}
	
	@Test
	public void testUpdate() throws ParseException{
		User user = new User();
		user.setId("9");
		user.setAge(30);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-08-09"));
		user.setName("Ð¡ºì");
		user.setPassword("99999");
		user.setSex(1);
		user.setUserName("test");
		
		userMapper.updateUser(user);
	}
	
	@Test
	public void testDelete(){
		userMapper.deleteUser("10");
	}
}

package demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void testQueryUserById(){
		List<User> users = userMapper.queryUserAll() ;
		System.out.println(users);
	}
}

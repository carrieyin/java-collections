package generatorTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.ydd.study.generated.entity.User;
import com.ydd.study.generated.mapper.UserMapper;

//https://blog.csdn.net/hellozpc/article/details/80878563#14sql_2058
/* 整合mybatis spring pagehelper
 * 使用插件mybatis generator可以自动生成mapper mapper.xml user
 * 使用前可删除userMapper.java User UserMapper.xml
 * 执行maven run后选择mybatis-generator:generate 可自动生成代码
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
	
	@Test
	public void testDeletByID(){
		userMapper.deleteByPrimaryKey(7);
	}
	
	
	@Test
	public void testQueryUserAll(){
		List<User> userList = userMapper.queryUserAll();
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
	@Test
	public void testQueryUserByPageHelper(){
		PageHelper.startPage(2, 2);
		List<User> userList = userMapper.queryUserAll();
		for(User u: userList){
			logger.info(u.toString());
		}
	}
	
}

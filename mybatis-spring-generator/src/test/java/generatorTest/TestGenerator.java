package generatorTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ydd.study.generated.mapper.UserMapper;

//https://blog.csdn.net/hellozpc/article/details/80878563#14sql_2058
/* 整合mybatis spring 
 * 使用插件mybatis generator可以自动生成mapper mapper.xml user
 * 使用前可删除userMapper.java User UserMapper.xml
 * 执行maven run后选择mybatis-generator:generate 可自动生成代码
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestGenerator {
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(TestGenerator.class);
	
	@Test
	public void testDeletByID(){
		userMapper.deleteByPrimaryKey(7);
	}
	
	
}

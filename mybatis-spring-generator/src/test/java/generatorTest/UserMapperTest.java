package generatorTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ydd.study.generated.entity.User;
import com.ydd.study.generated.entity.UserExample;
import com.ydd.study.generated.entity.UserExample.Criteria;
import com.ydd.study.generated.mapper.UserMapper;

//https://blog.csdn.net/hellozpc/article/details/80878563#14sql_2058
/* ����mybatis spring 
 * ʹ�ò��mybatis generator�����Զ�����mapper mapper.xml user
 * ʹ��ǰ��ɾ��userMapper.java User UserMapper.xml
 * ִ��maven run��ѡ��mybatis-generator:generate ���Զ����ɴ���
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
	public void testQueryWithExample(){
		UserExample example = new UserExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andAgeGreaterThanOrEqualTo(17);
		criteria.andAgeLessThan(20) ;
		
		criteria.andNameLike("��") ;
        List<User> userList = userMapper.selectByExample(example);	
        for(User u: userList){
        	logger.info(u.toString());
        }
        
	}
	
}

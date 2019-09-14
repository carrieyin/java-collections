package Generator_1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ydd.study.generated.mapper.UserMapper;



//https://blog.csdn.net/hellozpc/article/details/80878563#14sql_2058
//该项目mapper.xml mapper user均为自动生成，执行maven build-->goals (mybatis-generator:generate)
public class TestGenerator {
	
	private UserMapper userMapper;
	private Logger logger = LoggerFactory.getLogger(TestGenerator.class);
	
	@Before
	public void setUpBefore() throws IOException{
		InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	
	//openSession
	@Test
	public void testDeleteByPrimaryKey(){
		userMapper.deleteByPrimaryKey(8);
	}
	
	

}

package demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import demo.entity.User;

public class UserDaoImpl implements UserDao{
	private SqlSession sqlSession;
	

	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public User queryUserById(int id) {
        return sqlSession.selectOne("UserDao.queryUserById", id);
    }

	public List<User> queryUserAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

}

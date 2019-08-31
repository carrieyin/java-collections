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

	public User queryOneUser(int id){
		return sqlSession.selectOne("UserDao.queryUserById", id);
	}
	public List<User> queryUserAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("UserDao.queryUserAll");
	}

	public void insertUser(User user) {
		sqlSession.insert("UserDao.insertUser", user);
		
	}

	public void updateUser(User user) {
		sqlSession.update("UserDao.updateUser", user);
	}

	public void deleteUser(String id) {
		sqlSession.delete("UserDao.deleteUser", id);
		
	}

}

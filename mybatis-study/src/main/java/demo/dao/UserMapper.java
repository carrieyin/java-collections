package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.entity.User;

public interface UserMapper {
	//?ʹ��ע�⴫�������ֱ�Ӵ������������ ����������ʱ��Ҫʹ��ע�⴫��������򱨴�
	//tablenameΪʲô����ʹ��ע�⣿��  ${}������ֵ
	public User login(@Param("userName") String userName, @Param("password") String pwd);
	
	public List<User> queryUserByTable(@Param("tableName") String tableName);
	
	public User queryUserByID(String ID);
	
	public List<User> queryUserAll();
	
	public void insertUser(User user);
	
	public void deleteUserById(int id);
	
	public void updateUser(User user);
	
}

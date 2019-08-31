package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.entity.User;

public interface UserMapper {
	//?使用注解传入参数和直接传入参数的区别？ 传入多个参数时需要使用注解传入参数否则报错
	//tablename为什么必须使用注解？？  ${}里面存的值
	public User login(@Param("userName") String userName, @Param("password") String pwd);
	
	public List<User> queryUserByTable(@Param("tableName") String tableName);
	
	public User queryUserByID(String ID);
	
	public List<User> queryUserAll();
	
	public void insertUser(User user);
	
	public void deleteUserById(int id);
	
	public void updateUser(User user);
	
}

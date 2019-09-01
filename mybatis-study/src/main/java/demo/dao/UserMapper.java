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
	
	//��ѯ�������ԣ�����������ģ��ƥ��
	public List<User> queryUserListByName(@Param("name") String name);
	
	//����name����age��ѯ
	public List<User> queryUserByNameOrAge(@Param("name")String name, @Param("age")int age);
	
	//����name��age��ѯ
	public List<User> queryUserByNameAndAge(@Param("name")String name, @Param("age") int age);
	
	//���ݴ���id�����ѯ
	public List<User> queryUserInArrays(@Param("ids")String[] ids);
}

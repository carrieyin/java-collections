package demo.dao;

import java.util.List;

import demo.entity.User;

public interface UserMapper {
	public User queryUserById(int i);
	public User queryOneUser(int i);
	public List<User> queryUserAll();

    public void insertUser(User user);
    public void updateUser(User user);

    public void deleteUser(String id);

}

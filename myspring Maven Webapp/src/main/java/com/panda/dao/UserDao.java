package com.panda.dao;

import java.util.List;
import java.util.Map;

import com.panda.entity.BootPage;
import com.panda.entity.User;

public interface UserDao {
	public void saveUser(User user);

	public List<User> queryAllUser(Map<String, String> map);

	public User queryUserById(String id);

	public void delUser(User user);

	public int queryAllUserCount(Map<String, String> map);

	public void updateUser(User user);

	public BootPage<User> getByPage(BootPage<User> pager,
			Map<String, String> map);

	public Long getUserCount(Map<String, String> map);

	public User getUserByParam(String name, String password);
}

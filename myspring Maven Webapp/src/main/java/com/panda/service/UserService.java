package com.panda.service;

import java.util.List;
import java.util.Map;

import com.panda.entity.BootPage;
import com.panda.entity.User;

public interface UserService {
	public void saveUser(User user);

	public List<User> queryAllUser(Map<String, String> map);

	public User queryUserById(String id);

	public void delUser(String id);

	public void updateUser(User user);
	
	public BootPage<User> getByPage(BootPage<User> pager,Map<String, String> map);
	
	public Long getUserCount(Map<String, String> map);
	
	public Map<String, Object> login(User user);
}

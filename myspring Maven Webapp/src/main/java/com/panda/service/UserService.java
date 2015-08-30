package com.panda.service;

import java.util.Map;

import net.sf.json.JSONObject;

import com.panda.entity.User;

public interface UserService {
	public void saveUser(User user);

	public JSONObject queryAllUser(Map<String, String> map);

	public User queryUserById(String id);

	public void delUser(String id);

	public void updateUser(User user);
}

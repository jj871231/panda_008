package com.panda.service.impl;

import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.dao.UserDao;
import com.panda.entity.User;
import com.panda.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	@Override
	public JSONObject queryAllUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delUser(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}

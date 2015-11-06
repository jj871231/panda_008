package com.panda.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.panda.common.BaseDao;
import com.panda.dao.UserDao;
import com.panda.entity.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		/*
		 * Session ss = getSession();
		 * Transaction t = ss.beginTransaction();
		 * ss.save(user);
		 * t.commit();
		 */
		
		getSession().save(user);
		//getSession().flush();
		//String sql = "insert into t_user values('123','张三')";
		//jdbcTemplate.execute(sql);
	}

	@Override
	public List<User> queryAllUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public int queryAllUserCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

    /**
     * 重载方法
     * @param user
     * @return
     */
    @Override
    public User getUserByParam(String name,String password)
    {
        // TODO Auto-generated method stub
        String hql = " from User where name=? and password=?";
        Query query = getSession().createQuery(hql);
        query.setString(0, name);
        query.setString(1, password);
        return (User)query.uniqueResult();
    }

}

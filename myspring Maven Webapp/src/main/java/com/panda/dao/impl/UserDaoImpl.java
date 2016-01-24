package com.panda.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.panda.common.BaseDao;
import com.panda.dao.UserDao;
import com.panda.entity.BootPage;
import com.panda.entity.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
		getSession().save(user);
<<<<<<< HEAD
		//getSession().flush();
		//String sql = "insert into t_user values('123','张三')";
		//jdbcTemplate.execute(sql);
=======
		
>>>>>>> origin/master
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAllUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		String hql = " from User where 1=1";
		Query query = getSession().createQuery(hql);
		//query.setCacheable(true);
		List<User> list = query.list();
		
		/*System.out.println(getSession().getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		System.out.println(getSession().getSessionFactory().getStatistics().getSecondLevelCacheMissCount());
		System.out.println(getSession().getSessionFactory().getStatistics().getSecondLevelCachePutCount());
		*/
		
		return list;
	}

	@Override
	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		/*String hql = " from User where id=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, id);
		query.setCacheable(true);*/
		
        
        return getSession().get(User.class, id);
		//return (User) query.uniqueResult();
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

<<<<<<< HEAD
	@SuppressWarnings("unchecked")
	@Override
	public BootPage<User> getByPage(BootPage<User> pager,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		if (pager == null) {
            throw new IllegalArgumentException("分页 不能为空!");
        }
		String hql = " from User where 1=1";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(pager.getOffset());
		query.setMaxResults(pager.getLimit());
		List<User> list = query.list();
		pager.setRows(list);
		//pager.setTotal(this.countAll(hql, condition));
	    return pager;
	}

	@Override
	public Long getUserCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		String hql = " select count(*) from User where 1=1";
		Query query = getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}
=======
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
>>>>>>> origin/master

}

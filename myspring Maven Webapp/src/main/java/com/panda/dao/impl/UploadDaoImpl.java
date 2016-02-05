/*
 * 文 件 名:  UploadDaoImpl.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Feb 5, 2016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.panda.common.BaseDao;
import com.panda.dao.UploadDao;
import com.panda.entity.Upload;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liangjj
 * @version  [版本号, Feb 5, 2016]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Repository
public class UploadDaoImpl extends BaseDao implements UploadDao
{
    
    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void delUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        getSession().delete(upload);
    }
    
    /**
     * 重载方法
     * @param map
     * @return
     */
    @Override
    public List<Upload> queryAllUpload(Map<String, String> map)
    {
        // TODO Auto-generated method stub
        String hql = " from Upload t where 1=1";
        String path = map.get("path");
        if (null != path && !"".equals(path))
        {
            hql+=" and path = '"+path+"'";
        }
        hql += " and isdel = '0'";
        Query query = getSession().createQuery(hql);
        //query.setCacheable(true);
        List<Upload> list = query.list();
        return list;
    }
    
    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void saveUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        getSession().save(upload);
    }

    /**
     * 重载方法
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Upload getUploadByPath(String path)
    {
        // TODO Auto-generated method stub
        String hql = " from Upload t where t.path=?";
        Query query =getSession().createQuery(hql);
        query.setString(0, path);
        List<Upload> list = query.list();
        if (null != list && list.size()!=0)
        {
            return list.get(0);
        }
        return null;
    }

    /**
     * 重载方法
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Upload getUploadByName(String name)
    {
        // TODO Auto-generated method stub
        String hql = " from Upload t where t.name=?";
        Query query =getSession().createQuery(hql);
        query.setString(0, name);
        List<Upload> list = query.list();
        if (null != list && list.size()!=0)
        {
            return list.get(0);
        }
        return null;
    }

    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void updateUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        getSession().update(upload);
    }
    
}

/*
 * 文 件 名:  UploadServiceImpl.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Feb 5, 2016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.dao.UploadDao;
import com.panda.entity.Upload;
import com.panda.service.UploadService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liangjj
 * @version  [版本号, Feb 5, 2016]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UploadServiceImpl implements UploadService
{
    @Autowired
    private UploadDao uploadDao;
    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void delUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        uploadDao.delUpload(upload);
    }
    
    /**
     * 重载方法
     * @param map
     * @return
     */
    @Override
    public JSONArray queryAllUpload(Map<String, String> map)
    {
        // TODO Auto-generated method stub
        List<Upload> list = uploadDao.queryAllUpload(map);
        JSONArray json = JSONArray.fromObject(list);
        return json;
    }
    
    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void saveUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        uploadDao.saveUpload(upload);
    }

    /**
     * 重载方法
     * @param path
     * @return
     */
    @Override
    public Upload getUploadByPath(String path)
    {
        // TODO Auto-generated method stub
        return uploadDao.getUploadByPath(path);
    }

    /**
     * 重载方法
     * @param name
     * @return
     */
    @Override
    public Upload getUploadByName(String name)
    {
        // TODO Auto-generated method stub
        return uploadDao.getUploadByName(name);
    }

    /**
     * 重载方法
     * @param upload
     */
    @Override
    public void updateUpload(Upload upload)
    {
        // TODO Auto-generated method stub
        uploadDao.updateUpload(upload);
    }
    
}

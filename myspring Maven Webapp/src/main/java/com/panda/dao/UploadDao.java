/*
 * 文 件 名:  UploadDao.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Feb 5, 2016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.dao;

import java.util.List;
import java.util.Map;

import com.panda.entity.Upload;
import com.panda.entity.User;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liangjj
 * @version  [版本号, Feb 5, 2016]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UploadDao
{
    public List<Upload> queryAllUpload(Map<String, String> map);
    
    public void saveUpload(Upload upload);
    
    public void delUpload(Upload upload);
    
    public void updateUpload(Upload upload);

    
    public Upload getUploadByPath(String path);
    
    public Upload getUploadByName(String name);
}

/*
 * 文 件 名:  Utils.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Feb 5, 2016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liangjj
 * @version  [版本号, Feb 5, 2016]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Utils
{
    
    public static String getServicePath() {

        File directory = new File("");
        String projectpath = directory.getAbsolutePath();
        if (projectpath.endsWith("bin")) {
            projectpath = projectpath.substring(0, projectpath.length() - 4);
        }
        return projectpath + "/webapps";
    }
    
    public static void createDir(String name,String path)
    {
        String dicpath = getServicePath() + "/upload/" + path;
        File dicimg = new File(dicpath+"/"+name);
        if (!dicimg.exists()) {
            dicimg.mkdirs();
        }
    }
    
    public static void destory(File path)
    {
        if (!path.exists())  
            return;  
        if (path.isFile()) {  
            path.delete();  
            return;  
        }  
        File[] files = path.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            destory(files[i]);  
        }  
        path.delete();  
    }
    
    /**
     * 上传数据
     * 
     * @param attach
     * @return
     */
    public static String uploadFile(MultipartFile attach, String path) {

        String url = "";
        if (attach.getOriginalFilename() != null
                && !"".equals(attach.getOriginalFilename())) {
            // 获取文件后缀名
            String name = attach.getOriginalFilename();
            //String type = name.substring(name.lastIndexOf(".") + 1);
            String dicpath = getServicePath() + "/upload/" + path;
            File dicimg = new File(dicpath);
            if (!dicimg.exists()) {
                dicimg.mkdirs();
            }
            url =  name;
                    

            FileOutputStream write = null;
            InputStream in = null;
            try {
                in = attach.getInputStream();
                System.out.println(url);
                write = new FileOutputStream(new File(dicpath + "/" + name));
                byte[] bt = new byte[1024 * 1024];
                int z = in.available();
                int d = 1024 * 1024;
                if (z < 1024 * 1024) {
                    d = z;
                }
                while ((d = in.read(bt, 0, d)) != -1) {
                    write.write(bt, 0, d);
                    if (z / d == 0) {
                        d = z % d;
                    }
                }
                write.flush();
            } catch (Exception e) {
            } finally {
                if (null != write) {
                    try {
                        write.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return url;
    }
    
}

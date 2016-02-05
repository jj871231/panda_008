/*
 * 文 件 名:  UploadController.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Feb 5, 2016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.panda.common.Utils;
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
@Controller
@RequestMapping("/uploadController")
public class UploadController
{
    @Autowired
    private UploadService uploadService;
    
    @RequestMapping(value = "/toEditor")
    public ModelAndView toEditor()
    {
        
        return new ModelAndView("editor/editor");
    }
    
    @RequestMapping(value = "/imageRead")
    @ResponseBody
    public JSONArray imageRead(HttpServletRequest request,String path)
    {
        Map<String, String> map = new HashMap<String, String>();
//        if (null == path || "".equals(path))
//        {
//            path = "/";
//        }
        map.put("path", "/"+path);
        JSONArray json = uploadService.queryAllUpload(map);
        return json;
    }
    
    @RequestMapping(value = "/imageUpload")
    @ResponseBody
    public JSONObject imageUpload(HttpServletRequest request,@RequestParam("file") MultipartFile file,String path)
    {
        Upload upload = new Upload();
        if (!file.isEmpty())
        {
            String name = Utils.uploadFile(file, path);
            Upload upload2 = uploadService.getUploadByName(name);
            if (null != upload2)
            {
                uploadService.delUpload(upload2);
            }
            
            upload.setName(name);
            upload.setSize(String.valueOf(file.getSize()));
            upload.setType("f");
            upload.setPath("/"+ path);
            upload.setIsdel("0");
            uploadService.saveUpload(upload);
            
        }
        JSONObject json = JSONObject.fromObject(upload);   
            
        return json;
    }
    
    @RequestMapping(value = "/createDir")
    @ResponseBody
    public JSONObject createDir(HttpServletRequest request,String name,String path)
    {
        Upload upload = new Upload();
        Utils.createDir(name, path);
        
        upload.setName(name);
        upload.setSize("0");
        upload.setType("d");
        upload.setPath("/"+ path);
        upload.setIsdel("0");
        uploadService.saveUpload(upload);
            
        JSONObject json = JSONObject.fromObject(upload);
            
        return json;
    }
    
    @RequestMapping(value = "/destroy")
    public void destroy(HttpServletRequest request,HttpServletResponse response,String name,String path,String type)
    {
        //Upload upload = uploadService.getUploadByPath(path);
        String url = Utils.getServicePath()+ "/upload/" + path;
        File file=new File(url+name);
        Utils.destory(file);
        if (type.equals("f"))
        {
            Upload upload = uploadService.getUploadByPath("/"+path);
            uploadService.delUpload(upload);
        }else {
            Upload upload = uploadService.getUploadByPath("/"+path);
            upload.setIsdel("1");
            uploadService.updateUpload(upload);
        }
        
    }
    
    @RequestMapping(value = "/imageThumbnail")
    public void imageThumbnail(HttpServletRequest request,HttpServletResponse response,String path)
    {
        //Upload upload = uploadService.getUploadByPath(path);
        String url = Utils.getServicePath()+ "/upload/" + path;
        File srcFile=new File(url);
        
        try
        {
            BufferedImage bi=Thumbnails.of(srcFile).size(80,80).asBufferedImage();
            ImageIO.write(bi,"jpg",response.getOutputStream());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @RequestMapping(value = "/getImage")
    public void getImage(HttpServletRequest request,HttpServletResponse response,String path)
    {
        //Upload upload = uploadService.getUploadByPath(path);
        String url = Utils.getServicePath()+ "/upload/" + path;
        File srcFile=new File(url);
        
        try
        {
            BufferedImage bi=Thumbnails.of(srcFile).scale(1f).asBufferedImage();  
            ImageIO.write(bi,"jpg",response.getOutputStream());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    
}

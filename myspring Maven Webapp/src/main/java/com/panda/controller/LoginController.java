/*
 * 文 件 名:  LoginController.java
 * 版    权:  Trueway Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  liangjj
 * 修改时间:  Nov 6, 2015
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.panda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.panda.entity.User;
import com.panda.service.UserService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liangjj
 * @version  [版本号, Nov 6, 2015]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/loginController")
public class LoginController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/toIndex")
    public ModelAndView toIndex()
    {
        Map<String, String> map = new HashMap<String, String>();
        
        return new ModelAndView("index", map);
    }
    
    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login(User user,HttpServletRequest request)
    {
        //user.setName("张三");
        Map<String, Object> resMap = userService.login(user);
        String error = (String)resMap.get("error");
        JSONObject json = new JSONObject();
        if ("".equals(error))
        {
            request.getSession().setAttribute("USER_SESSION", 
                resMap.get("loginUser"));
            
            json.put("success", "true");
        }else {
            json.put("success", "false");
        }
        
        return json;
        
        
    }
}

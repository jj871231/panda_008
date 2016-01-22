package com.panda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.panda.entity.User;
import com.panda.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
    private UserService userService;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
              binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
       }
    
    @RequestMapping(value = "/toUserList")
    public ModelAndView toUserList()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> userList = userService.queryAllUser(new HashMap<String, String>());
        map.put("userList", userList);
        
        
        //User user = userService.queryUserById("123");
        
        //map.put("user", user);
        return new ModelAndView("user/userList", map);
    }
    
    @RequestMapping(value = "/saveUser",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject saveUser(User user,HttpServletResponse response)
    {
    	//user.setName("张三");
        userService.saveUser(user);
        JSONObject json = new JSONObject();
        json.put("success", "true");
        return json;
        
        
    }
}

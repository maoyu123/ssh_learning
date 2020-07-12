package com.taylor.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.taylor.entity.User;
import com.taylor.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author maoyu
 * @date 2020/7/12 15:45
 */
@Controller("userAction")
@Scope("prototype")
    public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;

    private User user;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }


    public String login(){
        if(userService.login(user)){
            Map session = ActionContext.getContext().getSession();
            session.put("user",user);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }


    public String add(User user) throws Exception {
        user.setUsername("taylor");
        user.setPassword("123456");
        if(userService.addUser(user)){
            Map session = ActionContext.getContext().getSession();
            session.put("user",user);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
}

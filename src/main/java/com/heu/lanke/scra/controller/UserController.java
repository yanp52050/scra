package com.heu.lanke.scra.controller;

import com.heu.lanke.scra.base.Response;
import com.heu.lanke.scra.base.controller.BasicController;
import com.heu.lanke.scra.base.pojo.entity.User;
import com.heu.lanke.scra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BasicController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public Response userLogin(@RequestBody User user){
        if (userService.userLogin(user)){
            return success("登录成功");
        }
        return fail("用户名密码不正确",null);
    }

    @GetMapping("/test")
    public  Response test(){
        return success("ssj");
    }
}

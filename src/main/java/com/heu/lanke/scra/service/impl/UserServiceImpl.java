package com.heu.lanke.scra.service.impl;

import com.heu.lanke.scra.base.pojo.entity.User;
import com.heu.lanke.scra.base.pojo.entity.UserExample;
import com.heu.lanke.scra.dao.UserMapper;
import com.heu.lanke.scra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean userLogin(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
        List<User> userList =  userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0){
            return true;
        }
        return false;
    }
}

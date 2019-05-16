package com.example.ys.Service;

import com.example.ys.Mapper.UserMapper;
import com.example.ys.Model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<user> getUser() {
        List<user> log = userMapper.getUser();
        return log;
    }
}

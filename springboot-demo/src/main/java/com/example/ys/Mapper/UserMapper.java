package com.example.ys.Mapper;


import com.example.ys.Model.user;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<user> getUser();
}

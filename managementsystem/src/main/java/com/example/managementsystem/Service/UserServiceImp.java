package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.User;
import com.example.managementsystem.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.getById(id);
    }

    @Override
    public void deletUser(String id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getByDeepManager(String department, String mposition) {
        return userMapper.getByDeepManager(department, mposition);
    }

    @Override
    public List<User> getByDeepList(String department, String mposition) {
        return userMapper.getByDeepList(department, mposition);
    }

    @Override
    public List<User> getByDesignList(String department, String mgroup, String mposition) {
        return  userMapper.getByDesignList(department,mgroup,mposition);
    }

}

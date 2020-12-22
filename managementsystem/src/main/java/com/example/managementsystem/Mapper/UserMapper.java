package com.example.managementsystem.Mapper;

import com.example.managementsystem.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    public User getById(String id);
    public void insert(User use);
    public void updateUser(User use);
    public void deleteUser(String id);
    public User getByDeepManager(String department,String mposition);
    public List<User> getByDeepList(String department, String mposition);
    public List<User> getByDesignList(@Param("department")String department, @Param("mgroup")String mgroup, @Param("mposition")String mposition);
}

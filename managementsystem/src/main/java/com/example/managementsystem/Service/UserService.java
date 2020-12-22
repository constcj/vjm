package com.example.managementsystem.Service;

import com.example.managementsystem.Entity.User;

import java.util.List;

public interface UserService {
  User getUser(String id);
  void deletUser(String id);
  void updateUser(User user);
  void insertUser(User user);
  User getByDeepManager(String department,String mposition);
  List<User> getByDeepList(String department, String mposition);
  List<User> getByDesignList(String department, String mgroup, String mposition);
}

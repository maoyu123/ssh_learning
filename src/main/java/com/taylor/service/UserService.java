package com.taylor.service;

import com.taylor.entity.User;

import java.util.List;

/**
 * @author maoyu
 * @date 2020/7/12 15:36
 */
public interface UserService {

    public boolean addUser(User user);

    public boolean login(User user);

    public List getAllUser();

    public User getUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);

}


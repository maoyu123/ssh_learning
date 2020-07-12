package com.taylor.service.impl;

import com.taylor.dao.UserDao;
import com.taylor.entity.User;
import com.taylor.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author maoyu
 * @date 2020/7/12 15:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        userDao.add(user);
        return true;
    }

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public List getAllUser() {
        return userDao.getUser();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUser(id);
    }

    @Override
    public boolean updateUser(User user) {

        userDao.update(user);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        userDao.delete(id);
        return true;
    }
}

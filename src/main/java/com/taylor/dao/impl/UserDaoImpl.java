package com.taylor.dao.impl;

import com.taylor.dao.UserDao;
import com.taylor.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @author maoyu
 * @date 2020/7/12 11:55
 */
@Transactional(rollbackFor = Exception.class)
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean login(User user) {
        Iterator<User> iterator;
        String hql = "From User u where u.username = ? and u.password = ?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,user.getUsername());
        query.setString(1,user.getPassword());
        System.out.println(user.getUsername()+"##########"+user.getPassword());
        iterator=query.iterate();
        if(iterator.hasNext()){
            System.out.println("获取到用户名和密码返回true");
            return true;
        }else {
            System.out.println("未获取到用户名和密码返回false");
            return false;
        }
    }

    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public User getUser(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class,id)
        );
    }
}

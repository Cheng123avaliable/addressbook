package com.example.addressbook.service.impl;

import com.example.addressbook.dao.UserDao;
import com.example.addressbook.domain.User;
import com.example.addressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: addressbook
 * @description:
 * @author: CZQYY
 * @create: 2020-05-05 21:23
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public List<User> selectAllByNid(Integer nid) {
        List<User> userList = userDao.selectAllByNid(nid);
        return userList;
    }

    @Override
    public List<User> selectByFuzzy(String name) {
        List<User> users = userDao.selectByFuzzy("%" + name + "%");
        return users;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOne(User user) {
        int i = userDao.updateByPrimaryKey(user);
        if (i >= 0) {
            return true;

        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOne(User user, Integer nid) {
//        首先查询 在 user_notes 表中 与 uid 相关的数据有几条
        Integer count = userDao.selectCountsByUid(user.getId());
//       如果存在一条以上则只删除关系 不删除数据
        if (count > 1) {
            userDao.deleteUserByNidAndUid(nid, user.getId());
            return true;
        } else {
//            如果只存在一条 则 删除关系 且 删除数据
            int delete = userDao.delete(user);
            if (delete >= 0) {
                userDao.deleteUserByNidAndUid(nid, user.getId());
                return true;
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertOne(User user, Integer nid) {
        int insert = userDao.insert(user);
//        回显 uid
        if (insert >= 0) {
//            两表关联关系
            userDao.insertByUidAndNid(user.getId(), nid);
            return true;
        }
        return false;
    }

    @Override
    public List<User> selectAll() {
        List<User> userList = userDao.selectAll();

        return userList;
    }

    @Override
    public User selectOne(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}

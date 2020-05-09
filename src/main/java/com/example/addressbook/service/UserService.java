package com.example.addressbook.service;

import com.example.addressbook.domain.Note;
import com.example.addressbook.domain.User;

import java.util.List;

/**
 * @program: addressbook
 * @description: User逻辑层
 * @author: CZQYY
 * @create: 2020-05-05 21:23
 **/
public interface UserService {

    List<User> findAll();

    /**
     * 通过nid 找 List<User></>
     * @param nid
     * @return
     */
    List<User> selectAllByNid(Integer nid);

    /**
     * 模糊查询 用于搜索
     * @param name
     * @return
     */
    List<User> selectByFuzzy(String name);

    boolean updateOne(User user);

    boolean deleteOne(User user,Integer nid);

    boolean insertOne(User user,Integer nid);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    User selectOne(Integer id);
}

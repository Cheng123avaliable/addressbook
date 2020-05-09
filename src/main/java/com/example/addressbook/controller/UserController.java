package com.example.addressbook.controller;

import com.example.addressbook.domain.Note;
import com.example.addressbook.domain.User;
import com.example.addressbook.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: addressbook
 * @description:
 * @author: CZQYY
 * @create: 2020-05-07 20:23
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> selectAll(){
        List<User> userList = userService.selectAll();
        return userList;
    }

    @GetMapping("/list/{nid}")
    public List<User> selectAllByNid(@PathVariable Integer nid){
      List<User> userList = userService.selectAllByNid(nid);
      return userList;
    }

    @GetMapping("fuzzy")
    public List<User>  selectByFuzzy(String name){
        List<User> users = userService.selectByFuzzy(name);
        return users;
    }

    @GetMapping("one")
    public User selectOne(Integer id){
     User  user =    userService.selectOne(id);
     return user;
    }
    @PostMapping("update")
    public boolean updateOne(User user){
        System.out.println(user);
        boolean b = userService.updateOne(user);
        return b;

    }

    @PostMapping("delete")
    public boolean deleteOne(User user,@RequestParam("nid")Integer nid){
        boolean b = userService.deleteOne(user,nid);
        return true;

    }

    @PostMapping("insert")
    public boolean insertOne( User user,@RequestParam("nid") Integer nid){
            boolean b = userService.insertOne(user,nid);
        return true;

    }
}

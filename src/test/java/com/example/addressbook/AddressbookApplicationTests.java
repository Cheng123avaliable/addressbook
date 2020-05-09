package com.example.addressbook;


import com.example.addressbook.dao.UserDao;
import com.example.addressbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.addressbook.dao")
@SpringBootTest
class AddressbookApplicationTests {

    @Autowired
    private UserService service;
    @Autowired
    private UserDao dao;
    @Test
    void contextLoads() {
        dao.insertByUidAndNid(1,3);
    }

}

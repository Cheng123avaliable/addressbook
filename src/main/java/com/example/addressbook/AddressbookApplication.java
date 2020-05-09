package com.example.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author CZQYY
 */
@MapperScan("com.example.addressbook.dao")
@SpringBootApplication
public class AddressbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressbookApplication.class, args);
    }

}

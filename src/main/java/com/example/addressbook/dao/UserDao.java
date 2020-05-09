package com.example.addressbook.dao;

import com.example.addressbook.domain.Note;
import com.example.addressbook.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: addressbook
 * @description: User持久层
 * @author: CZQYY
 * @create: 2020-05-05 21:16
 **/
@Repository
public interface UserDao  extends Mapper<User> {

    @Select("select * from users")
    List<User> findAll();


    /**
     * 通过nid 查询 nid
     * @param nid
     * @return
     */
    @Select("SELECT users.`id`,users.`name`,users.`mobilephone`,users.`email`,users.`telephone`,users.`remarks`\n" +
            "FROM users\n" +
            "WHERE id IN (\n" +
            "SELECT uid \n" +
            "FROM note_users\n" +
            "WHERE nid = #{nid})")
    List<User> selectAllByNid(@Param("nid") Integer nid);

    /**
     * 模糊查询 用于搜索
     * @param name
     * @return
     */
    @Select("select * from users where name like #{name} ")
    List<User> selectByFuzzy(@Param("name") String name);

    /**
     * 插入两表关系
     * @param id
     * @param nid
     */
    @Insert("insert into note_users values(#{nid},#{id})")
    void insertByUidAndNid(@Param("id") Integer id, @Param("nid") Integer nid);


    /**
     * 删除两表之间关系
     * @param nid
     * @param uid
     */
    @Delete("delete from note_users where nid = #{nid} and uid = #{uid}")
    void deleteUserByNidAndUid(@Param("nid") Integer nid,@Param("uid") Integer uid);

    /**
     * 通过 uid 查询 两表关系 个数
     * @param id
     * @return
     */
    @Select("SELECT COUNT(uid) FROM note_users WHERE uid = #{id}")
    Integer selectCountsByUid(@Param("id") Integer id);
}

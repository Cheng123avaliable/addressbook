package com.example.addressbook.dao;

import com.example.addressbook.domain.Note;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: addressbook
 * @description: Note持久层
 * @author: CZQYY
 * @create: 2020-05-05 21:16
 **/
@Repository
public interface NoteDao extends Mapper<Note> {
    /**
     * 模糊查询 用于搜索
      * @param name
     * @return  List<Note>
     */
    @Select("select * from note where name like #{name} ")
      List<Note> selectByFuzzy(@Param("name") String name);

    /**
     * 删除 电话簿 和 用户之间的关系
     * @param id
     */
    @Delete("delete from note_users where nid = #{id}")
    void deleteById(@Param("id") Integer id);
}

package com.example.addressbook.service;

import com.example.addressbook.domain.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: addressbook
 * @description: Note逻辑层
 * @author: CZQYY
 * @create: 2020-05-05 21:23
 **/
public interface NoteService {

    /**
     * 查询所有电话簿
     * @return
     */
    List<Note> selectAll();

    /**
     * 插入一个
     * @param note
     * @return
     */
    boolean insertOne(Note note);

    boolean updateOne(Note note);

    boolean deleteOne(Note note);

    /**
     * 模糊查询 用于搜索
     * @param name
     * @return
     */
    List<Note> selectByFuzzy (String name);
}

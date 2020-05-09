package com.example.addressbook.service.impl;

import com.example.addressbook.dao.NoteDao;
import com.example.addressbook.domain.Note;
import com.example.addressbook.service.NoteService;
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
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;


    @Override
    public List<Note> selectAll() {
        List<Note> notes = noteDao.selectAll();
        return notes;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertOne(Note note) {
        int count = noteDao.insert(note);
        if (count >= 0) {
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOne(Note note) {
        int i = noteDao.updateByPrimaryKey(note);
        if (i >= 0) {
            return true;
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOne(Note note) {
        int delete = noteDao.delete(note);
        if (delete >= 0) {
//            并且删除 用户 与 电话簿 之间关系
            noteDao.deleteById(note.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Note> selectByFuzzy(String name) {
        List<Note> notes = noteDao.selectByFuzzy("%" + name + "%");
        return notes;
    }
}

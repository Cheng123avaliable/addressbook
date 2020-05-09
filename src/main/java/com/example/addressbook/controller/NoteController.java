package com.example.addressbook.controller;

import com.example.addressbook.domain.Note;
import com.example.addressbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: addressbook
 * @description: Note Controller层
 * @author: CZQYY
 * @create: 2020-05-05 21:34
 **/
@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping("all")
    public List<Note>  selectAll(){
        List<Note> notes = service.selectAll();
        return notes;
    }

    @PostMapping("insert")
    public boolean insertOne(Note note){
        boolean b = service.insertOne(note);
        return b;

    }

    @PostMapping("update")
    public boolean updateOne(Note note){
        boolean b = service.updateOne(note);
        return b;

    }

    @PostMapping("delete")
    public boolean deleteOne(Note note){
        boolean b = service.deleteOne(note);
        return b;

    }
    @GetMapping("fuzzy")
    public List<Note>  selectByFuzzy(String name){
        List<Note> notes = service.selectByFuzzy(name);
        return notes;
    }


}

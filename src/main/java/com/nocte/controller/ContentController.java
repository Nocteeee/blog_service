package com.nocte.controller;

import com.nocte.mapper.ContentMapper;
import com.nocte.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentMapper contentMapper;

    @GetMapping("getAll")
    public List<Content> queryAllContext(){
        return contentMapper.queryAllContext();
    }

    @GetMapping("getById")
    public Content queryContentById(int id){
        return contentMapper.queryContentById(id);
    }

    @PostMapping("update")
    public int updateContent(Content content){
        return contentMapper.updateContent(content);
    }

    @PostMapping("add")
    public int addContent(Content content){
        return contentMapper.addContent(content);
    }

    @PostMapping("delete")
    public int deleteContent(int id){
        return contentMapper.deleteContent(id);
    }
}

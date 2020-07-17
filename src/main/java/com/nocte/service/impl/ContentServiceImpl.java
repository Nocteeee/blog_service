package com.nocte.service.impl;

import com.nocte.mapper.ContentMapper;
import com.nocte.pojo.Content;
import com.nocte.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Content> queryAllContext() {
        return contentMapper.queryAllContext();
    }

    @Override
    public Content queryContentById(int id) {
        return contentMapper.queryContentById(id);
    }

    @Override
    public int updateContent(Content content) {
        return contentMapper.updateContent(content);
    }

    @Override
    public int addContent(Content content) {
        return contentMapper.addContent(content);
    }

    @Override
    public int deleteContent(int id) {
        return contentMapper.deleteContent(id);
    }
}

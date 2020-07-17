package com.nocte.service;

import com.nocte.pojo.Content;

import java.util.List;

public interface ContentService {

    //获取文章
    List<Content> queryAllContext();

    //根据id 获取文章
    Content queryContentById(int id);

    //更新
    int updateContent(Content content);

    //添加
    int addContent(Content content);

    //删除
    int deleteContent(int id);
}

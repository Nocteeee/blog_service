package com.nocte.service;

import com.nocte.pojo.Article;

import java.util.List;

public interface ArticleService {
    // 获取所有文章
    List<Article> queryAllArticle();

    // 根据id 获取对应文章
    Article queryArticleById(int id);

    // 添加文章
    int addArticle(Article article,String content);

    // 更新文章
    int updateArticle(Article article,String content);

    //删除文章
    int deleteArticle(int id);
}

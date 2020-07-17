package com.nocte.service.impl;

import com.nocte.mapper.ArticleMapper;
import com.nocte.mapper.ContentMapper;
import com.nocte.pojo.Article;
import com.nocte.pojo.Content;
import com.nocte.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Article> queryAllArticle() {
        return articleMapper.queryAllArticle();
    }

    @Override
    public Article queryArticleById(int id) {
        return articleMapper.queryArticleById(id);
    }

    @Override
    @Transactional
    public int addArticle(Article article, String content) {
        articleMapper.addArticle(article);
        Content _content = new Content();
        _content.setArticle_id(article.getId());
        _content.setContent(content);
        return contentMapper.addContent(_content);
    }

    @Override
    public int updateArticle(Article article,String content) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        article.setModified_time(time);
        articleMapper.updateArticle(article);
        Content _content = new Content();
        _content.setArticle_id(article.getId());
        _content.setContent(content);
        return contentMapper.updateContent(_content);
    }

    @Override
    public int deleteArticle(int id) {
        contentMapper.deleteContent(id);
        return articleMapper.deleteArticle(id);
    }
}

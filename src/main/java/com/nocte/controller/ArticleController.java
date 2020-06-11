package com.nocte.controller;

import com.nocte.mapper.ArticleMapper;
import com.nocte.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("getAll")
    List<Article> queryAllArticle(){
        return articleMapper.queryAllArticle();
    }

    @GetMapping("getById")
    Article queryArticleById(int id){
        return articleMapper.queryArticleById(id);
    }

    @PostMapping("add")
    int addArticle(Article article){
        return articleMapper.addArticle(article);
    }

    @PostMapping("update")
    int updateArticle(Article article){
        return articleMapper.updateArticle(article);
    }

    @PostMapping("delete")
    int deleteArticle(int id){
        return articleMapper.deleteArticle(id);
    }

}

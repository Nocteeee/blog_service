package com.nocte.controller;

import com.nocte.annotation.UserLoginToken;
import com.nocte.pojo.Article;
import com.nocte.service.impl.ArticleServiceImpl;
import com.nocte.service.impl.ContentServiceImpl;
import com.nocte.utils.RestResponse;
import com.nocte.utils.RestResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("article")
@UserLoginToken
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private ContentServiceImpl contentService;

    @GetMapping("getList")
    RestResponse<Object> queryAllArticle(){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(articleService.queryAllArticle());
        return response;
    }

    @GetMapping("getById")
    RestResponse<Object> queryArticleById(int id){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(articleService.queryArticleById(id));
        return response;
    }

    @PostMapping("add")
    RestResponse<Object> addArticle(Article article, String content){
        RestResponse<Object> response = null;
        int i = articleService.addArticle(article,content);
        if(i == 1){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"添加失败");
        }
        return response;
    }

    @PostMapping("update")
    RestResponse<Object> updateArticle(Article article , String content){
        RestResponse<Object> response = null;
        int i = articleService.updateArticle(article,content);
        if(i == 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"更新失败");
        }
        return response;
    }

    @PostMapping("delete")
    RestResponse<Object> deleteArticle(Integer id){
        RestResponse<Object> response = null;
        int i = articleService.deleteArticle(id);
        if(i >= 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"删除失败");
        }
        return response;
    }

}

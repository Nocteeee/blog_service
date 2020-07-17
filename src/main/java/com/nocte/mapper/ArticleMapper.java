package com.nocte.mapper;

import com.nocte.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    //获取所有
    List<Article> queryAllArticle();

    //根据id 获取文章
    Article queryArticleById(int id);

    //添加
    int addArticle(Article article);

    //更新
    int updateArticle(Article article);

    //删除
    int deleteArticle(Integer id);
}

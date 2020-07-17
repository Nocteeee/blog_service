package com.nocte.service;

import com.nocte.pojo.Category;

import java.util.List;

public interface CategoryService {
    //获取所有分类
    List<Category> queryAllCategory();

    //id 查询分类
    Category queryCategoryById(int id);

    //添加分类
    int addCategory(Category category);

    //更新分类
    int updateCategory(Category category);

    //删除分类
    int deleteCategory(int id);
}

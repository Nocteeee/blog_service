package com.nocte.controller;

import com.nocte.mapper.CategoryMapper;
import com.nocte.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("get")
    public List<Category> queryAllCategory(){
        return categoryMapper.queryAllCategory();
    }

    @GetMapping("getById")
    public Category queryCategoryById(int id){
        return categoryMapper.queryCategoryById(id);
    }

    @PostMapping("add")
    public int addCategory(Category category){
        return categoryMapper.addCategory(category);
    }

    @PostMapping("update")
    public int updateCategory(Category category){
        return categoryMapper.updateCategory(category);
    }

    @PostMapping("delete")
    public int deleteCategory(int id){
        return categoryMapper.deleteCategory(id);
    }

}

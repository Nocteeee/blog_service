package com.nocte.service.impl;

import com.nocte.mapper.CategoryMapper;
import com.nocte.pojo.Category;
import com.nocte.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }

    @Override
    public Category queryCategoryById(int id) {
        return categoryMapper.queryCategoryById(id);
    }

    @Override
    public int addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategory(int id) {
        return categoryMapper.deleteCategory(id);
    }
}

package com.nocte.mapper;

import com.nocte.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    //获取所有分类
    List<Category> queryAllCategory();

    //根据id 获取分类
    Category queryCategoryById(int id);

    //添加分类
    int addCategory(Category category);

    //更新
    int updateCategory(Category category);

    //删除
    int deleteCategory(int id);
}

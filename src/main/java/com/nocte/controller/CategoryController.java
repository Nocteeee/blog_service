package com.nocte.controller;

import com.nocte.annotation.UserLoginToken;
import com.nocte.pojo.Category;
import com.nocte.service.impl.CategoryServiceImpl;
import com.nocte.utils.RestResponse;
import com.nocte.utils.RestResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("getList")
    @UserLoginToken
    public RestResponse<Object> queryAllCategory(){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(categoryService.queryAllCategory());
        return response;
    }

    @GetMapping("getById")
    @UserLoginToken
    public RestResponse<Object> queryCategoryById(int id){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(categoryService.queryCategoryById(id));
        return response;
    }

    @PostMapping("add")
    @UserLoginToken
    public RestResponse<Object> addCategory(Category category){
        RestResponse<Object> response = null;
        int i = categoryService.addCategory(category);
        if(i == 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"添加失败");
        }
        return response;
    }

    @PostMapping("update")
    @UserLoginToken
    public RestResponse<Object> updateCategory(Category category){
        RestResponse<Object> response = null;
        int i = categoryService.updateCategory(category);
        if(i == 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"更新失败");
        }
        return response;
    }

    @PostMapping("delete")
    @UserLoginToken
    public RestResponse<Object> deleteCategory(int id){
        RestResponse<Object> response = null;
        int i = categoryService.deleteCategory(id);
        if(i == 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"删除失败");
        }
        return response;
    }

}

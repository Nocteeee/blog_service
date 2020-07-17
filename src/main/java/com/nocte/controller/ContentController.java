package com.nocte.controller;

import com.nocte.pojo.Content;
import com.nocte.service.impl.ContentServiceImpl;
import com.nocte.utils.RestResponse;
import com.nocte.utils.RestResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentServiceImpl contentService;

    @GetMapping("getAll")
    public RestResponse<Object> queryAllContext(){
        RestResponse<Object> response = null;
        response = RestResponseUtil.success(contentService.queryAllContext());
        return response;
    }

    @GetMapping("getById")
    public Content queryContentById(int id){
        return contentService.queryContentById(id);
    }

    @PostMapping("update")
    public int updateContent(Content content){
        return contentService.updateContent(content);
    }

    @PostMapping("add")
    public RestResponse<Object> addContent(Content content){
        RestResponse<Object> response = null;
        int i = contentService.addContent(content);
        if(i == 0){
            response = RestResponseUtil.success();
        }else {
            response = RestResponseUtil.error(-1,"添加失败");
        }
        return response;
    }

    @PostMapping("delete")
    public int deleteContent(int id){
        return contentService.deleteContent(id);
    }
}

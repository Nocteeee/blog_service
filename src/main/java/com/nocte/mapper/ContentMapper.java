package com.nocte.mapper;

import com.nocte.pojo.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContentMapper {

    List<Content> queryAllContext();

    Content queryContentById(int id);

    int updateContent(Content content);

    int addContent(Content content);

    int deleteContent(int id);

}

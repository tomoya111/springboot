package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Category_1;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category_1> findAll();


    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category_1 category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category_1 get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category_1 category);
}

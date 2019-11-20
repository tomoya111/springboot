package com.how2java.springboot.dao;

import com.how2java.springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    public List<Category> findByName(String name);
    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name ,int id);
}

package com.how2java.springboot.test;

import com.how2java.springboot.Application;
import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJPA {
    @Autowired
    CategoryDAO dao;
    @Before
    public void before(){
        List<Category> cs=dao.findAll();
        for (Category c:cs) {
            dao.delete(c);
        }
        for (int i=0;i<10;i++){
            Category c=new Category();
            c.setName("Category"+i);
            dao.save(c);
        }
    }
    @Test
    public void test1(){
        List<Category> cs=dao.findAll();
        for (Category c: cs) {
            System.out.println(c.getName());
        }
        System.out.println();
    }
    @Test
    public void test2(){
        List<Category> cs=dao.findByName("Category1");
        for (Category c:cs ){
            System.out.println(c.getName());
        }
        System.out.println();
    }
    @Test
    public void test3(){
        List<Category> cs=dao.findByNameLikeAndIdGreaterThanOrderByNameAsc("%tego%",5);
        for (Category c:cs ){
            System.out.println(c.getName());
        }
        System.out.println();
    }

}

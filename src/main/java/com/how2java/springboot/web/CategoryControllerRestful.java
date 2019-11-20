package com.how2java.springboot.web;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryControllerRestful {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/categories")
    public String listCategory(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start =start > 0? start:0;
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<Category> page=categoryDAO.findAll(pageable);
        m.addAttribute("page",page);
        return "listCategoryRestful";
    }

    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id") int id, Model m) throws Exception {
        Category c= categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategoryRestful";
    }

    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }
}

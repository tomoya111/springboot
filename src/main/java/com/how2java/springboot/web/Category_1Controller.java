package com.how2java.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Category_1Controller {
    @Autowired
    CategoryMapper categoryMapper;
    @RequestMapping("/listCategory_1")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws  Exception{
        PageHelper.startPage(start,size,"id desc");
        List<Category_1> cs=categoryMapper.findAll();
        PageInfo<Category_1> page= new PageInfo<>(cs);
        m.addAttribute ("page",page);
        return "listCategory_1";
    }
    @RequestMapping("/addCategory_1")
    public String listCategory(Category_1 c) throws Exception {
        categoryMapper.save(c);
        return "redirect:listCategory_1";
    }
    @RequestMapping("/deleteCategory_1")
    public String deleteCategory(int id) throws Exception {
        categoryMapper.delete(id);
        return "redirect:listCategory_1";
    }
    @RequestMapping("/updateCategory_1")
    public String updateCategory(Category_1 c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory_1";
    }
    @RequestMapping("/editCategory_1")
    public String listCategory(int id,Model m) throws Exception {
        Category_1 c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory_1";
    }
}

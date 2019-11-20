package com.how2java.springboot.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator;

@Controller
public class CategoryController {
    @Autowired CategoryService categoryService;

    @RequestMapping("/listCategory")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<Category> page =categoryService.list(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        categoryService.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryService.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryService.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String ediitCategory(int id,Model m) throws Exception {
        Category c= categoryService.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
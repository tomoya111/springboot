package com.how2java.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 
    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
    	m.addAttribute("name","themyleaf");
//    	if(true){
//    		throw new Exception("some exception");
//    	}
        return "hello";
    }


    
    
}

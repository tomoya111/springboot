package com.how2java.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadPage")
    public String uploadPage(Model m){
        return "uploadPage";
    }

    @RequestMapping("/upload")
    public String upload(Model m, HttpServletRequest req, @RequestParam("file") MultipartFile file){
        try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            System.out.println(fileName);
            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
            System.out.println(destFileName);
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            m.addAttribute("fileName",fileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "showImg";
    }
}

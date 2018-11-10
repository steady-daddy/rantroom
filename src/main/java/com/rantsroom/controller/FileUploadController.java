package com.rantsroom.controller;

import com.rantsroom.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

//    @RequestMapping("/")
//    public String UploadPage(Model model){
//        return "uploadview";
//    }
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public void upload(){
//        logger.error("FILE: This is upload method");
//    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        if(!file.isEmpty()){
            try{
                logger.info("FILE: I am here");
                User user = (User) session.getAttribute("user");
                logger.info("USER: "+user);
                Path fileNamePath = Paths.get(uploadDirectory, file.getOriginalFilename());
                String filename = file.getOriginalFilename();
                try{
                    Files.write(fileNamePath, file.getBytes());
                }catch(Exception e){
                    logger.error("FILE: Unable to upload file due to: ");
                    e.printStackTrace();
                }
                model.addAttribute("profileUpdated", "Successfully uploaded files "+filename);
                return "redirect:/";
            }catch(Exception e){
                logger.error("FILE: Error occurred!");
                e.printStackTrace();
            }
        }else{
            System.out.println("FILE: File empty");
        }
        return "redirect:/";
//        return "users/profile";
    }
}

package com.fileUpload.fileManagement;

import java.io.File;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SpringFileUploadController {

    // http://localhost:8080/uploader.html
    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        File f = new File("C:\\Users\\hp\\Downloads\\" + fileName);
        try {
            file.transferTo(f);
           System.out.println(f.getAbsolutePath());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully to :"+ f.getAbsolutePath());
    }

}
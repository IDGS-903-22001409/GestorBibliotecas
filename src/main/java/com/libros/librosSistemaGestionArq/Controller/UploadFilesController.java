package com.libros.librosSistemaGestionArq.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.libros.librosSistemaGestionArq.Service.IUploadFilesService;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {
    
    @Autowired
    IUploadFilesService uploadFilesService;

    @PostMapping("/pdflibro")
    private ResponseEntity<String> uploadPdf(MultipartFile file) throws Exception{
        return new ResponseEntity<>(uploadFilesService.handleFileUploadString(file), HttpStatus.OK);
    }

}

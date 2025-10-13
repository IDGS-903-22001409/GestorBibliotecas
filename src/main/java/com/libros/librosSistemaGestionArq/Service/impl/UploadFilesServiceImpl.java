package com.libros.librosSistemaGestionArq.Service.impl;

import org.springframework.web.multipart.MultipartFile;
import com.libros.librosSistemaGestionArq.Service.IUploadFilesService;

public class UploadFilesServiceImpl implements IUploadFilesService{
    
    @Override
    public String handleFileUploadString (MultipartFile file) throws Exception {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = "C:/Users/sergi/Downloads/";
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            return "Archivo guardado exitosamente";
        } catch (Exception e) {
            throw new Exception("Error al guardar el archivo", e);
        }
    }
}

package com.desig_pattern.composite.controller;

import com.desig_pattern.composite.model.*;
import com.desig_pattern.composite.services.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/filesystem")
public class FileSystemController {

    @Autowired
    private FileSystemService fileSystemService;

    @GetMapping("/demo")
    public Map<String, Object> demo() {
        Map<String, Object> response = new HashMap<>();

        try {
            // Crear estructura de archivos
            File file1 = new File("document.txt", 10);
            File file2 = new File("image.jpg", 500);
            File file3 = new File("code.java", 25);

            Folder subfolder = new Folder("subfolder");
            subfolder.addFile(file3);
            subfolder.addFile(file1);

            fileSystemService.addChildren(file1);
            fileSystemService.addChildren(file2);
            fileSystemService.addChildren(subfolder);

            response.put("root", fileSystemService.getRoot());
            response.put("totalFiles", fileSystemService.countItems(fileSystemService.getRoot(), "file"));
            response.put("totalFolders", fileSystemService.countItems(fileSystemService.getRoot(), "folder"));
            response.put("totalSize", fileSystemService.calculateSize(fileSystemService.getRoot()));
            response.put("Busqueda", fileSystemService.findChildren("subfolder"));


            response.put("success", true);

        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }

        return response;
    }


}

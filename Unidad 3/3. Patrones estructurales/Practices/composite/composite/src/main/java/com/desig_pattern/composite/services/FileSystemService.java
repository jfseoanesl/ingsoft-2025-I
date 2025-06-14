package com.desig_pattern.composite.services;

import org.springframework.stereotype.Service;
import com.desig_pattern.composite.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileSystemService {

    private Folder root;

    public FileSystemService() {
        this.root = new Folder("root");
    }


    public void addChildren(Object children){

        if(children instanceof File){
            this.root.addFile((File)children);
        }else if(children instanceof Folder){
            this.root.addFolder((Folder)children);
        }

    }

    public Map<String, Object> findChildren(String name){
        Map<String, Object> response = new HashMap<>();
        Object result = this.root.findChildren(name);
        response.put("find", result);
        return response;
    }

    public Folder getRoot() {
        return root;
    }

    public void setRoot(Folder root) {
        this.root = root;
    }

    // FALLA 6: El servicio necesita conocer todos los tipos concretos
    public void displayFileSystem(Object item) {
        if (item instanceof File) {
            File file = (File) item;
            file.display();
        } else if (item instanceof Folder) {
            Folder folder = (Folder) item;
            folder.display();
        } else {
            throw new IllegalArgumentException("Tipo no soportado"); // FALLA 7: No extensible
        }
    }

    // FALLA 8: Método para calcular tamaño con lógica duplicada
    public int calculateSize(Object item) {
        if (item instanceof File) {
            return ((File) item).getSize();
        } else if (item instanceof Folder) {
            return ((Folder) item).getTotalSize();
        }
        return 0;
    }


    // FALLA 10: Imposible agregar nuevos tipos sin modificar código existente
    // Si quisiéramos agregar "SymbolicLink", tendríamos que modificar TODOS estos métodos

    // FALLA 13: Métodos auxiliares con lógica de tipo repetitiva
    public int countItems(Object item, String type) {
        int count = 0;

        if (type.equals("file") && item instanceof File) {
            return 1;
        } else if (type.equals("folder") && item instanceof Folder) {
            count = 1;
            Folder folder = (Folder) item;
            for (Object child : folder.getChildren()) {
                count += countItems(child, type);
            }
        } else if (item instanceof Folder) {
            Folder folder = (Folder) item;
            for (Object child : folder.getChildren()) {
                count += countItems(child, type);
            }
        }

        return count;
    }
}

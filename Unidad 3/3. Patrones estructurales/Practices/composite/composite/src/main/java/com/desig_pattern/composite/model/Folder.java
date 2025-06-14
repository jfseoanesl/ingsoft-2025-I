package com.desig_pattern.composite.model;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Object> children; // FALLA 2: Usando Object en lugar de interfaz común

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // FALLA 3: Métodos diferentes para archivos y carpetas
    public void addFile(File file) {
        children.add(file);
    }

    public void addFolder(Folder folder) {
        children.add(folder);
    }

    // FALLA 4: Lógica compleja para manejar diferentes tipos
    public void display() {
        System.out.println("Folder: " + name);
        for (Object child : children) {
            if (child instanceof File) {
                ((File) child).display(); // Cast inseguro
            } else if (child instanceof Folder) {
                ((Folder) child).display(); // Cast inseguro
            }
        }
    }
    // FALLA 5: Cálculo de tamaño con lógica compleja y repetitiva
    public int getTotalSize() {
        int totalSize = 0;
        for (Object child : children) {
            if (child instanceof File) {
                totalSize += ((File) child).getSize();
            } else if (child instanceof Folder) {
                totalSize += ((Folder) child).getTotalSize(); // Recursión pero con cast
            }
        }
        return totalSize;
    }

    public Object findChildren(String name){

        for(Object o: this.getChildren()){

            if(o instanceof File){
                File file = (File)o;
                if(file.getName().equals(name)){
                    return file;
                }
            }
            else if(o instanceof Folder){
                Folder folder = (Folder)o;
                if(folder.getName().equals(name)){
                    return folder;
                }else{
                    return folder.findChildren(name);
                }
            }else{
                return null;
            }

        }
        return null;
    }

    public List<Object> getChildren() { return children; }
}
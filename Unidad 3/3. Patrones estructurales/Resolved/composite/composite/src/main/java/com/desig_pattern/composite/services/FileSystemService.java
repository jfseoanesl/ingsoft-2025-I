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

    public void addChildren(FileSystemComponent children){

        this.root.addFile(children);

    }

    public Map<String, FileSystemComponent> findChildren(String name){
        Map<String, FileSystemComponent> response = new HashMap<>();
        FileSystemComponent result = this.root.findChildren(name);
        response.put("find", result);
        return response;
    }

    public Folder getRoot() {
        return root;
    }

    public void setRoot(Folder root) {
        this.root = root;
    }

    public void displayFileSystem(FileSystemComponent item) {
        item.display();
    }

    public int calculateSize(FileSystemComponent item) {

        return item.getSize();

    }

    public int countItems(FileSystemComponent item, String type) {
        int count = 0;

        if (type.equals("file") ) {
            count+=item.fileCountItem();
        } else if (type.equals("folder")) {
            count+=item.folderCountItem();
        }

        return count;
    }
}

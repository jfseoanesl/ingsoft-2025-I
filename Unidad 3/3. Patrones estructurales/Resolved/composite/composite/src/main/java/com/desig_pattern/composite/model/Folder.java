package com.desig_pattern.composite.model;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent{
    private List<FileSystemComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public void addFile(FileSystemComponent child) {
        children.add(child);
    }


    public void display() {

        for (FileSystemComponent child : children) {
            child.display();
        }
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public int fileCountItem() {
        int count = 0;
        for(FileSystemComponent child : children){
            if(!child.isComposite()){
                count++;
            }else{
                count += child.fileCountItem();
            }
        }
        return count;
    }

    @Override
    public int folderCountItem() {
        int count = 0;
        for(FileSystemComponent child : children){
            if(child.isComposite()){
                count++;
                count+=child.folderCountItem();
            }
        }
        return count;
    }

    public FileSystemComponent findChildren(String name){
        for(FileSystemComponent child: this.getChildren()){
            if(child.getName().equals(name)){
                return child;
            }else if(child.isComposite()){
                return ((Folder)child).findChildren(name);
            }

        }
        return null;
    }

    public List<FileSystemComponent> getChildren() { return children; }
}
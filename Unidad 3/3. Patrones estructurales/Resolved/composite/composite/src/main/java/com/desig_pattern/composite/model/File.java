package com.desig_pattern.composite.model;

public class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size =size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("File: " + this.getName() + " (" + size + " KB)");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public int fileCountItem() {
        return 1;
    }

    @Override
    public int folderCountItem() {
        return 0;
    }

}

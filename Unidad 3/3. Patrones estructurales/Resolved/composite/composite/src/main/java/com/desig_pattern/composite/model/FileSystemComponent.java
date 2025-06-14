package com.desig_pattern.composite.model;

public abstract class FileSystemComponent {
    private String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getSize();
    public abstract void display();
    public abstract boolean isComposite();
    public abstract int fileCountItem();
    public abstract int folderCountItem();
}

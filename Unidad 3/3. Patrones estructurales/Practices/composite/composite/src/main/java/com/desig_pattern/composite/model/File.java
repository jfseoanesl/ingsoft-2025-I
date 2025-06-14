package com.desig_pattern.composite.model;

public class File {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() { return name; }
    public int getSize() { return size; }

    public void display() {
        System.out.println("File: " + name + " (" + size + " KB)");
    }
}

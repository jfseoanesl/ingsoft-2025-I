package com.design_pattern.flyweight.model;


public class Tree {
    private String type;       // especie
    private String texture;    // textura (compartible)
    private String color;      // color (compartible)
    private double height;     // altura (compartible)
    private double size;

    private int x;             // posición X (extrínseco)
    private int y;             // posición Y (extrínseco)

    public Tree(String type, String texture, String color, double height, int x, int y, double size) {
        this.type = type;
        this.texture = texture;
        this.color = color;
        this.height = height;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void render() {
        System.out.printf("Drawing %s at (%d, %d)\n", type, x, y);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


package com.shape;

public class Rectangle {
    private double width = 1;
    private double height = 1;
    private String color = "yellow";

    public Rectangle() {}

    public Rectangle(double width, double height) {
        if  (width > 0) {
            setHeight(height);
        }

        if  (width > 0) {
            setWidth(width);
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double newWidth) {
        if (newWidth>0) {
            width = newWidth;
        }

    }

    public void setHeight(double newHeight) {
        if (newHeight>0) {
            height = newHeight;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setColor(String newColor) {
        if (newColor != null) {
            color = newColor;
        }

    }

    public String getColor() {
        return color;
    }

    public double getArea() {

        return width*height;
    }

    public double getPerimeter() {

        return 2*(width + height);
    }




}

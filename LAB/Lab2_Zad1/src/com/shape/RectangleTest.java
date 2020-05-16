package com.shape;

import java.util.Scanner;

public class RectangleTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double width;
        double height;
        String color;
        Rectangle myRectangle = new Rectangle(4.5,6.6); // create new Rectangle object

        System.out.println("Enter New Rectangle width: "); //prompt
        width = input.nextDouble();
        System.out.println("Enter New Rectangle height: ");
        height = input.nextDouble();
        System.out.println("Enter New Rectangle color: ");
        color = input.next();

        //Set new data
        myRectangle.setWidth(width);
        myRectangle.setHeight(height);
        myRectangle.setColor(color);

        //display Rectangle information
        System.out.printf("Width: %.2f\n", myRectangle.getWidth());
        System.out.printf("Height: %.2f\n", myRectangle.getHeight());
        System.out.println("Color: " + myRectangle.getColor());
        System.out.printf("Area: %.2f\n", myRectangle.getArea());
        System.out.printf("Perimeter: %.2f\n", myRectangle.getPerimeter());
    }
}

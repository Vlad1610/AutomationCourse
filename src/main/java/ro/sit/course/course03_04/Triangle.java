package ro.sit.course.course03_04;

import java.awt.*;

public class Triangle extends Shape {


    public Triangle(Color color) {
        super(color);
    }

    public void flipVertical() {
        System.out.println("Flip Triangle");
    }

    public void flipHorizontal() {
        System.out.println("Flip Horizontal Triangle");
    }

    @Override
    public void draw() {
        System.out.println("Draw a triangle");
    }

    //overloading
    public void draw(int l1, int l2, int l3) {
        System.out.println("Draw a triangle with value:" + l1+"," + l2 + "," + l3);
    }

    public void flipHorizontal(int degree){
        System.out.println("Filp triangle with degree:"+degree);
    }
}
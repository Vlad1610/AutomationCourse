package ro.sit.course.course03_04;

import java.awt.*;

public class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("Draw a new shape");
    }

    public void erase() {
        System.out.println("Delete shape");
    }

    private void shapePrivateMethod() {
        System.out.println("I am a private shape method");
    }

    protected void shapeProtectedMethod() {
        System.out.println("I am a protected shape method");
    }
}
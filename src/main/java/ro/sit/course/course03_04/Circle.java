package ro.sit.course.course03_04;

import java.awt.*;

public class Circle extends Shape {

    double radius;

    public Circle(){
        super(Color.BLACK);
    }
    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    void setRadius(double rad) {
        radius = rad;
    }

    double getArea() {
        return 3.14 * (radius * radius);
    }

    public void protectedMthCircle() {
        super.shapeProtectedMethod();
    }
}
package ro.sit.course.course03_04;

import java.awt.*;

public class EqTriangle extends Triangle{

    public EqTriangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Draw a EQ Triangle");
    }
}
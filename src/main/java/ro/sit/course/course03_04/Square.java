package ro.sit.course.course03_04;

public class Square {

    private double squareSide;
    Circle circle;

//    final double FIXED_SQUARE_SIDE;

    public Square(double squareSide) {
        this.squareSide = squareSide;
    }

    public Square() {

    }

    public Square(double squareSide, Circle circle) {
        this.squareSide = squareSide;
        this.circle = circle;
        System.out.println(circle.radius);
    }

//    public Square(double FIXED_SQUARE_SIDE) {
//        this.FIXED_SQUARE_SIDE = FIXED_SQUARE_SIDE;
//    }

// cannot change values of declared constants
//    void setFixedSquareSide(double FIXED_SQUARE_SIDE) {
//        this.FIXED_SQUARE_SIDE = FIXED_SQUARE_SIDE;
//    }

    double getArea() {
        return squareSide * squareSide;
    }

    void setSquareSide(double squareSide) {
        this.squareSide = squareSide;
    }
}
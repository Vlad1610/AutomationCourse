package ro.sit.course.course03_04;

public class Rectangle {

    double width;
    double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public double getDiagonal() {
        return Math.sqrt(this.width * this.width + this.length * this.length);
    }

}
package ro.sit.course.course03_04;

public class Shapes {

    public static void main(String[] args) {
//        Square square = new Square(Double.parseDouble(args[0]));
////        square.setSquareSide(Double.parseDouble(args[0]));
//        System.out.println(square.getArea());
//        System.out.println();
//
//        for (String argument : args) {
////            Square currentSquare = new Square(Double.parseDouble(argument));
//            Square squareWithoutParameters = new Square();
//            squareWithoutParameters.setSquareSide(Double.parseDouble(argument));
//            System.out.println(squareWithoutParameters.getArea());
//        }

        // access squareSide directly
//        System.out.println(square.squareSide);

        Rectangle rectangle = new Rectangle(Double.parseDouble(args[0]),
                Double.parseDouble(args[1]));
        System.out.println("Width= " + rectangle.width);
        System.out.println("Length= " + rectangle.length);
        System.out.println("Rectangle area= " + rectangle.getArea());
        System.out.println("Rectangle perimeter= " + rectangle.getPerimeter());
        System.out.println("Rectangle diagonal= " + rectangle.getDiagonal());

        Circle circle = new Circle();
        Square squareWithCircle = new Square(Double.parseDouble(args[0]), circle);
    }
}
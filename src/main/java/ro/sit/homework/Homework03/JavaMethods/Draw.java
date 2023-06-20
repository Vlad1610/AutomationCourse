package ro.sit.homework.Homework03.JavaMethods;

public class Draw {

    public static void main(String[] args) {
        if (args.length == 1) {
            drawFullShape(Integer.parseInt(args[0]));
            drawShapeOutline(Integer.parseInt(args[0]));
            drawShapeCorners(Integer.parseInt(args[0]));
        } else if (args.length == 2) {
            drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            drawShapeOutline(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            drawShapeCorners(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            System.out.println("Please add 1 or 2 arguments only");
        }
        System.out.println();
        System.out.println("--------");
        System.out.println();

    }

    // method 1 for drawShapeOutline
//    private static void drawShapeOutline(int width, int height) {
//        printShapeName("Empty rectangle");
//        printEntireLine(height);
//        System.out.println();
//        for (int i = 1; i < width - 1; i++) {
//            System.out.print("*");
//            for (int j = 1; j < height - 1; j++) {
//                System.out.print(" ");
//            }
//            System.out.println("*");
//        }
//        printEntireLine(height);
//    }

    //    method 2 for drawShapeOutline
    private static void drawShapeOutline(int width, int height) {
        printShapeName("Empty rectangle:");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == (width - 1) || j == 0 || j == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private static void drawShapeOutline(int squareSide) {
        printShapeName("Empty Square:");
        for(int i = 0; i < squareSide; i++) {
            for(int j = 0; j < squareSide; j++) {
                if (i == 0 || i == (squareSide - 1) || j == 0 || j == (squareSide - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawShapeCorners(int width, int length) {
        printShapeName("Rectangle corners:");
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                if((i == 0 && j == 0) || (i == 0 && j == length - 1) || (i == width - 1 && j == 0) || (i == width - 1 && j == length -1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    private static void drawShapeCorners(int squareSide) {
        printShapeName("Square corners:");
        for(int i = 0; i < squareSide; i++) {
            for(int j = 0; j < squareSide; j++) {
                if((i == 0 && j == 0) || (i == 0 && j == squareSide -1) || (i == squareSide - 1 && j == 0) || (i == squareSide - 1 && j == squareSide -1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawFullShape(int squareSide) {
        printShapeName("Full Square: ");
        for (int i = 0; i < squareSide; i++) {
            printEntireLine(squareSide);
           System.out.println();
        }
    }

    private static void drawFullShape(int width, int height) {
        printShapeName("Full Rectangle: ");
        for (int i = 0; i < width; i++) {
            printEntireLine(height);
            System.out.println();
        }
//        printEntireLine();
//        String message = "2 parameters method";
//        printEntireLine(width, message + " with first parameter ar int");
//        printEntireLine(width, message + " with first parameter as String");
    }

    private static void printShapeName(String shapeName) {
        System.out.println();
        System.out.println(shapeName);
        System.out.println();
    }

    private static void printEntireLine(int numarColoane) {
        for (int j = 0; j < numarColoane; j++) {
            System.out.print("*");
        }
    }

    private static void printEntireLine(int numarColoane, String message) {
        for (int j = 0; j < numarColoane; j++) {
            System.out.print("*");
        }
        System.out.println(message);
    }

    private static void printEntireLine(String numarColoane, String message) {
        for (int j = 0; j < Integer.parseInt(numarColoane); j++) {
            System.out.print("*");
        }
        System.out.println(message);
    }

    private static void printEntireLine() {
        System.out.print("**********");
    }
}
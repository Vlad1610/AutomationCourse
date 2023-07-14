package ro.sit.course.course06;

public class ExceptionsChecked {
    public static void main(String[] args) throws MyCustomException {
//        System.out.println(circleArea(-20));

        try {
            int age = Integer.parseInt(args[0]);
            System.out.println("age is: " + age);
//        } catch (RuntimeException e) {
//            System.out.println("There was a problem with the parameter");
//        }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new MyCustomException("The first parameter needs to be an int");
        }
//        catch (NumberFormatException e) {
//            System.out.println("There was a problem with the parameter");
//        }
        finally {
            System.out.println("Finally code will still run even if exception occurs");
        }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("There are no arguments set up as params");
//            e.printStackTrace();
//        } catch (NumberFormatException e) {
//            System.out.println("Argumentul nu poate fi transformat in numar");
//        }
        double aria;
        int param = -5;
        try {
            //System.out.println(circleArea(array1[0]));
            aria = circleArea(param);
            System.out.println(aria);
        } catch (IllegalArgumentException e) {
            //System.out.println(circleArea(array2[0]));
            aria = circleArea(param * -1);
            System.out.println("Something went wrong");
        }
        System.out.println("Aria: " + aria);
    }

    public static double circleArea(double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("radius should be positive");
        }
        return Math.PI * radius * radius;
    }
}

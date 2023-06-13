package ro.sit.homework.Homework02;

public class LeapYear {
    public static void main(String[] args) {
        int year = 0;
        if(args.length != 0) {
            year = Integer.parseInt(args[0]);
            if(year < 1900 || year > 2016) {
                System.out.println("The year must be a number between 1900 - 2016");
                return;
            }
        } else {
            System.out.println("There is no input to process!");
            return;
        }
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 != 0 && year % 100 == 0)) {
            System.out.println("Leap year: 29 days");
        } else {
            System.out.println("Normal year: 28 days");
        }
    }
}

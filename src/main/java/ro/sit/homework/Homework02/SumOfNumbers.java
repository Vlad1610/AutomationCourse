package ro.sit.homework.Homework02;

public class SumOfNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i <=100; i++) {
            sum = sum + i;
        }
        System.out.println("Sum using interrator method: " + sum);

        int n = 100; //the maximum number
        int gaussSum = n * (n + 1) / 2;
        System.out.println("Sum using the Gauss method: " + gaussSum);
    }
}

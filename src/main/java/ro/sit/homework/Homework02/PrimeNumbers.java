package ro.sit.homework.Homework02;

public class PrimeNumbers {
    public static boolean isPrime(int x) {
        if(x < 2) return false;
        if(x == 2) return true;
        if(x % 2 == 0) return false;
        int i;
        for(i = 3; i < x; i = i+2) {
            if(x % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 2;
        while (n <=1000000) {
            if (isPrime(n) == true) {
                System.out.println(n + " ");
            }
            n = n+1;
        }
    }
}

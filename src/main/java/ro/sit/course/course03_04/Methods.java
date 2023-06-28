package ro.sit.course.course03_04;

public class Methods {

    private static int a = 5;
    private static int b = 10;

    public static void main(String[] args) {
        int c = 20;
        int d = 15;

        int sumaAb = suma(a, b);
        int sumaCd = suma(c, d);
//        int sumaEf = suma(50, 100);

        for (int i = 0; i < 10; i = i + 2) {
            System.out.println(suma(i, i + 1));
        }

        System.out.println("sumaAb= " + sumaAb);
        System.out.println("sumaCd= " + sumaCd);
        System.out.println("sumaEf= " + suma(50, 100));
        System.out.println("sumaAb= " + sumaAb());
        printSumaAb();
        int maximulEste = getMax(a, b);
        System.out.println("Maximul dintre " + a + " si " + b + " este " + maximulEste);
        System.out.println("Maximul dintre " + 5 + " si " + 5 + " este " + getMax(5, 5));
        printFirst50Numbers();
        System.out.println("Numarul " + a + " este numar impar " + isOddNumber(a));

    }

    private static int suma(int firstNumber, int secondNumber) {
        System.out.println("Suma este: ");
        return firstNumber + secondNumber;
    }

    private static int sumaAb() {
        return a + b;
    }

    private static void printSumaAb() {
        System.out.println("printSumaAb= " + (a + b));
    }

    private static int getMax(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return firstNumber;
        } else if (secondNumber > firstNumber) {
            return secondNumber;
        } else {
            System.out.println("Numerele sunt egale");
            return -1;
        }
    }

    public static void printFirst50Numbers() {
        for (int i = 0; i < 100; i++) {
            if (i < 51) {
                System.out.println("Numarul este: " + i);
            } else {
                break;
            }
        }
        System.out.println("Ati ajuns la sfarsitul listei. Comanda de return nu a functionat");
    }

    private static boolean isOddNumber(int numberToVerify) {
//        if (numberToVerify % 2 == 0) {
//            return false;
//        } else {
//            return true;
//        }
        return numberToVerify % 2 != 0;
    }

}
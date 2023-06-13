package ro.sit.course;

public class Course02 {

    public static void main(String[] args) {
        System.out.println("Hellow world!");
        int number;
        number = 5;
        int secondNumber = 2;
        System.out.println(number);
        System.out.println(secondNumber);
        final String FIRST_NAME = "Darth Vader";
        String name = "Sidius";
        System.out.println(number + name + FIRST_NAME + secondNumber);
        int suma = number + secondNumber;
        System.out.println(suma);
//        number = 10;
        suma = number + secondNumber;
        int produs = number * secondNumber;
        System.out.println("Suma este: " + suma);
        System.out.println("Produsul este: " + produs);
        System.out.println(number + "+" + secondNumber + "=" + suma);
        System.out.println(number + "*" + secondNumber + "=" + produs);
        boolean isNegative = number < 0;
        System.out.println(isNegative);
        char caracter = 'a';
        System.out.println("Caracterul este: " + caracter);
        String numeComplet = FIRST_NAME + " " + name;
        System.out.println(numeComplet);
        int impartire = number / secondNumber;
        System.out.println("Rezultatul impartirii este: " + impartire);
        float impartire2 = (float) number / secondNumber;
        System.out.println("Rezultatul impartirii este: " + impartire2);
        int modul = number % secondNumber;
        System.out.println("Restul impartirii este: " + modul);
        modul = modul + 5;
        modul += 5;
        modul -= 3;
        modul *= 5;
        modul -= 1;
        modul = modul + 1;
        modul +=1;
        System.out.println("Inainte de incrementare/decrementare: " + modul);
//        modul ++;
        System.out.println("Post incremenetare : " + modul++);
//        modul --;
        System.out.println("Post decremenetare : " + modul--);
//        ++ modul;
        System.out.println("Pre incremenetare : " + ++modul);
//        --modul;
        System.out.println("Pre deremenetare : " + --modul);
        boolean areEqual = number == secondNumber;
        boolean notEqual = number != secondNumber;
        System.out.println("The numbers are equal " + areEqual);
        System.out.println("The numbers are  not equal " + notEqual);
        boolean areBothPositive = number >= 0 && secondNumber >= 0;
        System.out.println("Both numbers are positive " + areBothPositive);
        secondNumber = -2;
        areBothPositive = number >= 0 && secondNumber >= 0;
        System.out.println("Both numbers are positive " + areBothPositive);
        boolean eitherIsPositive = number >= 0 || secondNumber >= 0;
        System.out.println("Either number is positive " + eitherIsPositive);
        boolean reverseEitherIsPositive = !eitherIsPositive;
        System.out.println("Reverse either is positive: " + reverseEitherIsPositive);
        boolean xorOperator = number >= 0 ^ secondNumber >= 0;
        System.out.println("XOR Operator " + xorOperator);
        secondNumber = 3;
        xorOperator = number >= 0 ^ secondNumber >= 0;
        System.out.println("XOR Operator " + xorOperator);
        System.out.println("First sequence");
        System.out.println("Second sequence");
        System.out.println("Third sequence");
        number = 0;
        boolean isNumberPositive = number > 0;
        boolean isNumberNegative = number < 0;
        if (isNumberPositive) {
            System.out.println("Numarul este strict mai mare decat 0");
        } else if(isNumberNegative) {
            System.out.println("Numarul este strict negativ");
        } else {
            System.out.println("Numarul este egal cu 0");
        }

        String letter = "A";
        switch (letter) {
            case "A":
                System.out.println("apples");
                break;
            case "B":
                System.out.println("beer");
                break;
            case "C":
                System.out.println("cider");
                break;
            default:
                System.out.println("We only learned A, B, C");
        }

        String letter2 = "b";
        if(letter2.equals("b")) {
            System.out.println("beer");
        } else if(letter2.equals("a")) {
            System.out.println("apple");
        } else if(letter2.equals("c")) {
            System.out.println("cider");
        } else {
            System.out.println("We only learned A, B, C");
        }

//        int x = 0;
//        while(x < 25) {
//            System.out.println(x);
//            x++;
//        }

        int x1 = 25;
        do {
            System.out.println(x1);
            x1++;
        } while (x1 < 25);

 //       for(int i = 0; i <25; i++) {
 //           System.out.println(i);
 //       }

        for(int i = 25; i >= 0; i--) {
            System.out.println(i);
        }

        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        int summ = 0;
        for (int num : numbers) {
            if (num == 30) {
                continue;
            }
            summ += num;
            if (summ >100) {
                break;
            }
            System.out.println(num);
        }
        System.out.println("suma: " + summ);

    }
}

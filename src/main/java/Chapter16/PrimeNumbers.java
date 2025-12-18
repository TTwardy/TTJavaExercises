package Chapter16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = scanner.nextInt();

        System.out.println(isPrime(number));

        System.out.println(calculatePrimeFactors(number));
    }

    protected static Set<Integer> calculatePrimeFactors(int number){
        Set<Integer> primeFactors = new HashSet<>();
        int dividedNumber = number;

        while (true){if (dividedNumber%2==0){
                primeFactors.add(2);
                dividedNumber=dividedNumber/2;
            }
            else {
                break;
            }
        }
        while (true){if (dividedNumber%3==0){
                primeFactors.add(3);
                dividedNumber=dividedNumber/3;
            }
            else {
                break;
            }
        }

        for (int i = 5; i < Math.sqrt(number); i= nextPrime(i)) {
            if (dividedNumber%i==0){
                primeFactors.add(i);
                dividedNumber=dividedNumber/i;
            }
        }
        return primeFactors;
    }

    protected static int nextPrime(int current){
        int candidate= current +1;

        while(!isPrime(candidate)){
            candidate++;
        }

        return candidate;
    }
    protected static boolean isPrime (int number){
        if (number==2 || number == 3){
            return true;
        }
        if (number%2!=0){
            for (int i = 3; i <= Math.sqrt(number); i+=2) {
                if (number%i==0){
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

//    protected static int printPrimeFactors(int number){
//
//    }
}

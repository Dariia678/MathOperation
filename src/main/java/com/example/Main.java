package main.java.com.example;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface StringManipulator {
    String manipulate(String s);
}

class StringListProcessor {
    public static int countUppercase(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}

class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

public class Main {
    public static void main(String[] args) {
        // MathOperation using anonymous class
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Addition (5 + 3): " + addition.operate(5, 3));

        // StringManipulator using lambda
        StringManipulator toUpperCase = s -> s.toUpperCase();
        System.out.println("Uppercase of 'hello': " + toUpperCase.manipulate("hello"));

        // Method reference for countUppercase
        Function<String, Integer> uppercaseCounter = StringListProcessor::countUppercase;
        System.out.println("Number of uppercase letters in 'Hello World': " + uppercaseCounter.apply("Hello World"));

        // Supplier for random number
        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println("Random number between 1 and 100: " + randomSupplier.get());
    }
}

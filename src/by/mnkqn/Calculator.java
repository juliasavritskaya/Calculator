package by.mnkqn;

import java.util.Scanner;

public class Calculator {

    final int exitOperator = 0;
    final int sumOperator = 1;
    final int subtractionOperator = 2;
    final int multiplicationOperator = 3;
    final int divisionOperator = 4;
    final int exponentiationOperator = 5;
    final int sqrtOperator = 6;
    double result = 0;

    ConstantPhrases phrases = new ConstantPhrases();

    public void run() {
        System.out.println(phrases.helloText());
        selectOperation();
    }

    public void selectOperation() {

        Scanner scan = new Scanner(System.in);

        System.out.println(phrases.selectOperatorText());
        int operationType = scan.nextInt();
        if (operationType == exitOperator) {
            exit();
        } else {

            System.out.println(phrases.inputAText());
            double inputA = scan.nextDouble();

            if (operationType == sqrtOperator) {
                result = sqrt(inputA);
            } else {

                System.out.println(phrases.inputBText());
                double inputB = scan.nextDouble();

                switch (operationType) {
                    case sumOperator:
                        result = sum(inputA, inputB);
                        break;
                    case subtractionOperator:
                        result = subtraction(inputA, inputB);
                        break;
                    case multiplicationOperator:
                        result = multiplication(inputA, inputB);
                        break;
                    case divisionOperator:
                        result = division(inputA, inputB);
                        break;
                    case exponentiationOperator:
                        result = pow(inputA, inputB);
                }
            }

            System.out.println(phrases.resultIsText() + result);

            System.out.println(phrases.continText());
            int con = scan.nextInt();
            continueWorking(con);

            scan.close();
        }
    }

    public void continueWorking(int con) {
        if (con == 1) {
            selectOperation();
        } else if (con == 2) {
            exit();
        } else {
            System.out.println(phrases.unknownSymbolText());
        }
    }

    public void exit() {
        System.out.println(phrases.completedText());
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        return a / b;
    }

    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}

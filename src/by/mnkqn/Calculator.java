package by.mnkqn;

import java.util.Scanner;

public class Calculator {

    ConstantPhrases phrases = new ConstantPhrases();

    public void run() {
        System.out.println(phrases.helloText());
        selectOperation();
    }

    public void selectOperation() {

        Scanner scan = new Scanner(System.in);

        System.out.println(phrases.selectOperatorText());

        int operationType = scan.nextInt();
        if (operationType == 5) {
            exit();
        } else {

            System.out.println(phrases.inputAText());
            double inputA = scan.nextDouble();

            System.out.println(phrases.inputBText());
            double inputB = scan.nextDouble();

            double result = 0;
            switch (operationType) {
                case 1:
                    result = sum(inputA, inputB);
                    break;
                case 2:
                    result = minus(inputA, inputB);
                    break;
                case 3:
                    result = multiplication(inputA, inputB);
                    break;
                case 4:
                    result = division(inputA, inputB);
                    break;
            }
            System.out.printf(phrases.resultIsText() + result);

            System.out.println(phrases.contintext());
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
            System.out.println(phrases.unknownSymboltext());
        }
    }

    public void exit() {
        System.out.println(phrases.completedText());
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        return a / b;
    }
}
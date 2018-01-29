package com.yatsulka.rpn;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner == null) {
            System.out.print("Enter an integer (1 - 100): ");
            int t;
            t = scanner.nextInt();
            if (t > 0 && t <= 100)
                System.out.println("good\n");
            else
                System.out.println("bad integer. Try once more\n");
        }
    }
}



//public class Main {
//
//    static String command;
//    static boolean newCommand = false;
//
//    public static void main(String[] args) {
//
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
//
//        Calculator calculator = new Calculator();
//
//        System.out.println("Enter your expression, or 'exit' to quit");
//
//        boolean keepRunning = true;
//        while (keepRunning) {
//            String inputString = console.readLine(": ");
//            if ("exit".equals(inputString)) {
//                keepRunning = false;
//            } else {
//                try {
//                    calculator.eval(inputString);
//                } catch (CalculatorException e) {
//                    System.out.println(e.getMessage());
//                }
//
//                DecimalFormat fmt = new DecimalFormat("0.##########");
//                Stack<Double> stack = calculator.getValuesStack();
//                System.out.print("Stack: ");
//                for (Double value : stack) {
//                    System.out.print(fmt.format(value));
//                    System.out.print(" ");
//                }
//                System.out.printf("%n");
//            }
//        }
//    }
//}
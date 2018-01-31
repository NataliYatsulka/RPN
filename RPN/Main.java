//package com;
import java.util.Scanner;
import java.*;


public class Main {

    public static boolean hasPrecedence(char first, char second)
    {
        boolean rez = false;

        switch (first)
        {
            case '+':
            {
                rez = true;
            }
            break;
            case '-':
            {
                if (secod == '+')
                    rez = true;
            }
            break;
            case '*':
            {
                if (second == '+' || second == '-')
                    rez = true;
            }
            break;
            case '/':
            {
                if (second != '^')
                    rez = true;
            }
            break;
        }
        return rez;
    }


    public static void lastTest(char s, CharStack cs, String rpnExpresion)
    {
        if (hasPrecedence(cs.top(), s))
            cs.push(s);
        else
        {
            rpnExpresion += cs.top();
            cs.pop();
            lastTest(s, cs, rpnExpresion);
        }

    }

    public static void read_output(String expresion, String rpnExpresion)
    {
        char s;
        CharStack cs = new CharStack();

        for (int i = 0; i < expresion.length(); ++i)
        {
            s = expresion[i];
            if (s >= 'a' && s <= 'z')
                rpnExpresion += s;
            else if (s == '(')
                cs.push(s);
            else if (s == ')')
            {
                while (cs.top() != '(')
                {
                    rpnExpresion += cs.top();
                    cs.pop();
                }
                cs.pop();
            }
            else
            {
                if (cs.empty())
                    cs.push(s);
                else if (cs.top() == '(')
                    cs.push(s);
                else
                    lastTest(s, cs, rpnExpresion);
            }
        }
        while (!cs.empty())
        {
            cs.top();
            cs.pop();
        }
    }

    public static int check_numb(int t)
    {
        if (t > 0 && t <= 100)
            return (1);
        else
        {
            System.out.println("Not correct number of expresions.");
            return (-1);
        }
    }

    public static void main(String[] args){

        String expresion;
        String rpnExprecion;

        rpnExprecion = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer (1 - 100): ");
        int t;
        t = scanner.nextInt();
        if (check_numb(t) < 1)
            System.exit(0);
        for (int i = 0; i < t; ++i)
        {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter " + t + " expresions");
            expresion = scanner1.nextLine();
            read_output(expresion, rpnExprecion);
            rpnExprecion += '\n';
        }

    }
}



//#include <string>
//#include <iostream>
//#include <stack>
//
///*
// * Checks precedence between operators.
// * Returns true if the first has lower or equal precedence than the second.
// * Returns false if the first has higher precedence than the second.
// */
//bool HasPrecedence(char first, char second)
//        {
//        bool result = false;
//
//        switch (first)
//        {
//        case '+' :
//        {
//        result = true;
//        } break;
//
//        case '-' :
//        {
//        if (second == '+')
//        result = true;
//        } break;
//
//        case '*' :
//        {
//        if (second == '+' || second == '-')
//        result = true;
//        } break;
//
//        case '/' :
//        {
//        if (second != '^')
//        result = true;
//        } break;
//
//        // The ^ operator was skipped because it always returns false
//        }
//        return result;
//
//        }
//
///*
// * Recursive function that gets called when there are no more operands and
// * operation precedence is being decided for the last remaining operators on
// * the stack.
// */
//        void LastTest(char current, std::stack<char>& stack, std::string& rpnExpression)
//        {
//        if (HasPrecedence(stack.top(), current))
//        stack.push(current);
//
//        else
//        {
//        rpnExpression += stack.top();
//        stack.pop();
//        LastTest(current, stack, rpnExpression);
//        }
//        }
//
///*
// * Takes in an expression as a string and starts evaluating each character,
// * using a stack to keep track of operators and precedences.
// */
//        void Transform(std::string& algExpression, std::string& rpnExpression)
//        {
//        std::stack<char> stack;
//
//        for (int i = 0; i < algExpression.length(); ++i)
//        {
//        char current = algExpression[i];
//
//        // Operands get added to the buffer as soon as they are seen
//        if (current >= 'a' && current <= 'z')
//        rpnExpression += current;
//
//        else if (current == '(')
//        stack.push(current);
//
//        // When you find a closing parenthesis, you add the top elements of the
//        // stack to the buffer until you find the matching open parenthesis.
//        else if (current == ')')
//        {
//        while (stack.top() != '(')
//        {
//        rpnExpression += stack.top();
//        stack.pop();
//        }
//
//        stack.pop();
//        }
//
//        // If the code gets all the way here, it means that the current character
//        // is an operator.
//        else
//        {
//        if (stack.empty())
//        stack.push(current);
//
//        else if (stack.top() == '(')
//        stack.push(current);
//
//        else
//        LastTest(current, stack, rpnExpression);
//        }
//        }
//
//        // Removes the rest of the elements from the stack
//        while (!stack.empty())
//        {
//        std::cout << stack.top();
//        stack.pop();
//        }
//        }
//
///*
// * Entry point of the program. Takes a number N, which indicates the number of
// * test cases to follow. Then transforms every expression and prints them.
// */
//        int main (void)
//        {
//        int numEntries;
//        std::cin >> numEntries;
//
//        std::string algExpression;
//
//        // Storing outputs in a single buffer to ensure that std::cout gets called
//        // only once, as it is a very expensive operation.
//        std::string rpnExpression = "";
//
//        for (int i = 0; i < numEntries; ++i)
//        {
//        std::cin >> algExpression;
//        Transform(algExpression, rpnExpression);
//        rpnExpression += '\n';
//        }
//
//        // Print the result to current output.
//        std::cout << rpnExpression << std::endl;
//
//        return 0;
//        }



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
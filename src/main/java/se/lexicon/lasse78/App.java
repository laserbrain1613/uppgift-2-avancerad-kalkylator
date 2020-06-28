package se.lexicon.lasse78;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void mainMenu() {
        boolean keepRepeating = true;
        int userChoice = 0;

        do {
            System.out.println("Improved Calculator");
            System.out.println("-------------------\n");
            System.out.println("1. Perform one simple operation");
            System.out.println("2. Perform multiple additions");
            System.out.println("3. Perform multiple subtractions");
            System.out.println("4. End program\n");
            System.out.println("Please make a selection: ");

            userChoice = handleUserInput(userChoice);
            switch (userChoice) {
                case 1:
                    simpleCalculation();
                    break;
                case 2:
                    performMultipleCalculations('+');
                    break;
                case 3:
                    performMultipleCalculations('-');
                    break;
                case 4: // User chooses to end program
                    displayFancyMessage("Thank you for using this program, goodbye!");
                    keepRepeating = false;
                    break;
                default:
                    displayFancyMessage("Incorrect selection!"); //Last case does not need a break
            }
        } while (keepRepeating);
    }


    public static void simpleCalculation() {
        double result = 0, value1 = 0, value2 = 0;
        char operator = ' ';

        System.out.println("Please insert value 1: ");
        value1 = handleUserInput(value1);
        System.out.println("Please insert operator (+ - * / allowed):");
        operator = handleUserInput(operator);
        System.out.println("Please insert value 2: ");
        value2 = handleUserInput(value2);

        switch (operator) {
            case '+':
                result = calcAddValues(value1, value2);
                break;
            case '-':
                result = calcSubtractValues(value1, value2);
                break;
            case '*':
                result = calcMultiplyValues(value1, value2);
                break;
            case '/':
                result = calcDivideValues(value1, value2);
        }

        // This section either points out mathematical errors/oversights to the user or displays the result
        if (operator == '*' && (value1 == 0 || value2 == 0)) {
            System.out.println("Any value multiplied by zero becomes zero.\n");
        } else if (operator == '/' && value2 == 0) {
            System.out.println("Division by zero is not possible.\n");
        } else if (operator == '/' && value1 == 0) {
            System.out.println("A zero divided by another number will always be zero.\n");
        } else {
            System.out.println(value1 + " " + operator + " " + value2 + " = " + result + "\n");
        }
    }


    public static void performMultipleCalculations(char chosenOperator) {
        double[] doubleArray = new double[0];
        int howManyValues = 0;
        double result = 0, newValue = 0;

        System.out.println("How many values would you like to " + (chosenOperator == '+' ? "add:" : "subtract:"));
        howManyValues = handleUserInput(howManyValues, 2);

        for (int i = 0; i < howManyValues; i++) {
            System.out.println("Please insert value " + (i + 1) + " out of " + howManyValues);
            doubleArray = expandArray(doubleArray, handleUserInput(newValue)); // Expands array by 1 and adds newValue to last in index
        }

        System.out.println("The result is: " + ((chosenOperator == '+') ? calcAddValues(doubleArray) + "\n": calcSubtractValues(doubleArray) + "\n"));
    }


    public static double calcAddValues(double number1, double number2) {
        return (number1 + number2);
    }

    public static double calcAddValues(double[] doubleArray) {
        double result = 0;
        for (double valueInArray : doubleArray) {
            result += valueInArray;
        }
        return result;
    }

    public static double calcSubtractValues(double number1, double number2) {
        return (number1 - number2);
    }

    public static double calcSubtractValues(double[] doubleArray) {
        double result = calcAddValues(0, doubleArray[0]); // Originating value to subtract from
        for (int i = 1; i < doubleArray.length; i++) {
            result -= doubleArray[i];
        }
        return result;
    }

    public static double calcMultiplyValues(double number1, double number2) {
        return (number1 * number2);
    }

    public static double calcDivideValues(double number1, double number2) {
        return (number2 == 0 ? -1 : (number1 / number2)); // Returns either -1 (divide by zero) or a proper result
    }

    public static void displayFancyMessage(String string) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < string.length(); j++) {
                System.out.print((j % 2 == 0) ? "=" : "-"); // Fancy line, alternates = and -
            }
            System.out.println((i == 0) ? ("\n" + string) : ""); // I only want this to be displayed once
        }
        System.out.println();
    }

    public static double[] expandArray(double[] oldArray, double addValue) {
        double[] tempArray = Arrays.copyOf(oldArray, oldArray.length + 1);
        tempArray[tempArray.length - 1] = addValue;
        return tempArray;
    }

    public static int handleUserInput(int tryValue) { // Handling main menu selection (method input is only used to utilize overload)
        Scanner scanner = new Scanner(System.in);
        try {
            return tryValue = scanner.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public static double handleUserInput(double tryValue) { // Handling input of double
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                return tryValue = scanner.nextDouble();
            } catch (Exception e) {
                displayFancyMessage("Incorrect selection! Please input a proper number");
                scanner.nextLine();
                System.out.println("Please make a selection:");
            }
        } while (true);
    }

    public static int handleUserInput(int tryValue, int minRangeLimit) { // Handling amountOfValues
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                tryValue = scanner.nextInt();
                if (!(tryValue < minRangeLimit)) {
                    return tryValue;
                }
            } catch (Exception e) {
                // Doesn't need to do anything
            }
            displayFancyMessage("Incorrect selection! You need a value of at least 2 for this operation to work");
            scanner.nextLine();
            System.out.println("Please make a selection: ");
        } while (true);
    }

    public static char handleUserInput(char tryChar) { // Handling operator
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                tryChar = scanner.next().charAt(0);
            } catch (Exception e) {
                tryChar = '?';
                scanner.nextLine();
            }
            switch (tryChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    return tryChar;
                default:
                    displayFancyMessage("Incorrect selection! Please input an operator (+, -, * or /)");
                    System.out.println("Please make a selection: ");
            }
        } while (true);
    }


    public static void main(String[] args) {
        mainMenu();
    }
}
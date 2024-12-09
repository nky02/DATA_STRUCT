import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    private String infix;

    public InfixToPostfix(String infix) {
        this.infix = infix;
    }

    private int getPrec(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '+' || operator == '-') {
            return 1;
        }
        return -1;
    }

    public String convert() {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            } else if (Character.isDigit(c)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    output.append(infix.charAt(i));
                    i++;
                }
                output.append(" ");
                i--;
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && getPrec(c) <= getPrec(stack.peek())) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    public double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] elements = postfix.split(" ");

        for (String element : elements) {
            if (element.isEmpty()) {
                continue;
            }
            if (Character.isDigit(element.charAt(0))) {
                stack.push(Double.parseDouble(element));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (element.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InfixToPostfix ip = null;
        String postfix = "";

        int choice = 0;
        while (choice != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter a new expression");
            System.out.println("2. Convert the current expression to postfix");
            System.out.println("3. Evaluate the postfix expression");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter an infix expression: ");
                    String expression = scan.nextLine();
                    ip = new InfixToPostfix(expression);
                    postfix = "";
                    System.out.println("New expression set.");
                    break;
                case 2:
                    if (ip != null) {
                        postfix = ip.convert();
                        System.out.println("Postfix: " + postfix);
                    } else {
                        System.out.println("Please enter an expression first.");
                    }
                    break;
                case 3:
                    if (!postfix.isEmpty()) {
                        double result = ip.evaluatePostfix(postfix);
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Please convert the expression first.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

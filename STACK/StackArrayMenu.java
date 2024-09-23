import java.util.Scanner;

public class StackArrayMenu {

    Scanner scanner = new Scanner(System.in);
    private String[] s;
    private int count;

    public StackArrayMenu(int size) {
        s = new String[size];
        count = 0;
    }

    public StackArrayMenu() {
        this(10); // literally making a constructor
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == s.length;
    }

    private boolean push(String val) {
        if (!isFull()) {
            s[count++] = val;
            return true;
        }
        return false;
    }

    public String pop() {
        if (!isEmpty()) {
            String val = s[--count];
            s[count] = null;
            return val;
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return s[count - 1];
        }
        return null;
    }

    public void display() {

        if (!isEmpty()) {
            for (int i = count - 1; i >= 0; i--) {
                System.out.println("[" + s[i] + "]");
            }
        } else {
            System.out.println("Stack is empty");
        }

    }

    public void menu() {
        while (true) {
            System.out.println("\nStack Array Menu");
            System.out.println("[1] Push");
            System.out.println("[2] Pop");
            System.out.println("[3] Peek");
            System.out.println("[4] Display Stack");
            System.out.println("[5] Exit");
            System.out.println("Select a choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a word to push: ");
                    if (!push(scanner.next())) {
                        System.out.println("Sorry, the stack is full.");
                    }
                    break;
                case 2:
                    String poppedWord = pop();
                    if (poppedWord != null) {
                        System.out.println(poppedWord + " popped from the stack.");
                    } else {
                        System.out.println("Sorry, the stack is empty.");
                    }
                    break;
                case 3:
                    String topWord = peek();
                    if (topWord != null) {
                        System.out.println("Top word is: " + topWord);
                    } else {
                        System.out.println("Stack is empty. No top element.");
                    }
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}







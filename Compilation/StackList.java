import java.util.Scanner;

public class StackList {
    private StackNode top;
    private int count;

    public StackList() {
        top = null;
        count = 0;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        StackNode node = new StackNode(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public boolean pop() {
        if (!isEmpty()) {
            top = top.tail;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        if (!isEmpty()) {
            StackNode temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.tail;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty....");
        }
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        StackList sl = new StackList();

        while (true) {
            System.out.println("\nStack List Menu");
            System.out.println("[1] Push");
            System.out.println("[2] Pop");
            System.out.println("[3] Peek");
            System.out.println("[4] Display Stack");
            System.out.println("[5] Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to push: ");
                    String data = scanner.nextLine();
                    if (sl.push(data)) {
                        System.out.println(data + " pushed onto the stack.");
                    } else {
                        System.out.println("Failed to push " + data);
                    }
                    break;
                case 2:
                    if (sl.pop()) {
                        System.out.println("Element popped from the stack.");
                    } else {
                        System.out.println("Stack is empty, cannot pop.");
                    }
                    break;
                case 3:
                    String topData = sl.peek();
                    if (topData != null) {
                        System.out.println("Top element is: " + topData);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    sl.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }

    private static class StackNode {
        private String data;
        private StackNode tail;

        public StackNode(String data) {
            this.data = data;
        }
    }
}

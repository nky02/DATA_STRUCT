import java.util.Scanner;

public class Nodelist {
    private Node last;
    private int counter;

    public Nodelist() {
        last = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean add(Node item) {
        if (isEmpty()) {
            last = item;
            item.next = item;
            item.prev = item;
        } else {
            Node temp = last.next;
            last.next = item;
            item.prev = last;
            item.next = temp;
            temp.prev = item;
        }
        last = item;
        counter++;
        return true;
    }

    public boolean delete(int location) {
        if (isEmpty() || location < 0 || location >= counter) {
            return false;
        }

        Node current = last.next;
        for (int i = 0; i < location; i++) {
            current = current.next;
        }

        if (current == last) {
            last = current.prev;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        counter--;
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Sorry, the list is Empty");
            return;
        }
        Node current = last.next;
        while (current != last) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data + " ");
        System.out.println();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Nodelist list = new Nodelist();

        while (true) {
            System.out.println("\nNode List Menu");
            System.out.println("[1] Add Node");
            System.out.println("[2] Delete Node");
            System.out.println("[3] Display List");
            System.out.println("[4] Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter data for new node: ");
                    String data = scanner.nextLine();
                    Node newNode = new Node(data);
                    if (list.add(newNode)) {
                        System.out.println("Node with data '" + data + "' added.");
                    } else {
                        System.out.println("Failed to add node.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the position of the node to delete (0 to " + (list.counter - 1) + "): ");
                    int location = scanner.nextInt();
                    if (list.delete(location)) {
                        System.out.println("Node at position " + location + " deleted.");
                    } else {
                        System.out.println("Failed to delete node. Invalid position.");
                    }
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
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

    private static class Node {
        private String data;
        private Node next;
        private Node prev;

        public Node(String data) {
            this.data = data;
        }
    }
}

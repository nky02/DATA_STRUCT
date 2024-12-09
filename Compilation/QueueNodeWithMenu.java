import java.util.Scanner;

class QueueNode {
    Object value;
    QueueNode next;

    public QueueNode(Object value) {
        this.value = value;
        next = null;
    }
}

public class QueueNodeWithMenu {
    QueueNode first;
    QueueNode last;
    int count;

    public QueueNodeWithMenu() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public boolean enqueue(Object value) {
        QueueNode newNode = new QueueNode(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
        return true;
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
            count--;
            return true;
        } else
            return false;
    }

    public Object getFirst() {
        if (!isEmpty())
            return first.value;
        else
            return null;
    }

    public Object getLast() {
        if (!isEmpty())
            return last.value;
        else
            return null;
    }

    public void display() {
        if (!isEmpty()) {
            QueueNode temporary = first;
            while (temporary != null) {
                System.out.print("[" + temporary.value + "]->");
                temporary = temporary.next;
            }
            System.out.println();
        } else
            System.out.println("Queue is empty...");
    }

    public static void menu() {
        QueueNodeWithMenu qn = new QueueNodeWithMenu();
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Display first Element");
            System.out.println("5. Display last element");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    scan.nextLine();
                    String element = scan.nextLine();
                    if (qn.enqueue(element)) {
                        System.out.println("Element added to queue.");
                    } else {
                        System.out.println("Queue is full! Cannot enqueue.");
                    }
                    break;
                case 2:
                    if (qn.dequeue()) {
                        System.out.println("Element removed from queue.");
                    } else {
                        System.out.println("Queue is empty! Cannot dequeue.");
                    }
                    break;
                case 3:
                    System.out.println("Queue contents:");
                    qn.display();
                    break;
                case 4:
                    Object first = qn.getFirst();
                    if (first != null) {
                        System.out.println("First element: " + first);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 5:
                    Object last = qn.getLast();
                    if (last != null) {
                        System.out.println("Last element: " + last);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}

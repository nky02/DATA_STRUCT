import java.util.Scanner;

public class QueueArray {
    private Object[] items;
    private int count;

    public QueueArray(int size) {
        items = new Object[size];
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean enqueue(Object val) {
        if (!isFull()) {
            items[count++] = val;
            return true;
        }
        return false;
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            for (int i = 1; i < count; i++) {
                items[i - 1] = items[i];
            }
            items[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }

    public Object front() {
        if (!isEmpty()) {
            return items[0];
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < count; i++) {
                System.out.println("[" + items[i] + "]");
            }
            System.out.println(" ");
        } else {
            System.out.println("Queue is empty");
        }
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int size = scanner.nextInt();
        QueueArray queue = new QueueArray(size);

        int choice = 0;
        while (choice != 5) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Display Front Element");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    Object element = scanner.next();
                    if (queue.enqueue(element)) {
                        System.out.println("Element added to queue.");
                    } else {
                        System.out.println("Queue is full! Cannot enqueue.");
                    }
                    break;
                case 2:
                    if (queue.dequeue()) {
                        System.out.println("Element  dequeued.");
                    } else {
                        System.out.println("Queue is empty! Cannot dequeue.");
                    }
                    break;
                case 3:
                    System.out.println("Queue contents:");
                    queue.display();
                    break;
                case 4:
                    Object front = queue.front();
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
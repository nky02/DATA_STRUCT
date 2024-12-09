import java.util.Scanner;

public class Compilation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Program Menu ---");
            System.out.println("1. Find Largest Number");
            System.out.println("2. Odd and Even Numbers");
            System.out.println("3. Total Sum and Product");
            System.out.println("4. No Duplicates");
            System.out.println("5. Stack Array");
            System.out.println("6. Stack List");
            System.out.println("7. Node List");
            System.out.println("8. Queue Node");
            System.out.println("9. Queue Array");
            System.out.println("10. Infix to Postfix Conversion/Evaluation");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LargestNumber.main(new String[] {});
                    break;
                case 2:
                    OddandEvenNumbers.main(new String[] {});
                    break;
                case 3:
                    TotalSumAndProduct.main(new String[] {});
                    break;
                case 4:
                    NoDuplicateSeatwork.main(new String[] {});
                    break;
                case 5:
                    StackArrayMenu sa = new StackArrayMenu();
                    sa.menu();
                    break;
                case 6:
                    StackList sl = new StackList();
                    sl.menu();
                    break;
                case 7:
                    Nodelist list = new Nodelist();
                    list.menu();
                    break;
                case 8:
                    QueueNodeWithMenu qn = new QueueNodeWithMenu();
                    qn.menu();
                    break;
                case 9:
                    QueueArray.main(new String[] {});
                    break;
                case 10:
                    InfixToPostfix.main(new String[] {});
                    break;
                case 11:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}

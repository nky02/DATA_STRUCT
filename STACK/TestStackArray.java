
//my test class
import java.util.Scanner;

public class TestStackArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = scanner.nextInt();

        StackArrayMenu sa = new StackArrayMenu();
        sa.menu();
    }
}

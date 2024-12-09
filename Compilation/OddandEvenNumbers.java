import java.util.Scanner;

public class OddandEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] integerNum = new int[10];
        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Enter 10 integer numbers: ");
        for (int i = 0; i < 10; i++) {
            integerNum[i] = scan.nextInt();
        }

        for (int number : integerNum) {
            if (number % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        int[] evenNumbers = new int[evenCount];
        int[] oddNumbers = new int[oddCount];

        evenCount = 0;
        oddCount = 0;
        for (int number : integerNum) {
            if (number % 2 == 0) {
                evenNumbers[evenCount] = number;
                evenCount++;
            } else {
                oddNumbers[oddCount] = number;
                oddCount++;
            }
        }

        System.out.println("\nEven\t\tOdd");
        int maxCount = Math.max(evenCount, oddCount);
        for (int i = 0; i < maxCount; i++) {
            if (i < evenCount)
                System.out.print(evenNumbers[i]);
            else
                System.out.print("\t\t");

            if (i < oddCount)
                System.out.println("\t\t" + oddNumbers[i]);
            else
                System.out.println();
        }
    }
}

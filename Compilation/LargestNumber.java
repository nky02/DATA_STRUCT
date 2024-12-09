import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2, num3, largestNum;

        System.out.println("Enter three integer numbers: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        num3 = scan.nextInt();

        largestNum = num1;

        if (num2 > largestNum) {
            largestNum = num2;
        }

        if (num3 > largestNum) {
            largestNum = num3;
        }

        System.out.println("The largest number is: " + largestNum);

    }

}
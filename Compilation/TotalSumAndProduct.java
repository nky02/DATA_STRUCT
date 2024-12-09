import java.util.Scanner;

class TotalSumAndProduct {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int sum = 0;
      int product = 1;

      // Loop for taking 10 inputs
      for (int i = 0; i < 10; i++) {
         // Use a flag for input validation
         boolean validInput = false;

         while (!validInput) {
            try {
               System.out.print("Enter an integer: ");
               int integerNum = scan.nextInt();

               // Check if number is greater than 0
               if (integerNum > 0) {
                  sum += integerNum;
                  product *= integerNum;
                  validInput = true; // Set flag to true if input is valid
               } else {
                  System.out.println("Please enter a number greater than 0.");
               }

            } catch (Exception e) {
               System.out.println("Invalid input! Please enter a valid integer.");
               scan.nextLine(); // Clear the buffer
            }
         }
      }

      // Output the results
      System.out.println("Total Sum: " + sum);
      System.out.println("Total Product: " + product);
   }
}

package day2;

import java.util.Scanner;

public class CalculateFactorialThenSumOfItsDigits {
	public static void main(String args[]) {
		long number = 1L;
		System.out.println("This Code calculates the factorial, then produces the sum of its digits ");
		System.out.println("Please enter a number to calculate sum of digits of factorial. ");
		System.out.println("TO exit, enter 0");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println();

			System.out.print("Enter Number:");
			number = sc.nextLong(); // Remember number/10 reduces one digit from
									// number // and number%10 gives you last
									// digit
			int sum = 0;

			long i;
			long fact = 1;
			
			

			for (i = 1; i <= number; i++) {
				fact = fact * i;
			}
			System.out.println("Factorial of " + number + " is: " + fact);
			
			long tempVariable=fact;

			while (tempVariable != 0) {
				long lastdigit = tempVariable % 10; // Getting the last digit of the
											// number by getting a remainder
				sum += lastdigit;

				tempVariable /= 10;
			}
			System.out.printf("Sum of digits for number %d is %d", fact, sum);

		} while (number != 0);
		System.out.println();
		System.out.println("END OF PROGRAM");
		sc.close();
	}
}

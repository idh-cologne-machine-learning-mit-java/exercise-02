package de.ukoeln.idh.teaching.jml;

import java.util.Scanner;
import java.util.function.IntPredicate;

public class ATM {

	/**
	 * The bills available in the currency system (in this case: Euros)
	 */
	int[] bills = new int[] { 500, 200, 100, 50, 20, 10, 5 };

  IntPredicate check = i -> i % 5 == 0;

	/**
	 * Withdrawing logic.
	 * 
	 * @param amount The amount to withdraw
	 * @return An array of integers, showing how many of which bill to return (in
	 *         descending order)
	 */
	public int[] withdraw(int amount) {
		int[] numberOfBills = new int[bills.length];
		for (int b = 0; b < bills.length; b++) {
			int currentBill = bills[b];
			numberOfBills[b] = amount / currentBill;
			amount = amount - (numberOfBills[b] * currentBill);
		}
		if (amount == 0) {
			return numberOfBills;
		} else {
			throw new RuntimeException("Cannot withdraw");
		}

	}



	/**
	 * Main user loop. Allows users to enter an integer number or "exit" to leave
	 * the loop.
	 */
	public void run() {
		String userChoice;
		try (Scanner in = new Scanner(System.in)) {
			do {
				userChoice = in.next();
				if (userChoice.equalsIgnoreCase("exit")) {
					break;
				} else if (userChoice.matches("^\\d+$")) {
					try {
            if (! check.test(Integer.valueOf(userChoice))) {
						  int[] bills = withdraw(Integer.valueOf(userChoice));
						  System.out.println(join(bills));
            } else {
              throw new RuntimeException();
            }
					} catch (RuntimeException e) {
						System.err.println("Incorrect value");
					}
				} else {
					System.err.println("Incorrect value");
				}
				System.out.println();
			} while (in.hasNext());
		}
	}

	/**
	 * Helper method to generate a string representation from an integer array.
	 * Values are separated by comma
	 * 
	 * @param n The integer array
	 * @return A string
	 */
	public String join(int[] n) {
		if (n.length == 0)
			return "";

		StringBuffer b = new StringBuffer();
		b.append(n[0]);
		for (int i = 1; i < n.length; i++) {
			b.append(',').append(n[i]);
		}
		return b.toString();
	}

	public static void main(String[] args) {
		// create a new instance and launch it
		new ATM().run();
	}

}

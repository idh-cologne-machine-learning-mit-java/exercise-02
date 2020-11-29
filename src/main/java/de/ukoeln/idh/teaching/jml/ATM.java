package de.ukoeln.idh.teaching.jml;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.IntPredicate;


public class ATM {
	/**
	 * The bills available in the currency system (in this case: Euros)
	 */
	int[] bills = new int[] { 500, 200, 100, 50, 20, 10, 5 };

	private IntPredicate check = i -> i % 5 == 0;

	/**
	 * Withdrawing logic.
	 * 
	 * @param amount The amount to withdraw
	 * @return An array of integers, showing how many of which bill to return (in
	 *         descending order)
	 */
	public int[] withdraw(int amount) {

		if (!check.test(amount))
			throw new RuntimeException("Cannot withdraw");

		int[] numberOfBills = new int[bills.length];
		for (int b = 0; b < bills.length; b++) {
			int currentBill = bills[b];
			numberOfBills[b] = amount / currentBill;
			amount = amount - (numberOfBills[b] * currentBill);
		}
		return numberOfBills;
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
				} else if (userChoice.matches("\\d+$")) {
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

	public String toNotes (int [] numOfBills) {
		String bills = "";
		for (int i = 0; i < numOfBills.length; i++ ) {
			bills += numOfBills[i] > 0 ? numOfBills[i]+ "x" + this.bills[i] + ", " : "";
		}
		return bills;

	}

	private String join(int [] n) {
		return StringUtils.join(n, ',');
	}

	public static void main(String[] args) {
		// create a new instance and launch it
		new ATM().run();
	}

}

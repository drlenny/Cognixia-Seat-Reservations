package com.cognixia.jump.miniproject.seatreservation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeatReservationsDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean makeReservation = true;

		Scanner scan = new Scanner(System.in);
		String seatRegex = "[0-4]";
		String continueRegex = "(y|Y)";
		String exitRegex = "(n|N)";

		// regex pattern
		Pattern patternSeat = Pattern.compile(seatRegex);
		Pattern patternContinue = Pattern.compile(continueRegex);
		Pattern patternExit = Pattern.compile(exitRegex);

		Integer rowSelected;
		Integer columnSelected;
		String nameSubmitted;
		CharSequence reservingComplete;

		// matcher created with pattern and string
		Matcher rowMatcher;
		Matcher columnMatcher;
		Matcher continueMatcher;
		Matcher exitMatcher;

		int rowNumber;
		char seats[][] = { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } };

		while (makeReservation) {
			System.out.println("\n==================");
			System.out.println("SEATS");
			System.out.println("==================\n");

			System.out.printf("%13s %n", "1 2 3 4 5");
			System.out.printf("%13s %n", "----------");

			// print array
			rowNumber = 1;
			for (int row = 0; row < seats.length; row++) {

				System.out.print(rowNumber + " | ");

				for (int col = 0; col < seats[row].length; col++) {

					System.out.print(seats[row][col] + " ");
				}
				// print new line to separate each row when printing to screen
				System.out.println();
				rowNumber++;
			}

			System.out.println("\nWhich seat do you want to reserve?");

			System.out.println("Row: ");
			rowSelected = scan.nextInt() - 1;

			System.out.println("Column: ");
			columnSelected = scan.nextInt() - 1;

			System.out.println("Name of reservee: ");
			nameSubmitted = scan.next();

			rowMatcher = patternSeat.matcher(rowSelected.toString());
			columnMatcher = patternSeat.matcher(columnSelected.toString());

			if (rowMatcher.matches() && columnMatcher.matches()) {

//		System.out.println("You entered: " + rowSelected + " " + columnSelected + " " + nameSubmitted);

				// Checks if seat is already reserved
				if (seats[rowSelected][columnSelected] != 'x') {

					// create class
					SeatReservations seatReserved = new SeatReservations(rowSelected, columnSelected, nameSubmitted);

					System.out.println("\n==================");
					System.out.println("SEATS");
					System.out.println("==================\n");

					System.out.printf("%13s %n", "1 2 3 4 5");
					System.out.printf("%13s %n", "----------");

					// print array
					rowNumber = 1;
					for (int row = 0; row < seats.length; row++) {

						System.out.print(rowNumber + " | ");

						for (int col = 0; col < seats[row].length; col++) {

							if ((row == rowSelected) && (col == columnSelected)) {
								seats[rowSelected][columnSelected] = 'x';
							}

							System.out.print(seats[row][col] + " ");
						}
						// print new line to separate each row when printing to screen
						System.out.println();
						rowNumber++;
					}

					// displays reserved seat info
					System.out.println(seatReserved);

				} else {
					System.out.println("-- SEAT ALREADY RESERVED --");
				}
			} else {
				System.out.println("-- INVALID ENTRY --");
			}

			boolean requestComplete = true;

			// accepts any input that isnt y or Y should maybe tweak functionality

			while (requestComplete) {
				System.out.println("\nAre you finished reserving seats? (Y/N)");
				reservingComplete = scan.next();
				continueMatcher = patternContinue.matcher(reservingComplete);
				exitMatcher = patternExit.matcher(reservingComplete);
				if (continueMatcher.matches()) {
					makeReservation = false;
					requestComplete = false;
				} else if (exitMatcher.matches()) {
					requestComplete = false;
				} else {
					System.out.println("\nInvalid response, try again");
				}
			}
		}
		System.out.println("\nEnjoy your movie!");
		scan.close();
	}
}

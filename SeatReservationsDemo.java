package com.cognixia.jump.miniproject.seatreservation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeatReservationsDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Add class
		SeatReservations seatReservations = new SeatReservations(1);

		boolean makeReservation = true;

		Scanner scan = new Scanner(System.in);
		String seatRegex = "[0-4]";
		String continueRegex = "(y|Y)";
		String exitRegex = "(n|N)";

		// regex pattern
		Pattern patternSeat = Pattern.compile(seatRegex);
		Pattern patternContinue = Pattern.compile(continueRegex);
		Pattern patternExit = Pattern.compile(exitRegex);

		Integer rowSelected = null;
		Integer columnSelected = null;
		String nameSubmitted;
		CharSequence reservingComplete;

		// matcher created with pattern and string
		Matcher rowMatcher;
		Matcher columnMatcher;
		Matcher continueMatcher;
		Matcher exitMatcher;

		while (makeReservation) {

			// displays seating
			seatReservations.displaySeating();

			// =========== requesting user data ============
			System.out.println("\nWhich seat do you want to reserve?");

			boolean checkRowError = true;
			while (checkRowError) {
				try {
					System.out.println("Row: ");
					rowSelected = scan.nextInt();
					checkRowError = false;
				} catch (InputMismatchException exception) {
					System.out.println("Please enter a row number");
					scan.next();
					checkRowError = true;
				}
			}
			
			boolean checkColumnError = true;
			while(checkColumnError) {
				try {
			System.out.println("Column: ");
			columnSelected = scan.nextInt();
			checkColumnError = false;
				} catch (InputMismatchException exception) {
					System.out.println("Please enter a column number");
					scan.next();
					checkColumnError = true;
				}
			}

			System.out.println("Name of reservee: ");
			nameSubmitted = scan.next();

			rowMatcher = patternSeat.matcher(rowSelected.toString());
			columnMatcher = patternSeat.matcher(columnSelected.toString());

			if (rowMatcher.matches() && columnMatcher.matches()) {
				if (seatReservations.checkSeating(rowSelected, columnSelected) == false) {
					seatReservations.addUser(new ReservedSeat(rowSelected, columnSelected, nameSubmitted));
					// displays seating
					seatReservations.displaySeating();
				} else {
					// displays seating
					seatReservations.displaySeating();
					System.out.println("\n-- SEAT ALREADY RESERVED --");
				}
			} else {
				System.out.println("\n-- INVALID ENTRY --");
			}

			seatReservations.listUsers();

			// Checks if user is done with reservations
			boolean requestComplete = true;
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

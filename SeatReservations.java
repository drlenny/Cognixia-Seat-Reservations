package com.cognixia.jump.miniproject.seatreservation;

public class SeatReservations {

	// Attributes
	private static int rowNumber = 1;
	private static char seats[][] = { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
			{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } };

	private boolean occupied;

//	private ReservedSeat[] reservedSeats;
	
	// Default Constructor
	public SeatReservations() {
		super();
		this.occupied = false;
	}
	
	// Constructor with arguments
	public SeatReservations(boolean occupied) {
		super();
		this.occupied = occupied;
	}
	
	
	/**
	 * @return the occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * @param occupied the occupied to set
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void displaySeating () {
		
		System.out.println("\n==================");
		System.out.println("SEATS");
		System.out.println("==================\n");

		System.out.printf("%13s %n", "1 2 3 4 5");
		System.out.printf("%13s %n", "----------");

		// print array
		for (int row = 0; row < seats.length; row++) {

			System.out.print(rowNumber + " | ");

			for (int col = 0; col < seats[row].length; col++) {

				System.out.print(seats[row][col] + " ");
			}
			// print new line to separate each row when printing to screen
			System.out.println();
			rowNumber++;
		}
	}

}

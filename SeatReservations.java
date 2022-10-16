package com.cognixia.jump.miniproject.seatreservation;

public class SeatReservations {

	// Attributes
	
	
	private char seats[][];

	private int rowNumber;
	private int audienceSize; // only generate getter for size
	
	private ReservedSeat[] reservedSeats;
	
	//  Constructor
	public SeatReservations(int rowNumber) {
		super();
		this.reservedSeats = new ReservedSeat[25];
		this.seats = new char[5][5];
		this.rowNumber = rowNumber;

	}

	/**
	 * @return the seats
	 */
	public char[][] getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(char[][] seats) {
		this.seats = seats;
	}

	/**
	 * @return the reservedSeats
	 */
	public ReservedSeat[] getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(ReservedSeat[] reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * @return the rowNumber
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	/**
	 * @return the audienceSize
	 */
	public int getAudienceSize() {
		return audienceSize;
	}

	// Get, Add, and Delete Reservation
	// created so we don't need to keep adding for loops
	// each time we do our get, add, and delete
	private int indexOfUser(int id) {
		
		for(int s = 0; s < reservedSeats.length; s++) {
			
			if(reservedSeats[s] == null) { // check first not null
				continue;
			}
			else if(reservedSeats[s].getUserId() == id) {
				return s;
			}
		}
		
		return -1; // default if no user found		
	}
	
	// determines if requested seat is already reserved
	boolean checkSeating(int selectedRow, int selectedColumn) {
		
		for (int i = 0; i < reservedSeats.length; i++) {
			if(reservedSeats[i] == null) {
				continue;
			}
			else if(reservedSeats[i].getRowNumber() == selectedRow && reservedSeats[i].getColumnNumber() == selectedColumn) {
				return true;
			}
		}
		
		return false;
	}
	
	// get user
		public ReservedSeat getUser(int id) {
			
			int index = indexOfUser(id); // finds index where user is
			
			if(index != -1) {
				return reservedSeats[index]; // returns user
			}
			
			return null; // returns null for not found if index is -1
		}
		

		// add new user
		public ReservedSeat addUser(ReservedSeat newUser) {

			if(checkSeating(newUser.getRowNumber(), newUser.getColumnNumber()) == true) { // if seat already reserved don't add
				return null;
			}
			if (getUser(newUser.getUserId()) == null) { // as long as new user isn't in audience already...

				for (int s = 0; s < reservedSeats.length; s++) {

					if (reservedSeats[s] == null) { // ...add new user where there is a blank spot open
						reservedSeats[s] = newUser;
						audienceSize++;
						return newUser;
					}
				}
			}
			
			return null;
		}
		
		// delete user
		public ReservedSeat removeUser(int id) {
			
			int index = indexOfUser(id);
			
			if(index != -1) {
				ReservedSeat temp = reservedSeats[index];
				reservedSeats[index] = null; // remove user if found
				audienceSize--;
				return temp; // return user removed
			}
			
			return null; // return null if not removed
		}
		
		// print users in audience
		public void listUsers() {
			
			if(audienceSize == 0) {
				System.out.println("\nNo audience members");
			}
			else {
				System.out.println();
				for (ReservedSeat s : reservedSeats) {

					if (s != null) {
						System.out.println(s);
					} 
				}
			}
		}
	
	// Displays Seating
	public void displaySeating () {
		
		System.out.println("\n==================");
		System.out.println("SEATS");
		System.out.println("==================\n");

		System.out.printf("%13s %n", "1 2 3 4 5");
		System.out.printf("%13s %n", "----------");

		// print array
		for (int row = 0; row < seats.length; row++) {
			
			if (rowNumber < 0 || rowNumber > 5) {
				rowNumber = 1;
			}

			System.out.print(rowNumber + " | ");

			for (int col = 0; col < seats[row].length; col++) {
				
				for (ReservedSeat s : reservedSeats) {

					if (checkSeating((row + 1), (col + 1)) == true) {
						seats[row][col] = 'x';
					} else {
						seats[row][col] = 'o';
					}
				}
				System.out.print(seats[row][col] + " ");

			}

			// print new line to separate each row when printing to screen
			System.out.println();
			rowNumber++;
		}
		
	}

}

package com.cognixia.jump.miniproject.seatreservation;

public class ReservedSeat {
	
	private static int idCounter = 1; // keep track of ids for students

	// Attributes
	private int userId; // used to identify each user
	private Integer rowNumber;
	private Integer columnNumber;
	private String nameSubmitted;


//	// Default Constructor
//	public ReservedSeat() {
//		super();
//		this.rowNumber = -1;
//		this.columnNumber = -1;
//		this.nameSubmitted = "Unoccupied";
//	}

	// Constructor with Arguments
	public ReservedSeat(Integer rowNumber, Integer columnNumber, String nameSubmitted) {
		super();
		this.userId = idCounter++; // don't pass in an id, generate it with the idCounter
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.nameSubmitted = nameSubmitted;

	}

	// Getters and Setters
	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	public String getNameSubmitted() {
		return nameSubmitted;
	}

	public void setNameSubmitted(String nameSubmitted) {
		this.nameSubmitted = nameSubmitted;
	}
	
	// only generate a getter for user ID, don't 
	// want to change value once set
	public int getUserId() {
		return userId;
	}


	@Override
	public String toString() {
		return "ReservedSeat [userId=" + userId + ", rowNumber=" + rowNumber + ", columnNumber=" + columnNumber
				+ ", nameSubmitted=" + nameSubmitted + "]";
	}

}

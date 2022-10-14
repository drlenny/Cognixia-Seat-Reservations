package com.cognixia.jump.miniproject.seatreservation;

public class SeatReservations {

	// Attributes
	private Integer rowNumber;
	private Integer columnNumber;
	private String nameSubmitted;

	// Default Constructor
	public SeatReservations() {
		super();
		this.rowNumber = -1;
		this.columnNumber = -1;
		this.nameSubmitted = "Unoccupied";
	}

	// Constructor with Arguments
	public SeatReservations(Integer rowNumber, Integer columnNumber, String nameSubmitted) {
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

	// Methods
	@Override
	public String toString() {
		return "SeatReservations [rowNumber=" + rowNumber + ", columnNumber=" + columnNumber + ", nameSubmitted="
				+ nameSubmitted + "]";
	}

}

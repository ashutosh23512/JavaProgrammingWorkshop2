package com.hotelreservation.dto;

public class Hotel {

	private String hotelName;
	private int RegularCustomerRate;

	public Hotel(String hotelName, int RegularCustomerRate) {
		this.hotelName = hotelName;
		this.RegularCustomerRate = RegularCustomerRate;
	}

	public Hotel() {
	}

	public void setName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getName() {
		return this.hotelName;
	}

	public void setCustomerRate(int hotelRateRegularCustomer) {
		this.RegularCustomerRate = hotelRateRegularCustomer;
	}

	public int getRegularCustomerRate() {
		return this.RegularCustomerRate;
	}

	@Override
	public String toString() {
		return ("Hotel: " + getName() + " Rate: " + getRegularCustomerRate() + "\n");
	}

}

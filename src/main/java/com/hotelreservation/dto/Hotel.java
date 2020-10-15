package com.hotelreservation.dto;

public class Hotel {

	private String hotelName;
	private int RegularCustomerRate;
	private int RegularCustomerRateWeekend;
	private int rating;

	public Hotel(String hotelName, int RegularCustomerRate, int RegularCustomerRateWeekend, int rating) {
		this.hotelName = hotelName;
		this.RegularCustomerRate = RegularCustomerRate;
		this.RegularCustomerRateWeekend = RegularCustomerRateWeekend;
		this.rating = rating;
	}

	public Hotel() {
	}

	public void setName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getName() {
		return this.hotelName;
	}

	public void setCustomerRate(int hotelRateRegularCustomer, int hotelRateRegularCustomerWeekend) {
		this.RegularCustomerRate = hotelRateRegularCustomer;
		this.RegularCustomerRateWeekend = RegularCustomerRateWeekend;
	}

	public int getRegularCustomerRate() {
		return this.RegularCustomerRate;
	}

	public int getRegularCustomerRateWeekend() {
		return this.RegularCustomerRateWeekend;
	}

	public int getRating() {
		return this.rating;
	}

	@Override
	public String toString() {
		return ("Hotel: " + getName() + " Weekday Rate: " + getRegularCustomerRate() + " Weekend Rate: "
				+ getRegularCustomerRateWeekend() + "Rating: " + getRating() + "\n");
	}

}

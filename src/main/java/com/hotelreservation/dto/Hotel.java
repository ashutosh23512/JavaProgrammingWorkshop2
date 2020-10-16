package com.hotelreservation.dto;

public class Hotel {

	private String hotelName;
	private int RegularCustomerRate;
	private int RegularCustomerRateWeekend;
	private int rating;
	private int RewardCustomerRate;
	private int RewardCustomerRateWeekend;

	public Hotel(String hotelName, int RegularCustomerRate, int RegularCustomerRateWeekend, int RewardCustomerRate,
			int RewardCustomerRateWeekend, int rating) {
		this.hotelName = hotelName;
		this.RegularCustomerRate = RegularCustomerRate;
		this.RegularCustomerRateWeekend = RegularCustomerRateWeekend;
		this.RewardCustomerRate = RewardCustomerRate;
		this.RewardCustomerRateWeekend = RewardCustomerRateWeekend;
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

	public int getRewardCustomerRate() {
		return this.RewardCustomerRate;
	}

	public int getRewardCustomerRateWeekend() {
		return this.RewardCustomerRateWeekend;
	}

	@Override
	public String toString() {
		return ("Hotel: " + getName() + " Regular Customer Weekday Rate: " + getRegularCustomerRate()
				+ " Regular Customer Weekend Rate: " + getRegularCustomerRateWeekend()
				+ " Reward Customer Weekday Rate: " + getRewardCustomerRate() + " Reward Customer Weekend Rate: "
				+ getRewardCustomerRateWeekend() + " Rating: " + getRating() + "\n");
	}

}

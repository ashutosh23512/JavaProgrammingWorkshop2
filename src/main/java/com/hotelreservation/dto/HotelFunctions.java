package com.hotelreservation.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class HotelFunctions {

	public static List<Hotel> hotelList = new ArrayList<>();
	public static List<Integer> totalPrice = new ArrayList<>();
	Hotel h1 = new Hotel();

	public static void addHotel(String hotelName, int RegularCustomerRate,int RegularCustomerRateWeekend) {
		Hotel h = new Hotel(hotelName, RegularCustomerRate, RegularCustomerRateWeekend);
		hotelList.add(h);
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}

	public static void getcheapest(String range) throws Exception {
		String[] dates = range.split(",");

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");

		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int totaldays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);

		for (Hotel x : hotelList) {
			totalPrice.add(totaldays * x.getRegularCustomerRate());
		}

		Collections.sort(totalPrice);
		System.out.println("The Cheapest Hotel is: " + hotelList.get(0).getName() + " at: " + totalPrice.get(0)
				+ "$ for " + totaldays + " days.");

	}
}

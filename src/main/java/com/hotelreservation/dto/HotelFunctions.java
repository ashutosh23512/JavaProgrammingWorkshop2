package com.hotelreservation.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class HotelFunctions {

	public static List<Hotel> hotelList = new ArrayList<>();
	public static Map<String, Float> priceList = new TreeMap<>();

	Hotel h1 = new Hotel();

	public static void addHotel(String hotelName, int RegularCustomerRate, int RegularCustomerRateWeekend) {
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
		Map<String, Integer> list = new HashMap<>();
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int totaldays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int min = Integer.MAX_VALUE;
		String s = null;
		for (Hotel j : hotelList) {
			int price = 0;
			int start = checkin.getDay();
			for (int i = 0; i < totaldays; i++) {
				if (start == 0 || start == 6) {
					price += j.getRegularCustomerRateWeekend();
				} else {
					price += j.getRegularCustomerRate();
				}
				start = (start + 1) % 7;
			}
			if (min > price) {
				min = price;
			}
			list.put(j.getName(), price);
		}
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getValue() == min) {
				System.out.print("Cheapest Hotel is: " + entry.getKey());
			}
		}
		System.out.print(" with price $" + min + "\n");
	}
}

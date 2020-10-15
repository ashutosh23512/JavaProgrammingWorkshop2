package com.hotelreservation.dto;

import java.util.*;

public class HotelFunctions {

	public static List<Hotel> hotelList = new ArrayList<>();
	Hotel h1 = new Hotel();

	public static void addHotel(String hotelName, int RegularCustomerRate) {
		Hotel h = new Hotel(hotelName, RegularCustomerRate);
		hotelList.add(h);
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}
}

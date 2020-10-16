package com.hotelreservation.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class HotelFunctions {

	public static List<Hotel> hotelList = new ArrayList<>();
	public static Map<String, Float> priceList = new TreeMap<>();

	Hotel h1 = new Hotel();

	public static void addHotel(String hotelName, int RegularCustomerRate, int RegularCustomerRateWeekend, int rating) {
		Hotel h = new Hotel(hotelName, RegularCustomerRate, RegularCustomerRateWeekend, rating);
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
		Map<String, Integer> Maplist = new HashMap<>();
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int totaldays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int min = Integer.MAX_VALUE;
		Map<String, Integer> list = new HashMap<>();
		Map<String,Integer> byRating = new HashMap<>();

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
			byRating.put(j.getName(), j.getRating());
			
		}
		List<String> finalHotel = new ArrayList<>();
		int minRate = -1;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getValue() == min) {
				for(Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if(entry1.getValue()>minRate && entry1.getKey().equals(entry.getKey())) {
						minRate = entry1.getValue();
						if(finalHotel.size() == 0)	finalHotel.add(entry1.getKey());
						else finalHotel.set(0, entry1.getKey());
					}
				}
			}
		}
		int finalRating = 0, finalPrice = 0;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getKey().equals(finalHotel.get(0))) {
				finalPrice = entry.getValue();
				for(Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if(entry1.getKey().equals(finalHotel.get(0))) {
						finalRating  = entry1.getValue();
					}
				}
			}
		}
		System.out.print(finalHotel.get(0)+","+" Rating: "+finalRating+" Total Rates:$"+finalPrice+"\n");
	}}

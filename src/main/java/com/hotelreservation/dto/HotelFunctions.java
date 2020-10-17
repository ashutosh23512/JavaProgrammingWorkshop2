package com.hotelreservation.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class HotelFunctions {

	public static List<Hotel> hotelList = new ArrayList<>();
	public static Map<String, Float> priceList = new TreeMap<>();

	Hotel h1 = new Hotel();

	public static void addHotel(String hotelName, int RegularCustomerRate, int RegularCustomerRateWeekend,
			int RewardCustomerRate, int RewardCustomerRateWeekend, int rating) {
		Hotel h = new Hotel(hotelName, RegularCustomerRate, RegularCustomerRateWeekend, RewardCustomerRate,
				RewardCustomerRateWeekend, rating);
		hotelList.add(h);
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}

	public static int getcheapestreward(Hotel hotel, String range) throws Exception {
		String[] dates = range.split(",");

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int totaldays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);

		int price = 0;
		int start = checkin.getDay();
		for (int i = 0; i < totaldays; i++) {
			if (start == 0 || start == 6) {
				price += hotel.getRewardCustomerRateWeekend();
			} else {
				price += hotel.getRewardCustomerRate();
			}
			start = (start + 1) % 7;
		}

		return price;
	}

	public static void getCheapestBestRatedHotelReward(String range) throws Exception {
		Hotel cheapestHotel = hotelList.stream().min((hotel1, hotel2) -> {
			try {
				return getcheapestreward(hotel1, range) > getcheapestreward(hotel2, range) ? 1 : -1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}).get();

		Hotel cheapestBestRatedHotel = hotelList.stream().filter(hotel -> {
			try {
				return getcheapestreward(hotel, range) == getcheapestreward(cheapestHotel, range);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).max((hotel1, hotel2) -> hotel1.getRating() > hotel2.getRating() ? 1 : -1).get();
		System.out.println(cheapestBestRatedHotel.getName() + " Rating: " + cheapestBestRatedHotel.getRating()
				+ " and Total rates: $" + getcheapestreward(cheapestBestRatedHotel, range));
	}

	public void getbest(String range1) throws ParseException {
		String[] range = range1.split(",");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date checkin = (Date) dateFormat.parse(range[0]);
		Date checkout = (Date) dateFormat.parse(range[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int noOfDays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int day = checkin.getDay();
		Map<String, Integer> list = new HashMap<>();
		Map<String, Integer> byRating = new HashMap<>();
		for (Hotel k : hotelList) {
			int price = 0;
			int tempDay = day;
			for (int i = 0; i < noOfDays; i++) {
				if (tempDay == 0 || tempDay == 6) {
					price += k.getRegularCustomerRateWeekend();
				} else {
					price += k.getRegularCustomerRate();
				}
				tempDay = (tempDay + 1) % 7;
			}
			list.put(k.getName(), price);
			byRating.put(k.getName(), k.getRating());
		}
		List<String> finalHotel = new ArrayList<>();
		int minRate = -1;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
				if (entry1.getValue() > minRate && entry1.getKey().equals(entry.getKey())) {
					minRate = entry1.getValue();
					if (finalHotel.size() == 0)
						finalHotel.add(entry1.getKey());
					else
						finalHotel.set(0, entry1.getKey());
				}
			}
		}
		int finalRating = 0, finalPrice = 0;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getKey().equals(finalHotel.get(0))) {
				finalPrice = entry.getValue();
				for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if (entry1.getKey().equals(finalHotel.get(0))) {
						finalRating = entry1.getValue();
					}
				}
			}
		}
		System.out.print(finalHotel.get(0) + " & Total Rates $" + finalPrice + "\n");

	}

	public static int getcheapestregular(Hotel hotel, String range) throws Exception {
		String[] dates = range.split(",");

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		Map<String, Integer> Maplist = new HashMap<>();
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int totaldays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int min = Integer.MAX_VALUE;

		int price = 0;
		int start = checkin.getDay();
		for (int i = 0; i < totaldays; i++) {
			if (start == 0 || start == 6) {
				price += hotel.getRegularCustomerRateWeekend();
			} else {
				price += hotel.getRegularCustomerRate();
			}
			start = (start + 1) % 7;
		}

		return price;
	}

	public static void getCheapestBestRatedHotelRegular(String range) throws Exception {
		Hotel cheapestHotel = hotelList.stream().min((hotel1, hotel2) -> {
			try {
				return getcheapestregular(hotel1, range) > getcheapestregular(hotel2, range) ? 1 : -1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}).get();

		Hotel cheapestBestRatedHotel = hotelList.stream().filter(hotel -> {
			try {
				return getcheapestregular(hotel, range) == getcheapestregular(cheapestHotel, range);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).max((hotel1, hotel2) -> hotel1.getRating() > hotel2.getRating() ? 1 : -1).get();
		System.out.println(cheapestBestRatedHotel.getName() + " Rating: " + cheapestBestRatedHotel.getRating()
				+ " and Total rates: $" + getcheapestregular(cheapestBestRatedHotel, range));
	}

}

package com.hotelvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelValidation {
	private final String hotel_name = "^[A-Z]{1}[a-z A-Z]{2,}$";
	private final String datecheck = "^[0-9]{2}[a-z A-Z]{3}[0-9]{4}$";

	private boolean validate(String string, String field) {
		boolean matched = false;
		Pattern pattern = Pattern.compile(field);
		Matcher matcher = pattern.matcher(string);
		matched = matcher.find();
		return matched;
	}

	public boolean validateHotelName(String hotelName) {
		return validate(hotelName, hotel_name);
	}



	public boolean validatedate(String date) {
		return validate(date, datecheck);
	}

}

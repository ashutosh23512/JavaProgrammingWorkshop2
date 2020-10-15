package com.hotelreservation;

import java.util.Date;
import com.hotelreservation.dto.*;
import com.hotelvalidation.HotelValidation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Hotel Reservation Program");
		System.out.println();

		HotelFunctions hlist = new HotelFunctions();
		HotelValidation valid = new HotelValidation();

		while (true) {

			System.out.println("Press 1 to add hotel");
			System.out.println("Press 2 to get cheapest hotel");
			System.out.println("Press 3 to exit");
			Scanner s = new Scanner(System.in);
			int options = s.nextInt();
			switch (options) {

			case 1:

				System.out.println("Enter Hotel Name");
				String hotelName = s.next();
				boolean isValid = valid.validateHotelName(hotelName);

				while (!isValid) {
					System.out.println("Invalid hotel name");
					hotelName = s.next();
					isValid = valid.validateHotelName(hotelName);
				}
				System.out.println("Enter Weekday Hotel Rate for Regular Customer");
				int RegularCustomerRate = s.nextInt();
				System.out.println("Enter Weekend Hotel Rate for Regular Customer");
				int RegularCustomerRateWeekend = s.nextInt();
				hlist.addHotel(hotelName, RegularCustomerRate, RegularCustomerRateWeekend);
				System.out.println("Hotel Added Successfully");
				System.out.println(hlist);
				System.out.println();

				break;

			case 2:
				System.out.println("Enter the range of dates separated by commas (DDMMMYYYY)");
				String Range = s.next();
				hlist.getcheapest(Range);
				break;

			case 3:
				System.out.println("Good Bye");
				return;

			default:
				break;

			}
		}

	}

}

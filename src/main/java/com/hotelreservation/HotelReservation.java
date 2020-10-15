package com.hotelreservation;

import com.hotelreservation.dto.*;
import com.hotelvalidation.HotelValidation;

import java.util.*;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");
		System.out.println();

		HotelFunctions hlist = new HotelFunctions();
		HotelValidation valid = new HotelValidation();

		while (true) {

			System.out.println("Press 1 to add hotel");
			System.out.println("Press 2 to exit");
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
				System.out.println("Enter Hotel Rate for Regular Customer");
				int RegularCustomerRate = s.nextInt();
				hlist.addHotel(hotelName, RegularCustomerRate);
				System.out.println("Hotel Added Successfully");
				System.out.println(hlist);
				System.out.println();

				break;

			case 2:
				System.out.println("Good Bye");
				return;

			default:
				break;

			}
		}

	}

}

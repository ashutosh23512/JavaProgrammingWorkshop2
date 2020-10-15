package com.hotelreservation;

import org.junit.Assert;
import org.junit.Test;

import com.hotelvalidation.HotelValidation;

public class HotelReservationTest {
	@Test
	public void givenHotelNameValidReturnTrue() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validateHotelName("Lakewood");
		Assert.assertEquals(result, true);

	}

	@Test
	public void givenHotelNameInValidReturnFalse() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validateHotelName("lakewood");
		Assert.assertEquals(result, false);

	}

	@Test
	public void givendateInValidReturnTrue() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validatedate("02JAN2020");
		Assert.assertEquals(true,result);

	}

	@Test
	public void givendateInValidReturnFalse() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validatedate("0QTAN2020");
		Assert.assertEquals(false, result);

	}

}

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

}

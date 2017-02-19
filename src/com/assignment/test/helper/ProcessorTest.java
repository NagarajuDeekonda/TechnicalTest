package com.assignment.test.helper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.assignment.helper.UtilDate;

public class ProcessorTest {
	
	@Test
	public void checkIfDateFallsOnWeekend(){
		Date date = new Date("02/12/2017");
		assertEquals(UtilDate.isWorkWeekForCurrency("USD", date),true);
	}
}

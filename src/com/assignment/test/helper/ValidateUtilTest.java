package com.assignment.test.helper;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assignment.enums.TradeType;
import com.assignment.exceptionHandling.*;
import com.assignment.helper.ValidateUtil;
import com.assignment.object.Entity;

public class ValidateUtilTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	Entity entity = new Entity();
	@Before
	public void setUp(){
		entity.setEntityName("BAR");
		entity.setTradeIndicator(TradeType.SELL);
		entity.setCurrency("EUR");
		entity.setAgreedFx(new BigDecimal("0.22"));
		entity.setPricePerUnit(new BigDecimal("150.5"));
		entity.setUnits(450L);
		entity.setInstructionDate(new Date("05/01/2000"));
		entity.setSettlementDate(new Date("02/11/2017"));
	}
	
	@Test(expected = EntityException.class)
	public void checkForEmptyName() {
		entity.setEntityName("");
		ValidateUtil util = new ValidateUtil();
		util.validate(entity);
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Trade is empty");
	}
	
}

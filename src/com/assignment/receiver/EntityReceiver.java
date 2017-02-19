package com.assignment.receiver;

import java.math.BigDecimal;
import java.util.Date;

import com.assignment.enums.TradeType;
import com.assignment.helper.EveryDayTradeProcessor;
import com.assignment.helper.MessageProcessor;
import com.assignment.helper.Report;
import com.assignment.object.Entity;
import com.assignment.processor.Processor;

public class EntityReceiver {
	public static void main(String args[]){
		Entity entity = new Entity();
		entity.setEntityName("SAR");
		entity.setTradeIndicator(TradeType.BUY);
		entity.setCurrency("SAR");
		entity.setAgreedFx(new BigDecimal("5.00"));
		entity.setPricePerUnit(new BigDecimal("2.5"));
		entity.setUnits(100L);
		entity.setInstructionDate(new Date("11/10/2000"));
		entity.setSettlementDate(new Date("02/11/2017"));
		
		Entity entity1 = new Entity();
		entity1.setEntityName("FOO");
		entity1.setTradeIndicator(TradeType.BUY);
		entity1.setCurrency("SAR");
		entity1.setAgreedFx(new BigDecimal("0.50"));
		entity1.setPricePerUnit(new BigDecimal("100.25"));
		entity1.setUnits(100L);
		entity1.setInstructionDate(new Date("01/01/2000"));
		entity1.setSettlementDate(new Date("02/01/2016"));
		
		Entity entity2 = new Entity();
		entity2.setEntityName("BAR");
		entity2.setTradeIndicator(TradeType.SELL);
		entity2.setCurrency("SAR");
		entity2.setAgreedFx(new BigDecimal("0.22"));
		entity2.setPricePerUnit(new BigDecimal("150.5"));
		entity2.setUnits(100L);
		entity2.setInstructionDate(new Date("11/10/2000"));
		entity2.setSettlementDate(new Date("07/01/2016"));
		
		Processor processor =   Processor.newProcessor();
		processor.process(entity);
		EveryDayTradeProcessor process = EveryDayTradeProcessor.getInstance();
		process.process(entity);
		
		processor.process(entity1);
		process.process(entity1);
		
		processor.process(entity2);
		process.process(entity2);
		Processor reportProcessor = new Report();
		reportProcessor.process(entity1);
	}
}

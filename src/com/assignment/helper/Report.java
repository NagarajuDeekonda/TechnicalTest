package com.assignment.helper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map.Entry;

import com.assignment.object.Entity;
import com.assignment.processor.Processor;
import com.assignment.storage.MessageStore;

public class Report implements Processor {
	public void process(Entity entity){
		EveryDayTradeProcessor everyDayProcessor = EveryDayTradeProcessor.getInstance();
		System.out.println("-----------------------------------INCOMING TRADE MESSAGES------------------------------------");
		for(int i=0 ; i < MessageStore.incomingEntities.size() ; i++){
			Entity incomingEntity = MessageStore.incomingEntities.get(i);
			System.out.println("Rank "+ (int)(i+1) + "   Name:"+incomingEntity.getEntityName()+"   Amount Settle In USD:"+incomingEntity.getPriceInUSD());
		}
		System.out.println("-----------------------------------OUTGOING TRADE MESSAGES------------------------------------");
		for(int i=0 ; i < MessageStore.outgoingEntities.size() ; i++){
			Entity outgoingEntity = MessageStore.outgoingEntities.get(i);
			System.out.println("Rank "+ (int)(i+1) + "   Name:"+outgoingEntity.getEntityName()+"   Amount Settle In USD:"+outgoingEntity.getPriceInUSD());
		}
		System.out.println("-----------------------------------OUTGOING TRADE MESSAGES EVERYDAY SETTLEMENT------------------------------------");
		for(Entry<Date, BigDecimal> entry : everyDayProcessor.getTodaysOutgoingAggregate().entrySet()){
			System.out.println("Date:"+entry.getKey()+"--------------"+"Amount Settled:"+entry.getValue());
		}
		System.out.println("-----------------------------------INCOMING TRADE MESSAGES EVERYDAY SETTLEMENT------------------------------------");
		for(Entry<Date, BigDecimal> entry : everyDayProcessor.getTodaysIncomingAggregate().entrySet()){
			System.out.println("Date:"+entry.getKey()+"--------------"+"Amount Settled:"+entry.getValue());
		}
	}
}

package com.assignment.helper;

import java.math.BigDecimal;

import com.assignment.enums.TradeType;
import com.assignment.exceptionHandling.EntityException;
import com.assignment.object.Entity;

public class ValidateUtil {
	public void validate(Entity entity){
		if(entity == null){
			throw new EntityException("Trade Message is empty");
		}
		if(entity.getEntityName()== null || entity.getEntityName().length() == 0){
			throw new EntityException("Trade stock name missing");
		}
		if(entity.getAgreedFx().compareTo(new BigDecimal("0.01")) < 0){
			throw new EntityException("Invalid Forex Rate");
		}
		if(entity.getUnits() <= 0){
			throw new EntityException("Units cannot be 0 or less than 0");
		}
		if(!TradeType.BUY.equals(entity.getTradeIndicator()) && !TradeType.SELL.equals(entity.getTradeIndicator())){
			throw new EntityException("Unable to understand the action. Should be BUY or SELL");
		}
		if(entity.getInstructionDate().compareTo(entity.getSettlementDate()) > 0){
			throw new EntityException("Instruction Date cannot be after settlement date");
		}
		if(entity.getPricePerUnit().compareTo(new BigDecimal("0.01")) < 0){
			throw new EntityException("Invalid price per unit");
		}
	}
}

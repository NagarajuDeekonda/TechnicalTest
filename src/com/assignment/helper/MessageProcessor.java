package com.assignment.helper;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.List;

import com.assignment.enums.TradeType;
import com.assignment.interceptor.Interceptor;
import com.assignment.object.Entity;
import com.assignment.processor.Processor;
import com.assignment.storage.MessageStore;

public class MessageProcessor implements Processor {
	
	public MessageProcessor() {		
	}
	@ToBeValidated									//ValidationUtil called to validate if entity is perfect
	public void process(Entity entity){
		
		BigDecimal totalPrice = getTotalPrice(entity);
		
		entity.setPriceInUSD(getPriceInUSD(totalPrice, entity));
		
		MessageStore mStore = MessageStore.getInstance(); // Singleton instance of message store
		
		if(UtilDate.isWorkWeekForCurrency(entity.getCurrency(), entity.getSettlementDate())){ //check if falling on weekend
			entity.setSettlementDate(UtilDate.getWorkingSettlementDate(entity)); //adjust settlement date to next working day
		}
		
		if(TradeType.SELL.equals(entity.getTradeIndicator())){
			if(mStore.incomingEntities.contains(entity)){		//if the list already contains the trade entity, update the entity
				updateEntity(mStore.incomingEntities, entity);
			}else{
			mStore.storeIncomingEntities(entity);
			}
		}else{
			if(mStore.outgoingEntities.contains(entity)){
				updateEntity(mStore.outgoingEntities, entity);
			}else{
			mStore.storeOutgoingEntities(entity);
			}
		}
	}
	
	private BigDecimal getTotalPrice(Entity entity){
		return new BigDecimal(entity.getUnits()).multiply(entity.getPricePerUnit());
	}
	
	private BigDecimal getPriceInUSD(BigDecimal totalPrice,Entity entity){
		return totalPrice.multiply(entity.getAgreedFx());
	}
	
	private void updateEntity(List<Entity> entityList, Entity entity){
		int index = entityList.indexOf(entity);
		Entity oldEntity = entityList.get(index);
		oldEntity.setUnits(oldEntity.getUnits()+ entity.getUnits());
		oldEntity.setPriceInUSD(oldEntity.getPriceInUSD().add(entity.getPriceInUSD()));
		entityList.remove(index);
		entityList.add(oldEntity);
	}
}

package com.assignment.object;


import java.math.BigDecimal;
import java.util.Date;

import com.assignment.enums.TradeType;

public class Entity {
	
	private String entityName;
	
	private TradeType tradeIndicator;
	
	private BigDecimal agreedFx;
	
	private String currency;
	
	private Date instructionDate;
	
	private Date settlementDate;
	
	private Long units;
	
	private BigDecimal pricePerUnit;
	
	private BigDecimal priceInUSD;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tradeIndicator == null) ? 0 : tradeIndicator.hashCode());
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (tradeIndicator != other.tradeIndicator)
			return false;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public TradeType getTradeIndicator() {
		return tradeIndicator;
	}

	public void setTradeIndicator(TradeType tradeIndicator) {
		this.tradeIndicator = tradeIndicator;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getPriceInUSD() {
		return priceInUSD;
	}

	public void setPriceInUSD(BigDecimal priceInUSD) {
		this.priceInUSD = priceInUSD;
	}

	
}

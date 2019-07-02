package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打折
 * @author Eclipse
 *
 */
public class CouponsAction extends JoinAction{

	/**
	 * @param actId
	 * @param actName
	 * @param actType
	 * @param actRate
	 */
	public CouponsAction(String actId,BigDecimal actRate) {
		this.actId = actId;
		super.actName = "打折";
		super.actRate = actRate;
		super.actType = COUPONS;
				
	}
	
	@Override
	public BigDecimal getPayValue(BigDecimal price,BigDecimal prodNum) {
		
		return super.actRate.multiply(prodNum).multiply(price);
	}
	
	@Override
	public BigDecimal getPayFreeValue(BigDecimal price,BigDecimal prodNum) {
		return (new BigDecimal(1).subtract(super.actRate)).multiply(prodNum).multiply(price);
	}
	
}

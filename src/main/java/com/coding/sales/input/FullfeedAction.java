package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第3件半价,满3送1
 * @author Eclipse
 *
 */
public class FullfeedAction extends JoinAction{
	
	private static BigDecimal SAN = new BigDecimal(3);
	private static BigDecimal ZEROFIVE = new BigDecimal(0.5);
	private static BigDecimal SI = new BigDecimal(4);
	private static BigDecimal YI = new BigDecimal(1);
	
	private static String HUODONGYI = "第3件半价";
	private static String HUODONGER = "满3送1";
	
	private static String PAYTYPE1 = "1";
	private static String PAYTYPE2 = "2";
	
	public String payType;//支付类型
	
	/**
	 * @param actId
	 * @param actName
	 * @param actType
	 * @param actRate
	 */
	public FullfeedAction() {
		super();
		this.actType = FULLFEED_ACTIVITY;
	}
	
	@Override
	public BigDecimal getPayValue(BigDecimal price,BigDecimal prodNum) {
		
		if(PAYTYPE1.equals(this.payType)&&prodNum.compareTo(SAN)>=0) {
			return price.multiply(ZEROFIVE);
		}
		if(PAYTYPE2.equals(this.payType)&&prodNum.compareTo(SI)>=0) {
			return price.multiply(YI);
		}
		return new BigDecimal(0);
		
	}
	
	@Override
	public BigDecimal getPayFreeValue(BigDecimal price,BigDecimal prodNum) {
		
		if(PAYTYPE1.equals(this.payType)&&prodNum.compareTo(SAN)>=0) {
			super.actName = HUODONGYI;
			return price.multiply(prodNum.subtract(ZEROFIVE));
		}
		if(PAYTYPE2.equals(this.payType)&&prodNum.compareTo(SI)>=0) {
			super.actName = HUODONGER;
			return price.multiply(prodNum.subtract(YI));
		}
		return price.multiply(prodNum);
	}

	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
}

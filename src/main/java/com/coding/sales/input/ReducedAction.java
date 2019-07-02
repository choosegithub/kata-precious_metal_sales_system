package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 满减
 * @author Eclipse
 *
 */
public class ReducedAction  extends JoinAction{
	
	private static BigDecimal YIQIANYUAN = new BigDecimal(1000);
	private static BigDecimal ERQIANYUAN = new BigDecimal(2000);
	private static BigDecimal SANQIANYUAN = new BigDecimal(3000);
	
	private static BigDecimal YUAN_10 = new BigDecimal(10);
	private static BigDecimal YUAN_30 = new BigDecimal(30);
	private static BigDecimal YUAN_350 = new BigDecimal(350);
	
	private static String MAN1000 = "每满1000元减10";
	private static String MAN2000 = "每满2000元减30";
	private static String MAN3000 = "每满3000元减350";
	
	/**
	 * @param actId
	 * @param actName
	 * @param actType
	 * @param actRate
	 */
	public ReducedAction(String actId, String actName, String actType, double actRate) {
		super.actType = REDUCED_ACTIVITY;
	}
	
	public BigDecimal getPayValue(BigDecimal price,BigDecimal prodNum) {
		
		BigDecimal amt = price.multiply(prodNum);
		
		BigDecimal result = null;
		if(amt.compareTo(YIQIANYUAN)<0) {
			result= amt;
		}else if (amt.compareTo(YIQIANYUAN)>=0 && amt.compareTo(ERQIANYUAN)<0){
			result = amt.subtract(YUAN_10);
			super.actName = MAN1000;
		}else if (amt.compareTo(ERQIANYUAN)>=0 && amt.compareTo(SANQIANYUAN)<0){
			result = amt.subtract(YUAN_30);
			super.actName = MAN2000;
		}else if (amt.compareTo(SANQIANYUAN)>=0){
			result = amt.subtract(YUAN_350);
			super.actName = MAN3000;
		}
		
		return result;
	}
	
}

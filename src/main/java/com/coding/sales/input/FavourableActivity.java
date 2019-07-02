package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 优惠活动
 * @author Eclipse
 *
 */
public class FavourableActivity {

	private String actId;//活动编号
	private String actName;//活动名称
	private String actType;//活动类型
	private double actRate;//比率(折扣)
	
	public  static String COUPONS = "1";//打折
	public static String REDUCED_ACTIVITY = "2";//满减
	public static String FULLFEED_ACTIVITY = "3";//满送
	
	
	private static Map<BigDecimal,BigDecimal> REDUCed_MAP = null;
	static {
		REDUCed_MAP = new HashMap<BigDecimal,BigDecimal>();
		REDUCed_MAP.put(new BigDecimal(3000), new BigDecimal(350));
		REDUCed_MAP.put(new BigDecimal(2000), new BigDecimal(30));
		REDUCed_MAP.put(new BigDecimal(1000), new BigDecimal(10));
	}
	
	/**
	 * @param actId
	 * @param actName
	 * @param actType
	 * @param actRate
	 */
	public FavourableActivity(String actId, String actName, String actType, double actRate) {
		super();
		this.actId = actId;
		this.actName = actName;
		this.actType = actType;
		this.actRate = actRate;
	}
	
	
	/**
	 * 打折
	 * @param amt
	 * @param actRate
	 * @return
	 */
	public BigDecimal getCouponsAction(BigDecimal amt,String actRate) {
		
		if(new BigDecimal(0).compareTo(amt)==0) {
			return amt;
		}
		
		return amt.multiply(new BigDecimal(actRate));
		
	}
	
	public BigDecimal getReducedAction(BigDecimal amt,String actType) {
		if(new BigDecimal(0).compareTo(amt)==0) {
			return amt;
		}
		
		return null;
	}
	

	/**
	 * @return the actId
	 */
	public String getActId() {
		return actId;
	}


	/**
	 * @param actId the actId to set
	 */
	public void setActId(String actId) {
		this.actId = actId;
	}


	/**
	 * @return the actName
	 */
	public String getActName() {
		return actName;
	}


	/**
	 * @param actName the actName to set
	 */
	public void setActName(String actName) {
		this.actName = actName;
	}


	/**
	 * @return the actType
	 */
	public String getActType() {
		return actType;
	}


	/**
	 * @param actType the actType to set
	 */
	public void setActType(String actType) {
		this.actType = actType;
	}


	/**
	 * @return the actRate
	 */
	public double getActRate() {
		return actRate;
	}


	/**
	 * @param actRate the actRate to set
	 */
	public void setActRate(double actRate) {
		this.actRate = actRate;
	}
}

package com.coding.sales.input;

import java.math.BigDecimal;

/**
 * 会员等级
 * @author Eclipse
 *
 */
public class MemberLevel {
	
	private String levelId;
	private String levelName;
	private int points;
	
	private static String PUBLICLEVEL = "1";
	private static String GOLDLEVEL = "2";
	private static String PLATINUMLEVEL = "3";
	private static String DIAMONDLEVEL = "4";
	
	private static String PUBLICNAME = "普卡";
	private static String GOLDNAME = "金卡";
	private static String PLATINUMNAME = "白金卡";
	private static String DIAMONDNAME = "钻石卡";
	
	private static int ZERO = 0;
	private static int ONEWAN = 10000;
	private static int FIVEWAN = 50000;
	private static int TENWAN = 100000;

	public MemberLevel() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberLevel(String levelId,String levelName) {
		this.levelId = levelId;
		this.levelName = levelName;
	}

	/**
	 * 获取会员等级
	 * @param memberPoints
	 * @return
	 */
	public static MemberLevel getNewMemLevel(int memberPoints) {
		
		MemberLevel member = null;
		if(memberPoints>ZERO && memberPoints <ONEWAN) {
			member =  new MemberLevel(PUBLICLEVEL,PUBLICNAME);
		}else if(memberPoints>=ONEWAN && memberPoints<FIVEWAN) {
			member =  new MemberLevel(GOLDLEVEL,GOLDNAME);
		}else if(memberPoints>=FIVEWAN && memberPoints<TENWAN) {
			member =  new MemberLevel(PLATINUMLEVEL,PLATINUMNAME);
		}else if(memberPoints>=TENWAN) {
			member =  new MemberLevel(DIAMONDLEVEL,DIAMONDNAME);
		}
		return member;
	}
	
	/**
	 * 积分
	 * @param amt
	 * @return
	 */
	public int getNewPoint(BigDecimal amt) {
		
		int points = amt.setScale( 0, BigDecimal.ROUND_DOWN ).intValue();
		if(PUBLICLEVEL.equals(this.levelId)) {
			points = points;
		}else if(GOLDLEVEL.equals(this.levelId)) {
			points = (int) (points * 1.5);
		}else if(PLATINUMLEVEL.equals(this.levelId)) {
			points = (int) (points *1.8);
		}else if(DIAMONDLEVEL.equals(this.levelId)) {
			points = (int) (points * 2.0);
		}
		return points;
	}

	/**
	 * @return the levelId
	 */
	public String getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
}

package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.List;

/**
 * 贵金属产品定义
 * @author Eclipse
 *
 */
public class MetalProduct {

	private String productNo;//产品编号
    private String productName;//产品名称
    private String priceUnit;//单位
    private BigDecimal price;//单价
    private List<FavourableActivity> favourActions;//参与的活动
    
    public MetalProduct(String productNo) {
    	this.productNo = productNo;
    }
    
    public MetalProduct(String productNo,String productName,BigDecimal price,String priceUnit,
    		List<FavourableActivity> favourableActivity) {
    	this.productNo = productNo;
    	this.productName = productName;
    	this.price = price;
    	this.favourActions = favourableActivity;
    }
    
    public MetalProduct(String productNo,String productName,BigDecimal price,String priceUnit) {
    	this.productNo = productNo;
    	this.productName = productName;
    	this.price = price;
    	this.priceUnit = priceUnit;
    	this.favourActions = null;
    }
    
	/**
	 * @return the productNo
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * @param productNo the productNo to set
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the priceUnit
	 */
	public String getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @param priceUnit the priceUnit to set
	 */
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @return the favourActions
	 */
	public List<FavourableActivity> getFavourActions() {
		return favourActions;
	}
	/**
	 * @param favourActions the favourActions to set
	 */
	public void setFavourActions(List<FavourableActivity> favourActions) {
		this.favourActions = favourActions;
	}
    
    
}

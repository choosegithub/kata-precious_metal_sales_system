package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.List;

public class OrderInfo {

	private MetalProduct metalProduct;
	private BigDecimal productNum;
	private double actRate;
	
	public BigDecimal ProductPriceCal(MetalProduct metalProductList) {
		
		if(metalProductList==null) {
			return new BigDecimal(0);
		}
		
		getReducedPriceCal();
		
		return null;
	}
	
	
	public OrderInfo(MetalProduct metalProduct,BigDecimal productNum) {
		this.metalProduct = metalProduct;
		this.productNum = productNum;
		
	}
	
	
	/**
	 * 打折手续费计算
	 */
	public BigDecimal getReducedPriceCal() {
		
		BigDecimal price = this.metalProduct.getPrice();
		
		double actRact = 1.00;
		if(this.metalProduct.getFavourActions()!=null) {
			List<FavourableActivity> favourList = this.metalProduct.getFavourActions();
			for (FavourableActivity favourableActivity : favourList) {
				String actType = favourableActivity.getActType();
				if(FavourableActivity.COUPONS.equals(actType)) {
					actRact = favourableActivity.getActRate();
					break;
				}
			}
			
		}
		return price.multiply(new BigDecimal(actRact)).multiply(this.getProductNum());
		
	}

	/**
	 * @return the metalProduct
	 */
	public MetalProduct getMetalProduct() {
		return metalProduct;
	}

	/**
	 * @param metalProduct the metalProduct to set
	 */
	public void setMetalProduct(MetalProduct metalProduct) {
		this.metalProduct = metalProduct;
	}

	/**
	 * @return the productNum
	 */
	public BigDecimal getProductNum() {
		return productNum;
	}

	/**
	 * @param productNum the productNum to set
	 */
	public void setProductNum(BigDecimal productNum) {
		this.productNum = productNum;
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

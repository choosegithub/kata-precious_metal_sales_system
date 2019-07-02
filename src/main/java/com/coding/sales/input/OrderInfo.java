package com.coding.sales.input;

import java.math.BigDecimal;
import java.util.List;

import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;

public class OrderInfo {

	private MetalProduct metalProduct;
	private BigDecimal productNum;//产品数量
	private BigDecimal actRate;
	private BigDecimal discount;//优惠金额
	private BigDecimal subTotal;//小计
	private String type; //支付类型
    private BigDecimal amount;//支付金额
	
	
	private List<DiscountItemRepresentation> discounts;
	private List<OrderItemRepresentation> items;
	
	public BigDecimal ProductPriceCal(List<MetalProduct> metalProductList) {
		
		if(metalProductList==null && metalProductList.size()<=0) {
			return new BigDecimal(0);
		}
		
		for (MetalProduct metalProduct : metalProductList) {
			List<JoinAction> favourList =  metalProduct.getFavourActions();
			BigDecimal coupons,fullfeed,reduced;
			
			
			
			
			
			for (JoinAction favourable : favourList) {
				
				String actType = favourable.getActType();
				if(JoinAction.COUPONS.equals(actType)) {
					getCouponsPriceCal(metalProduct);
				}else if(JoinAction.FULLFEED_ACTIVITY.equals(actType)) {
					
				}else if(JoinAction.REDUCED_ACTIVITY.equals(actType)) {
					getReducedPriceCal();
				}
			}
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
	public BigDecimal getCouponsPriceCal(MetalProduct metalProduct) {
		BigDecimal price = metalProduct.getPrice();
		
		return this.getActRate().multiply(price).multiply(this.productNum);
		
	}
	
	/**
	 * 免减续费计算
	 */
	public BigDecimal getReducedPriceCal() {
		
		BigDecimal price = this.metalProduct.getPrice();
		
		if(this.metalProduct.getFavourActions()!=null) {
			List<FavourableActivity> favourList = this.metalProduct.getFavourActions();
			for (FavourableActivity favourableActivity : favourList) {
				String actType = favourableActivity.getActType();
				if(FavourableActivity.REDUCED_ACTIVITY.equals(actType)) {
					return price.multiply(this.getProductNum().subtract(FavourableActivity.REDUCed_MAP.get(price.multiply(this.getProductNum()));
				}
			}
			
		}
	}
	
	public BigDecimal getFullfeedPriceCal() {
		
		if(this.metalProduct.getFavourActions()!=null) {
			List<FavourableActivity> favourList = this.metalProduct.getFavourActions();
			for (FavourableActivity favourableActivity : favourList) {
				String actType = favourableActivity.getActType();
				if(FavourableActivity.FULLFEED_ACTIVITY.equals(actType)) {
					
					return price.multiply(this.getProductNum().subtract(FavourableActivity.REDUCed_MAP.get(price.multiply(this.getProductNum()));
				}
			}
			
		}
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
	public BigDecimal getActRate() {
		return actRate;
	}

	/**
	 * @param actRate the actRate to set
	 */
	public void setActRate(BigDecimal actRate) {
		this.actRate = actRate;
	}
	
	

}

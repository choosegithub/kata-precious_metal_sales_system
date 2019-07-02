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
		
		BigDecimal coupons,fullfeed,reduced;
		for (MetalProduct metalProduct : metalProductList) {
			List<JoinAction> favourList =  metalProduct.getFavourActions();
			
			for (JoinAction favourable : favourList) {
				this.amount = favourable.getPayValue(metalProduct.getPrice(), this.productNum);
				this.discount = favourable.getPayFreeValue(metalProduct.getPrice(), this.productNum);
			}
		}
		
		return null;
	}
	
	
	public OrderInfo(MetalProduct metalProduct,BigDecimal productNum) {
		this.metalProduct = metalProduct;
		this.productNum = productNum;
		
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

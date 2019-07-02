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
	
	@SuppressWarnings("unlikely-arg-type")
	public BigDecimal productPriceCal(MetalProduct metalProductList) {
		
		if(metalProductList==null) {
			return new BigDecimal(0);
		}
		
		//初始化
		BigDecimal coupons=new BigDecimal(0),fullfeed=new BigDecimal(0),reduced=new BigDecimal(0);
		BigDecimal couponsFree=new BigDecimal(0),fullfeedFree=new BigDecimal(0),reducedFree=new BigDecimal(0);
		
		List<JoinAction> favourList =  metalProduct.getFavourActions();
		
		for (JoinAction favourable : favourList) {
			if(JoinAction.COUPONS.equals(favourable.getActType())) {
				coupons = favourable.getPayValue(metalProduct.getPrice(), this.productNum);
				couponsFree = favourable.getPayFreeValue(metalProduct.getPrice(), this.productNum);					
			}else if((JoinAction.FULLFEED_ACTIVITY.equals(favourable.getActType()))) {
				fullfeed = favourable.getPayValue(metalProduct.getPrice(), this.productNum);
				fullfeedFree = favourable.getPayFreeValue(metalProduct.getPrice(), this.productNum);		
			}else if((JoinAction.REDUCed_MAP.equals(favourable.getActType()))) {
				reduced = favourable.getPayValue(metalProduct.getPrice(), this.productNum);
				reducedFree = favourable.getPayFreeValue(metalProduct.getPrice(), this.productNum);		
			}
		}
		
		if(coupons.compareTo(reduced)>0 && coupons.compareTo(fullfeed)>0) {
			this.amount = coupons;
			this.discount = couponsFree;
		}else if(reduced.compareTo(coupons)>0 && reduced.compareTo(fullfeed)>0) {
			this.amount = reduced;
			this.discount = reducedFree;
		}else if(fullfeed.compareTo(reduced)>0 && fullfeed.compareTo(coupons)>0) {
			this.amount = fullfeed;
			this.discount = fullfeedFree;
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


	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}


	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}


	/**
	 * @return the subTotal
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}


	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	/**
	 * @return the discounts
	 */
	public List<DiscountItemRepresentation> getDiscounts() {
		return discounts;
	}


	/**
	 * @param discounts the discounts to set
	 */
	public void setDiscounts(List<DiscountItemRepresentation> discounts) {
		this.discounts = discounts;
	}


	/**
	 * @return the items
	 */
	public List<OrderItemRepresentation> getItems() {
		return items;
	}


	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItemRepresentation> items) {
		this.items = items;
	}
	
	

}

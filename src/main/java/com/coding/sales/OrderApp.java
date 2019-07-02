package com.coding.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.sales.input.CouponsAction;
import com.coding.sales.input.JoinAction;
import com.coding.sales.input.MemberLevel;
import com.coding.sales.input.Members;
import com.coding.sales.input.MetalProduct;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderInfo;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.output.OrderRepresentation;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {
	
	public static Map<String,MetalProduct> METALPRODUCTLIST = new HashMap<String,MetalProduct>();
	static {
		METALPRODUCTLIST.put("001001", new MetalProduct("001001", "世园会五十国钱币册", new BigDecimal("998.00"),"册"));
    	
    	
		CouponsAction favPrd = new CouponsAction("1",new BigDecimal(0.9));
    	List<JoinAction> favPrdlist = new ArrayList<JoinAction>();
    	favPrdlist.add(favPrd);
    	
    	METALPRODUCTLIST.put("001002", new MetalProduct("001002", "2019北京世园会纪念银章大全40g", new BigDecimal("1380.00"),"盒"));
    	
    	Map<String,MetalProduct> prdMap3 = new HashMap<String,MetalProduct>();
    	METALPRODUCTLIST.put("003001", new MetalProduct("003001", "招财进宝", new BigDecimal("1580.00"),"条",favPrdlist));
    
	}
	 //会员信息
    static Map<String,Members> MERMBERLIST = null;
    
    static {
    	MERMBERLIST = new HashMap<String,Members>();
    	
    	Map<String,Members> map = new HashMap<String,Members>();
    	map.put("6236609999", new Members("6236609999","马丁",1,1,9860));
    	map.put("6630009999", new Members("6630009999","王立",2,2,48860));
    	map.put("8230009999", new Members("8230009999","李想",3,3,98860));
    	map.put("9230009999", new Members("9230009999","张三",4,4,198860));
    	
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);
        
        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;

       
        List<OrderItemCommand> orderItmes = command.getItems();
        BigDecimal total = new BigDecimal(0);
        BigDecimal totalFree = new BigDecimal(0);
        for (OrderItemCommand orderItemCommand : orderItmes) {
        	MetalProduct product = METALPRODUCTLIST.get(orderItemCommand.getProduct());
        	OrderInfo temOrder = new OrderInfo(product,orderItemCommand.getAmount());
        	temOrder.productPriceCal(product);
        	BigDecimal tmp = temOrder.getAmount();
        	BigDecimal tmpFree = temOrder.getSubTotal();
        	total.add(tmp);
        	totalFree.add(tmpFree);
		}
        
        Members member = MERMBERLIST.get(command.getMemberId());
        
        result = new OrderRepresentation();
        result.setOrderId(command.getOrderId());
        result.setCreateTime(new Date(command.getCreateTime()));
        result.setMemberNo(command.getMemberId());
        result.setReceivables(total);
        result.setTotalPrice(totalFree);
        result.setOldMemberType(member.getOldMemberType()+"");
        MemberLevel merberlevl = MemberLevel.getNewMemLevel(member.getMemberPoints()+member.getMemberPointsIncreased());
        result.setNewMemberType(merberlevl.getNewPoint(total)+"");
        
        
        
        return result;
    }
}

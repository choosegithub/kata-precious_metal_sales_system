package com.coding.sales.input;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderCommand {
    private String orderId;
    private String createTime;
    private String memberId;
    private List<OrderItemCommand> items;
    private List<PaymentCommand> payments;
    private List<String> discounts;
    
    //会员信息
    static List<Map<String,Members>> MERMBERLIST = null;
    
    //产品信息
    static List<Map<String,MetalProduct>> METALPRODUCTLIST = null;

    static {
    	MERMBERLIST = new ArrayList<Map<String,Members>>();
    	
    	Map<String,Members> map1 = new HashMap<String,Members>();
    	map1.put("6236609999", new Members("6236609999","马丁",1,1,9860));
    	Map<String,Members> map2 = new HashMap<String,Members>();
    	map2.put("6630009999", new Members("6630009999","王立",2,2,48860));
    	Map<String,Members> map3 = new HashMap<String,Members>();
    	map3.put("8230009999", new Members("8230009999","李想",3,3,98860));
    	Map<String,Members> map4 = new HashMap<String,Members>();
    	map4.put("9230009999", new Members("9230009999","张三",4,4,198860));
    	
    	MERMBERLIST.add(map1);
    	MERMBERLIST.add(map2);
    	MERMBERLIST.add(map3);
    	MERMBERLIST.add(map4);
    	
    	
    	METALPRODUCTLIST = new ArrayList<Map<String,MetalProduct>>();
    	Map<String,MetalProduct> prdMap1 = new HashMap<String,MetalProduct>();
    	prdMap1.put("001001", new MetalProduct("001001", "世园会五十国钱币册", new BigDecimal("998.00"),"册"));
    	
    	Map<String,MetalProduct> prdMap2 = new HashMap<String,MetalProduct>();
    	
    	FavourableActivity favPrd = new FavourableActivity("1","打折",FavourableActivity.COUPONS,"0.9");
    	List<FavourableActivity> favPrdlist = new ArrayList<FavourableActivity>();
    	favPrdlist.add(favPrd);
    	
    	prdMap2.put("001002", new MetalProduct("001002", "2019北京世园会纪念银章大全40g", new BigDecimal("1380.00"),"盒"));
    	
    	Map<String,MetalProduct> prdMap3 = new HashMap<String,MetalProduct>();
    	prdMap3.put("003001", new MetalProduct("003001", "招财进宝", new BigDecimal("1580.00"),"条",favPrdlist));
    	
    	
    	METALPRODUCTLIST.add(prdMap1);
    	METALPRODUCTLIST.add(prdMap2);
    	METALPRODUCTLIST.add(prdMap3);
    }
    

    public static OrderCommand from(String orderCommand) {
        JSONObject jsonObject = new JSONObject(orderCommand);

        OrderCommand command = new OrderCommand(
                jsonObject.getString("orderId"),
                jsonObject.getString("createTime"),
                jsonObject.getString("memberId"),
                parseItems(jsonObject.getJSONArray("items")),
                parsePayments(jsonObject.getJSONArray("payments")),
                parseDiscounts(jsonObject.getJSONArray("discountCards"))
        );

        return command;
    }

    public OrderCommand(String orderId, String createTime, String memberId, List<OrderItemCommand> items, List<PaymentCommand> payments, List<String> discounts) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.memberId = memberId;
        this.items = items;
        this.payments = payments;
        this.discounts = discounts;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public List<OrderItemCommand> getItems() {
        return items;
    }

    public List<PaymentCommand> getPayments() {
        return payments;
    }

    public List<String> getDiscounts() {
        return discounts;
    }

    private static List<OrderItemCommand> parseItems(JSONArray jsonArray) {
        List<OrderItemCommand> results = new ArrayList<OrderItemCommand>();

        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            results.add(new OrderItemCommand(object.getString("product"), object.getBigDecimal("amount")));
        }

        return results;
    }

    private static List<PaymentCommand> parsePayments(JSONArray jsonArray) {
        List<PaymentCommand> results = new ArrayList<PaymentCommand>();

        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            results.add(new PaymentCommand(object.getString("type"), object.getBigDecimal("amount")));
        }

        return results;
    }

    private static List<String> parseDiscounts(JSONArray jsonArray) {
        List<String> results = new ArrayList<String>();

        for (Object o : jsonArray) {
            results.add((String) o);
        }

        return results;
    }
}

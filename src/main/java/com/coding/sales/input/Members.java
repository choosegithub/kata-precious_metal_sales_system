package com.coding.sales.input;

/**
 * 会员
 * @author Eclipse
 *
 */
public class Members {
	
	
	/**
     * @param orderId               订单号
     * @param createTime            订单创建时间
     * @param memberNo              会员编号
     * @param memberName            会员姓名
     * @param oldMemberType         原会员等级
     * @param newMemberType         新会员等级。当新老等级不一致时，视为升级
     */
	//会员编号
	private String memberNo;
	//会员姓名
    private String memberName;
    //原会员等级
    private String oldMemberType;
    //新会员等级
    private String newMemberType;
    //本次消费会员新增的积分
    private int memberPointsIncreased;
    //会员最新的积分
    private int memberPoints;
    
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getOldMemberType() {
		return oldMemberType;
	}
	public void setOldMemberType(String oldMemberType) {
		this.oldMemberType = oldMemberType;
	}
	public String getNewMemberType() {
		return newMemberType;
	}
	public void setNewMemberType(String newMemberType) {
		this.newMemberType = newMemberType;
	}
	public int getMemberPointsIncreased() {
		return memberPointsIncreased;
	}
	public void setMemberPointsIncreased(int memberPointsIncreased) {
		this.memberPointsIncreased = memberPointsIncreased;
	}
	public int getMemberPoints() {
		return memberPoints;
	}
	public void setMemberPoints(int memberPoints) {
		this.memberPoints = memberPoints;
	}
}

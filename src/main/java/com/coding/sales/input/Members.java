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
	//会员编号(卡号)
	private String memberNo;
	//会员姓名
    private String memberName;
    //原会员等级
    private int oldMemberType;
    //新会员等级
    private int newMemberType;
    //本次消费会员新增的积分
    private int memberPointsIncreased;
    //会员最新的积分
    private int memberPoints;
    
	/**
	 * @param memberNo
	 * @param memberName
	 * @param oldMemberType
	 * @param newMemberType
	 * @param memberPointsIncreased
	 * @param memberPoints
	 */
	public Members(String memberNo, String memberName, int oldMemberType, int newMemberType,
			int memberPointsIncreased, int memberPoints) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.oldMemberType = oldMemberType;
		this.newMemberType = newMemberType;
		this.memberPointsIncreased = memberPointsIncreased;
		this.memberPoints = memberPoints;
	}
	
	public Members(String memberNo, String memberName, int oldMemberType, int newMemberType,
		    int memberPoints) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.oldMemberType = oldMemberType;
		this.newMemberType = newMemberType;
		this.memberPointsIncreased = 0;
		this.memberPoints = memberPoints;
	}
	
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

	public int getOldMemberType() {
		return oldMemberType;
	}

	public void setOldMemberType(int oldMemberType) {
		this.oldMemberType = oldMemberType;
	}

	public int getNewMemberType() {
		return newMemberType;
	}

	public void setNewMemberType(int newMemberType) {
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

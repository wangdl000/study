package com.commodity.gift_order.service.dto;

import java.util.List;

import com.commodity.gift_order.bean.MsgListBean;

public class MsgSearchOutputDto extends BaseOutputDto {

	/** 総件数 */
	private Integer totalRecCnt;

	/** 一覧リスト */
	private List<MsgListBean> msgList;

	/**
	 * @return the totalRecCnt
	 */
	public Integer getTotalRecCnt() {
		return totalRecCnt;
	}

	/**
	 * @param totalRecCnt the totalRecCnt to set
	 */
	public void setTotalRecCnt(Integer totalRecCnt) {
		this.totalRecCnt = totalRecCnt;
	}

	/**
	 * @return msgList
	 */
	public List<MsgListBean> getMsgList() {
		return msgList;
	}

	/**
	 * @param msgList
	 *            セットする msgList
	 */
	public void setMsgList(List<MsgListBean> msgList) {
		this.msgList = msgList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MsgSearchOutputDto [msgList=" + msgList + ", totalRecCnt="
				+ totalRecCnt + "]";
	}

}

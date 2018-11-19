package com.commodity.gift_order.service.dto;

import java.util.List;

import com.commodity.gift_order.bean.MessageBean;

public class MessageOutputDto extends BaseOutputDto {

	List<MessageBean> messageList;

	public List<MessageBean> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<MessageBean> messageList) {
		this.messageList = messageList;
	}

	@Override
	public String toString() {
		return "MessageOutputDto [messageList=" + messageList + "]";
	}

}

package com.commodity.gift_order.exception;

public class BusinessException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {

		super();

	}

	public BusinessException(String string) {

		super(string);

	}

	public BusinessException(String string, String arg) {

		super(string, arg);

	}

	public BusinessException(String string, String[] args) {

		super(string, args);

	}

}

package com.commodity.gift_order.service;

import java.util.List;

import com.commodity.entity.custom.dto.BaseDict;
import com.commodity.entity.custom.dto.Customer;
import com.commodity.entity.custom.dto.QueryVo;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;

public interface CustomerService {

	public List<BaseDict> findDictByCode(String code) throws BusinessException, GelSystemException;

	public List<Customer> findCustomerByVo(QueryVo vo) throws BusinessException, GelSystemException;

	public Integer findCustomerByVoCount(QueryVo vo) throws BusinessException, GelSystemException;

	public Customer findCustomerById(Long id) throws BusinessException, GelSystemException;

	public void updateCustomerState(Customer customer) throws BusinessException, GelSystemException;

	public void deleteCustomer(Long id) throws BusinessException, GelSystemException;
}

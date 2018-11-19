package com.commodity.gift_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commodity.entity.custom.dao.CustomerMapper;
import com.commodity.entity.custom.dao.DictMapper;
import com.commodity.entity.custom.dto.BaseDict;
import com.commodity.entity.custom.dto.Customer;
import com.commodity.entity.custom.dto.QueryVo;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private DictMapper dictMapper;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<BaseDict> findDictByCode(String code) throws BusinessException, GelSystemException {
		List<BaseDict> list = dictMapper.findDictByCode(code);
		return list;
	}

	@Override
	public List<Customer> findCustomerByVo(QueryVo vo) throws BusinessException, GelSystemException {
		List<Customer> list = customerMapper.findCustomerByVo(vo);
		return list;
	}

	@Override
	public Integer findCustomerByVoCount(QueryVo vo) throws BusinessException, GelSystemException {
		Integer count = customerMapper.findCustomerByVoCount(vo);
		return count;
	}

	/*
	 * 根据id 查询用户资料
	 */
	@Override
	public Customer findCustomerById(Long id) throws BusinessException, GelSystemException {
		Customer customer = customerMapper.findCustomeById(id);
		return customer;
	}

	@Override
	public void updateCustomerState(Customer customer) throws BusinessException, GelSystemException {
		// GEL-DOCTODO Auto-generated method stub
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomer(Long id) throws BusinessException, GelSystemException {
		customerMapper.deleteCustomer(id);
	}

}

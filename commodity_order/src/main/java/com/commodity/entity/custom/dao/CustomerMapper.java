package com.commodity.entity.custom.dao;

import java.util.List;

import com.commodity.entity.custom.dto.Customer;
import com.commodity.entity.custom.dto.QueryVo;

public interface CustomerMapper {

	public List<Customer> findCustomerByVo(QueryVo vo);

	public Integer findCustomerByVoCount(QueryVo vo);

	public Customer findCustomeById(Long id);

	public void updateCustomerById(Customer customer);

	public void deleteCustomer(Long id);
}

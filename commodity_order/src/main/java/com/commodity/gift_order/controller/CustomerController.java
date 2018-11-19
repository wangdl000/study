package com.commodity.gift_order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commodity.entity.custom.dto.BaseDict;
import com.commodity.entity.custom.dto.Customer;
import com.commodity.entity.custom.dto.QueryVo;
import com.commodity.gift_order.service.CustomerService;

import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Value("${customer.dict.source}")
	private String source;
	@Value("${customer.dict.industry}")
	private String industry;
	@Value("${customer.dict.level}")
	private String level;

	@RequestMapping("/list")
	public String list(QueryVo vo, Model model) throws Exception {
		// GEL-DOC客户来源 002
		List<BaseDict> sourceList = customerService.findDictByCode(source);
		// GEL-DOC所属行业
		List<BaseDict> industryList = customerService.findDictByCode(industry);
		// GEL-DOC客户级别
		List<BaseDict> levelList = customerService.findDictByCode(level);

		// GEL-DOC处理中文乱码情况
		if (vo.getCustName() != null) {
			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"), "utf-8"));
		}

		if (vo.getPage() == null) {
			vo.setPage(1);
		}

		// GEL-DOC设置初始查询记录 页数
		vo.setStart((vo.getPage() - 1) * vo.getSize());

		// GEL-DOC查询列表和列表总数
		List<Customer> resutList = customerService.findCustomerByVo(vo);
		Integer count = customerService.findCustomerByVoCount(vo);

		Page<Customer> page = new Page<Customer>();
		page.setTotal(count); // GEL-DOC数据总数
		page.setSize(vo.getSize()); // GEL-DOC每页显示的条数
		page.setPage(vo.getPage()); // GEL-DOC当前页数
		page.setRows(resutList); // GEL-DOC列表数据源

		model.addAttribute("page", page);

		// GEL-DOC高级查询下拉列表数据
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);

		// GEL-DOC高级查询选中数据回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());

		return "customer";
	}

	/**
	 * 查询用户详细资料
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody
	public Customer detail(Long id) throws Exception {

		Customer customer = customerService.findCustomerById(id);

		return customer;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	// GEL-DOC@RequestBody 自动转成json格式
	public String updateCustomer(Customer customer) throws Exception {
		customerService.updateCustomerState(customer);
		return "customer";
	}

	@RequestMapping(value = "delete")
	public String deleteCustomer(Long id) throws Exception {
		customerService.deleteCustomer(id);
		return "customer";
	}

}

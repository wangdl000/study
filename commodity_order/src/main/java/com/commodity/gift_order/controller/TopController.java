package com.commodity.gift_order.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/top")
public class TopController {
	private Logger log = Logger.getLogger(this.getClass());

//	@Autowired(required = true)
//	private CatalogGenreService catalogGenreService;
//
//	@Autowired(required = true)
//	private MessageService messageService;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() throws Exception {

		// カタログジャンル情報
//		CatalogGenreInputDto input = new CatalogGenreInputDto();
//		input.setCatalogId(getCatalog().getCatalogId());
//		CatalogGenreOutputDto out = (CatalogGenreOutputDto)this.serviceExecute(catalogGenreService, input);
//		List<GenreBean> genreList = out.getGenreList();
//
//		// お知らせ情報
//		MessageInputDto msgInput = new MessageInputDto();
//		msgInput.setCatalogId(getCatalog().getCatalogId());
//		MessageOutputDto msgOut = (MessageOutputDto) this.serviceExecute(messageService, msgInput);
//		List<MessageBean> messageList = msgOut.getMessageList();
//
//		OrderPageCommonsSessionBean orderPage = new OrderPageCommonsSessionBean();
//		orderPage.setGenreList(genreList);
//		orderPage.setMessageList(messageList);
//		orderPage.setSearchJenre("");
//		orderPage.setSearchKeywords("");

//		this.setOrderPageCommons(orderPage);

		ModelAndView modelAndView = new ModelAndView("webadmin_top");


		return modelAndView;
	}

}

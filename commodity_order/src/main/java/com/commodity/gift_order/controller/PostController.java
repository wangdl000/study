package com.commodity.gift_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.commodity.gift_order.service.PostService;

@Controller
@RequestMapping("/postsanmple1")
public class PostController {

	@Autowired
	public PostService postService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView index() throws Exception {
		// modelの場合JSPパスとファイル名を設定しないいけない
//		model.addAttribute("posts", postService.findAll());
//		return "postsample/post";

		// tiles_definition_webadmin.xmlで定義したdefinitionのname属性の値と一致しないいけない
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("posts", postService.findAll());
		return modelAndView;
	}
}

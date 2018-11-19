package com.commodity.gift_order.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.commodity.entity.dto.MWebLogin;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.LoginService;
import com.commodity.gift_order.service.dto.OrderLoginInputDto;

@Controller
public class LoginController {
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * ログインチェックサービス
	 */
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name", required = true) String loginId,
			@RequestParam(value = "password", required = true) String password, Model model, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info(loginId);

		OrderLoginInputDto inputDto = new OrderLoginInputDto();

		inputDto.setId1(loginId);
		inputDto.setPassword(password);

		MWebLogin outUser = null;
		try {
			outUser = loginService.Login(inputDto);
		} catch (BusinessException | GelSystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (outUser == null) {
			model.addAttribute("error", "ログインIDまたパスワードが不正。");
			return "forward:/index.jsp";
		} else {
			req.getSession().setAttribute("sessionUser", outUser);
			String loginname = outUser.getLoginId();
			Cookie cookie = new Cookie("loginname", loginname);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			resp.addCookie(cookie);
			return "main";
		}
	}
}
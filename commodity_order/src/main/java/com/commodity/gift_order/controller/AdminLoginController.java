package com.commodity.gift_order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.commodity.gift_order.controller.model.AdminLoginModel;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.AdminLoginService;
import com.commodity.gift_order.service.dto.AdminLoginInputDto;
import com.commodity.gift_order.service.dto.AdminLoginOutputDto;

/**
 * <B>AdminLoginAction</B><BR>
 * <P>
 * 管理者用ログイン
 * </P>
 * <BR>
 *
 */
@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController {

	/**
	 * 企画検索サービス
	 */
// GEL-DOC   @Autowired(required = true)
// GEL-DOC   @Qualifier("KikakuSearchService")
// GEL-DOC   private ServiceInterface kikakuSearchService;

	/**
	 * ログインチェックサービス
	 */
	@Autowired(required = true)
	private AdminLoginService adminLoginService;

	/**
	 * <B>execute</B><BR>
	 * <P>
	 * 管理者用ログイン画面の初期表示処理
	 * </P>
	 * <BR>
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() throws Exception {

//		// GEL-DOC入力Dto
//		KikakuSearchInputDto inputDto = new KikakuSearchInputDto();
//		// GEL-DOC出力Dto
//		KikakuSearchOutputDto outDto;
//
//		try {
//
//			// GEL-DOC条件なしで、KikakuSearchServiceを実行
//			outDto = (KikakuSearchOutputDto) serviceExecute(kikakuSearchService, inputDto);
//
//			// GEL-DOCセッションへ格納する情報
//			Map<String, String> kikakuMap = outDto.getReturnMap();
//
//			if (kikakuMap == null) {
//				kikakuMap = new LinkedHashMap<String, String>();
//			}
//
//			model.setKikakuMap(kikakuMap);
//
//		} catch (BusinessException e) {
//
//			addActionErrors(e);
//
//			return INPUT;
//
//		}
//		webadmin_layout_main
//		return "jsp_webadmin/tiles_layout/webadmin_login";
//		return "/jsp_webadmin/tiles_layout/webadmin_layout";

		// GEL-DOCセッションへ格納する情報
		Map<String, String> kikakuMap=new HashMap<String, String>();
		kikakuMap.put("111111", "kikaku123456");
		kikakuMap.put("123456", "kikaku123456");
		AdminLoginModel adminmodel = new AdminLoginModel();
		adminmodel.setKanriUserId("");
		adminmodel.setKanriUserPassword("");
		adminmodel.setKikakuCd("");
		adminmodel.setKikakuMap(kikakuMap);

		ModelAndView mav = new ModelAndView();
		// return:path
		mav.setViewName("webadmin_login");
		mav.getModel().put("adminmodel", adminmodel);

		mav.addObject("map", kikakuMap );

		// ModelAndView返却
		return mav;
	}

	/**
	 * <B>login</B><BR>
	 * <P>
	 * 管理者用画面へのログインチェック
	 * </P>
	 * <BR>
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("adminmodel") AdminLoginModel adminmodel) throws SystemException {

		// GEL-DOC入力Dto
		AdminLoginInputDto inputDto = new AdminLoginInputDto();

		inputDto.setKanriUserId(adminmodel.getKanriUserId());
		inputDto.setKanriUserPassword(adminmodel.getKanriUserPassword());
		inputDto.setKikakuCd(adminmodel.getKikakuCd());

		// GEL-DOC出力Dto
		AdminLoginOutputDto outDto = null;
		try {
			outDto = adminLoginService.execute(inputDto);
		} catch (BusinessException | GelSystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		ModelAndView modelAndView = new ModelAndView("webadmin_top");
		modelAndView.addObject("adminLogin", outDto.toString());

		return modelAndView;
	}
}

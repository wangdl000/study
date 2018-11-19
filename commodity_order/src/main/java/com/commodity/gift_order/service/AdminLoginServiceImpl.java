package com.commodity.gift_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commodity.entity.dao.MKanrisyaUserKikakuMapper;
import com.commodity.entity.dao.MKanrisyaUserMapper;
import com.commodity.entity.dao.VWebKikakuMapper;
import com.commodity.entity.dto.MKanrisyaUser;
import com.commodity.entity.dto.MKanrisyaUserExample;
import com.commodity.entity.dto.MKanrisyaUserKikaku;
import com.commodity.entity.dto.MKanrisyaUserKikakuExample;
import com.commodity.entity.dto.VWebKikaku;
import com.commodity.entity.dto.VWebKikakuExample;
import com.commodity.gift_order.bean.session.AdminLoginSessionBean;
import com.commodity.gift_order.constant.ConstMessageId;
////import com.commodity.entity.dao.MKanrisyaUserMapper;
////import com.commodity.entity.dao.VWebKikakuMapper;
//import com.commodity.entity.dto.MKanrisyaUser;
//import com.commodity.entity.dto.MKanrisyaUserExample;
//import com.commodity.entity.dto.MKanrisyaUserKikaku;
//import com.commodity.entity.dto.MKanrisyaUserKikakuExample;
//import com.commodity.entity.dto.VWebKikaku;
//import com.commodity.entity.dto.VWebKikakuExample;
//import com.commodity.gift_order.bean.session.AdminLoginSessionBean;
//import com.commodity.gift_order.constant.ConstMessageId;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.dto.AdminLoginInputDto;
import com.commodity.gift_order.service.dto.AdminLoginOutputDto;

/**
 * <B>AdminLoginService </B><BR>
 * <P>
 * 説明：入力値でM_KANRISYA_USERテーブル、M_KANRISYA_USER_KIKAKUテーブルを検索、結果からloginbeanを生成。
 * </P>
 * <br>
 *
 * @date 2010.12.08
 * @author ou
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private MKanrisyaUserMapper mKanrisyaUserMapper;
	@Autowired
	private MKanrisyaUserKikakuMapper mKanrisyaUserKikakuMapper;
	@Autowired
	private VWebKikakuMapper vWebKikakuMapper;

	/**
	 * <B>execute</B><BR>
	 * <P>
	 * 入力値でM_KANRISYA_USERテーブル、M_KANRISYA_USER_KIKAKUテーブルを検索、結果からloginbeanを生成。
	 * </P>
	 * <BR>
	 */
	@Override
	public AdminLoginOutputDto execute(AdminLoginInputDto input) throws BusinessException, GelSystemException {

		if (mKanrisyaUserMapper == null || mKanrisyaUserKikakuMapper == null || vWebKikakuMapper == null) {
			throw new GelSystemException();
		}

		AdminLoginInputDto inDto = (AdminLoginInputDto) input;

		// MKanrisyaUserMapperを使い、下記の条件で検索
		MKanrisyaUserExample kanrisyaUserExample = new MKanrisyaUserExample();
		kanrisyaUserExample.createCriteria().andKanriUserIdEqualTo(inDto.getKanriUserId())// AdminLoginInputDtoの管理者ユーザID
				.andKanriUserPasswordEqualTo(inDto.getKanriUserPassword());// AdminLoginInputDtoの管理者パスワード

		List<MKanrisyaUser> listKanrisyaUser = null;
		listKanrisyaUser = mKanrisyaUserMapper.selectByExample(kanrisyaUserExample);

		// 結果件数が1でなかったら業務例外
		if (listKanrisyaUser == null || listKanrisyaUser.size() != 1) {
			// GEL-DOCmsgId101 ＝ IDまたはパスワードが正しくありません。
			throw new BusinessException(ConstMessageId.WEBADMIN_BUSINESS_MSG_101);
		}

		MKanrisyaUser kanrisyaUser = listKanrisyaUser.get(0);

		// 結果のsiyouKahiFlgが1でなかったら業務例外
		if (!"1".equals(kanrisyaUser.getSiyouKahiFlg())) {
			// GEL-DOCmsgId111 ＝ 使用が許可されていないユーザIDです。
			throw new BusinessException(ConstMessageId.WEBADMIN_BUSINESS_MSG_111);
		}

		// GEL-DOC結果のsVFlgが1でなかった場合、以下のチェックを行う。
		if (!"1".equals(kanrisyaUser.getSvFlg())) {
			// GEL-DOCMKanrisyaUserKikakuMapperを使い、下記の条件で検索
			MKanrisyaUserKikakuExample kanrisyaUserKikakuExample = new MKanrisyaUserKikakuExample();
			kanrisyaUserKikakuExample.createCriteria().andKanriUserIdEqualTo(inDto.getKanriUserId())// GEL-DOCAdminLoginInputDtoの管理者ユーザID
					.andKikakuCdEqualTo(inDto.getKikakuCd());// GEL-DOCAdminLoginInputDtoの企画コード(コース)

			List<MKanrisyaUserKikaku> listKanrisyaUserKikaku = null;
			listKanrisyaUserKikaku = mKanrisyaUserKikakuMapper.selectByExample(kanrisyaUserKikakuExample);

			// GEL-DOC検索した結果件数が1でなかったら業務例外
			if (listKanrisyaUserKikaku == null || listKanrisyaUserKikaku.size() != 1) {
				// GEL-DOCmsgId109 このIDでは、指定された企画は使用できません。
				throw new BusinessException(ConstMessageId.WEBADMIN_BUSINESS_MSG_109);
			}
		} else {// GEL-DOC結果のsVFlgが1だった場合、以下のチェックを行う。
			// VWebKikakuMapperを使い、下記の条件で検索
			VWebKikakuExample vWebKikakuExample = new VWebKikakuExample();
			vWebKikakuExample.createCriteria().andKikakuCdEqualTo(inDto.getKikakuCd());// GEL-DOCAdminLoginInputDtoの企画コード(コース)

			List<VWebKikaku> listVWebKikaku = null;
			listVWebKikaku = vWebKikakuMapper.selectByExample(vWebKikakuExample);

			// GEL-DOC検索した結果件数が1でなかったら業務例外
			if (listVWebKikaku == null || listVWebKikaku.size() != 1) {
				// GEL-DOCmsgId110 指定の企画は、使用できません。
				throw new BusinessException(ConstMessageId.WEBADMIN_BUSINESS_MSG_110);
			}
		}

		// GEL-DOCAdminLoginSessionBeanのオブジェクトを作成する。
		AdminLoginSessionBean adminLogin = new AdminLoginSessionBean();

		adminLogin.setKanriUserId(kanrisyaUser.getKanriUserId());// GEL-DOC管理者ユーザID
		adminLogin.setSvFlg(kanrisyaUser.getSvFlg());// GEL-DOCSVフラグ
		adminLogin.setKanriUserNm(kanrisyaUser.getKanriUserNm());// GEL-DOC管理者ユーザ名
		adminLogin.setKikakuCd(inDto.getKikakuCd());// GEL-DOC企画コード(コース)

		AdminLoginOutputDto outDto = new AdminLoginOutputDto();
		outDto.setLoginBean(adminLogin);

		return outDto;

	}

}

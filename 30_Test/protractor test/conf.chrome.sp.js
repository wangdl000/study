
var date = new Date();
var format = 'YYYYMMDDhhmmss';
format = format.replace(/YYYY/g, date.getFullYear());
format = format.replace(/MM/g, ('0' + (date.getMonth() + 1)).slice(-2));
format = format.replace(/DD/g, ('0' + date.getDate()).slice(-2));
format = format.replace(/hh/g, ('0' + date.getHours()).slice(-2));
format = format.replace(/mm/g, ('0' + date.getMinutes()).slice(-2));
format = format.replace(/ss/g, ('0' + date.getSeconds()).slice(-2));

exports.config = {
	// The address of a running selenium server.
	seleniumAddress : 'http://localhost:4444/wd/hub',

	// Capabilities to be passed to the webdriver instance.

	capabilities : {
		browserName: 'chrome',
		chromeOptions : {
			mobileEmulation : {
				deviceName : 'Apple iPhone 4',
			},
		},
		acceptSslCerts: true,
		trustAllSSLCertificates: true,
	},
	//    
	onPrepare : function() {
		console.log('Chromeでの自動化テスト(SP)開始：' + format);
		global.browser_name = "chrome";
		
		global.folder = "screenshots/captures_windows/" + browser_name + "_" + format ;
		global.url = "http://localhost/SFC/apps/services/www/SFC/desktopbrowser/default/index.html?mode=";
		global.screenshot = require('screenshot-protractor').saveScreenshot;
		
		global.val_sp_width = 400; // 320
		global.val_sp_height = 960; // 480
		global.val_pc_width = 1920;
		global.val_pc_height = 1080;

		// ブラウザサイズの設定(一括テストを実行する用)
		setTimeout(function() {
			browser.driver.executeScript(function() {
				return {
					width : window.screen.availWidth,
					height : window.screen.availHeight
				};
			}).then(function(result) {
				global.val_pc_width = result.width;
				global.val_pc_height = result.height;
				
//				global.val_pc_width = 1920; // TODO 暫定
//				global.val_pc_height = 1080; // TODO 暫定
			});
		});
	},

	// Spec patterns are relative to the current working directly when
	// protractor is called.
	// specs: ['example.js'],
	
//	specs : ['spec/*_SP_spec.js'], // 一括テスト実施：全部
	specs : ['spec/0*_SP_spec.js'], // 一括テスト実施：正常系
//	specs : ['spec/1*_SP_spec.js'], // 一括テスト実施：入力チェックエラー
//	specs : ['spec/2*_SP_spec.js'], // 一括テスト実施：異常系
	
//	specs : ['spec/00_login_PC_spec.js'], // ログイン(PC)
//	specs : ['spec/00_login_SP_spec.js'], // ログイン(SP)
//	specs : ['spec/01_transfer_PC_spec.js'], // 振込(PC)
//	specs : ['spec/01_transfer_SP_spec.js'], // 振込(SP)
//	specs : ['spec/02_fx_PC_spec.js'], // 外貨普通預金のお取引(PC)
//	specs : ['spec/02_fx_SP_spec.js'], // 外貨普通預金のお取引(SP)
//	specs : ['spec/01_transfer_history_PC_spec.js'], // 外貨普通預金のお取引(PC)
//	specs : ['spec/01_transfer_history_SP_spec.js'], // 外貨普通預金のお取引(SP)
//	specs : ['spec/01_transfer_deleteBeneficiary_PC_spec.js'], // 外貨普通預金のお取引(PC)
//	specs : ['spec/01_transfer_deleteBeneficiary_SP_spec.js'], // 外貨普通預金のお取引(SP)
//	specs : ['spec/03_userSetting_email_PC_spec.js'], // 登録情報の確認・変更ー通知Eメールの登録・変更(PC)
//	specs : ['spec/03_userSetting_email_SP_spec.js'], // 登録情報の確認・変更ー通知Eメールの登録・変更(SP)
//	specs : ['spec/03_userSetting_pwd_PC_spec.js'], // 登録情報の確認・変更ーパワーダイレクトパスワードの変更(PC)
//	specs : ['spec/03_userSetting_pwd_SP_spec.js'], // 登録情報の確認・変更ーパワーダイレクトパスワードの変更(SP)
//	specs : ['spec/03_userSetting_spAuth_PC_spec.js'], // 登録情報の確認・変更ースマホ認証端末の登録・解除(PC)
//	specs : ['spec/03_userSetting_spAuth_SP_spec.js'], // 登録情報の確認・変更ースマホ認証端末の登録・解除(SP)
//	specs : ['spec/03_userSetting_transferLimits_PC_spec.js'], // 登録情報の確認・変更ー振込限度額の変更(PC)
//	specs : ['spec/03_userSetting_transferLimits_SP_spec.js'], // 登録情報の確認・変更ー振込限度額の変更(SP)	
//	specs : ['spec/04_account_activity_PC_spec.js'], // 入出金明細（PC）
//	specs : ['spec/04_account_activity_SP_spec.js'], // 入出金明細（SP）
//	specs : ['spec/20_ex_login_PC_spec.js'], //ログイン（異常系）(PC)
//	specs : ['spec/20_ex_login_SP_spec.js'], //ログイン（異常系）(SP)
	
	// Options to be passed to Jasmine-node.
	jasmineNodeOpts : {
		showColors : true,
		defaultTimeoutInterval : 1800000
	}
};
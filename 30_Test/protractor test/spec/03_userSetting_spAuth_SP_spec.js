//登録情報の確認・変更ースマホ認証端末の登録・解除(SP)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs spAuth todo list', function() {
	it('登録情報の確認・変更ースマホ認証端末の登録・解除(SP)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_03_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "SPAUTH_";

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['SpAuth'];

		/** ************ログイン　開始*************************** */
		// ログインIDとパスワードを取得する
		var val_id_cell = worksheet['B2'].v;
		var val_pwd_cell = worksheet['C2'].v;
		
		//console.log('ログイン Step 1' + "id: [" + val_id_cell + "]. pwd: [" + val_id_cell + "]");
		// ログインIDとパスワードを入力する
		element(by.css('[ng-model="nationalId"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="nationalId"]')).sendKeys(val_id_cell);
		browser.sleep(1000);
		element(by.css('[ng-model="password"]')).clear();
		browser.sleep(1000);
		var promiseInput = element(by.css('[ng-model="password"]')).sendKeys(val_pwd_cell);
		browser.sleep(1000);
		browser.wait(promiseInput, 2000);
		screenshot(my_folder + '00_LOGIN.png');
		// 「ログイン」クリック
		if (mode === 1) {
			// PC ng-click="login();"
			element(by.css('[ng-click="login();"]')).click();
		} else {
			// SP ng-click="login()"
			element(by.css('[ng-click="login()"]')).click();
		}
		browser.sleep(6000);
		screenshot(my_folder + '00_MENU_TOP.png');
		// expect(browser.getTitle()).toEqual('トップ | 新生パワーダイレクト');
		/** ************ログイン　終了*************************** */

		// TOPの「登録情報を確認する」クリック
		// ng-bind="('CP0003_004' | translate)"
		element(by.css('[ng-bind="(\'CP0003_004\' | translate)"]')).click();
		browser.sleep(3000);
		// 登録情報の確認・変更 TOP
		screenshot(my_folder + '01_TOP_INIT.png');
		
		// 「スマホ認証端末の登録・解除」クリック
		if (mode === 1) {
			// PC: ng-bind="('CP0003_015' | translate)"
			element(by.css('[ng-bind="(\'CP0003_015\' | translate)"]')).click();
		} else {
			// SP: ng-bind="('RG0001_006' | translate)"
			element(by.css('[ng-bind="(\'RG0001_006\' | translate)"]')).click();
		}
		browser.sleep(5000);
		// パワーダイレクトパスワード変更 - 入力
		screenshot(my_folder + '02_INIT.png');

		
		var val_forGridChallenge1Cell_cell = worksheet['B6'].v;
		var val_forGridChallenge2Cell_cell = worksheet['C6'].v;
		var val_forGridChallenge3Cell_cell = worksheet['D6'].v;
		//console.log('Step 3' + "row: [B6] value : [" + val_forGridChallenge1Cell_cell + "]. ");
		//console.log('Step 3' + "row: [C6] value : [" + val_forGridChallenge2Cell_cell + "]. ");
		//console.log('Step 3' + "row: [D6] value : [" + val_forGridChallenge3Cell_cell + "]. ");
		
		// ng-model="forGridChallenge1Cell"
		element(by.css('[ng-model="forGridChallenge1Cell"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="forGridChallenge1Cell"]')).sendKeys(val_forGridChallenge1Cell_cell);
		browser.sleep(1000);
		
		// ng-model="forGridChallenge2Cell"
		element(by.css('[ng-model="forGridChallenge2Cell"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="forGridChallenge2Cell"]')).sendKeys(val_forGridChallenge2Cell_cell);
		browser.sleep(1000);
		// ng-model="forGridChallenge3Cell"
		element(by.css('[ng-model="forGridChallenge3Cell"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="forGridChallenge3Cell"]')).sendKeys(val_forGridChallenge3Cell_cell);
		browser.sleep(2000);
		screenshot(my_folder + '03_INPUT.png');
		
		// 「スマホ認証端末の解除」クリック
		element(by.css('[ng-click="authCheck();"]')).click();
		browser.sleep(5000);
		// 完了画面
		screenshot(my_folder + '04_COMPLETE.png');
		//expect(browser.getTitle()).toEqual('スマホ認証端末の解除完了 | 新生パワーダイレクト');
		
		// 「スマホ認証端末を登録する」クリック
		// ng-click="spAuthReg();"
//		element(by.css('[ng-click="authCheck();"]')).click();
//		browser.sleep(5000);
//		// スマホ認証端末登録画面
//		screenshot(my_folder + '05_SPAUTH_REGIST.png');
//		
//		browser.sleep(1000);

		/** ************ログアウト　開始*************************** */
		// 「ログアウト」クリック
		if (mode === 1) {
			// PC:ng-click="logout();"
			element(by.css('[ng-click="logout();"]')).click();
		} else {
			// SP:ng-click="logout()"
			element(by.css('[ng-click="logout()"]')).click();
		}
		browser.sleep(5000);
		// 振込完了画面のエビデンス作成
		//screenshot(my_folder + '98_LOGOUT_CONFIRM.png');
		// ログアウト確認画面で「はい」クリック
		// ng-click="logout();"
		element.all(by.css('[ng-click="logout();"]')).then(function(items) {
			var promiseLogoutYes = items[items.length - 1].click();
			browser.wait(promiseLogoutYes, 6000);
		});
		browser.sleep(1000);
		//screenshot(my_folder + '99_LOGOUT_COMPLETE.png');
		// ログイン画面へ遷移
		// ng-click="goLogin();"
		element(by.css('[ng-click="goLogin();"]')).click();
		browser.sleep(4000);
		// expect(browser.getTitle()).toEqual('ログイン | 新生パワーダイレクト');
		/** ************ログアウト　終了*************************** */

	});
});

//登録情報の確認・変更ー通知Eメールの登録・変更(SP)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs email todo list', function() {
	it('登録情報の確認・変更ー通知Eメールの登録・変更(SP)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_03_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "EMAIL_";

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Email'];

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
		browser.sleep(6000);
		// 登録情報の確認・変更 TOP
		screenshot(my_folder + '01_TOP_INIT.png');
		
		// 「通知Eメールの登録・変更」クリック
		if (mode === 1) {
			// PC:ng-bind="('CP0003_013' | translate)"
			element(by.css('[ng-bind="(\'CP0003_013\' | translate)"]')).click();
		} else {
			// SP: ng-bind="('RG0001_004' | translate)"
			element(by.css('[ng-bind="(\'RG0001_004\' | translate)"]')).click();
		}
		browser.sleep(7000);
		// 通知Eメールの登録・変更 - 入力
		screenshot(my_folder + '02_EMAIL_INIT.png');

		// 「下記注意事項をよく読み確認しました。」をチェックオン
		var promisecheckNotes = element(by.css('[ng-model="checkNotes"]')).click();
		browser.wait(promisecheckNotes, 3000);
		browser.sleep(1000);
		// 「携帯・スマートフォン」をチェックオンnewMobileFlg
		var promisenewMobileFlg = element(by.css('[ng-model="newMobileFlg"]')).click();
		browser.wait(promisenewMobileFlg, 3000);
		browser.sleep(1000);
		screenshot(my_folder + '03_EMAIL_CHECKEDON.png');
		
		// 「新しく設定するメールアドレス」と「新しく設定するメールアドレス(再入力)」を入力する

		// 新しく設定するメールアドレス
		val_newMailId_cell = worksheet['B6'].v;
		// 新しく設定するメールアドレス(再入力)
		val_chkMailId_cell = worksheet['C6'].v;
		val_file_mark_cell = "_" + worksheet['E6'].v;
		
		//console.log('Step 3' + "row: [B6] value : [" + val_newMailId_cell + "]. \n");
		//console.log('Step 3' + "row: [C6] value : [" + val_chkMailId_cell + "]. \n");
		// ng-model="newMailId"
		element(by.css('[ng-model="newMailId"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="newMailId"]')).sendKeys(val_newMailId_cell);
		browser.sleep(1000);
		// ng-model="chkMailId"
		element(by.css('[ng-model="chkMailId"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="chkMailId"]')).sendKeys(val_chkMailId_cell);
		browser.sleep(2000);
		screenshot(my_folder + '03_EMAIL_INPUT.png');

		// 「通知Eメールを登録・変更する」クリック
		element(by.css('[ng-click="mailRegistration();"]')).click();
		browser.sleep(5000);
		
		// Emailチェック結果のエビデンス
		screenshot(my_folder + '04_EMAIL_CONFIRM.png');
		
		// 通知Eメールの登録・変更 - 確認画面で「実行」押下
		// ng-click="mailRegistration();"
		element(by.css('[ng-click="mailRegistration();"]')).click();
		browser.sleep(6000);
		// 完了画面
		screenshot(my_folder + '05_EMAIL_COMPLETE.png');
		
		browser.sleep(1000);
		//expect(browser.getTitle()).toEqual('通知Eメールの登録・変更完了 | 新生パワーダイレクト');

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

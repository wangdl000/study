//登録情報の確認・変更ーパワーダイレクトパスワードの変更(PC)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs password changing todo list', function() {
	it('登録情報の確認・変更ーパワーダイレクトパスワードの変更(PC)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 1;
		var txt_mode = "_03_PC_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_pc_width, val_pc_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "CHGPWD_";
		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Chgpwd'];

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
		
		// 「パワーダイレクトパスワードの変更」クリック
		if (mode === 1) {
			// PC:TODO
			element(by.css('[ng-bind="(\'RG0001_003\' | translate)"]')).click();
		} else {
			// SP: ng-bind="('RG0001_003' | translate)"
			element(by.css('[ng-bind="(\'RG0001_003\' | translate)"]')).click();
		}
		browser.sleep(7000);
		// パワーダイレクトパスワード変更 - 入力
		screenshot(my_folder + '02_CHG_PWD_INIT.png');

		// 「新しく設定するメールアドレス」と「新しく設定するメールアドレス(再入力)」を入力する

		// 現在登録されているパスワード
		var val_oldPassword_cell = worksheet['B6'].v;
		// 新しく設定するパスワード
		var val_newPassword_cell = worksheet['C6'].v;
		// 新しく設定するパスワード(再入力)
		var val_chkPassword_cell = worksheet['D6'].v;
		val_file_mark_cell = "_" + worksheet['F6'].v;
		//console.log('Step 3' + "row: [B6] value : [" + val_oldPassword_cell + "]. \n");
		//console.log('Step 3' + "row: [C6] value : [" + val_newPassword_cell + "]. \n");
		//console.log('Step 3' + "row: [D6] value : [" + val_chkPassword_cell + "]. \n");
		// ng-model="oldPassword"
		element(by.css('[ng-model="oldPassword"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="oldPassword"]')).sendKeys(val_oldPassword_cell);
		browser.sleep(1000);
		// ng-model="newPassword"
		element(by.css('[ng-model="newPassword"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="newPassword"]')).sendKeys(val_newPassword_cell);
		browser.sleep(1000);
		// ng-model="chkPassword"
		element(by.css('[ng-model="chkPassword"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="chkPassword"]')).sendKeys(val_chkPassword_cell);
		browser.sleep(2000);
		screenshot(my_folder + '03_CHG_PWD_INPUT.png');

		// 「実行 (スマホ認証)」クリック
		element(by.css('[ng-bind="(\'PW0001_012\' | translate)"]')).click();
		browser.sleep(7000);
		
		// 完了画面
		screenshot(my_folder + '05_CHG_PWD_COMPLETE.png');
		
		browser.sleep(1000);
		//expect(browser.getTitle()).toEqual('パスワード変更完了 | 新生パワーダイレクト');

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

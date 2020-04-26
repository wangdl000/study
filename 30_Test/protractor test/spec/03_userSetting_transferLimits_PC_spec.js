//登録情報の確認・変更ー振込限度額の変更（PC）
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs transfer limits todo list', function() {
	it('登録情報の確認・変更ー振込限度額の変更（PC）',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 1;
		var txt_mode = "_03_PC_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_pc_width, val_pc_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "_TFLIMITS_";
		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['TfLimits'];

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
		// 振込限度額の変更 TOP
		screenshot(my_folder + '01_TOP_INIT.png');
		
		// 「振込限度額の変更」クリック
		if (mode === 1) {
			// PC: ng-bind="('CP0003_014' | translate)"
			element(by.css('[ng-bind="(\'CP0003_014\' | translate)"]')).click();
		} else {
			// SP: ng-bind="('RG0001_005' | translate)"
			element(by.css('[ng-bind="(\'RG0001_005\' | translate)"]')).click();
		}
		browser.sleep(5000);
		// 振込限度額の変更 - 入力
		screenshot(my_folder + '02_TFLIMITS_INIT.png');

		
		var val_newFtLimit_cell = worksheet['B6'].v;
		//console.log('Step 3' + "row: [B6] value : [" + val_newFtLimit_cell + "]. ");
		
		// ng-model="newFtLimit"
		element(by.css('[ng-model="newFtLimit"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="newFtLimit"]')).sendKeys(val_newFtLimit_cell);
		browser.sleep(1000);
		
		screenshot(my_folder + '03_TFLIMITS_INPUT.png');
		
		// 「振込額の変更」クリック
		element(by.css('[ng-click="ftLimitChange();"]')).click();
		browser.sleep(5000);
		// 確認画面
		screenshot(my_folder + '04_TFLIMITS_CONFIRM.png');
		
		// 振込限度額の変更 - 確認画面で「実行 (スマホ認証)」クリック
		if (mode === 1) {
			// PC: g-bind="('LM0002_008' | translate)"
			element(by.css('[ng-bind="(\'LM0002_008\' | translate)"]')).click();
		} else {
			// SP: ng-bind-html="('LM0002_008' | translate)"
			element(by.css('[ng-bind-html="(\'LM0002_008\' | translate)"]')).click();
		}
		browser.sleep(5000);
		// 振込限度額の変更 - 完了画面
		screenshot(my_folder + '05_TFLIMITS_COMPLETE.png');
		
		browser.sleep(1000);
		//expect(browser.getTitle()).toEqual('振込限度額変更完了 | 新生パワーダイレクト');

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

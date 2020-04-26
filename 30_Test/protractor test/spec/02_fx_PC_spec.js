//外貨普通預金のお取引(PC)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs payment todo list', function() {
	it('外貨普通預金のお取引(PC)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 1;
		var txt_mode = "_02_PC_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_pc_width, val_pc_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "FX_";

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Fx'];

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

		// TOPの「外貨から外貨のお取引」クリック
		// ng-bind="('CP0003_003' | translate)"
		element(by.css('[ng-bind="(\'CP0003_003\' | translate)"]')).click();
		browser.sleep(6000);
		// 外貨普通預金TOP画面のエビデンス作成
		screenshot(my_folder + '01_TOP_INIT.png');
		//console.log('Step 3 外貨普通預金TOP \n');

		// 「外貨から外貨のお取引」クリック
		// ng-click="dealingsForeignCurrency()"
		if (browser_name === 'firefox') {
			element(by.css('[ng-click="dealingsForeignCurrency()"]')).click();
		} else {
			browser.actions().mouseMove(element(by.css('[ng-click="dealingsForeignCurrency()"]'))).click().perform();
			
		}
		// 一行目の「売却」クリック
//		element.all(by.buttonText('売却')).then(function(items) {
//			items[0].click();
//		});
		
		browser.sleep(5000);
		// 外貨普通預金口座のお取り引き - 入力画面のエビデンス作成
		screenshot(my_folder + '02_ACCOUNT_INIT.png');
		
		// 「出金口座の選択」クリック
		// ng-bind="('FD0002_004' | translate)"
		element(by.css('[ng-bind="(\'FD0002_004\' | translate)"]')).click();
		browser.sleep(5000);
		// 振込先口座の選択画面のエビデンス作成
		screenshot(my_folder + '03_1_CONTRIBUTION_INIT.png');
		
		// 「米ドル」クリック
		element.all(by.repeater('detail in midRateList')).then(function(itemsUsd) {
			itemsUsd[1].click();
			//itemsUsd[1].element(by.linkText("米ドル")).click();
		});
		browser.sleep(5000);
		// 振込先情報の入力画面のエビデンス作成(支店/出張所名に入力済み)
		screenshot(my_folder + '03_1_CONTRIBUTION_USD_SELECTED.png');
		
		// 「入金口座の選択」クリック
		// ng-bind="('FD0002_007' | translate)"
		element(by.css('[ng-bind="(\'FD0002_007\' | translate)"]')).click();
		browser.sleep(5000);
		screenshot(my_folder + '03_2_PAYMENT_INIT.png');
		
		// 入金口座の「円」クリック
		element.all(by.repeater('detail in midRateList')).then(function(itemsOther) {
			//itemsOther[itemsOther.length - 1].element(by.linkText("ブラジル・レアル")).click();
			if (itemsOther.length > 14) {
				//var promiseOther = itemsOther[14].click();
				if (browser_name === 'firefox') {
					itemsOther[14].click();
				} else {
					browser.actions().mouseMove(itemsOther[14]).click().perform();
				}
				browser.sleep(5000);
			} else if (itemsOther.length === 14) {
				// 入金口座を先に選択している場合
				var promiseOther = itemsOther[0].click();
				browser.wait(promiseOther, 5000);
				browser.sleep(3000);
			}
		});
		screenshot(my_folder + '03_2_PAYMENT_OTHER_SELECTED.png');
		
		//金額と暗証番号を入力する
		var valAccount = worksheet['B6'].v;
		var valPin = worksheet['C6'].v;
		// ng-model="amount"
		// ng-model="pin"
		element(by.css('[ng-model="amount"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="amount"]')).sendKeys(valAccount);
		browser.sleep(1000);
		element(by.css('[ng-model="pin"]')).clear();
		browser.sleep(1000);
		var promiseAccountInput = element(by.css('[ng-model="pin"]')).sendKeys(valPin);
		browser.sleep(1000);
		browser.wait(promiseAccountInput, 5000);
		browser.sleep(1000);
		//console.log('Step 4' + "account: [" + valAccount + "].pin: [" + valPin + "]\n");
		// 入力した後のエビデンスを作成
		screenshot(my_folder + '04_AMOUNT_INPUT.png');

		// 外貨普通預金口座のお取り引き - 入力画面のの「次へ」クリック
		// ng-bind="('FD0002_013' | translate)"
		element(by.css('[ng-click="next();"]')).click();
		browser.sleep(5000);
		screenshot(my_folder + '05_CONFIRM_INIT.png');
		
		// 外貨普通預金口座のお取引 - 確認画面の「実行」クリック
		element(by.css('[ng-click="execute();"]')).click();
		browser.sleep(5000);
		screenshot(my_folder + '05_COMPLETE.png');
		
		browser.sleep(1000);
		// expect(browser.getTitle()).toEqual('外貨普通預金口座振替完了 | 新生パワーダイレクト');

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

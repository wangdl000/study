﻿//振込状況照会・取消（SP）
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs transfer history todo list', function() {
	it('振込状況照会・取消（SP）',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_01_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var inputMode = "";
		var my_folder = folder + txt_mode + "TRANSFER_HS_";
		//console.log("Step 0 url:[" + url + "]");

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Transfer'];

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

		// 「振込を行う」クリック
		// ng-bind="('CP0003_002' | translate)"
		var promiseTransfTop = element(by.css('[ng-bind="(\'CP0003_002\' | translate)"]')).click();
		browser.wait(promiseTransfTop, 5000);
		browser.sleep(1000);
		// 振込TOP画面エビデンスの作成
		screenshot(my_folder + '01_TRANSFER_TOP.png');

		// 「振込状況の照会・取消」クリック
		if (mode === 1) {
			// PC:g-bind="('CP0003_008' | translate)"
			element(by.css('[ng-bind="(\'CP0003_008\' | translate)"]')).click();
		} else {
			// SP:ng-bind="('TR0001_003' | translate)"
			element(by.css('[ng-bind="(\'TR0001_003\' | translate)"]')).click();
		}
		browser.sleep(3000);
		//expect(browser.getTitle()).toEqual('振込先口座選択 | 新生パワーダイレクト');
		// 振込状況照会・取消画面エビデンスの作成
		screenshot(my_folder + '02_RESULT_LIST.png');

		// 最終行目の「取消」クリック
		// ng-bind="('TR0010_012' | translate)"
		element.all(by.css('[ng-bind="(\'TR0010_012\' | translate)"]')).then(function(del_items) {
			if (browser_name === 'firefox') {
				del_items[del_items.length - 1].click();
			} else {
				browser.actions().mouseMove(del_items[del_items.length - 1]).click().perform();
			}
			browser.sleep(5000);
		});
		
		// 振込取消画面エビデンスの作成
		screenshot(my_folder + '03_DELETE_INPUT.png');
		
		// TODO
		// 「暗証番号」入力
		var val_pin_cell = worksheet['B15'].v;
		
		element(by.css('[ng-model="pin"]')).clear();
		browser.sleep(1000);
		var promiseAccountInput = element(by.css('[ng-model="pin"]')).sendKeys(val_pin_cell);
		browser.sleep(1000);
		browser.wait(promiseAccountInput, 5000);
		browser.sleep(1000);
		//console.log('Step 4' + "pin: [" + val_pin_cell + "]\n");
		// 入力した後のエビデンスを作成
		screenshot(my_folder + '04_PIN_INPUT.png');
		
		// 「実行」クリック
		// ng-click="deleteTransfer()"
		element(by.css('[ng-click="deleteTransfer()"]')).click();
		browser.sleep(5000);
		// 振込取消画面ー削除完了
		screenshot(my_folder + '04_DELETE_COMPLETE.png');
		element.all(by.css('[ng-bind-html="msg"]')).then(function(errs) {
			// errs.length 
			// expect(errs[0].getText()).toEqual('振込を取り消しました。');
		});

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
		//expect(browser.getTitle()).toEqual('ログイン | 新生パワーダイレクト');
		/** ************ログアウト　終了*************************** */

	});
});

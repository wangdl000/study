//登録情報の確認・変更ーパワーダイレクトパスワードの変更(SP)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs password changing todo list', function() {
	it('登録情報の確認・変更ーパワーダイレクトパスワードの変更(CHK)(SP)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_13_CHK_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "PWD_";

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Chk_pwd'];

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
		var chg_pwd_length = 0;
		for (var i = 0; i < 100; i++) {
			var chg_pwd_no_cell = worksheet['A' + (i + 6)];
			//console.log('Step 3' + "chg_pwd_no_cell : [" + chg_pwd_no_cell + "]. \n");
			if (chg_pwd_no_cell === 'undefined' || typeof chg_pwd_no_cell !== 'object') {
				chg_pwd_length = i;
				break;
			}
		}
		//console.log('Step 3' + "chg_pwd_length : [" + chg_pwd_length + "]. \n");
		
		// ng-model="oldPassword"
		// ng-model="newPassword"
		// ng-model="chkPassword"
		
		var val_oldPassword_cell = "";
		var val_newPassword_cell = "";
		var val_chkPassword_cell = "";
		var val_file_mark_cell = "";
		if (chg_pwd_length > 0) {
			for (var i = 0; i < chg_pwd_length; i++) {
//				var oldPassword_cell = worksheet['B' + (i + 6)];
				//console.log('Step 3' + "row: [B" + (i + 6) + "] cell : [" + worksheet['B' + (i + 6)] + "]. \n");
				//console.log('Step 3' + "row: [C" + (i + 6) + "] cell : [" + worksheet['C' + (i + 6)] + "]. \n");
				//console.log('Step 3' + "row: [D" + (i + 6) + "] cell : [" + worksheet['D' + (i + 6)] + "]. \n");
				// 現在登録されているパスワード
				val_oldPassword_cell = "";
				if ((worksheet['B' + (i + 6)] !== 'undefined') && (typeof worksheet['B' + (i + 6)] === 'object')) {
					val_oldPassword_cell = worksheet['B' + (i + 6)].v;
				}
				// 新しく設定するパスワード
				val_newPassword_cell = "";
				if ((worksheet['C' + (i + 6)] !== 'undefined') && (typeof worksheet['C' + (i + 6)] === 'object')) {
					val_newPassword_cell = worksheet['C' + (i + 6)].v;
				}
				// 新しく設定するパスワード(再入力)
				val_chkPassword_cell = "";
				if ((worksheet['D' + (i + 6)] !== 'undefined') && (typeof worksheet['D' + (i + 6)] === 'object')) {
					val_chkPassword_cell = worksheet['D' + (i + 6)].v;
				}
				val_file_mark_cell = "";
				if ((worksheet['F' + (i + 6)] !== 'undefined') && (typeof worksheet['F' + (i + 6)] === 'object')) {
					val_file_mark_cell = "_" + worksheet['F' + (i + 6)].v;
				}
				//console.log('Step 3' + "row: [B" + (i + 6) + "] value : [" + val_oldPassword_cell + "]. \n");
				//console.log('Step 3' + "row: [C" + (i + 6) + "] value : [" + val_newPassword_cell + "]. \n");
				//console.log('Step 3' + "row: [D" + (i + 6) + "] value : [" + val_chkPassword_cell + "]. \n");
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
				
				switch (i) {
				case 0:
					// msg in errorMsgs track by $index
					// ng-bind-html="msg"
					// 予想：
					// 現在登録されているパスワードを入力してください。
					// 新しく設定するパスワードを入力してください。
					// 新しく設定するパスワード(再入力)を入力してください。
					element.all(by.css('[ng-bind-html="msg"]')).then(function(errs) {
						// errs.length 
						// expect(errs[0].getText()).toEqual('現在登録されているパスワードを入力してください。');
						// expect(errs[1].getText()).toEqual('新しく設定するパスワードを入力してください。');
						// expect(errs[2].getText()).toEqual('新しく設定するパスワード(再入力)を入力してください。');
					});

					break;
				case 2:
					// TODO ......
					break;
					// TODO ......
				default:
					//expect(browser.getTitle()).toEqual('通知Eメールの登録・変更完了 | 新生パワーダイレクト');
					break;
				}
				// Emailチェック結果のエビデンス
				screenshot(my_folder + '04_CHG_PWD_CHK_' + val_file_mark_cell + '.png');
				
			}
		}
		
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

//登録情報の確認・変更ー通知Eメールの登録・変更(CHK)(SP)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs email todo list', function() {
	it('登録情報の確認・変更ー通知Eメールの登録・変更(CHK)(SP)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_13_CHK_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "EMAIL_";

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Chk_Email'];

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
		var email_length = 0;
		for (var i = 0; i < 100; i++) {
			var email_no_cell = worksheet['A' + (i + 6)];
			//console.log('Step 3' + "email_no_cell : [" + email_no_cell + "]. \n");
			if (email_no_cell === 'undefined' || typeof email_no_cell !== 'object') {
				email_length = i;
				break;
			}
		}
		//console.log('Step 3' + "email_length : [" + email_length + "]. \n");
		var val_newMailId_cell = "";
		var val_chkMailId_cell = "";
		var val_file_mark_cell = "";
		if (email_length > 0) {
			for (var i = 0; i < email_length; i++) {
				//console.log('Step 3' + "row: [B" + (i + 6) + "] cell : [" + worksheet['B' + (i + 6)] + "]. \n");
				//console.log('Step 3' + "row: [C" + (i + 6) + "] cell : [" + worksheet['C' + (i + 6)] + "]. \n");
				// 新しく設定するメールアドレス
				val_newMailId_cell = "";
				if ((worksheet['B' + (i + 6)] !== 'undefined') && (typeof worksheet['B' + (i + 6)] === 'object')) {
					val_newMailId_cell = worksheet['B' + (i + 6)].v;
				}
				// 新しく設定するメールアドレス(再入力)
				val_chkMailId_cell = "";
				if ((worksheet['C' + (i + 6)] !== 'undefined') && (typeof worksheet['C' + (i + 6)] === 'object')) {
					val_chkMailId_cell = worksheet['C' + (i + 6)].v;
				}
				val_file_mark_cell = "";
				if ((worksheet['E' + (i + 6)] !== 'undefined') && (typeof worksheet['E' + (i + 6)] === 'object')) {
					val_file_mark_cell = "_" + worksheet['E' + (i + 6)].v;
				}
				//console.log('Step 3' + "row: [B" + (i + 6) + "] value : [" + val_newMailId_cell + "]. \n");
				//console.log('Step 3' + "row: [C" + (i + 6) + "] value : [" + val_chkMailId_cell + "]. \n");
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
				
				switch (i) {
				case 0:
					// msg in errorMsgs track by $index
					// ng-bind-html="msg"
					// 予想：
					// 新しく設定するメールアドレスを入力してください。
					// 新しく設定するメールアドレス(再入力)を入力してください。
					element.all(by.css('[ng-bind-html="msg"]')).then(function(errs) {
						// errs.length 
						// expect(errs[0].getText()).toEqual('新しく設定するメールアドレスを入力してください。');
						// expect(errs[1].getText()).toEqual('新しく設定するメールアドレス(再入力)を入力してください。');
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
				screenshot(my_folder + '04_EMAIL_CHK_' + val_file_mark_cell + '.png');
				
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

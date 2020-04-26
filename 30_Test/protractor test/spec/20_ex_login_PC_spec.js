//ログイン
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
//

describe('angularjs homepage todo list', function() {
	it('ログイン（異常系）(PC)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 1;
		var txt_mode = "_20_EX_PC_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_pc_width, val_pc_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var my_folder = folder + txt_mode + "LOGIN_";
//		//console.log("ログイン Step 0 url:[" + url + "]");

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Ex_Login'];
		
		/** ************ログイン　開始*************************** */
		
		var email_length = 0;
		for (var i = 0; i < 100; i++) {
			var email_no_cell = worksheet['A' + (i + 2)];
			//console.log('Step 3' + "email_no_cell : [" + email_no_cell + "]. \n");
			if (email_no_cell === 'undefined' || typeof email_no_cell !== 'object') {
				email_length = i;
				break;
			}
		}
		//console.log('Step 3' + "email_length : [" + email_length + "]. \n");
		var val_id_cell = "";
		var val_pwd_cell = "";
		var val_common_err = "";
		var val_file_mark_cell = "";
		
		if (email_length > 0) {
			for (var i = 0; i < email_length; i++) {
				
				// 新しく設定するメールアドレス
				val_id_cell = "";
				if ((worksheet['B' + (i + 2)] !== 'undefined') && (typeof worksheet['B' + (i + 2)] === 'object')) {
					val_id_cell = worksheet['B' + (i + 2)].v;
				}
				// 新しく設定するメールアドレス(再入力)
				val_pwd_cell = "";
				if ((worksheet['C' + (i + 2)] !== 'undefined') && (typeof worksheet['C' + (i + 2)] === 'object')) {
					val_pwd_cell = worksheet['C' + (i + 2)].v;
				}
				//共通画面へ遷移するか(値がある：遷移)
				val_common_err = "";
				if ((worksheet['D' + (i + 2)] !== 'undefined') && (typeof worksheet['D' + (i + 2)] === 'object')) {
					val_common_err = worksheet['D' + (i + 2)].v;
				}
				val_file_mark_cell = "";
				if ((worksheet['E' + (i + 2)] !== 'undefined') && (typeof worksheet['E' + (i + 2)] === 'object')) {
					val_file_mark_cell = "_" + worksheet['E' + (i + 2)].v;
				}
				//console.log('Step 3' + "row: [B" + (i + 2) + "] value : [" + val_id_cell + "]. \n");
				//console.log('Step 3' + "row: [C" + (i + 2) + "] value : [" + val_pwd_cell + "]. \n");
				//console.log('Step 3' + "row: [D" + (i + 2) + "] value : [" + val_common_err + "]. \n");
				
				////console.log('ログイン Step 1' + "id: [" + val_id_cell + "]. pwd: [" + val_id_cell + "]");
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
				screenshot(my_folder + "[B" + (i + 2) + "]_01_LOGIN_ID_" + val_id_cell + "_INPUT.png");
				// 「ログイン」クリック
				if (mode === 1) {
					// PC ng-click="login();"
					element(by.css('[ng-click="login();"]')).click();
				} else {
					// SP ng-click="login()"
					element(by.css('[ng-click="login()"]')).click();
				}
				browser.sleep(6000);
				
				switch (i) {
				case 0:
					// ng-bind-html="msg"
					// 予想：
					// XXX
					// 新しく設定するメールアドレス(再入力)を入力してください。
					element.all(by.css('[ng-bind-html="msg"]')).then(function(errs) {
						// errs.length 
						// expect(errs[0].getText()).toEqual('XXX');
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
				// LOGIN異常エビデンス
				screenshot(my_folder + "[B" + (i + 2) + "]_02_LOGIN_ID_" + val_id_cell + "_EX_" + val_file_mark_cell + ".png");
				/** ************ログイン　終了*************************** */
				
				/** 共通画面へ遷移する場合 */
				if (val_common_err !== "") {
					// ログイン画面へ遷移
					// ng-click="goLogin()"
					element(by.css('[ng-click="gotoLogin()"]')).click();
					browser.sleep(4000);
				}
				
			}
		}

	});
});

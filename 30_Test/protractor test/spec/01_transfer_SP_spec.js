//振込(SP)
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs transfer todo list', function() {
	it('振込(SP)',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 2;
		var txt_mode = "_01_SP_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_sp_width,val_sp_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var inputMode = "";
		var my_folder = folder + txt_mode + "TRANSFER_";
//		//console.log("Step 0 url:[" + url + "]");
		
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
		element(by.css('[ng-bind="(\'CP0003_002\' | translate)"]')).click();
		browser.sleep(5000);
		// 振込TOP画面エビデンスの作成
		screenshot(my_folder + '01_TRANSFER_TOP.png');

		// 「振込」クリック
		if (mode === 1) {
			// PC:ng-bind="(\'CP0003_007\' | translate)"
			element(by.css('[ng-bind="(\'CP0003_007\' | translate)"]')).click();
		} else {
			// SP:ng-click="transition('TR0002');"
			element(by.css('[ng-click="transition(\'TR0002\');"]')).click();
		}
		browser.sleep(6000);
		//expect(browser.getTitle()).toEqual('振込先口座選択 | 新生パワーダイレクト');
		// 振込先口座の選択画面エビデンスの作成
		screenshot(my_folder + '02_SELECT_INIT.png');

		// 「新規の口座に振込 (金融機関検索へ)」クリック
		if (mode === 1) {
			// PC:ng-bind="('CP0003_007' | translate)"
			element(by.css('[ng-bind="(\'CP0003_007\' | translate)"]')).click();
		} else {
			// SP:ng-bind-html="('TR0002_004_M' | translate)"
			element(by.css('[ng-bind-html="(\'TR0002_004_M\' | translate)"]')).click();
		}
		browser.sleep(6000);
		// 振込先情報の入力画面エビデンスの作成
		screenshot(my_folder + '03_INPUT.png');

		if (mode === 1) {
			//「新規の口座に振込 (金融機関検索へ)」クリック
			// PC:tabindex="1010"
			element(by.css('[tabindex="1010"]')).click();
			browser.sleep(5000);
		}
		
		// 「金融機関の選択」クリック
		if (mode === 1) {
			// PC:ng-bind="('TR0003_011_P' | translate)"
			element(by.css('[ng-bind="(\'TR0003_011_P\' | translate)"]')).click();
		} else {
			// SP:ng-bind="('TR0003_012_M' | translate)"
			element(by.css('[ng-bind="(\'TR0003_012_M\' | translate)"]')).click();
		}
		browser.sleep(5000);
		// 金融機関を選択画面のエビデンス作成
		screenshot(my_folder + '04_BANK.png');

		//銀行検索
		// ng-model="bankSearchChar"
		var bank_cell_value = worksheet['B5'].v;
		//var branch_cell_value = "ぎんこう";
		element(by.css('[ng-model="bankSearchChar"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="bankSearchChar"]')).sendKeys(bank_cell_value);
		browser.sleep(1000);
		// 「検索」クリック
		// ng-click="searchBank()"
		element(by.css('[ng-click="searchBank()"]')).click();
		browser.sleep(3000);
		screenshot(my_folder + '05_BANK_RESULT.png');
		
		// 「横浜銀行」クリック
		// ng-bind="fetchBank.bankNameKanji"
		element.all(by.css('[ng-bind="fetchBank.bankNameKanji"]')).then(function(bank_items) {
			bank_items[0].click();
		});
		browser.sleep(3000);
		// 振り込み先の金融機関
		screenshot(my_folder + '06_INPUT_HAVE_BANK.png');

		// 支店 / 出張所の選択
		if (mode === 1) {
			// PC:ng-bind="('TR0003_013_P' | translate)"
			element(by.css('[ng-bind="(\'TR0003_013_P\' | translate)"]')).click();
		} else {
			// SP:ng-bind="('TR0003_012_M' | translate)"
			element.all(by.css('[ng-bind="(\'TR0003_012_M\' | translate)"]')).then(function(branch_items) {
				branch_items[branch_items.length - 1].click();
			});
		}
		browser.sleep(5000);
		// 支店 / 出張所選択画面のエビデンス作成
		screenshot(my_folder + '07_BRANCH_INIT.png');

		// 「支店/出張所名」に入力
		// ng-model="branchSearchChar"
		var branch_cell_value = worksheet['C5'].v;
		//var branch_cell_value = "あい";
		//console.log('Step 7' + "branch: [" + branch_cell_value+ "].");
		element(by.css('[ng-model="branchSearchChar"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="branchSearchChar"]')).sendKeys(branch_cell_value);
		browser.sleep(1000);
		// 「検索」クリック
		// ng-click="searchBranch()"
		element(by.css('[ng-click="searchBranch()"]')).click();
		browser.sleep(5000);
		// 支店/出張所選択画面の検索結果のエビデンス作成
		screenshot(my_folder + '08_BRANCH_RESULT.png');

		// 「赤坂支店>」クリック
		element.all(by.css('[ng-bind="fetchBranch.branchNameKanji"]')).then(function(sub_branch_items) {
			sub_branch_items[0].click();
			//sub_branch_items[0].element(by.linkText("赤坂支店")).click();
		});
		browser.sleep(6000);
		// 振込先情報の入力画面のエビデンス作成(支店/出張所名に入力済み)
		screenshot(my_folder + '09_BRANCH_INPUT.png');
		
		// 「支店/出張所名」に入力
		//ng-model="accountNumber"
		var account_cell_value = worksheet['B8'].v;
		//console.log('Step 9' + "branch: ["+ account_cell_value + "]. \n");
		element(by.id('accountNumber')).sendKeys(account_cell_value).clear();;
		browser.sleep(1000);
		var promiseAccountNo = element(by.id('accountNumber')).sendKeys(account_cell_value);
		browser.sleep(1000);
		browser.wait(promiseAccountNo, 5000);
		browser.sleep(1000);
		screenshot(my_folder + '10_ACCOUNT_INPUT.png');
		
		// 「次へ」クリック
		// ng-click="next();"
		var promiseNext = element(by.css('[ng-click="next();"]')).click();
		browser.wait(promiseNext, 5000);
		browser.sleep(3000);
		// 振込依頼人情報の入力画面のエビデンス作成
		screenshot(my_folder + '11_CUSTOMER_INT.png');

		// 振込依頼人名と振込金額を入力する
		var valCustomerNameKana = worksheet['B11'].v;
		var valAmount = worksheet['C11'].v;
		// 既存な値を削除する
		element(by.css('[ng-model="customerNameKana"]')).clear();
		browser.sleep(1000);
		element(by.css('[ng-model="customerNameKana"]')).sendKeys(valCustomerNameKana);
		browser.sleep(1000);
		
		element(by.css('[ng-model="amount"]')).clear();
		element(by.css('[ng-model="amount"]')).sendKeys(valAmount);
		browser.sleep(2000);
		screenshot(my_folder + '12_CUSTOMER_INPUT.png');
		
		//console.log('Step 12' + "customerNameKana: [" + valCustomerNameKana + "]. amount: [" + valAmount + "]\n");
		
		// 振込依頼人情報の入力の「次へ」クリック
		// ng-click="next();"
		element(by.css('[ng-click="next();"]')).click();
		browser.sleep(5000);
		screenshot(my_folder + '13_CONFIRM_INIT.png');
		
		// [振込先登録口座へ登録する]チェックオン
		// ng-model="beneficiaryAdd"
		var promiseInputBranck = element(by.css('[ng-model="beneficiaryAdd"]')).click();
		browser.wait(promiseInputBranck, 3000);
		browser.sleep(1000);
		screenshot(my_folder + '14_CONFIRM_CHECKED.png');
		
		// 「実行 (スマホ認証)」クリック
		if (mode === 1) {
			// PC:ng-bind="('TR0007_016_P' | translate)"
			element(by.css('[ng-bind="(\'TR0007_016_P\' | translate)"]')).click();
		} else {
			// SP:ng-bind="('TR0007_016_M' | translate)"
			element.all(by.css('[ng-bind="(\'TR0007_016_M\' | translate)"]')).then(function(branch_items) {
				branch_items[branch_items.length - 1].click();
			});
		}
		browser.sleep(6000);
		// 振込完了画面のエビデンス作成
		screenshot(my_folder + '15_COMPLETE.png');
		browser.sleep(1000);

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

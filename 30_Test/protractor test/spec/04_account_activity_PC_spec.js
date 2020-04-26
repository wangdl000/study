//入出金明細（PC）
//「_INIT」は初期画面
//「_INPUT」は値を入力した後の画面
describe('angularjs account activity todo list', function() {
	it('入出金明細（PC）',function() {
		
		// ※  mode. PC:1; SP: 2
		var mode = 1;
		var txt_mode = "_03_PC_";

		// ブラウザサイズを設定する
		browser.driver.manage().window().setSize(val_pc_width, val_pc_height);
		browser.get(url + mode);
		browser.sleep(5000);
		
		var inputMode = "";
		var my_folder = folder + txt_mode + "ACCOUNT_";
		////console.log("Step 0 url:[" + url + "]");

		// 入力データ取込
		var XLSX = require("xlsx");
		var workbook = XLSX.readFile('input/test.xlsx');
		var worksheet = workbook.Sheets['Account'];

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

		// 「入出金明細」クリック
		if (mode === 1) {
			// PC:ng-bind="('CP0003_006' | translate)"
			element(by.css('[ng-bind="(\'CP0003_006\' | translate)"]')).click();
		} else {
			// SP:ng-bind="('TP0001_016' | translate)"
			element(by.css('[ng-bind="(\'TP0001_016\' | translate)"]')).click();
		}
		browser.sleep(3000);
		// 入出金明細一覧 （円普通預金）
		screenshot(my_folder + '01_INIT.png');
		
		if (mode === 2) {
			// SP
			// 「条件を絞り込む」クリック
			//ng-bind="('AI0002_023_M' | translate)"
			element(by.css('[ng-bind="(\'AI0002_023_M\' | translate)"]')).click();
			browser.sleep(2000);
			screenshot(my_folder + '01_SEARCH_INIT.png');
		}

		// 絞り込み条件のケース数を計算する
		var narrowing_length = 0;
		for (var i = 0; i < 100; i++) {
			var narrowing_no_cell = worksheet['A' + (i + 5)];
			////console.log('絞り込み条件No:' + "narrowing_length : [" + narrowing_no_cell + "]. ");
			if (narrowing_no_cell === 'undefined' || typeof narrowing_no_cell !== 'object') {
				narrowing_length = i;
				break;
			}
		}
		//console.log('Step 3' + "narrowing_length : [" + narrowing_length + "]. ");
		
		// 絞り込み条件を設定する
		var val_narrowing_cell = "";
		var val_narrowing_txt_cell = "";
		var val_beginDate_cell = "";
		var val_dateEnd_cell = "";
		var val_file_mark_cell = "";
		if (narrowing_length > 0) {
			for (var i = 0; i < narrowing_length; i++) {
				////console.log('Step 3' + "row: [B" + (i + 5) + "] cell : [" + worksheet['B' + (i + 5)] + "]. ");
				////console.log('Step 3' + "row: [C" + (i + 5) + "] cell : [" + worksheet['C' + (i + 5)] + "]. ");
				// 絞り込み条件
				val_narrowing_cell = "";
				if ((worksheet['B' + (i + 5)] !== 'undefined') && (typeof worksheet['B' + (i + 5)] === 'object')) {
					val_narrowing_cell = worksheet['B' + (i + 5)].v;
				}
				val_narrowing_txt_cell = "";
				if ((worksheet['C' + (i + 5)] !== 'undefined') && (typeof worksheet['C' + (i + 5)] === 'object')) {
					val_narrowing_txt_cell = worksheet['C' + (i + 5)].v;
				}
				//console.log('Step 3' + "row: [B" + (i + 5) + "] 絞り込み条件  : [" + val_narrowing_cell + "]:[" + val_narrowing_txt_cell + "]. ");
				if (val_narrowing_cell === "range") {
					// 絞り込み条件:期間指定の場合
					val_beginDate_cell = "";
					if ((worksheet['D' + (i + 5)] !== 'undefined') && (typeof worksheet['D' + (i + 5)] === 'object')) {
						val_beginDate_cell = worksheet['D' + (i + 5)].v;
					}
					//console.log('Step 3' + "row: [D" + (i + 5) + "] 期間開始  : [" + val_beginDate_cell + "]. ");
					val_dateEnd_cell = "";
					if ((worksheet['E' + (i + 5)] !== 'undefined') && (typeof worksheet['E' + (i + 5)] === 'object')) {
						val_dateEnd_cell = worksheet['E' + (i + 5)].v;
					}
					//console.log('Step 3' + "row: [E" + (i + 5) + "] 期間終了  : [" + val_dateEnd_cell + "]. ");
				}
				val_file_mark_cell = "";
				if ((worksheet['G' + (i + 5)] !== 'undefined') && (typeof worksheet['G' + (i + 5)] === 'object')) {
					val_file_mark_cell = "_" + worksheet['G' + (i + 5)].v;
				}
				
				var displayed = true;
				if (mode === 2) {
					element(by.css('[data-value="' + val_narrowing_cell + '"]')).isDisplayed().then(function(visible) {
						displayed = visible;
					});
					if(!displayed) {
						// SP
						// 「条件を絞り込む」クリック
						//ng-bind="('AI0002_023_M' | translate)"
						element(by.css('[ng-bind="(\'AI0002_023_M\' | translate)"]')).click();
						browser.sleep(2000);
						screenshot(my_folder + '01_SEARCH_INIT.png');
					}
				}
				if(displayed) {
					// 絞り込み条件選択
					// //data-value="0" ~"5", "range"
					element(by.css('[data-value="' + val_narrowing_cell + '"]')).click();
					browser.sleep(2000);
					
					if (val_narrowing_cell === "range") {
						// 絞り込み条件:期間指定の場合
						// ng-model="beginDate"
						element(by.css('[ng-model="beginDate"]')).click();
						browser.sleep(1000);
						element(by.css('[ng-model="beginDate"]')).clear();
						browser.sleep(1000);
						element(by.css('[ng-model="beginDate"]')).sendKeys(val_beginDate_cell);
						browser.sleep(1000);
						// 絞り込み条件:期間指定選択(期間終了が見えない為)
						element(by.css('[data-value="range"]')).click();
						browser.sleep(2000);
						// ng-model="dateEnd"
						element(by.css('[ng-model="endDate"]')).click();
						browser.sleep(1000);
						element(by.css('[ng-model="endDate"]')).clear();
						browser.sleep(1000);
						element(by.css('[ng-model="endDate"]')).sendKeys(val_dateEnd_cell);
						browser.sleep(1000);
						// 絞り込み条件:期間指定選択(照会ボタンが見えない為)
						element(by.css('[data-value="range"]')).click();
						browser.sleep(2000);
						
					}
					screenshot(my_folder + '02_NARROWIN_OFTER_INPUT.png');
					
					// 「照会」クリック
					// ng-click="search();"
					if (browser_name === 'firefox') {
						element(by.css('[ng-click="search();"]')).click();
					} else {
						browser.actions().mouseMove(element(by.css('[ng-click="search();"]'))).click().perform();
					}
					browser.sleep(3000);
					
					// 照会結果
					screenshot(my_folder + '04_NARROWIN＿RESULT' + val_file_mark_cell + '.png');
					
					switch (i + 1) {
					case 1:
						// TODO ......
						
						break;
						// TODO ......
					case 8:
						// msg in errorMsgs track by $index
						// ng-bind-html="msg"
						
						//element.all(by.css('[ng-bind-html="msg"]')).then(function(errs) {
						// errs.length 
						//expect(errs[0].getText()).toEqual('入出金明細は、照会日当日～前々年同月まで照会いただけます。絞込み条件をご確認ください。');
						//});
						break;
					default:
						//expect(browser.getTitle()).toEqual('');
						break;
					}
					
					if (mode === 1 && browser_name === 'chrome') {
						// PC
						// CSVダウンロード
						element.all(by.css('[ng-click="getCsvString();"]')).then(function(csv_items) {
							for (var j = 0; j < csv_items.length; j++) {
								// CSVダウンロード（C13）、CSVダウンロード（C14）
								browser.actions().mouseMove(csv_items[j]).click().perform();
								browser.sleep(5000);
							}
						});
					}
				}
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
		//expect(browser.getTitle()).toEqual('ログイン | 新生パワーダイレクト');
		/** ************ログアウト　終了*************************** */

	});
});

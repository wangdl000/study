//({{ today | date:'HHmmsssss' }})
// mode. PC:1; SP: 2
var mode = 1;
var url = "http://localhost/SFC/apps/services/www/SFC/desktopbrowser/default/index.html?mode="
		+ mode;
var pageId = "";
var inputMode = "";
browser.get(url);
console.log('Step 0');
browser.sleep(3000);
var folder = "screenshots/captures/";

// 入力データ取込
var XLSX = require("xlsx");
var workbook = XLSX.readFile('input/test.xlsx');
var worksheet = workbook.Sheets['Login'];
// ログインIDとパスワードを取得する
var id_cell = worksheet['B2'];
var pwd_cell = worksheet['C2'];
console.log('Step 1' + "id: [" + id_cell.v + "]. pwd: [" + pwd_cell.v + "]\n");
// ログインIDとパスワードを入力する
inputMode = "nationalId";
element(by.css('[ng-model="' + inputMode + '"]')).sendKeys(id_cell.v);
browser.sleep(1000);
inputMode = "password";
var promiseA = element(by.css('[ng-model="' + inputMode + '"]')).sendKeys(
		pwd_cell.v);
browser.sleep(1000);
browser.wait(promiseA, 5000);
screenshot(folder + 'LOGIN.png');

// 「ログイン」クリック
var promiseB = element(by.css('[ng-click="login();"]')).click();
browser.wait(promiseB, 5000);
browser.sleep(3000);
screenshot(folder + 'MENU_TOP.png');
console.log('Step 2' + "MENU_TOP OK. \n");

// 「振込を行う」クリック
// ng-bind="('CP0003_002' | translate)"
pageId = "'CP0003_002'";
var promiseTransfTop = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseTransfTop, 5000);
browser.sleep(3000);
// 振込TOP画面のエビデンス作成
screenshot(folder + 'TRANSFER_01_TOP.png');
console.log('Step 3' + "TRANSFER TOP OK. ");

// 「振込」クリック
// ng-bind="('CP0003_007' | translate)"
pageId = "'CP0003_007'";
if (mode == 2) {
	// SP
	pageId = "'CP0003_007'";
}
console.log('Step 4' + "pageId: [" + pageId + "]. \n");
var promiseTransf = element(by.css('[ng-bind="(' + pageId + ' | translate)"]'))
		.click();
browser.wait(promiseTransf, 5000);
browser.sleep(5000);
// 振込先口座の選択画面のエビデンス作成
screenshot(folder + 'TRANSFER_02_SELECT.png');

// 「新規の口座に振込 (金融機関検索へ)」クリック
// ng-bind="('TR0002_003_P' | translate)"
pageId = "'TR0002_003_P'";
if (mode == 2) {
	// SP
	pageId = "'TR0002_003_P'";
}
console.log('Step 5' + "pageId: [" + pageId + "]. \n");
var promiseNewAcountBtn = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseNewAcountBtn, 5000);
browser.sleep(5000);
// 振込先情報の入力画面のエビデンス作成
screenshot(folder + 'TRANSFER_03_INPUT.png');

// 「金融機関の選択」クリック
// ng-bind="('TR0003_011_P' | translate)"
pageId = "'TR0003_011_P'";
if (mode == 2) {
	// SP
	pageId = "'TR0003_011_P'";
}
console.log('Step 6' + "pageId: [" + pageId + "]. \n");
var promiseAcountBtn = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseAcountBtn, 5000);
browser.sleep(5000);
// 金融機関を選択画面のエビデンス作成
screenshot(folder + 'TRANSFER_04_BANK.png');

// 「りそな銀行」クリック
// ng-bind="preferredBank.bankNameKanji"
pageId = "preferredBank.bankNameKanji";
if (mode == 2) {
	// SP
	pageId = "preferredBank.bankNameKanji";
}
console.log('Step 6' + "pageId: [" + pageId + "]. \n");
var promiseBank = element(by.css('[tabindex="1093"]')).click();
browser.wait(promiseBank, 5000);
browser.sleep(5000);
// 振込先情報の入力画面のエビデンス作成(金融機関に入力済み)
screenshot(folder + 'TRANSFER_05_INPUT_HAVE_BANK.png');

// 支店 / 出張所の選択
// ng-bind="('TR0003_013_P' | translate)"
pageId = "'TR0003_013_P'";
if (mode == 2) {
	// SP
	pageId = "'TR0003_013_P'";
}
console.log('Step 6' + "pageId: [" + pageId + "]. \n");
var promiseBranchBtn = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseBranchBtn, 5000);
browser.sleep(5000);
// 支店 / 出張所選択画面のエビデンス作成
screenshot(folder + 'TRANSFER_06_BRANCH.png');

// 「支店/出張所名」に入力
inputMode = "branchSearchChar";
// ng-model="branchSearchChar"
// var branch_cell_value = worksheet['B3'].v;
var branch_cell_value = "あ";
console.log('Step 7' + "branch: [" + branch_cell_value + "]. " + "pageId: ["
		+ pageId + "]. \n");
var promiseInputBranck = element(by.css('[ng-model="' + inputMode + '"]'))
		.sendKeys(branch_cell_value);
browser.sleep(1000);
browser.wait(promiseInputBranck, 5000);
// 「りそな銀行」クリック
// ng-bind="('TR0005_001' | translate)"
pageId = "'TR0005_001'";
if (mode == 2) {
	// SP
	pageId = "'TR0005_001'";
}
console.log('Step 7' + "pageId: [" + pageId + "]. \n");
var promiseSearchBranchBtn = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseSearchBranchBtn, 5000);
browser.sleep(5000);
// 支店/出張所選択画面の検索結果のエビデンス作成
screenshot(folder + 'TRANSFER_07_BRANCH_RESULT.png');

// 「明石支店>」クリック
// ng-bind="fetchBranch.branchNameKanji"
pageId = "fetchBranch.branchNameKanji";
if (mode == 2) {
	// SP
	pageId = "fetchBranch.branchNameKanji";
}
console.log('Step 6' + "明石支店> : tabindex[ 1362]. \n"); // TODO 問題ある
var promiseBranch = element(by.css('[tabindex="1362"]')).click();
browser.wait(promiseBranch, 5000);
browser.sleep(5000);
// 振込先情報の入力画面のエビデンス作成(支店/出張所名に入力済み)
screenshot(folder + 'TRANSFER_08_INPUT_HAVE_BRANCH.png');

// 「支店/出張所名」に入力
inputMode = "accountNumber";
// ng-model="accountNumber"
// var accountNum_cell_value = worksheet['B4'].v;
var accountNum_cell_value = "1234567";
console.log('Step 9' + "branch: [" + accountNum_cell_value + "]. "
		+ "pageId: [" + pageId + "]. \n");
var promiseAccountNum = element(by.css('[ng-model="' + inputMode + '"]'))
		.sendKeys(accountNum_cell_value);
browser.sleep(1000);
browser.wait(promiseAccountNum, 5000);
// 「次へ」クリック
// ng-bind="('TR0003_016' | translate)"
pageId = "'TR0003_016'";
if (mode == 2) {
	// SP
	pageId = "'TR0003_016'";
}
console.log('Step 9' + "pageId: [" + pageId + "]. \n");
var promiseCustomer = element(
		by.css('[ng-bind="(' + pageId + ' | translate)"]')).click();
browser.wait(promiseCustomer, 5000);
browser.sleep(5000);
// 振込依頼人情報の入力画面のエビデンス作成
screenshot(folder + 'TRANSFER_09_CUSTOMER_INPUT.png');

console.log('Operation took ' + (end.getTime() - start.getTime()) + ' msec');

browser.screenshot(folder + 'END.png');

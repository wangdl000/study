	browser.get('http://localhost:10080/SFC/apps/services/www/SFC/mobilewebapp/');
	console.log('Step 0');
	browser.sleep(3000);
	var XLSX = require("xlsx");
	var workbook = XLSX.readFile('input/test.xlsx');
	var worksheet = workbook.Sheets['Login'];
	var id_cell = worksheet['B2'];
	var pwd_cell = worksheet['C2'];
    	
	element(by.css('[ng-model="nationalId"]')).sendKeys(id_cell.v);
	browser.sleep(1000);
	var promiseA = element(by.css('[ng-model="password"]')).sendKeys(pwd_cell.v);
	browser.sleep(1000);
	browser.wait(promiseA,5000);
	screenshot('screenshots/LOGIN.png');
	var promiseB = element(by.css('[ng-click="login();"]')).click();
	browser.wait(promiseB,5000);
	browser.sleep(3000);
	screenshot('screenshots/HURIKOMI.png');

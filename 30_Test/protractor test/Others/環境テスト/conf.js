
// An example configuration file.
exports.config = {
	// The address of a running selenium server.
	seleniumAddress : 'http://localhost:4444/wd/hub',

	// Capabilities to be passed to the webdriver instance.
	capabilities : {
		'browserName' : 'chrome'
	// 'browserName': 'internet explorer'
	// 'chromeOptions': { 'args': ['--disable-extensions']}
	},
	//    

	var nowtime = new Date().getTime();
	var date = new Date(nowtime + (60 * 60 * 24 * 1000 * 366 * 10));

	
	
	onPrepare : function() {
//		global.screenshot = require('screenshot-protractor').saveScreenshot;


//		var format = 'YYYYMMDDhhmmss.SSS';
//		format = format.replace(/YYYY/g, date.getFullYear());
//		format = format.replace(/MM/g, ('0' + (date.getMonth() + 1)).slice(-2));
//		format = format.replace(/DD/g, ('0' + date.getDate()).slice(-2));
//		format = format.replace(/hh/g, ('0' + date.getHours()).slice(-2));
//		format = format.replace(/mm/g, ('0' + date.getMinutes()).slice(-2));
//		format = format.replace(/ss/g, ('0' + date.getSeconds()).slice(-2));
//		if (format.match(/S/g)) {
//			var milliSeconds = ('00' + date.getMilliseconds()).slice(-3);
//			var length = format.match(/S/g).length;
//			for (var i = 0; i < length; i++)
//				format = format.replace(/S/, milliSeconds.substring(i, i + 1));
//		}
//		global.formatDate = format;
//	},

	// Spec patterns are relative to the current working directly when
	// protractor is called.
	// specs: ['example_spec.js'],
	// 振込
	specs : [ '01_transfer_spec.js' ],

	// Options to be passed to Jasmine-node.
	jasmineNodeOpts : {
		showColors : true,
		defaultTimeoutInterval : 30000
	}
};
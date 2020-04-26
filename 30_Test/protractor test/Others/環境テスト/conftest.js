//var screenShot = require('screenshot-protractor');

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


	// Spec patterns are relative to the current working directly when
	// protractor is called.
	// specs: ['example_spec.js'],
	// 振込
	specs : [ 'todo-spec.js' ],


};
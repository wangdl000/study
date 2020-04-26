describe('angularjs homepage todo list', function() {
  it('should add a todo', function() {
    browser.get('https://www.google.co.jp/');

    var promiseInp = element(by.css('[id="lst-ib"]')).sendKeys("angular js test");
    browser.sleep(1000);
    browser.wait(promiseInp, 5000);

    var promiseShearch = element(by.css('[name="btnK"')).click();
    browser.wait(promiseShearch, 5000);
    browser.sleep(5000);

    // You wrote your first test, cross it off the list
    //todoList.get(2).element(by.css('input')).click();
    //var completedAmount = element.all(by.css('.done-true'));
    //expect(completedAmount.count()).toEqual(2);
  });
});
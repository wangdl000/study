cd C:\Users\jmas\AppData\Roaming\npm
set PROXY=http://proxy.jmas.co.jp:8080
set HTTP_PROXY=%PROXY%
set HTTPS_PROXY=%PROXY% 
webdriver-manager update

webdriver-manager start
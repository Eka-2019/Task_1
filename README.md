# Created project tests the below API - https://api.wazirx.com/sapi/v1/tickers/24hr

#   add at least 5 or more test cases that does the proper health check for the mentioned API - done in APITests.java
#   nice to have if you can implement any report/result for the above test run - half done.
#   get all symbols whose open price is less than low price - done, but I get whole element, because it's easier to investigate in fail case.
#   get all such symbols and baseAssets whose volume are more than average of all volumes in the list - done, but I get whole element.
#   find 5 such assets/symbol which has the least differences between bidPrice and askPrice - done, but I get whole element.

# All tests suit can be run in two ways: 
# 1) from /test/java/runner folder all suites run under default browser = Chrome:
# 2) In Terminal using:  mvn clean test

# How to create surefire report:
# Run tests via terminal using mvn clean site.
# Wait until folder: target/site will be created

# How to open surefire report:
# Go to folder: target/site and open file: surefire-report.html in any browser
# PS: (Unfortunately, I do not know why tests are duplicated in report)
 






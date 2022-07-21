$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/MobilePurchase.feature");
formatter.feature({
  "name": "Mobile Purchase",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Mobile"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launches flipkart application",
  "keyword": "Given "
});
formatter.match({
  "location": "MobilePurchaseSteps.user_launches_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login into flipkart",
  "keyword": "And "
});
formatter.match({
  "location": "MobilePurchaseSteps.user_login_into_flipkart()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mobile",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Mobile"
    }
  ]
});
formatter.step({
  "name": "User search mobile",
  "keyword": "When "
});
formatter.match({
  "location": "MobilePurchaseSteps.user_search_mobile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User choose the mobile and doing payments",
  "keyword": "And "
});
formatter.match({
  "location": "MobilePurchaseSteps.user_choose_the_mobile_and_doing_payments()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User receive order confirmation message",
  "keyword": "Then "
});
formatter.match({
  "location": "MobilePurchaseSteps.user_receive_order_confirmation_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
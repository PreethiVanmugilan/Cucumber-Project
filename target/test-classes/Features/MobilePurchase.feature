#Author: preethi@your.domain.com

@Mobile
Feature: Mobile Purchase
  I want to use this template for my feature file

  Background: 
    Given User launches flipkart application
    And User login into flipkart

  Scenario: Mobile
    When User search mobile
    And User choose the mobile and doing payments
    Then User receive order confirmation message
    
    Scenario: Mobile one dim list
    When User search mobile by using one dim list
      | POCO | iPhone | realme |
    And User choose the mobile and doing payments
    Then User receive order confirmation message

  Scenario: Mobile one dim map
    When User search mobile by using one dim map
      | phone1 | iPhone          |
      | phone2 | SAMSUNG Mobiles |
      | phone3 | realme          |
    And User choose the mobile and doing payments
    Then User receive order confirmation message

  Scenario Outline: All Mobiles
    When User search mobile "<Phones>"
    And User choose the mobile and doing payments
    Then User receive order confirmation message

    Examples: 
      | Phones |
      | iPhone |
      | POCO   |
      | realme |
    

  
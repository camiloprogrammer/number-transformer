Feature: Number to English representation transformer

  Background: 
    Given I want to transform numbers in English

  Scenario Outline: transform a number in English
    Given I want to transform number "<number>"
    When I transform the number to english
    Then I get "<result>" as the transformed number

    Examples: 
      | number       | result |
      | 0            | Zero   |
      | 1            | One    |
      | 2            | Two    |
      | 12           | Twelve |
      | 15           | Fifteen |
      | 19           | Nineteen |
      | 20           | Twenty |
      | 21           | Twenty one |
      | 29           | Twenty nine |
      | 99           | Ninety nine |
      | 100          | One hundred |
      | 101          | One hundred one |
      | 111          | One hundred eleven |
      | 199          | One hundred ninety nine |
      | 999          | Nine hundred ninety nine |
      | 1000         | One thousand |
      | 1001         | One thousand one |
      | 1011         | One thousand eleven |
      | 1111         | One thousand one hundred eleven |
      | 1000000      | One million |
      | 1000001      | One million one |
      | 1000200      | One million two hundred |
      | 1006000      | One million six thousand |
      | 1000000000   | One billion |
      | 1234568790   | One billion two hundred thirty four million five hundred sixty eight thousand seven hundred ninety |
      | 2147483647   | Two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven |
      | -1           | Negative one |
      | -2147483648  | Negative two billion one hundred forty seven million four hundred eighty three thousand six hundred forty eight |

Feature: Number to Spanish representation transformer

  Background: 
    Given I want to transform numbers in Spanish

  Scenario Outline: transform a number in Spanish
    Given I want to transform number "<number>"
    When I transform the number to english
    Then I get "<result>" as the transformed number

    Examples: 
      | number       | result |
      | 0            | Cero   |
      | 1            | Uno    |
      | 2            | Dos    |
      | 12           | Doce   |
      | 15           | Quince |
      | 19           | Diecinueve |
      | 20           | Veinte |
      | 21           | Veintiuno |
      | 29           | Veintinueve |
      | 99           | Noventa y nueve |
      | 100          | Cien |
      | 101          | Ciento uno |
      | 111          | Ciento once |
      | 199          | Ciento noventa y nueve |
      | 999          | Novecientos noventa y nueve |
      | 1000         | Mil |
      | 1001         | Mil uno |
      | 1011         | Mil once |
      | 1111         | Mil ciento once |
      | 2000         | Dos mil |
      | 2001         | Dos mil uno |
      | 1000000      | Un millon |
      | 1000001      | Un millon uno |
      | 1000200      | Un millon doscientos |
      | 1006000      | Un millon seis mil |
      | 2000000      | Dos millones |
      | 1000000000   | Un billon |
      | 1234568790   | Un billon doscientos treinta y cuatro millones quinientos sesenta y ocho mil setecientos noventa |
      | 2147483647   | Dos billones ciento cuarenta y siete millones cuatrocientos ochenta y tres mil seiscientos cuarenta y siete |
      | -1           | Menos uno |
      | -2147483648  | Menos dos billones ciento cuarenta y siete millones cuatrocientos ochenta y tres mil seiscientos cuarenta y ocho |

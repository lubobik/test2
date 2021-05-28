# Explanation of test coverage

### General explanation

#### Desired scope
Tests should only be written for more complex use cases. 
That means, if there are many edge cases and / or a complicated business logic
is implemented, it is useful to back your individual 
implementation with several, encapsulated test cases. 
An example would be a functionality which represents / generates 
different kind of outputs based on the given input.

#### Consequences of misuse
Writing (unit) tests for every little method or component of a certain application,
which will always return a valid outcome, 
should be minimized. Otherwise, a lot of time 
and therefore money will be unnecessarily spend. 
As a consequence, this would ultimately lead to a generation 
of a stalling effect within the project.

#### Brief conclusion
Implement as many USEFUL test cases, 
which validate different sections of the implemented logic, as possible.

---

### Current coverage(s)

| Class                  | Instruction / line coverage   | Branch coverage   |
|------------------------|:-----------------------------:|:-----------------:|
| CashRegisterManagement |             100%              |       100%        |
| DrinkSale              |             100%              |       100%        |
| Operator               |             100%              |       100%        |
| Cocktail               |             100%              |       100%        |
| LongDrink              |             100%              |       100%        |
| Smoothie               |             100%              |       100%        |
| Tea                    |             100%              |       100%        |
| Brand                  |             100%              |       100%        |
| Fruit                  |             100%              |       100%        |
| SoftLiquid             |             100%              |       100%        |
| CashRegisterRandomizer |             100%              |       100%        |
| DrinkUtils             |             100%              |       100%        |
| ~ValidationException~  |             100%              |       100%        |
| ~Main~                 |             100%              |       100%        |

#### Concrete statement
In order to achieve 100% test coverage on all classes, which are shown above, 
different cases for different output scenarios were implemented.
Interestingly, the IntelliJ code coverage analysis came to another conclusion, 
compared to the Jacoco coverage report. It seems like Jacoco actually notices, 
if some branch of a method / functionality is not used and therefore tested.
The IntelliJ coverage runner is seemingly not supporting this feature.

However, with the more precise analysis of Jacoco, there is also a tradeoff.
When testing static / utility classes, a private constructor must be added.
Otherwise, missing coverage percentages can be found on the coverage report.

##### Special cases
Pure console output methods (with no return value --> void) will always return a valid result.
Because of that, exactly testing these kind of functions is not really practical.

The same assertion applies to testing the main method of an application.
Next to that, testing enormous methods / functionalities within a single unit test,
violates the fundamental principal of unit tests in general. 
Unit tests should always focus on atomic snapshots of an application's business logic.

To actually test the debug / console output, you could read from the output stream.
This would be weird though and not really suited for (most) real world cases.

##### Reference
For additional explanations and eventually more test specific information, 
please consult the individual test class and therefore its documentation.
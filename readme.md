# Drinks project of BSD20

## General info
**Name of the repository**: Konf_B20_Bobik_Steirer  
**Members**: Lukas Bobik and Andreas Steirer

---

## Motivation
This is a simple example project for the subject 'Configuration Mangement' in 2021.  
The main purpose of it is getting to know Git and all its commands,  
but also to get used to technologies like Maven, Junit etc.

---

## Submissions

As a base for this project we got a zip file, containing 4 Java classes
 (Drink (abstract), Liquid, SimpleDrink, Main)

### Submission #1

#### General  
Each group member had to derive a new class from `Drink` / `SimpleDrink` or from a class another group mate has created before.  
After that each one created objects from their corresponding classes in the Main file to demonstrate their implementations
(e.g. printing the `String` representation of `Drink`s, which mostly include info about each individual `Drink`).  
While implementing all the known requirements, each student had to take notes and put them in the `README` as a development documentation.
All files were of course checked into the VCS to actually track the changes   
(without that you would not be here reading this amazing information).  

#### Procedure 
1. To extend a class from an abstract class, all methods and variables from the abstract class have to be (directly or indirectly) 
implemented in the deriving class.  
1. The new created class needs at least one constructor and for every field there has to be at least a getter method
(setter is optional, if you set all required field values inside a constructor and never want to change them).  
1. In the `toString`-method of each class you can implement a custom message. 
It will be shown when the `toString` method is explicitly (calling by name) or implicitly called (e.g. concatenation with another `String`).
1. As already mentioned above, after implementing some functionality and methods the objects will be tested in the project's `Main` class.
1. Finishing up, every larger change will be stored and pushed in its own atomic commit + message.

#### Lessons learned   
Basic usage of Git as a VCS, deriving classes from abstract classes in Java, 
implementing some minor business logic and a brief entry into merging files.

### Submission #2

#### General  
* Each group member had to create a new Git branch for every class that he / she created, 
implement JUnit tests for their individual implementations and try to reach a test coverage of 100%.  
* If not already done, adapt all undocumented Java classes with respective comments using JavaDoc.
* After all required tests are added, accordingly tested and commited,
push each branch to the GitHub repository before merging it back into the main branch.  
If a developer gets lucky and no other team member worked on the same lines of code as he did, 
there should not be the need of an additional merging process.

#### Procedure   
In order to start a new test class (e.g. `SimpleDrinkTests`) a new class needs to be created
(in IntelliJ, you can auto-generate test classes
[ALT+PASTE, then choose test and mark what methods you want to test] or just create a new class in `"test / java / packageName"`).
One test object (e.g. `SimpleDrink`) acts as attribute 
and for every method or use case of the base class there has to be at least one test method.

**Used annotations**
* `@BeforeEach` - indicates a method that is executed before every test  
* `@Test` - is used for a method as an indication, declaring the method as a test method  
* `@DisplayName(String displayName)` - when placed over a test method a different display name for the following test is assigned 
(default would be the method name) 
* `@Nested` - enables the use of child classes inside a test class 
(mainly used for better structuring and prevention of unnecessary setup)

**Additional explanation**  
* With `assertEquals(expectedResult, actualResult)` you can test if a method returning a value or a calculated value 
is really what it is supposed to be. 
The first parameter represents the desired outcome, the second one represents the actual result or value of a method or variable. 
If both outputs are equal the corresponding test will pass else it will fail.
* There are also additional methods like `assertFalse`, `assertTrue` (both are `boolean` assertions), etc. 
which support your testing needs in a comfortable manner.
* In order to test expected errors / exceptions the `assertThrows(exceptionClass, lambda expression)` method is provided.  
The test only passes if the code / logic in the lambda expression / function really throws the specified exception.

Example of a test case: To verify the functionality of methods like `setName` the name is set during the test
and checked by calling `getName` at the point of assertion.  

Most of the implemented logic and tests are self-explanatory and therefore do not need 
further detail explanation then the provided code and already given README documentation.  
The general principle of creating a test is always the same  
--> Setup, Exercise, Verify (and Tear-down)  
(actually all typical unit test kits / frameworks, for all typical languages work in the same way).

#### Lessons learned   
Advanced usage of Git as a VCS (branching and merging), deriving classes from abstract classes in Java, 
implementing some small business logic, creating unit tests with a focus on 100% line coverage, 
getting to know JavaDoc and documentation process.

### Submission #3

#### General  
Dear reader,  

this time we would like to forward you to the latest Maven site documentation.
Everything included in this release is specified there more precisely.
It is correct, that we could simply paste the information here once again.
However, we want to keep the documentation clear and preferably non-redundant.

Please visit the 'Design decisions' section, 
for more information about all exciting new features of this amazing project.

Kind regards,  
the developers of this project

#### Lessons learned   
Advanced usage of Git as a VCS (multi branching and merging), implementing interfaces in Java, 
updating and extending the code base, creating unit tests with a focus on 100% line coverage, 
working by best practice principles and 
getting familiar with new packages such as Jacoco, 
Surefire or Maven site (supporting our documentation representation).

---

## JavaDoc crash course

### General
JavaDoc is part of the JDK (Java Development Kit) and therefore a tool for generating documentations in HTML format.  
In order to generate a documentation from `.java` files, comments inside the code have to be added complying with the JavaDoc specification.  
JavaDoc comments are similar to normal comments, but with a second asterisk at the beginning of the first comment line.

```
/**
* This is a nice JavaDoc comment.
*/
```

JavaDoc comments should be placed in front of classes, enumerations, fields or method declarations.  
They should consist out of two parts, a description and optional annotations.
Description simply means what a class or method does, preferred in a way more descriptive
 than what can be read from the method name.
Each block tag contains individual important info or references.

#### Most important block tags:  
* `@author` - Name of the programmer(s). Only for classes, interfaces and enumerations.  
Ideally: Multiple `@authors` should be ordered in chronological way.
* `@version` - Represents the version of the software (or file, some organizations might miss-use it).   
Classes, interfaces and enumerations should be annotated with it.  
* `@param` - What parameters are used in a method (and how they are used).  
Ideally: Should be listed in the order of the corresponding arguments.  
* `@return` - Gives further information about the value which a method returns.  
* `@exception / @throws` - Describes cases in which an exception is expected from a method and the type of it.  
* `@see` - Links or references classes, enumerations, interfaces or other information of another documentation.  
Hint: Can be specified as the simple class name or for greater projects path to class name (namespace/className).  
* `@since` - Specifies in which version a class, enumeration, interface, field or method was added  
(can be omitted if `@version` represents the same value).  
* `@deprecated` - Explains why code is deprecated and what the alternatives are. Can again be used for classes,
enumerations, interfaces, fields or methods.

There are also additional, less common tags (`@docRoot`, `@inheritDoc`, `@serial`, etc.).   
Please consult the reference for further information about them.

**Reference**:
[Official documentation](https://www.oracle.com/technical-resources/articles/java/JavaDoc-tool.html)

---

## Test coverage

### General information / opinion
Tests should only be written for more complex use cases 
(especially if there are many edge cases and a complicated business logic is implemented).  
Writing tests for every little method, which will always return a valid outcome, 
should be minimized as otherwise a lot of time and therefore money will be wasted. 

**Note**: This is only a brief introduction to the topic of test coverage.  
For additional information please consolidate 
the latest Maven site documentation ('Test coverage info' section).

---

## Changelog

### Version 1.0

#### Added classes
- Brand
- SoftLiquid
- Tea
- Cocktail
- Smoothie
- Fruit

#### Changes of Lukas Bobik
1. **Commit**: add new `Tea` class
   Add a new tea and print tea to main method
   Add "sugar" as attribute
   
1. **Commit**: merge  
  Merge Main class, done in IntelliJ directly
   
1. **Commit**: 
   Add a new attribute to Tea "Milk"
   Changes to toString Method
   
3. **Commit**: 
   Add setter  
   updates to some method description and small code changes  
   changes to toString  

4. **Commit**: 
   Updates to README.md
   
5. **Commit**: 
    Small readme changes
  
6. **Commit**: adds a new drink subclass `Smoothie` and a `Fruit` class as ingredients 
   Add corresponding new `Smoothie` to main method. 
   (also adds a small gimmick that praises the superiority of milkshakes over normal smoothies if milk is chosen as liquid)
   
7. **Commit**: update descriptions and format

#### Changes of Andreas Steirer
1. **Commit**: add Brand enum  
   Add a `Brand` enumeration for future use in our drinks-project.  
   This enum represents a cleaner way of handling different static types in our implementation.  
   **Additional information**:  
   - Introduce title variable to achieve a better readable name.
   - Implement `toString`-Method for cleaner / easier usage of `Brand`.
   
1. **Commit**: add SoftLiquid class  
   Add `SoftLiquid` which extends from the already defined `Liquid` class.  
   Additional parameter `Brand` can be found in there specifying the newly  
   defined `Liquid` (`SoftLiquid`) a little further.  
   Next to that soft drinks always got a name and a volume. For the variable `alcoholPercent`
   a default value (0.0) is passed to the super constructor as there is never alcohol in a `SoftLiquid`.
   
1. **Commit**: minor changes to SimpleDrink class  
   Some formatting clean-up and simplification of an expression.

1. **Commit**: add .gitignore file to disable change tracking for the specified files    
   Introduce a .gitignore file to the root of the project, 
   to get rid of the annoying generated IDE and build files in our changelist.
   
1. **Commit**: add description to Brand getter / setter in SoftLiquid  
   Introduce a description to the two extra specified methods because of the `Brand` implementation.
   
1. **Commit**: update structure of README  
   Clean-up and extend structure of `README`. Introduce mark-up syntax and some general information.
   
1. **Commit**: minor changes to Brand enum (do not use same naming like base implementation)  
   Prevent a misuse / shadow of the main `name` definition of an enumeration. We now use `title` instead.
   
1. **Commit**: update README with commit- and changelog-history and minor formatting changes  
   Extend the already defined structure with all the changes I applied to the project.
   Apply auto-formatting to all project files.
   
1. **Commit**: minor changes to toString method of SoftLiquid  
   Update the `toString` method in terms of formulation.
   
1. **Commit**: clean-up in Main class  
   Minor clean-up work to prevent too much code duplication.
   
1. **Commit**: fix mismatch in SoftLiquid toString formulation  
   Again fix the formulation of `SoftLiquid` method as there were errors.
   
1. **Commit**: update description of SoftLiquid  
   Fix some wrong descriptions inside `SoftLiquid` class.

1. **Commit**: add Cocktail class which extends from Drink and add corresponding Main demonstration  
   Implement a second class / beverage called `Cocktail` to make sure, 
   that I do not act against the task description (inherit from `Drink` / `SimpleDrink`) :D
   The new `Cocktail` class and later on its objects contain information about its name and included `Liquid`s.
   The implementation of the inherited methods uses information of the object
   to compute values such as the total alcohol percentage and the volume of the whole `Cocktail`. 
   It also states if the `Cocktail` includes alcohol or not as a little shortcut.
   
### Version 2.0
 
#### Added classes
- LongDrink
- ValidationException
- CocktailTests
- softLiquidTests
- FruitTests
- LiquidTests
- LongDrinkTests
- SimpleDrinkTests
- SmoothieTests
- TeaTests
 
#### Changes of Lukas Bobik
1. **Commit**: add `LongDrink` class that extends `Drink class`, and contains 1 alcoholic `Liquid` and 1 `SoftLiquid`
    fixed a small typo in `Fruit` class
    
1. **Commit**: add and implement a test class for `Tea` and removed an unnecessary constructor from `Tea` class
 
1. **Commit**: add tests for `Smoothie` and `Fruit` classes
 
1. **Commit**: add tests for `LongDrink` class
 
1. **Commit**: add missing javdoc descriptions
 
1. **Commit**: merge test branches to main
 
1. **Commit**: add tests for `Liquid` and `SimpleDrink` classes
 
1. **Commit**: minor change to some test names
 
1. **Commit**: changes to readme (test coverage, JavaDoc)

#### Changes of Andreas Steirer
* **Commit**: small update to project structure  
  Updates the structure of the project to be more ordered and therefore easier to navigate.
  
  Current structure is now as following:
  
    ```
    |-- src                           Source directory for the entire code base
    |   |-- java                      Sources root directory for the entire code base
    |   |   |-- at.fhj.iit            Main package for the entire application code
    |   |   |   |-- base              Base package including the stock code base
    |   |   |   |-- custom            Custom package including the student-engineered code base
    |   |   |   |   |-- drink         Drink package storing all the custom created drink classes
    |   |   |   |   |-- misc          Misc package including different kind of additional classes
    |-- test    |   |                 Source directory for code testing
    |   |       |-- exception         Custom exception types are included here
    |   |-- java    |                 Test sources root directory for code testing
    |   |   |-- at.fhj.iit            Main test package for code testing      
    ```

* **Commits**:  
  1. update structure of README    
  1. re-structure README file and add additional documentation  
  1. minor changes to README  
  
  Change structure of README file so that changelog is now versioned correctly.
  
* **Commit**: refactor structure of `Main` class
  Refactor and update structure of `Main` class to be more clear and therefore clean.
  
* **Commit**: add missing jupiter dependencies to pom.xml    
  After looking up the required dependencies and a comparison with the presented example projects,  
  the missing dependencies of junit.jupiter were added to Maven's configuration file (pom.xml).
  
* **Commits**:  
  1. update pom file with developer and version info 
  1. re-add initial developer info (to not steal credit :D)   
  Small addition to the developer and version information properties.
  The students of this project are now also part of it! Nothing more to add or explain.
  
* **Commits**:
  1. add additional documentation to `Cocktail` class
  1. add missing documentation to `SoftLiquid` class
  1. update `Brand` with documentation and change wording
  1. add missing documentation to `Liquid` class
  1. add missing documentation to `Drink` class
  1. add missing documentation to `SimpleDrink` class  
  1. remove redundant version numbers in both tests  
  1. add additional documentation to Main class   
  1. apply formatting and add info to all tests classes  
  
  Update of several classes with latest information and missing javadoc components.  
  Following files were affected: `Cocktail`, `SoftLiquid`, `Brand`, `Liquid`, `Drink` and `SimpleDrink`. 

* **Commit**: add additional functionality to `Cocktail` class
  Add an additional object generation validation in order to prevent the generation of `Cocktail`s without a `Liquid`.  
  Besides that, a special setter / update method is added which can manipulate single `Liquid` objects of a `Cocktail` per field.
  
* **Commits**: 
  1. add custom `ValidationException`
  1. change Exception type in Liquid (checkVolume)  
  
  To better specify an error occurred during a validation a custom `Exception` is introduced.  
  This custom `ValidationException` inherits its type from `IllegalArgumentException`.  
  Therefore, all current usages of validations in connection with `IllegalArgumentException`s are replaced.  
  
* **Commits**:
  1. add CocktailTests class  
  2. add SoftLiquidTests class  
  
  In order to achieve 100% test coverage several to all possible test cases are implemented  
  (also some which might not be implemented or really needed in a real environment).  
  
  
### Version 3.0
 
#### Added classes
- CashRegisterManagement
- DrinkSale
- Operator
- IDrinkSpecification
- CashRegisterRandomizer
- DrinkUtils
 
#### Added test classes
- CashRegisterManagementTests
- DrinkSaleTests
- OperatorTests
- CashRegisterRandomizerTests
- DrinkUtilsTests
- MainTests
 
 
#### Update to structural model
Current structure is now as following:
```
|-- src                            Source directory for the entire code base
|   |-- java                       Sources root directory for the entire code base
|   |   |-- at.fhj.iit             Main package for the entire application code
|   |   |   |-- base               Base package including the stock code base
|   |   |   |-- custom             Custom package including the student-engineered code base
|   |   |   |   |-- cashRegister   CashRegister solution package includes data and mangements classes
|   |   |   |   |-- drink          Drink package storing all the custom created drink classes
|   |   |   |   |-- misc           Misc package including different kind of additional classes / interfaces
|-- test    |   |                  Source directory for code testing
|   |       |-- exception          Custom exception types are included here
|   |       |-- extension          Extension package including different extensive classes / interfaces
|   |       |-- util               Helper package including utility classes / methods for broader usage
|   |
|   |-- java                       Test sources root directory for code testing
|   |   |-- at.fhj.iit             Main test package for code testing  
|   |   |   |-- base               Base test package including test cases for the stock code base
|   |   |   |-- custom             Custom test package including tests for the student-engineered code base
|   |   |   |   |-- cashRegister   CashRegister test package including tests for the cash register feature
|   |   |   |   |-- drink          Drink test package holds all unit tests regarding the created drink classes
|   |   |   |   |-- misc           Misc package including different kind of additional classes / interfaces
```

#### Changes of Lukas Bobik
* **Commit**: fix package structure for tests  
!! TODO !!
 
* **Commit**: fix 2 small test cases  
!! TODO !!
 
* **Commit**: add surefire report plugin for maven site  
!! TODO !!

* **Commit**: add site.xml and md files for site  
!! TODO !!
 
#### Changes of Andreas Steirer
* **Commit**: update pom file with site plugins and packages   
  Update pom.xml file with task specific / required plugins and dependencies 
  (jacoco, javadoc, project-info-reports, resources, surefire). 
  Additionally, update JUnit from 5.7.0-M1 to 5.8.0-M1, 
  add some describing comments and additional artifacts like `scm` and `licences`.
   
* **Commit**: rename `SoftDrink` to `SoftLiquid`  
  Not really an explanation needed :D
   
* **Commits**: 
  1. add DrinkSpecification interface
  1. implement DrinkSpecification to `Drink` inheritors
  
  From now on the abstract `Drink` class implements the `IDrinkSpecification` interface.
  We do this because every `ConcreteDrink` should implement the defined `calculatePrice` method in their own way. 
  Alternatively, we could have declared the method head in the abstract class itself.
  However, we would act against a requirement of the task.
  Therefore, and for diversification purposes we let all 
  child classes implement the price calculation method.
  
  ```
  Nice-to-know: Java apparently does not specify a (naming) convention, 
  which prohibits the use of methods starting with 'get' for non-accessor / state only purposes.
  ```
  
* **Commit**: add `DrinkUtils` class with helper methods  
  To keep application code simple and clean,  
  we extract smaller utility functions / common code to an own file.
   
* **Commits**: 
  1. add javafaker dependency for testing purposes
  1. add `CashRegisterRandomizer` for test purposes
  
  Implement a helper class for filling the `CashRegisterManagement` (history)
  implementation with random information. 
  Mainly for demonstration purposes, but also created out of sheer fun, 
  as I it is kind of handy and good for random demonstrations :D  
  
* **Commits**: 
  1. add entire `CashRegisterManagement` logic
  1. implement CashRegister demo, refactoring in Main
  1. add additional methods to `CashRegisterManagement`
  1. update `DrinkSale` constructor
  1. relocate `IDrinkSpecification` to 'extension'
  
  Implement a `CashRegisterManagement` class, 
  which is basically equal to the `Registrierkasse` class of the requirements doc.
  Next to an item / a drink sale history list with additional addition logic, the management / inventory class include
  all required report queries / metric calculations.
  We decided to wrap `Drink` objects generated in a sale, 
  into a new `DrinkSale` object. It also includes information about the exact time on which a sale happens 
  and by whom it is carried out / executed.
  
  To actually use the already mentioned `CashRegisterRandomizer` class, we created a demo in the `Main` class.
  Apparently the re-structuring of the `Main` file was lost last time, so we re-add it once again. 
  
  "Missing" methods like an extra constructor taking a `salesHistory`, 
  the accessory method for the `salesHistory` and an aggregate addition method for the `salesHistory` are added.
  
* **Commits**: 
  1. add documentation and some restructuring/clean-up
  1. update javadoc documentation of several classes
  1. minor changes to docu in `Tea`
  1. update all javadoc with the latest info
  1. add missing info in `CashRegisterManagementTests`
  1. minor changes to `Fruit- and SoftLiquidTests`
  1. update several documentations in tests
  1. update documentation for some tests
  1. update documentation + behavior of multiple tests
  1. update README file with changelog of version 3.0
  1. update README file with last changes and reference
  1. update 'Test coverage' section in README
  
  Not much to say about these points. 
  Mainly adding documentation for the newly created business logic, 
  additions to old docs and corresponding annotations.
  
* **Commits**: 
  1. add `CashRegisterManagementTests` class
  1. add `OperatorTests` class
  1. add `DrinkSaleTests` class
  1. minor update to several tests (conform to JUnit)
  1. add `DrinkUtilsTests` class
  1. add `CashRegisterRandomizerTests` class
  1. add `MainTests` class
  1. add missing DisplayName to `OperatorTests`
  1. update some classes for Jacoco coverage
  1. minor changes in Smoothie class
  
  Basically a bump from last's assignment description of implementation / changelog.
  For additional, more test specific specialities / documentation 
  please consult the unit tests (documentation) accordingly.
  ```
  In order to achieve 100% test coverage several to all possible test cases are implemented  
  (also some which might not be implemented or really needed in a real environment).  
  ```
  
* **Commit**: fix a problem in Cocktail's update method  
  There was a problem in the implementation leading to unwanted changes.
  This behavior has been fixed now.
  
* **Commits**: 
  1. rename two site markup files
  1. remove README.md from site markdow
  1. add generated / copied site README file to .gitignore
  1. update site.xml and image resources
  1. add 'design decisions' site documentation
  
  Introducing two new Maven sites. 
  The first one features thoughts and ideas behind 
  our cash register management functionality.
  The second one dives in and explains the achieved 
  percentages, the meaning of test coverage and 
  unit test procedures in general.
  
  
  
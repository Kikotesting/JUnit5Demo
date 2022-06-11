# Setup the IntelliJ IDEA 2022.1.1 Community
1. Go to maven repository: [https://mvnrepository.com/](https://mvnrepository.com/)
2. Search for JUnit5 Aggregator
3. Copy the maven dependancy
4. Open IntelliJ idea and create maven project-quick start
5. Clean the folder below java in test and main
6. Go to maven options locates right on the panel
7. Select clean and install and run the project
8. Go to pom.xml and find the "<artifactId>maven-compiler-plugin</artifactId>"
9. Add this configurator options below version tag
```
<configuration>
  <source>8</source>
  <target>8</target>
</configuration>
```
10.Go to maven options and re-run the project

# Tests

1. Lifecycle methods - BeforeAll-Each, AfterAll-Each
2. Parameterized tests 
3. ValueSource
4. CsvSource
5. CsvFileSource
6.MethodSource
- If they are in a different class, they will need to be `static`
- If they're in the same class, we could also declare them as `static`, unless we've already actually used the lifecycle per class option, because we already had some before or after types of annotations in our tests.
- If we don't have that, then this method will need to be static, but I don't want to make the methods static
## Test Run Order
1. ClassName⇒ methods name
2. DisplayName - alphabetical order
3. OrderName 
    We will need to add an additional annotation - namely, the `@Order`.
    And then, between the `()`, we need to specify an `int` value, so I will specify the value '1'
    
## Assumption
Here, we can use JUnit 5's assumption features, which will allow us to skip either an entire test or parts of the test based on the conditions that we will provide to the so-called Assumptions.

1. assumeTrue
 means that if the condition provided to the assumption evaluates to true, only then will the test run. If the condition does not evaluate to true, the test will be skipped.
**Assumptions Require A Condition**
The important thing to remember here is that within the assumption, we need to provide a condition to be evaluated, no matter what that condition is, and that it needs to evaluate to a boolean value.
2. assumeThat
Taking a look at the parameters that I have available
In this case, when we're using `assuming that`, and we are specifying the code to be executed inside the assumption, the rest of the test will run no matter what the result of evaluating this condition from within the assumption will be.
3. assumeFalse
Here I will do an assumption, and I will say `assumeFalse` - so let's try a different type of assumption her - and I will say `assumeFalse(param1.equals("steve"))` , and if this assumption will fail, we want the following message to be printed to the console - namely, "The assumption failed for the following param2."

## Disabled test
1. @Disabled
2. @DisabledByOS
3. @DisabledIf(value = "...", disabled Reason = "....")
 -  boolean expression
## Tags

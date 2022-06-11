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
2. Parameterized tests - (name = “Run {index} - value: {arguments}”)
### ValueSource
```
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }
 ```
 ### CsvSource
 ```
    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky, barners"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, 32, True", "captain, 21, false", "bucky, 5, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
    @ParameterizedTest
    @CsvSource(value = {"captain america, 'steve, rogers'", "winter soldier," + "'bucky barners'"})
    void csvSource_StringWithComma(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain?america","bucky?barners"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
```
### CsvFileSource
```
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
     void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }
```
### MethodSource

- In order for a method to be eligible to be the provider of values for the parameter of another test method, it needs to return a type Stream or anything that can be converted to a Stream, for example, Collections.
- If they are in a different class, they will need to be `static`
- If they're in the same class, we could also declare them as `static`, unless we've already actually used the lifecycle per class option, because we already had some before or after types of annotations in our tests.
- If we don't have that, then this method will need to be static, but I don't want to make the methods static - I prefer to just go ahead and on the class, level say @TestInstance(TestInstance.Lifecycle.PER_CLASS), and this way I don't need to specify the static attributes for my parameter values method.
```
      @ParameterizedTest
      @MethodSource(value = "JUnit5tests.ParamProvider#sourceStream_StringDouble") // choose first or second to execute or to take from different class all parameters
      void methodSource_String(String param1) {
          System.out.println("param1 = " + param1);

      }
      List<String> sourceString() { // this is the first
          //process is done here
          return Arrays.asList("tomato", "carrot", "cabage");
      }

      Stream<String> sourceStringAsStream(){ // this is second
          return Stream.of("beetroot", "apple", "pear");
      }
      @ParameterizedTest
      @MethodSource(value = "sourceList_StringDouble")
      void methodSource_StringDoubleList (String param1, double param2){
          System.out.println("param1 = " + param1 + ", param2 = " + param2);
      }

      List<Arguments> sourceList_StringDouble(){
          //processing
          return Arrays.asList(Arguments.arguments("tomato",2.0),
                  Arguments.arguments("carrot",4.5),
                  Arguments.arguments("cabbage",7.5));
      }
      @ParameterizedTest
      @MethodSource(value = "sourceStream_StringDouble")
      void methodSource_StringDoubleStream(String param1, double param2){
          System.out.println("param1 = " + param1 + ", param2 = " + param2);
      }
```
### Test Run Order
1. ClassName⇒ methods name
2. DisplayName - alphabetical order
3. OrderName 
    We will need to add an additional annotation - namely, the `@Order`.
    And then, between the `()`, we need to specify an `int` value, so I will specify the value `1`.

package JUnit5tests;
import org.junit.jupiter.api.*;




@TestMethodOrder(MethodOrderer.MethodName.class) // alphanumeric order based on method names
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.printf("--This is the before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("-- THis is the before each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("-- THis is the after All method");
    }
    @AfterEach
    void afterEach(){
        System.out.println("-- THis is the after each method");
    }

    @Test
        //access-modifier returnType nameOfMethod(params)
    void firstMethod(){
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }

    @Test
    @DisplayName("Third")
    void thirdMethod(){
        System.out.println("This is the third test method");
    }
}

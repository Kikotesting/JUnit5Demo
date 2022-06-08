package JUnit5tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.printf("--This is the before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("-- THis is the before each method");
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
}

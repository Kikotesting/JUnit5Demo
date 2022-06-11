package JUnit5tests;

import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests {

    @RepeatedTest(5)
    void firstRepeatedMethod(){
        System.out.println("We are repeating the test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." + " Total is: {totalRepetitions}")
    void secondRepetitionMethod(){
        System.out.println("We are repeat a new test");
    }

}

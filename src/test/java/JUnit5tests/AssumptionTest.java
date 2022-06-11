package JUnit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
        assumeTrue(theParam > 4);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky, barners"})
    void csvSource_StringString(String param1, String param2){
        assumeFalse(param1.equals("steve"),"The assumtion failed for the param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, 32, True", "captain, 21, false", "bucky, 5, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        assumingThat(param2 > 20,() -> System.out.println("This code run"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}

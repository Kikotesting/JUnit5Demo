package JUnit5tests;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firststring", "secondstring"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }

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

    @ParameterizedTest
    @CsvFileSource(files ={"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
     void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files ="src/test/resources/params/shoppinglist3.csv",
            numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(
            String name, double price, int qty, String uom, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

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

}

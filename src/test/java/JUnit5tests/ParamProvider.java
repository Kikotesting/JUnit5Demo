package JUnit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ParamProvider {

    static Stream<Arguments> sourceStream_StringDouble(){

        return Stream.of(Arguments.arguments("apple",8.9),Arguments.arguments("pear",1.9));
    }
}

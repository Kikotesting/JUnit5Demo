package JUnit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.debugger.Address;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class AssertionTest {

    @Test
    void assertEqualTestStrings(){
        Assertions.assertEquals("firststring", "firststring");

    }
    @Test
    void assertEqualTestWithMessage(){
        Assertions.assertEquals("firststring", "secondstring", "this string is not equal");

    }
    @Test
    void assertEqualLists(){
        List<String> expectedValues = Arrays.asList("firststring", "secondstring", "thirdstring");
        List<String> actualValues = Arrays.asList("firststring", "", "thirdstring");
        Assertions.assertEquals(expectedValues,actualValues);

    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1,5,3};
        int[] actualValues = {1,2,3};
        Assertions.assertArrayEquals(expectedValues,actualValues);
    }

    @Test
    void assertFalseTest(){
        Assertions.assertFalse(false,"condition true");
    }

    @Test
    void assertThrowsTest(){
        Assertions.assertThrows(NullPointerException.class,null);
    }

}

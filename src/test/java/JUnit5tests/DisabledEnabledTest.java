package JUnit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class DisabledEnabledTest {

    @Test
    @Disabled // can run if we are going to run manually from IntelliJ
    void firstTest(){
        System.out.println("First test method");
    }
    @Test
    @Disabled(value = "Disabled for demo of Disabled")
    void secondTest(){
        System.out.println("Second test method");
    }
    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo")
    void thirdTest(){
        System.out.println("Third test method");
    }
    @Test
    void fourthTest(){
        System.out.println("Fourth test method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled demo for boolean")
    void fiveTest(){
        System.out.println("Five test method");
        String kiko = LocalDateTime.now().getDayOfWeek().toString();
        System.out.println(kiko);
    }
    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
}

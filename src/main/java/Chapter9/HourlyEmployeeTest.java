package Chapter9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyEmployeeTest {

    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("John", "Doe", "123-45-6789", 40, 15);
    }

    @Test
    public void testConstructorValidData() {
        assertEquals(40, hourlyEmployee.getHours());
        assertEquals(15, hourlyEmployee.getWage());
        assertEquals("John", hourlyEmployee.getFirstName());
        assertEquals("Doe", hourlyEmployee.getLastName());
        assertEquals("123-45-6789", hourlyEmployee.getSocialSecurityNumber());
    }

    @Test
    public void testConstructorInvalidHours() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("John", "Doe", "123-45-6789", -5, 15);
        });
        assertEquals("Wrong hours", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("John", "Doe", "123-45-6789", 200, 15);
        });
        assertEquals("Wrong hours", exception.getMessage());
    }

    @Test
    public void testConstructorInvalidWage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("John", "Doe", "123-45-6789", 40, -10);
        });
        assertEquals("Wage cannot be negative", exception.getMessage());
    }

    @Test
    public void testSetHoursValid() {
        hourlyEmployee.setHours(30);
        assertEquals(30, hourlyEmployee.getHours());
    }

    @Test
    public void testSetHoursInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            hourlyEmployee.setHours(-10);
        });
        assertEquals("Wrong hours", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            hourlyEmployee.setHours(170);
        });
        assertEquals("Wrong hours", exception.getMessage());
    }

    @Test
    public void testSetWageValid() {
        hourlyEmployee.setWage(20);
        assertEquals(20, hourlyEmployee.getWage());
    }

    @Test
    public void testSetWageInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            hourlyEmployee.setWage(-5);
        });
        assertEquals("Wage cannot be negative", exception.getMessage());
    }
}

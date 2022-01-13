package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfileTest {
    private Profile profileTester;

    @BeforeEach
    public void beforeEachProfileTest() {
        profileTester = new Profile("Sam Zhao", 20021025, 18,
                181, 176, 215, 385, 335);

    }

    @Test
    public void getFullNameTest() {
        assertEquals("Sam Zhao", profileTester.getFullName());
    }

    @Test
    public void getDateOfBirthTest() {
        assertEquals(20021025, profileTester.getDateOfBirth());
    }

    @Test
    public void getAgeTest() {
        assertEquals(18, profileTester.getAge());
    }

    @Test
    public void getHeightTest() {
        assertEquals(181, profileTester.getHeight());
    }

    @Test
    public void getWeightTest() {
        assertEquals(176, profileTester.getWeight());
    }

    @Test
    public void getBenchMaxTest() {
        assertEquals(215, profileTester.getBenchMax());
    }

    @Test
    public void getDeadliftMaxTest() {
        assertEquals(385, profileTester.getDeadliftMax());
    }

    @Test
    public void getSquatMaxTest() {
        assertEquals(335, profileTester.getSquatMax());
    }

    @Test
    public void setFullNameTest() {
        assertEquals("Sam Zhao", profileTester.getFullName());
        profileTester.setFullName("John Smith");
        assertEquals("John Smith", profileTester.getFullName());
    }

    @Test
    public void setAgeTest() {
        assertEquals(18, profileTester.getAge());
        profileTester.setAge(20);
        assertEquals(20, profileTester.getAge());
    }

    @Test
    public void setHeightTest() {
        assertEquals(181, profileTester.getHeight());
        profileTester.setHeight(183);
        assertEquals(183, profileTester.getHeight());
    }
    @Test
    public void setWeightTest() {
        assertEquals(176, profileTester.getWeight());
        profileTester.setWeight(200);
        assertEquals(200, profileTester.getWeight());
    }

    @Test
    public void setDateOfBirthTest() {
        assertEquals(20021025, profileTester.getDateOfBirth());
        profileTester.setDateOfBirth(20001014);
        assertEquals(20001014, profileTester.getDateOfBirth());
    }

    @Test
    public void setBenchMaxTest() {
        assertEquals(215, profileTester.getBenchMax());
        profileTester.setBenchMax(135);
        assertEquals(135, profileTester.getBenchMax());
    }

    @Test
    public void setDeadliftMaxTest() {
        assertEquals(385, profileTester.getDeadliftMax());
        profileTester.setDeadliftMax(225);
        assertEquals(225, profileTester.getDeadliftMax());
    }

    @Test
    public void setSquatMaxTest() {
        assertEquals(335, profileTester.getSquatMax());
        profileTester.setSquatMax(245);
        assertEquals(245, profileTester.getSquatMax());
    }


}

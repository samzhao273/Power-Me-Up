package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkoutTest {
    private Workout workoutTester;

    @BeforeEach
    public void beforeEachWorkoutTest() {
        workoutTester = new Workout("workout1", 20211013, 30,
                200, "Push", 185, 5, 5,
                "BirdCoop", "quick little workout, hit some chest.", false);
    }

    @Test
    public void getSetsTest() {
        assertEquals(5, workoutTester.getSets());

    }

    @Test
    public void getRepsTet() {
        assertEquals(5, workoutTester.getReps());

    }
    @Test
    public void getDescriptionTest() {
        assertEquals("quick little workout, hit some chest.", workoutTester.getDescription());
    }

}
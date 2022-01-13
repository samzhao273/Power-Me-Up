package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkoutsTest {
    private Workout workout1;
    private Workout workout2;
    private Workout workout3;
    private Workout workout4;
    private Workout workout5;
    private Workout workout6;
    private Workouts workoutsTest;

    @BeforeEach
    public void beforeEachTest() {
        workout1 = new Workout("workout1", 20211013, 30,
                200, "Push", 185, 5, 5,
                "BirdCoop", "quick little workout, hit some chest.", false);
        workout2 = new Workout("workout2", 20211014, 60,
                300, "Pull", 245, 5, 5,
                "ARC", "quick little workout, hit some back.", false);
        workout3 = new Workout("workout3", 20211015, 90,
                400, "Legs", 225, 5, 5,
                "Home", "Long Workout, hit some legs.", true);
        workout4 = new Workout("workout4", 20211016, 45,
                300, "Push", 215, 1, 1,
                "BirdCoop", "hit my max for bench.", true);
        workout5 = new Workout("workout5", 20211017, 15,
                100, "Pull", 385, 1, 1,
                "ARC", "hit my max for deadlifts.", true);
        workout6 = new Workout("workout6", 20211018, 10,
                50, "Legs", 335, 1, 1,
                "Home", "hit my max for squats.", true);
        workoutsTest = new Workouts("Workouts Test");


    }
    @Test
    public void getNameTest() {
        assertEquals("Workouts Test", workoutsTest.getName());
    }

    @Test
    public void addWorkoutTest() {
        assertEquals(0, workoutsTest.length());
        workoutsTest.addWorkout(workout1);
        assertEquals(1, workoutsTest.length());

    }

    @Test
    public void removeWorkoutTest() {
        assertEquals(0, workoutsTest.length());
        workoutsTest.addWorkout(workout1);
        assertEquals(1, workoutsTest.length());
        workoutsTest.removeWorkout(workout1);
        assertEquals(0, workoutsTest.length());
    }

    @Test
    public void getWorkoutTest() {
        workoutsTest.addWorkout(workout1);
        assertEquals(workout1, workoutsTest.getWorkout("workout1"));
        assertEquals(null, workoutsTest.getWorkout("workout2"));

    }

    @Test
    public void filterByTypeTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(2, workoutsTest.filterByType("Push").length());

    }

    @Test
    public void filterByFavouritesTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(4, workoutsTest.filterByFavourites().length());

    }

    @Test
    public void filterByDurationTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(4, workoutsTest.filterByDuration(30).length());

    }

    @Test
    public void filterByCaloriesBurnedTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(3, workoutsTest.filterByCaloriesBurned(300).length());

    }


    @Test
    public void filterByWeightHitTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(2, workoutsTest.filterByWeightHit("Push", 185).length());
        assertEquals(1, workoutsTest.filterByWeightHit("Push", 215).length());

    }

    @Test
    public void filterByDateTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(3, workoutsTest.filterByDate(20211016).length());

    }

    @Test
    public void filterByLocationTest() {
        workoutsTest.addWorkout(workout1);
        workoutsTest.addWorkout(workout2);
        workoutsTest.addWorkout(workout3);
        workoutsTest.addWorkout(workout4);
        workoutsTest.addWorkout(workout5);
        workoutsTest.addWorkout(workout6);
        assertEquals(6, workoutsTest.length());
        assertEquals(2, workoutsTest.filterByLocation("ARC").length());

    }

    @Test
    public void getWlTest() {
        assertTrue(workoutsTest.length() == workoutsTest.getWl().size());

    }

    @Test
    public void showWorkoutsTest() {
        workoutsTest.addWorkout(workout1);
        assertEquals( "\n" + "workout1", workoutsTest.showWorkouts());
    }












}



    



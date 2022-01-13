package persistence;

import model.Profile;
import model.Workout;
import model.Workouts;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
// Reference: Used JsonSerializationDemo code

public class JsonWriterTest {

    Workout workout1 = new Workout("workout1", 20211013, 30,
            200, "Push", 185, 5, 5,
            "BirdCoop", "quick little workout, hit some chest.", false);


    @Test
    void testWriterInvalidFile() {
        try {
            Workouts wl = new Workouts("Your Workouts");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            //pass

        }

    }

    @Test
    void testWriterEmptyWorkouts() {
        try {
            Workouts wl = new Workouts("Your Workouts");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkouts.json");
            writer.open();
            writer.writeWorkouts(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkouts.json");
            wl = reader.readWorkouts();
            assertEquals("Your Workouts", wl.getName());
            assertEquals(0, wl.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }

    @Test
    void testWriterGeneralWorkouts() {
        try {
            Workouts wl = new Workouts("Your Workouts");
            wl.addWorkout(workout1);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkouts.json");
            writer.open();
            writer.writeWorkouts(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkouts.json");
            wl = reader.readWorkouts();
            assertEquals("Your Workouts", wl.getName());
            List<Workout> workoutList = wl.getWl();
            assertEquals(1, workoutList.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");

        }

    }

    @Test
    void testProfile() {
        try {
            Profile profile = new Profile("Sam Smith", 200210101, 1000, 1,
                    1,1,1,1);
            JsonWriter writer = new JsonWriter("./data/testProfile.json");
            writer.open();
            writer.writeProfile(profile);
            writer.close();

            JsonReader reader = new JsonReader("./data/testProfile.json");
            assertEquals("Sam Smith", profile.getFullName());
        } catch (FileNotFoundException e) {
            fail("Exception should not have been thrown");
        }
    }
}

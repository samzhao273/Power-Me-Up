package persistence;

import model.Workout;
import model.Workouts;
import model.Profile;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Reference: Used JsonSerializationDemo code

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Workouts wl = reader.readWorkouts();
            fail("IOException expected");
        } catch (IOException e) {
           // pass
        }
    }

    @Test
    void testReaderEmptyWorkouts() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkouts.json");
        try {
            Workouts wl = reader.readWorkouts();
            assertEquals("Your Workouts", wl.getName());
            assertEquals(0, wl.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkouts() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkouts.json");
        try {
            Workouts wl = reader.readWorkouts();
            assertEquals("Your Workouts", wl.getName());
            List<Workout> workouts = wl.getWl();
            assertEquals(1, workouts.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    @Test
    void testReaderEmptyProfile() {
        JsonReader reader = new JsonReader ("./data/testProfile.json");
        try {
           Profile profile = reader.readProfile();
            assertEquals("Sam Smith", profile.getFullName());
        } catch (IOException e) {
            fail("Couldn't read from file");

        }
    }


}

package persistence;


import model.Workout;
import model.Profile;
import model.Workouts;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Reference: Used JsonSerializationDemo code
// represents a reader that reads Workouts from JSON data stored in given file

public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;

    }

    //EFFECTS: reads Workouts from file and returns it
    // throws IOException if an error happens while data is being read from file
    public Workouts readWorkouts() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkouts(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    //EFFECTS: parses Workouts from JSON object and returns it
    private Workouts parseWorkouts(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Workouts wl = new Workouts(name);
        addWorkouts(wl, jsonObject);
        return wl;


    }

    //MODIFIES: wl
    //EFFECTS: parses workouts from JSON object and adds them to the workout list
    private void addWorkouts(Workouts wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Your Workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(wl, nextWorkout);
        }
    }

    //MODIFIES: wl
    //EFFECTS: parses workout from JSON object and adds it to workouts
    private void addWorkout(Workouts wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int date = jsonObject.getInt("date");
        int duration = jsonObject.getInt("duration");
        int caloriesBurned = jsonObject.getInt("calories burned");
        String type = jsonObject.getString("type");
        int weight = jsonObject.getInt("weight");
        int sets = jsonObject.getInt("sets");
        int reps = jsonObject.getInt("reps");
        String location = jsonObject.getString("location");
        String description = jsonObject.getString("description");
        boolean favour = jsonObject.getBoolean("favourite");
        Workout workout = new Workout(name, date, duration, caloriesBurned, type, weight, sets, reps, location,
                description, favour);
        wl.addWorkout(workout);
    }

    //EFFECTS: reads Profile from file and returns it
    // throws IOException if an error happens while data is being read from file
    public Profile readProfile() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProfile(jsonObject);
    }

    //EFFECTS: parses Workouts from JSON object and returns it
    private Profile parseProfile(JSONObject jsonObject) {
        String fullName = jsonObject.getString("fullName");
        int dateOfBirth = jsonObject.getInt("dateOfBirth");
        int age = jsonObject.getInt("age");
        int height = jsonObject.getInt("height");
        int weight = jsonObject.getInt("weight");
        int benchMax = jsonObject.getInt("benchMax");
        int deadliftMax = jsonObject.getInt("deadliftMax");
        int squatMax = jsonObject.getInt("squatMax");
        Profile profile = new Profile(fullName, dateOfBirth, age, height, weight, benchMax, deadliftMax, squatMax);
        return profile;

    }


}

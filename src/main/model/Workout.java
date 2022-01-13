package model;

import persistence.Writable;
import org.json.JSONObject;




public class Workout implements Writable {
    private String name;
    private int date;     // must be in form YYYYMMDD
    private int duration; // in minutes
    private int caloriesBurned;
    private String type;  // must be only "Push" or "Pull" or "Legs"
    private int weight;   // in lbs
    private int sets;     // Must be > 0
    private int reps;     // Must be > 0
    private String location;
    private String description;
    private boolean favour;


    //REQUIRES: Must enter all data in workout
    //MODIFIES: this
    //EFFECTS: Creates new workout with date, duration, calories burned, type and location
    public Workout(String nameOfWorkout, int dateOfWorkout, int durationOfWorkout,
                   int caloriesBurnedInWorkout, String workoutType, int workoutWeight, int workoutSets, int workoutReps,
                   String workoutLocation, String workoutDescription,
                   boolean workoutFavourite
    ) {
        this.name = nameOfWorkout;
        this.date = dateOfWorkout;
        this.duration = durationOfWorkout;
        this.caloriesBurned = caloriesBurnedInWorkout;
        this.sets = workoutSets;
        this.reps = workoutReps;
        this.type = workoutType;
        this.weight = workoutWeight;
        this.location = workoutLocation;
        this.description = workoutDescription;
        this.favour = workoutFavourite;
    }


    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getType() {
        return type;
    }


    public String getLocation() {
        return location;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public String getDescription() {
        return description;
    }


    public Boolean isFavourite() {
        return favour;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("date",date);
        json.put("duration",duration);
        json.put("calories burned",caloriesBurned);
        json.put("type",type);
        json.put("weight",weight);
        json.put("sets",sets);
        json.put("reps", reps);
        json.put("location", location);
        json.put("description",description);
        json.put("favourite", favour);
        return json;
    }

    public String showWorkoutDetails(Workout w) {
        EventLog.getInstance().logEvent(new Event("Got Workout:" + " " + w.getName()));
        String s = "";
        s += "Date:" + " " + Integer.toString(w.getDate()) + "\n"
                + "Duration:" + " " + Integer.toString(w.getDuration()) + "\n"
                + "Calories Burned:" + " " + Integer.toString(w.getCaloriesBurned()) + "\n"
                + "Type:" + " " + w.getType() + "\n"
                + "Weight Used:" + " " + Integer.toString(w.getWeight()) + "\n"
                + "#of Sets:" + " " + Integer.toString(w.getSets()) + "\n"
                + "#of Reps:" + " " + Integer.toString(w.getReps()) + "\n"
                + "Workout Location:" + " " + w.getLocation() + "\n"
                + "Description:" + " " + w.getDescription() + "\n"
                + "Favourite:" + " " + Boolean.toString(w.isFavourite());
        return s;

    }
}
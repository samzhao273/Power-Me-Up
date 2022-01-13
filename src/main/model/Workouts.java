package model;



import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;


// Only one List of Workout will be used throughout the application
// Workouts is a list of workouts with a name and a list of attached workouts
public class Workouts implements Writable {
    private String name = new String();
    private ArrayList<Workout> wl = new ArrayList<>();

    public Workouts(String name) {
        super();
    }

    public String getName() {
        return name;
    }

    public void addWorkout(Workout w) {
        wl.add(w);
        EventLog.getInstance().logEvent(new Event("Workout: " + w.getName() + " added to Your Workouts"));
    }

    //EFFECTS: Removes the workout from the collection of workouts
    public void removeWorkout(Workout w) {
        wl.remove(w);
    }

    //REQUIRES: The list of Workouts to be non-empty and must contain the workout
    //EFFECTS: Returns the workout after inputting the name of specified
    //         workout that user is looking for or returns null if not found
    public Workout getWorkout(String workoutName) {
        for (Workout w : wl) {
            if (w.getName().equals(workoutName)) {
                return w;
            }
        }
        return null;
    }

    //EFFECTS: Returns the list of Workouts
    public ArrayList<Workout> getWl() {
        return wl;
    }

    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS: creates and returns a  list of filtered workouts that have the same type
    public Workouts filterByType(String workoutType) {
        Workouts workoutsOfSameType = new Workouts("Filtered by Type");
        for (Workout w : wl) {
            if (w.getType().equals(workoutType)) {
                workoutsOfSameType.addWorkout(w);
            }
        }
        return workoutsOfSameType;

    }

    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS: creates and returns a list of favourite workouts
    public Workouts filterByFavourites() {
        Workouts favouriteWorkouts = new Workouts("Favourite Workouts");
        for (Workout w : wl) {
            if (w.isFavourite() == true) {
                favouriteWorkouts.addWorkout(w);
            }
        }
        return favouriteWorkouts;
    }


    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS:  creates  and returns a list filtered out workouts that have duration >= x
    public Workouts filterByDuration(int workoutDuration) {
        Workouts workoutsFilteredByDuration = new Workouts("Filtered By Duration");
        for (Workout w : wl) {
            if (w.getDuration() >= workoutDuration) {
                workoutsFilteredByDuration.addWorkout(w);
            }
        }
        return workoutsFilteredByDuration;
    }

    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS: creates and returns a list of workouts with calories burned >= x
    public Workouts filterByCaloriesBurned(int caloriesBurnedInWorkout) {
        Workouts workoutFilteredByCalories = new Workouts("Filtered By Calories");
        for (Workout w : wl) {
            if (w.getCaloriesBurned() >= caloriesBurnedInWorkout) {
                workoutFilteredByCalories.addWorkout(w);
            }
        }
        return workoutFilteredByCalories;
    }


    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS:  creates and returns a list of Workouts that are the same type and have reached a certain weight
    public Workouts filterByWeightHit(String workoutType, int workoutWeight) {
        Workouts workoutsFilteredByWeightHit = new Workouts("Filtered by Weight");
        for (Workout w : wl) {
            if ((w.getType().equals(workoutType))
                    &&
                    (w.getWeight() >= workoutWeight)) {
                workoutsFilteredByWeightHit.addWorkout(w);
            }
        }
        return workoutsFilteredByWeightHit;
    }

    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS:  creatse and returns and lit of workouts that are after a certain date
    public Workouts filterByDate(int dateOfWorkout) {
        Workouts workoutsFilteredByDate = new Workouts("Filtered By Date");
        for (Workout w : wl) {
            if (w.getDate() >= dateOfWorkout) {
                workoutsFilteredByDate.addWorkout(w);
            }
        }
        return workoutsFilteredByDate;
    }

    //REQUIRES: A list of Workouts that is non-empty
    //EFFECTS:  creates and returns a list of workouts in the same location
    public Workouts filterByLocation(String workoutLocation) {
        Workouts workoutsFilteredByLocation = new Workouts(" Filtered by Location");
        for (Workout w : wl) {
            if (w.getLocation().equals(workoutLocation)) {
                workoutsFilteredByLocation.addWorkout(w);
            }
        }
        return workoutsFilteredByLocation;
    }


    //EFFECTS: Returns the number of Workouts in the workout List
    public Integer length() {
        return wl.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Your Workouts", workoutsToJson());
        return json;

    }

    //EFFECTS: return things in this Workout list as a JSON array
    private JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Workout w : wl) {
            jsonArray.put((w.toJson()));
        }
        return jsonArray;


    }

    //EFFECTS: returns your wl with the names in a the format of a list
    public String showWorkouts() {
        EventLog.getInstance().logEvent(new Event("Viewed Your Workouts"));
        String s = "";
        for (Workout w : wl) {
            if (w.getName() != "") {
                s += "\n" + w.getName();

            }
        }
        return s;
    }

}

package model;


import org.json.JSONObject;
import persistence.Writable;

public class Profile implements Writable {

    private String fullName; // First and Last Name
    private int dateOfBirth; // Must be in form YYYYMMDD
    private int age; // Must be > 12
    private int height; // In cm, must be > 0.
    private int weight; // In lbs, must be > 0.
    private int benchMax; // In lbs.
    private int deadliftMax; // In lbs.
    private int squatMax; // In lbs.

    public Profile(String profileName, int profileDateOfBirth, int profileAge, int profileHeight,
                   int profileWeight, int profileBenchMax, int profileDeadliftMax, int profileSquatMax) {
        this.fullName = profileName;
        this.dateOfBirth = profileDateOfBirth;
        this.age = profileAge;
        this.height = profileHeight;
        this.weight = profileWeight;
        this.benchMax = profileBenchMax;
        this.deadliftMax = profileDeadliftMax;
        this.squatMax = profileSquatMax;

    }

    public String getFullName() {
        return fullName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getBenchMax() {
        return benchMax;
    }

    public int getDeadliftMax() {
        return deadliftMax;
    }

    public int getSquatMax() {
        return squatMax;
    }

    public void setFullName(String s) {
        this.fullName = s;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBenchMax(int benchMax) {
        this.benchMax = benchMax;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDeadliftMax(int deadliftMax) {
        this.deadliftMax = deadliftMax;
    }

    public void setSquatMax(int squatMax) {
        this.squatMax = squatMax;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //EFFECTS: Returns your Profile details in a string-list Form
    public String showProfileDetails() {
        EventLog.getInstance().logEvent(new Event("Viewed Profile: " + fullName));
        String s = "";
        s += "Date of Birth: " + Integer.toString(dateOfBirth) + "\n"
                + "Age: " + Integer.toString(age) + "\n"
                + "Height(cm): " + Integer.toString(height) + "\n"
                + "Weight(lbs): " + Integer.toString(weight) + "\n"
                + "Bench Max(lbs): " + Integer.toString(benchMax) + "\n"
                + "Deadlift Max(lbs): " + Integer.toString(dateOfBirth) + "\n"
                + "Squat Max(lbs): " + Integer.toString(squatMax);
        return s;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("fullName", fullName);
        json.put("dateOfBirth", dateOfBirth);
        json.put("age", age);
        json.put("height", height);
        json.put("weight", weight);
        json.put("benchMax", benchMax);
        json.put("deadliftMax", deadliftMax);
        json.put("squatMax", squatMax);
        return json;

    }
}

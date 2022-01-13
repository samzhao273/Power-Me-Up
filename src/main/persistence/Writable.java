package persistence;

import org.json.JSONObject;

public interface Writable {
    //EFFECTS: returns writable as JSON object
    JSONObject toJson();

}

package droidudes.hackathon.prefs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Zare Ahmed on 4/27/2017.
 */
public class GenericPrefs {

    //TypeToken<YourClassName> typeToken= new TypeToken<YourClassName>() {};
    public static <T> void saveAnyTypeOfList(String key, List<T> value) {
        Gson gson = new GsonBuilder().create();
        JsonArray jsonArray = gson.toJsonTree(value).getAsJsonArray();
        SharedPrefs.save(key, jsonArray.toString());
    }

    public static <T> List<T> readAnyTypeOfList(String key, TypeToken<List<T>> tt) {
        Gson gson = new Gson();
        return (gson.fromJson(SharedPrefs.read(key, "[]"), tt.getType()));
    }

    public static <T> void saveAnyTypeOfObject(String key, T value){
        Gson gson = new Gson();
        String json = gson.toJson(value);
        SharedPrefs.save(key, json);
    }
    //Type listType = new TypeToken<YourClass>(){}.getType();
    public static <T> T readAnyTypeOfObject(String key, Type tt) {
        Gson gson = new Gson();
        String json = SharedPrefs.read(key, "{}");
        T obj = gson.fromJson(json, tt);
        return obj;
    }
}

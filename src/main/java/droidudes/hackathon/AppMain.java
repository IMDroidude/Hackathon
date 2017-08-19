package droidudes.hackathon;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by Zare Ahmed on 17-Aug-17.
 */
public class AppMain extends MultiDexApplication {

    public static Context applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
    }
}

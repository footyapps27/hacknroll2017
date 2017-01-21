package roll.hack.iss.hackroll2017;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class App extends Application {
    public RequestQueue queue;//only create one queue during the volley life

    //application Context scope parameter

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initVolleySetting();
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    /**
     * init volley request queue setting
     * configure some volley spec setting
     */
    private void initVolleySetting() {
        queue = Volley.newRequestQueue(this);
    }
}


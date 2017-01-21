package roll.hack.iss.hackroll2017;

import android.app.Application;
import android.os.Build;
import android.speech.tts.TextToSpeech;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Locale;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class App extends Application implements TextToSpeech.OnInitListener {
    public RequestQueue queue;//only create one queue during the volley life

    //application Context scope parameter

    /****************************/
    // Properties
    /****************************/

    private static App mInstance;

    public TextToSpeech mTextToSpeech;

    /****************************/
    // App Lifecycle
    /****************************/

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mTextToSpeech = new TextToSpeech(mInstance, this);
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

    /****************************/
    // Interface Implementation
    /****************************/
    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            mTextToSpeech.setLanguage(Locale.US);
            mTextToSpeech.setSpeechRate(0.8f);
        }
    }

    /****************************/
    // Public Methods
    /****************************/
    public void speak(String textToSpeak) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_ADD, null, null);
        }
        else {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_ADD, null);
        }
    }
}


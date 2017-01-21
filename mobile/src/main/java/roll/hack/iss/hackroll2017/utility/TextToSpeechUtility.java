package roll.hack.iss.hackroll2017.utility;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Samrat on 21/1/17.
 */

public class TextToSpeechUtility implements TextToSpeech.OnInitListener {

    /****************************/
    // Constants
    /****************************/
    private int MY_DATA_CHECK_CODE = 0;

    /****************************/
    // Properties
    /****************************/
    private TextToSpeech mTextToSpeech;

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

    /**
     * Call this method "onStart" of the fragment.
     * @param fragment
     */
    public void initializeTextToSpeech(Fragment fragment) {
        Intent textToSpeechIntent = new Intent();
        textToSpeechIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        fragment.startActivityForResult(textToSpeechIntent, MY_DATA_CHECK_CODE);
    }

    /**
     * Call this method after receiving the "onActivityResult" call from system.
     * @param fragment
     * @param requestCode
     * @param resultCode
     */
    public void receivedOnActivityResult(Fragment fragment, int requestCode, int resultCode) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                mTextToSpeech = new TextToSpeech(fragment.getActivity(), this);
            }
            else {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                fragment.getActivity().startActivity(installTTSIntent);
            }
        }
    }

    public void speak(String textToSpeak) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}

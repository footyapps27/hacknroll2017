package roll.hack.iss.hackroll2017.utility;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class VoiceUtility {
    public static void getVoiceInput(Fragment fragment) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What do you have in your Fridge");
        fragment.startActivityForResult(intent, 1010);
    }
}

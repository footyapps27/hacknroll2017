package roll.hack.iss.hackroll2017.ui.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;
import roll.hack.iss.hackroll2017.utility.TextToSpeechUtility;

/**
 * Created by Deepak on 21/01/2017.
 */

public class DashboardFragment extends BaseFragment {

    private TextToSpeechUtility mTextToSpeechUtility;

    @Override
    public void onStart() {
        super.onStart();

        try {
            if(!App.getInstance().blAlreadyExecuted) {
                int resID = getResources().getIdentifier("launch_audio", "raw", getActivity().getPackageName());
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),resID);
                mediaPlayer.start();
                App.getInstance().blAlreadyExecuted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_layout;
    }

    @Override
    protected void initComponent() {
       /* mTextToSpeechUtility = new TextToSpeechUtility();
        mTextToSpeechUtility.initializeTextToSpeech(this);*/
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTextToSpeechUtility.receivedOnActivityResult(this, requestCode, resultCode);
        if(mTextToSpeechUtility != null) {
            mTextToSpeechUtility.speak("Hello John, what do you want to cook today?");
        }
    }
}

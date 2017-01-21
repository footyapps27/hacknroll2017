package roll.hack.iss.hackroll2017.ui.fragment;

import android.content.Intent;

import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;
import roll.hack.iss.hackroll2017.utility.TextToSpeechUtility;

/**
 * Created by linby on 21/01/2017.
 */

public class DashBoardFragment extends BaseFragment {

    private TextToSpeechUtility mTextToSpeechUtility;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_layout;
    }

    @Override
    protected void initComponent() {
        mTextToSpeechUtility = new TextToSpeechUtility();
        mTextToSpeechUtility.initializeTextToSpeech(this);
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

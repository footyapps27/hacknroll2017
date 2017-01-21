package roll.hack.iss.hackroll2017.ui.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.activity.VoiceInputActivity;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;
import roll.hack.iss.hackroll2017.utility.TextToSpeechUtility;
import roll.hack.iss.hackroll2017.utility.VoiceUtility;

/**
 * Created by Deepak on 21/01/2017.
 */

public class DashboardFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.imageView_voice)
    ImageView voiceButton;

    private TextToSpeechUtility mTextToSpeechUtility;
    private ArrayList<String> voiceOutput;
    private AlertDialog.Builder alertDialogBuilder;
    private ListView mVoiceOutputList;



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
       /* mTextToSpeechUtility = new TextToSpeechUtility();
        mTextToSpeechUtility.initializeTextToSpeech(this);*/
        voiceButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTextToSpeechUtility.receivedOnActivityResult(this, requestCode, resultCode);
        if (mTextToSpeechUtility != null) {
            mTextToSpeechUtility.speak("Hello John, what do you want to cook today?");
        } else if (requestCode == 1010 && resultCode == Activity.RESULT_OK) {
//            this.mVisionOutputLayout.setVisibility(View.VISIBLE);
            voiceOutput = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            resultAlertDialog();
            resultSuccess();//            this.setFields(this.mVisionOutputList);
        }
    }

    public void resultAlertDialog() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.activity_voice_result, null);
        alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setView(promptsView);

        mVoiceOutputList = (ListView) promptsView.findViewById(R.id.voice_listview);

    }

    private  void resultSuccess() {
        mVoiceOutputList.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, voiceOutput));
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.imageView_voice:
                VoiceUtility.getVoiceInput(DashboardFragment.this);
        }
    }

}
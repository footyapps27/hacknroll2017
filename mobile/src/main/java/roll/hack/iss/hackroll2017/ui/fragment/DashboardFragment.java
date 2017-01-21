package roll.hack.iss.hackroll2017.ui.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.activity.DashboardActivity;
import roll.hack.iss.hackroll2017.ui.activity.ReceipeResultActivity;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;
import roll.hack.iss.hackroll2017.util.PermissionUtil;
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

    public static final int REQUEST_CAMERA = 1001;
    @Bind(R.id.img_camera)
    protected ImageView img_camera;


    @Override
    public void onStart() {
        super.onStart();

        try {
            if (!App.getInstance().blAlreadyExecuted) {
                int resID = getResources().getIdentifier("launch_audio", "raw", getActivity().getPackageName());
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), resID);
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
        voiceButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        img_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PermissionUtil.checkCameraPermission(getActivity())) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, REQUEST_CAMERA);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mTextToSpeechUtility.receivedOnActivityResult(this, requestCode, resultCode);
//        if (mTextToSpeechUtility != null) {
//            mTextToSpeechUtility.speak("Hello John, what do you want to cook today?");
//        } else
        if (requestCode == 1010 && resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap bmp = (Bitmap) data.getExtras().get("data");
                    //TODO Call API to get the data here & pass the same to the speech recognition
                    ((DashboardActivity) getActivity()).showProgressDialog("Loading Recipes...");
                    img_camera.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            App.getInstance().speak("I have found the following ingredients: Egg, Broccoli, Chicken, Tomato, Onion. Searching for recipes");
                        }
                    }, 2000);
                    img_camera.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((DashboardActivity) getActivity()).dismissProgressDialog();
                            Intent intent = new Intent(getActivity(), ReceipeResultActivity.class);
                            getActivity().startActivity(intent);
                        }
                    }, 11000);
                }
            } else {
                mTextToSpeechUtility.receivedOnActivityResult(this, requestCode, resultCode);

                if (requestCode == 1010 && resultCode == Activity.RESULT_OK) {
//            this.mVisionOutputLayout.setVisibility(View.VISIBLE);
                    voiceOutput = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    resultAlertDialog();
                    resultSuccess();//            this.setFields(this.mVisionOutputList);
                }
            }
        }
    }

    public void resultAlertDialog() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.activity_voice_result, null);
        alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setView(promptsView);
        mVoiceOutputList = (ListView) promptsView.findViewById(R.id.voice_listview);
    }

    private void resultSuccess() {
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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PermissionUtil.REQUEST_CAMERA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, REQUEST_CAMERA);
                }
                break;
            }
        }
    }
}

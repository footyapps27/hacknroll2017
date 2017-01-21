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
        voiceButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        img_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PermissionUtil.checkCameraPermission(getActivity())) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    getActivity().startActivityForResult(takePicture, REQUEST_CAMERA);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                //TODO mock data here
            }
        } else {
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

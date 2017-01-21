package roll.hack.iss.hackroll2017.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;
import roll.hack.iss.hackroll2017.util.PermissionUtil;
import roll.hack.iss.hackroll2017.utility.TextToSpeechUtility;

/**
 * Created by Deepak on 21/01/2017.
 */

public class DashboardFragment extends BaseFragment {

    private TextToSpeechUtility mTextToSpeechUtility;
    @Bind(R.id.img_camera)
    private ImageView img_camera;

    private static final int REQUEST_CAMERA = 1001;

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
            }
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

package roll.hack.iss.hackroll2017.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import roll.hack.iss.hackroll2017.R;


/**
 * Created by linby on 15/12/2016.
 * this util is created for handling the checkPermission when the version is above android 6.0
 */
public class PermissionUtil {
    public final static int REQUEST_CAMERA = 10001;
    public final static int REQUEST_READ_EXTERNAL = 10002;

    public static boolean checkCameraPermission(Activity activity){
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission(activity);
            return false;
        }else{
            return true;
        }
    }

    private static void requestCameraPermission(final Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            Snackbar.make(activity.findViewById(android.R.id.content), R.string.permission_camera_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(activity,
                                    new String[]{Manifest.permission.CAMERA},
                                    REQUEST_CAMERA);
                        }
                    }).show();
        } else {
            // Camera permission has not been granted yet. Request it directly.
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA);
        }
    }

    public static boolean checkReadExternalPermission(Activity activity){
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestReadExternalPermission(activity);
            return false;
        }else{
            return true;
        }
    }

    private static void requestReadExternalPermission(final Activity activity){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            Snackbar.make(activity.findViewById(android.R.id.content), R.string.permission_read_external_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(activity,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    REQUEST_READ_EXTERNAL);
                        }
                    }).show();
        } else {
            // Camera permission has not been granted yet. Request it directly.
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_EXTERNAL);
        }
    }
}

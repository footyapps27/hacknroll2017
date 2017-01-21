package roll.hack.iss.hackroll2017.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.ButterKnife;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public abstract class BaseSingleFragmentActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected Context mContext;
    private ProgressDialog pDlg;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

    /****************************************************/
    // Abstract Method Declaration
    /****************************************************/
    /**
     * Method to return to the base class the fragment that will be added to the fragment container.
     *
     * @return The fragment that needs to be added to the container.
     */
    protected abstract Fragment createFragment();

    protected abstract void addActions();

    protected abstract int getLayoutId();

    protected abstract int getFragmentContainer();


    /****************************************************/
    // Activity Lifecycle

    /****************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = BaseSingleFragmentActivity.this;
        mContext = mActivity.getBaseContext();
        setContentView(getLayoutId());
        // Bind the views
        ButterKnife.bind(this);
        // Add actions
        addActions();
        // Call the fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(getFragmentContainer());
        if (fragment == null) {
            // Get the fragment that needs to be added.
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(getFragmentContainer(), fragment)
                    .commit();
        }
    }

    protected void showProgressDialog(String title, String msg) {
        pDlg = ProgressDialog.show(mActivity, title, msg);
    }

    protected void showProgressDialog(String msg) {
        pDlg = ProgressDialog.show(mActivity, "Progressing", msg);
    }

    protected void dismissProgressDialog() {
        if (pDlg != null) {
            pDlg.dismiss();
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("BaseSingleFragment Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
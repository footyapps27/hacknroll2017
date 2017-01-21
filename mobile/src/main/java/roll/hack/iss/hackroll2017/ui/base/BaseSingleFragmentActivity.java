package roll.hack.iss.hackroll2017.ui.base;

/**
 * Created by Samrat on 9/9/16.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import roll.hack.iss.hackroll2017.ui.activity.DashboardActivity;

/**
 * Generic base class that contains a container for holding a fragment.
 */
public abstract class BaseSingleFragmentActivity extends AppCompatActivity {

    protected Activity mActivity; //get current Activity Instance
    protected Context mContext; //get the baseContext related to the activity
    private ProgressDialog pDlg; //native progress dialog used for loading scenery

    /****************************************************/
    // Abstract Method Declaration
    /****************************************************/
    /**
     * Method to return to the base class the fragment that will be added to the fragment container.
     *
     * @return The fragment that needs to be added to the container.
     */
    protected abstract Fragment createFragment(String tag);

    /**
     * set action for the fragment component
     */
    protected abstract void addActions();

    /**
     * @return the current layout resource
     */
    protected abstract int getLayoutId();

    /**
     * @return the placeholder for switching fragment
     */
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
        ChangeFragment(DashboardActivity.FRAG_MAIN);
    }


    protected void ChangeFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = createFragment(tag);
        fragmentManager.beginTransaction()
                .replace(getFragmentContainer(), fragment)
                .commit();
    }

    /**
     * native progress dialog invoked with title and msg
     *
     * @param title
     * @param msg
     */
    protected void showProgressDialog(String title, String msg) {
        pDlg = ProgressDialog.show(mActivity, title, msg);
    }

    /**
     * use "Progressing" as the title by default
     *
     * @param msg
     */
    public void showProgressDialog(String msg) {
        pDlg = ProgressDialog.show(mActivity, "Progressing", msg);
    }

    /**
     * dismiss single dialog
     */
    public void dismissProgressDialog() {
        if (pDlg != null) {
            pDlg.dismiss();
        }
    }
}


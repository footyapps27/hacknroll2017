package roll.hack.iss.hackroll2017.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import roll.hack.iss.hackroll2017.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected Activity mActivity;
    protected Context mContext;
    private ProgressDialog pDlg;
    protected Toolbar toolbar; //tool bar reference

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderScreen();
        ButterKnife.bind(this);
        mActivity = this;
        mContext = mActivity.getBaseContext();
        initToolBar();
        initComponent();
        initData();
    }

    private void initToolBar() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        toolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mActivity.onBackPressed();
//                    }
//                }
//        );

    }

    private void renderScreen() {
        setContentView(getLayoutId());
    }

    protected void showProgressDialog(String title, String msg) {
        pDlg = ProgressDialog.show(mActivity, title, msg);
    }

    protected void showProgressDialog(String msg) {
        pDlg = ProgressDialog.show(mActivity, "Progressing", msg);
    }

    /**
     * Hides the soft keyboard
     */
    protected void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    protected void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    protected void dismissProgressDialog() {
        if (pDlg != null) {
            pDlg.dismiss();
        }
    }

    protected abstract void initComponent();

    protected abstract void initData();

    protected abstract int getLayoutId();

}

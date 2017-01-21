package roll.hack.iss.hackroll2017.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

public class SettingsActivity extends BaseActivity {

    @Bind(R.id.switch_image)
    protected SwitchCompat mImageSwitch;

    @Override
    protected void initComponent() {

        if ((mImageSwitch.isChecked())){
            SharedPreferences settings = this.getSharedPreferences("SETTINGS", 0);
            final SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("IMAGE", true);
            editor.apply();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }
}

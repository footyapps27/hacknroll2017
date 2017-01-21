package roll.hack.iss.hackroll2017.ui.activity;

import android.support.v4.app.Fragment;

import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseSingleFragmentActivity;
import roll.hack.iss.hackroll2017.ui.fragment.DashboardFragment;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class DashboardActivity extends BaseSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DashboardFragment();
    }

    @Override
    protected void addActions() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.activity_dashboard;
    }
}

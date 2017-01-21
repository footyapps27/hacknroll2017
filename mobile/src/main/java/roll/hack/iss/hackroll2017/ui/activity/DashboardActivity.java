package roll.hack.iss.hackroll2017.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;
import roll.hack.iss.hackroll2017.ui.base.BaseSingleFragmentActivity;
import roll.hack.iss.hackroll2017.ui.fragment.DashboardFragment;
import roll.hack.iss.hackroll2017.ui.fragment.ProfileFragment;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class DashboardActivity extends BaseSingleFragmentActivity implements View.OnClickListener {
    public static final String FRAG_MAIN = "FRAG_MAIN";
    public static final String FRAG_PROFILE = "FRAG_PROFILE";
    public static final String FRAG_FAVORITE = "FRAG_FAVORITE";
    @Bind(R.id.toolbar)
    protected
    Toolbar toolbar;
    @Bind(R.id.linearLayout_home)
    protected View homeView;
    @Bind(R.id.linearLayout_favorite)
    protected View favoriteView;
    @Bind(R.id.linearLayout_profile)
    protected View profileView;

    @Override
    protected Fragment createFragment(String tag) {
        switch (tag) {
            case FRAG_MAIN:
                return new DashboardFragment();
            case FRAG_PROFILE:
                return new ProfileFragment();
            case FRAG_FAVORITE:
                return new ProfileFragment();
            default:
                return null;
        }
    }

    /**
     * manage logic of switch fragment here
     */
    @Override
    protected void addActions() {
        toolbar.setTitle(getResources().getString(R.string.app_name));
        ImageButton btn_notification = (ImageButton) toolbar.findViewById(R.id.right_button);
        btn_notification.setVisibility(View.VISIBLE);
        btn_notification.setImageResource(R.drawable.voice);
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, SettingsActivity.class);
                startActivity(intent);
            }
        });
        homeView.setOnClickListener(this);
        favoriteView.setOnClickListener(this);
        profileView.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.fragment_container;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.linearLayout_home:
                ChangeFragment(FRAG_MAIN);
                break;
            case R.id.linearLayout_profile:
                ChangeFragment(FRAG_PROFILE);
                break;
            case R.id.linearLayout_favorite:
                ChangeFragment(FRAG_FAVORITE);
                break;
        }
    }
}

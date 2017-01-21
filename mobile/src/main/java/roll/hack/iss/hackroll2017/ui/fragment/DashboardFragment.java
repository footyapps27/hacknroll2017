package roll.hack.iss.hackroll2017.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class DashboardFragment extends BaseFragment implements View.OnClickListener{
    @Bind(R.id.photo_camera)
    ImageView photoCamera;
    @Bind(R.id.favorite)
    ImageView favourite;
    @Bind(R.id.profile)
    ImageView profile;
    @Bind(R.id.home)
    ImageView home;

    public DashboardFragment() {
    }


    /****************************************************/
    // Abstract Method Implementation

    /****************************************************/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_layout, container, false);
        ButterKnife.bind(this, rootView);
        this.photoCamera.setOnClickListener(this);
        this.favourite.setOnClickListener(this);
        this.profile.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo_camera:
                break;

        }

    }
}
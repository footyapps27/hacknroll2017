package roll.hack.iss.hackroll2017.ui.fragment;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.activity.ManualInputActivity;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;

/**
 * Created by linby on 21/01/2017.
 */

public class DashboardFragment extends BaseFragment {
    @Bind(R.id.imageView_manualEntry)
    ImageView imvManualEntry;

    @Override
    protected int getLayoutId() {
        return R.layout.main_layout;
    }

    @Override
    protected void initComponent() {
        imvManualEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ManualInputActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}

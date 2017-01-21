package roll.hack.iss.hackroll2017.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import roll.hack.iss.hackroll2017.R;


public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,view);
        initComponent();
        initData();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initComponent();

    protected abstract void initData();
}

package roll.hack.iss.hackroll2017.ui.fragment;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.adapter.FavoriteListAdapter;
import roll.hack.iss.hackroll2017.model.Recipe;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;

/**
 * Created by linby on 21/01/2017.
 */

public class FavoriteFragment extends BaseFragment {
    @Bind(R.id.favorite_listview)
    protected ListView favoriteListView;
    private FavoriteListAdapter adapter;
    private List<Recipe> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.frag_favorite;
    }

    @Override
    protected void initComponent() {
        adapter = new FavoriteListAdapter(getActivity());
        initDummyData();
        favoriteListView.setAdapter(adapter);
        adapter.setListData(list);
    }

    private void initDummyData() {
        for (int i = 0; i < 10; i++) {
            Recipe receipe = new Recipe();
            list.add(receipe);
        }
    }

    @Override
    protected void initData() {

    }
}

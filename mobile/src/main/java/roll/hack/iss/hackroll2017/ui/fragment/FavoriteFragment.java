package roll.hack.iss.hackroll2017.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.adapter.FavoriteListAdapter;
import roll.hack.iss.hackroll2017.model.Recipe;
import roll.hack.iss.hackroll2017.ui.activity.ReceipeDetailActivity;
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
        list = App.getInstance().getMockData();
        favoriteListView.setAdapter(adapter);
        adapter.setListData(list);
    }

    @Override
    protected void initData() {
        favoriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), ReceipeDetailActivity.class);
                intent.putExtra("recipe", list.get(position));
                getActivity().startActivity(intent);
            }
        });
    }
}

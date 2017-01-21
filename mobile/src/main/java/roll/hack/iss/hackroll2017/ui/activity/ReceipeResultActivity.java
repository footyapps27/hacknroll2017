package roll.hack.iss.hackroll2017.ui.activity;

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
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by linby on 21/01/2017.
 */

public class ReceipeResultActivity extends BaseActivity{
    @Bind(R.id.result_listview)
    protected ListView recipeListView;
    private FavoriteListAdapter adapter;
    private List<Recipe> list = new ArrayList<>();

    @Override
    protected void initComponent() {
        adapter = new FavoriteListAdapter(mActivity);
        list = App.getInstance().getMockData();
        recipeListView.setAdapter(adapter);
        adapter.setListData(list);
    }

    @Override
    protected void initData() {
        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(mActivity, ReceipeDetailActivity.class);
                intent.putExtra("recipe", list.get(position));
                mActivity.startActivity(intent);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipe_result;
    }
}

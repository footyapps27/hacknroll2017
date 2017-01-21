package roll.hack.iss.hackroll2017.ui.activity;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.adapter.ResultListAdapter;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by linby on 21/01/2017.
 */

public class ReceipeDetailActivity extends BaseActivity {

    @Bind(R.id.result_listview)
    protected ListView resultListView;
    private ResultListAdapter resultListAdapter;
    @Bind(R.id.reciepe_image)
    ImageView receipeImage;
    @Bind(R.id.reciepe_instruction)
    TextView reciepe_instruction;



    @Override
    protected void initComponent() {
        


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipe_detail;
    }
}

package roll.hack.iss.hackroll2017.ui.activity;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.adapter.ResultListAdapter;
import roll.hack.iss.hackroll2017.model.Recipe;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by linby on 21/01/2017.
 */

public class ReceipeDetailActivity extends BaseActivity {

    @Bind(R.id.reciepe_image)
    ImageView receipeImage;
    @Bind(R.id.reciepe_instruction)
    TextView reciepe_instruction;



    @Override
    protected void initComponent() {



    }

    @Override
    protected void initData() {
        Recipe recipe1;
        recipe1 =  App.getInstance().getMockData().get(0);
        reciepe_instruction.setText(recipe1.getDetailedSteps());


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipe_detail;
    }
}

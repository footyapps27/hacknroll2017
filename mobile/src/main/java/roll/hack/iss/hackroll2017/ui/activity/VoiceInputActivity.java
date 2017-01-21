package roll.hack.iss.hackroll2017.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class VoiceInputActivity extends BaseActivity {
    @Bind(R.id.voice_listview)
    ListView mVoiceList;
    private ArrayList<String> mVoiceResults;

    @Override
    protected void initComponent() {
    }

    @Override
    protected void initData() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            mVoiceResults = args.getStringArrayList("VOICE");
            mVoiceList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mVoiceResults));

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_voice_result;
    }
}

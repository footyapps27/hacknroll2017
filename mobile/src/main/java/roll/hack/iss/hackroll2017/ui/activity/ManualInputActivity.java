package roll.hack.iss.hackroll2017.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by linby on 21/01/2017.
 */

public class ManualInputActivity extends BaseActivity {
    @Bind(R.id.fab_add_ingredient)
    protected FloatingActionButton fabAdd;

    @Override
    protected void initComponent() {
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(new ContextThemeWrapper(mActivity, R.style.DialogSlideAnim));
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setTitle(R.string.dlg_input_title);
                dialog.setContentView(R.layout.dlg_manually_input);
                EditText foodName = (EditText) dialog.findViewById(R.id.edittext_foodname);
                EditText foodQuantity = (EditText) dialog.findViewById(R.id.edittext_quantity);


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                lp.copyFrom(window.getAttributes());
                //This makes the dialog take up the full width
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);
                dialog.setCancelable(true);
                dialog.show();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_manually_input;
    }
}

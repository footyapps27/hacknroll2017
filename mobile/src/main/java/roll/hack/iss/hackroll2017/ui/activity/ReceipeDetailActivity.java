package roll.hack.iss.hackroll2017.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
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
        /*Recipe recipe1;
        recipe1 =  App.getInstance().getMockData().get(0);
        reciepe_instruction.setText(recipe1.getDetailedSteps());
*/      Bundle args = this.getIntent().getExtras();
        // getting attached intent data
        Recipe recipe = (Recipe) args.get("recipe");
        // displaying selected product name
        reciepe_instruction.setText(recipe.getDetailedSteps());
        final ImageView imageView = receipeImage;
        ImageRequest imageRequest = new ImageRequest(
                recipe.getImgPath(),

                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }
        });
        App.getInstance().queue.add(imageRequest);
         }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipe_detail;
    }
}

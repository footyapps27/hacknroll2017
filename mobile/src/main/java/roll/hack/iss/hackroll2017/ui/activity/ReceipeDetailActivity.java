package roll.hack.iss.hackroll2017.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
    @Bind(R.id.reciepe_name)
    TextView reciepe_name;

    private Recipe mRecipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().speak(mRecipe.getDetailedSteps());
    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void initData() {
        /*Recipe recipe1;
        recipe1 =  App.getInstance().getMockData().get(0);
        reciepe_instruction.setText(recipe1.getDetailedSteps());
*/
        Bundle args = this.getIntent().getExtras();
        // getting attached intent data
        mRecipe = (Recipe) args.get("recipe");
        // displaying selected product name
        reciepe_name.setText(mRecipe.getName());
        reciepe_name.setPaintFlags(reciepe_name.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        reciepe_instruction.setText(mRecipe.getDetailedSteps());

       /// receipeImage.setImageResource(Integer.parseInt(mRecipe.getImgPath()));
        receipeImage.setImageResource(mActivity.getResources().getIdentifier(mRecipe.getImgPath(),"drawable", mActivity.getPackageName()));
        /*final ImageView imageView = receipeImage;
        ImageRequest imageRequest = new ImageRequest(
                mRecipe.getImgPath(),

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
         }*/
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipe_detail;
    }
}

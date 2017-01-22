package roll.hack.iss.hackroll2017.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.ArrayList;
import java.util.List;

import roll.hack.iss.hackroll2017.App;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.model.Recipe;

/**
 * Created by linby on 21/01/2017.
 */

public class FavoriteListAdapter extends BaseAdapter {
    List<Recipe> list = new ArrayList<>();
    LayoutInflater mInflater;
    Activity mActivity;

    /**
     * constructor requrire list
     */
    public FavoriteListAdapter(Activity mActivity) {
        this.mActivity = mActivity;
        mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setListData(List<Recipe> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item_receipe, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.duration = (TextView) convertView.findViewById(R.id.duration);
            holder.complexity = (TextView) convertView.findViewById(R.id.complexity);
            holder.kcal = (TextView) convertView.findViewById(R.id.kcal);
            holder.receipe_image = (ImageView) convertView.findViewById(R.id.receipe_image);
            holder.starLayout = (LinearLayout) convertView.findViewById(R.id.rating);
            //setting view here
            holder.name.setText(list.get(position).getName());
            holder.duration.setText("Time: "+list.get(position).getTimeToCook()+" mins");
            holder.complexity.setText("Difficulty Level:"+list.get(position).getComplexity());
            holder.kcal.setText(list.get(position).getCalorieCount()+" cal");
            final ImageView imageView = holder.receipe_image;
//            ImageRequest imageRequest = new ImageRequest(
//                    list.get(position).getImgPath(),
//                    new Response.Listener<Bitmap>() {
//                        @Override
//                        public void onResponse(Bitmap response) {
//                            imageView.setImageBitmap(response);
//                        }
//                    }, 0, 0, Bitmaap.Config.RGB_565, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    imageView.setImageResource(R.mipmap.ic_launcher);
//                }
//            });
            holder.receipe_image.setImageResource(mActivity.getResources().getIdentifier(list.get(position).getImgPath(),"drawable", mActivity.getPackageName()));
//
            int count = 0;
            while (count < 5) {
                if (count < list.get(position).getRating()) {
                    ImageView starImage = new ImageView(mActivity);
                    starImage.setImageResource(android.R.drawable.star_on);
                    holder.starLayout.addView(starImage);
                } else {
                    ImageView starImage = new ImageView(mActivity);
                    starImage.setImageResource(android.R.drawable.star_off);
                    holder.starLayout.addView(starImage);
                }
                count++;
            }App.getInstance().queue.add(imageRequest);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

   static class ViewHolder {
        public TextView name;
        public TextView duration;
        public TextView complexity;
        public TextView kcal;
        public ImageView receipe_image;
        public LinearLayout starLayout;
    }
}

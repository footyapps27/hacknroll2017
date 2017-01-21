package roll.hack.iss.hackroll2017.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.model.FoodItem;

/**
 * Created by linby on 22/01/2017.
 */

public class FoodListAdapter extends BaseAdapter {
    List<FoodItem> foodList = new ArrayList<>();
    LayoutInflater mInflater;

    public FoodListAdapter(Activity activity) {
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataList(List<FoodItem> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new FoodListAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item_receipe, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        public TextView textView;
    }
}

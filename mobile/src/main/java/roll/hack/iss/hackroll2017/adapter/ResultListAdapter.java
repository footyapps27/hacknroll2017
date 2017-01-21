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
import roll.hack.iss.hackroll2017.model.Recipe;
import roll.hack.iss.hackroll2017.ui.base.BaseActivity;

/**
 * Created by linby on 22/01/2017.
 */

public class ResultListAdapter extends BaseAdapter {
    List<Recipe> list = new ArrayList<>();
    LayoutInflater mInflater;

    /**
     * constructor requrire list
     */
    public ResultListAdapter(Activity mActivity) {
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
            holder = new ResultListAdapter.ViewHolder();
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

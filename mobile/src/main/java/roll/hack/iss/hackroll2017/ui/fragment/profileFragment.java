package roll.hack.iss.hackroll2017.ui.fragment;


import android.graphics.Color;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import butterknife.Bind;
import roll.hack.iss.hackroll2017.R;
import roll.hack.iss.hackroll2017.ui.base.BaseFragment;

/**
 * Created by linby on 21/01/2017.
 */

public class ProfileFragment extends BaseFragment{
    @Bind(R.id.graph)
    GraphView graph;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_profile;
    }

    @Override
    protected void initComponent() {

        graph.setTitle("Heart Rate");
        graph.getGridLabelRenderer();
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1, 85),
                new DataPoint(2, 103),
                new DataPoint(3, 90),
                new DataPoint(4, 102),
                new DataPoint(5, 78),
                new DataPoint(6, 104),
                new DataPoint(7, 72),
        });
        graph.addSeries(series);
/*

        series.setTitle("Heart Rate");
        series.setColor(Color.GREEN);


// custom paint to make a dotted line
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        series.setCustomPaint(paint);
        }*/

// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series.setSpacing(7);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);

    }



    @Override
    protected void initData() {

    }
}

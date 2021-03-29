package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import hb.drawable.shape.shape.ShapeFactory;


public class HbListView extends ListView {
    public HbListView(Context context) {
        super(context);
    }

    public HbListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

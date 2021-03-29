package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import hb.drawable.shape.shape.ShapeFactory;


public class HbGridLayout extends GridLayout {
    public HbGridLayout(Context context) {
        super(context);
    }

    public HbGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


import hb.drawable.shape.shape.ShapeFactory;

public class HbView extends View {
    public HbView(Context context) {
        super(context);
    }

    public HbView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

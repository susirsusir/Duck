package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;


import hb.drawable.shape.shape.ShapeFactory;

public class HbRadioGroup extends RadioGroup {
    public HbRadioGroup(Context context) {
        super(context);
    }

    public HbRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

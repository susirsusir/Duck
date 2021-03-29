package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;


import hb.drawable.shape.shape.ShapeFactory;

public class HbButton extends AppCompatButton {
    public HbButton(Context context) {
        super(context);
    }

    public HbButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

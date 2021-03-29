package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatCheckBox;

import hb.drawable.shape.shape.ShapeFactory;


public class HbCheckBox extends AppCompatCheckBox {
    public HbCheckBox(Context context) {
        super(context);
    }

    public HbCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

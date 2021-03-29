package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import hb.drawable.shape.shape.ShapeFactory;


public class HbImageView extends AppCompatImageView {
    public HbImageView(Context context) {
        super(context);
    }

    public HbImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

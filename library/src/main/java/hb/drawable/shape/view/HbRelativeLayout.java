package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import hb.drawable.shape.shape.ShapeFactory;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class HbRelativeLayout extends RelativeLayout {

    public HbRelativeLayout(Context context) {
        super(context);
    }

    public HbRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        ShapeFactory.setViewBackground(context, attrs, this);
    }

}

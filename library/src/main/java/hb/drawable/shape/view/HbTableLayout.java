package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hb.drawable.shape.shape.ShapeFactory;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-20
 * @desc
 */
public class HbTableLayout extends TableLayout {

    public HbTableLayout(Context context) {
        super(context);
    }

    public HbTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

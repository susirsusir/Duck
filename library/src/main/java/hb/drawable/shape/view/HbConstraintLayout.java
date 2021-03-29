package hb.drawable.shape.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import hb.drawable.shape.shape.ShapeFactory;


public class HbConstraintLayout extends ConstraintLayout {

    public HbConstraintLayout(@NonNull Context context) {
        super(context);
    }

    public HbConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HbConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        ShapeFactory.setViewBackground(context, attrs, this);
    }
}

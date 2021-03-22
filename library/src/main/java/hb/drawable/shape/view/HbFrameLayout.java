package hb.drawable.shape.view;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class HbFrameLayout extends FrameLayout {
    public HbFrameLayout(@NonNull Context context) {
        super(context);
    }

    public HbFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HbFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

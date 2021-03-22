package hb.drawable.shape.view;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class HbScrollView extends ScrollView {
    public HbScrollView(@NonNull Context context) {
        super(context);
    }

    public HbScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HbScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

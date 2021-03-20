package cn.deemons.library.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class HbLinearLayout extends LinearLayout {

    public HbLinearLayout(Context context) {
        super(context);
    }

    public HbLinearLayout(Context context,
                          @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HbLinearLayout(Context context,
                          @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

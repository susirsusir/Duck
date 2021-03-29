package hb.drawable.shape.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public interface Injector {

    /**
     * View 构造函数 注入
     *
     * @param view    View
     * @param context Context
     * @param attrs   AttributeSet
     * @return View
     */
    View inject(View view, Context context, AttributeSet attrs);

}

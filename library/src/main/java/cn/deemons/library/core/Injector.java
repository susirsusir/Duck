package cn.deemons.library.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

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
     */
    void inject(View view, Context context, AttributeSet attrs);

}

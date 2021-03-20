package cn.deemons.library.core;

import cn.deemons.library.shape.ShapeInjector;

/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class HbFactor {

    private static Injector mInjector;


    public static void setFactor(Injector injector) {
        mInjector = injector;
    }

    public static Injector getFactor() {
        if (mInjector == null) {
            mInjector = new ShapeInjector();
        }
        return mInjector;
    }
}

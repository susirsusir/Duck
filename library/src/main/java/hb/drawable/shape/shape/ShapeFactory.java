package hb.drawable.shape.shape;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import hb.drawable.shape.core.HbFactor;
/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class ShapeFactory implements LayoutInflater.Factory2 {

    private LayoutInflater.Factory mViewCreateFactory;
    private LayoutInflater.Factory2 mViewCreateFactory2;

    private static final Class<?>[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    private static final Object[] mConstructorArgs = new Object[2];
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap<>();
    private static final HashMap<String, HashMap<String, Method>> methodMap = new HashMap<>();

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //如果是blview，代表已经进行了背景设置，无需再次创建，留给系统创建就行
        if(name.startsWith("hb.drawable.shape.view")){
            return null;
        }
        View view = null;

        //防止与其他调用factory库冲突，例如字体、皮肤替换库，用已经设置的factory来创建view
        if (mViewCreateFactory2 != null) {
            view = mViewCreateFactory2.onCreateView(name, context, attrs);
            if (view == null) {
                view = mViewCreateFactory2.onCreateView(null, name, context, attrs);
            }
        } else if (mViewCreateFactory != null) {
            view = mViewCreateFactory.onCreateView(name, context, attrs);
        }
        return setViewBackground(name, context, attrs, view);
    }

    /**
     * 根据属性设置图片背景
     * @param name view的名字
     * @param context 上下文
     * @param attrs 属性
     * @param view view
     * @return view
     */
    @Nullable
    private static View setViewBackground(String name, Context context, AttributeSet attrs, View view) {
        try {
            if (view == null) {
                view = createViewFromTag(context, name, attrs);
            }
            if (view == null) {
                return null;
            }
            return HbFactor.getFactor().inject(view, context, attrs);
        } catch (Exception e) {
            e.printStackTrace();
            return view;
        }
    }

    @Nullable
    public static View setViewBackground(Context context, AttributeSet attrs, View view){
        return setViewBackground(null, context, attrs, view);
    }

    public void setInterceptFactory(LayoutInflater.Factory factory) {
        mViewCreateFactory = factory;
    }

    public void setInterceptFactory2(LayoutInflater.Factory2 factory) {
        mViewCreateFactory2 = factory;
    }

    private static View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if(TextUtils.isEmpty(name)){
            return null;
        }
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            mConstructorArgs[0] = context;
            mConstructorArgs[1] = attrs;

            if (-1 == name.indexOf('.')) {
                View view = null;
                if ("View".equals(name)) {
                    view = createView(context, name, "android.view.");
                }
                if (view == null) {
                    view = createView(context, name, "android.widget.");
                }
                if (view == null) {
                    view = createView(context, name, "android.webkit.");
                }
                return view;
            } else {
                return createView(context, name, null);
            }
        } catch (Exception e) {
            Log.w("BackgroundLibrary", "cannot create 【" + name + "】 : ");
            return null;
        } finally {
            mConstructorArgs[0] = null;
            mConstructorArgs[1] = null;
        }
    }

    private static View createView(Context context, String name, String prefix) throws InflateException {
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        try {
            if (constructor == null) {
                Class<? extends View> clazz = context.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name).asSubclass(View.class);

                constructor = clazz.getConstructor(sConstructorSignature);
                sConstructorMap.put(name, constructor);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(mConstructorArgs);
        } catch (Exception e) {
            Log.w("BackgroundLibrary", "cannot create 【" + name + "】 : ");
            return null;
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return onCreateView(name, context, attrs);
    }
}

package hb.drawable.shape;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterCompat;

import java.lang.reflect.Field;

import hb.drawable.shape.shape.ShapeFactory;


/**
 * @author HB.SuZhanFeng
 * @date 2021-03-18
 * @desc
 */
public class ShapeLibrary {

    public static LayoutInflater inject(Context context) {
        LayoutInflater inflater;
        if (context instanceof Activity) {
            inflater = ((Activity) context).getLayoutInflater();
        } else {
            inflater = LayoutInflater.from(context);
        }
        if (inflater == null) {
            return null;
        }
        if (inflater.getFactory2() == null) {
            ShapeFactory factory = setDelegateFactory(context);
            inflater.setFactory2(factory);
        } else if (!(inflater.getFactory2() instanceof ShapeFactory)) {
            forceSetFactory2(inflater);
        }
        return inflater;
    }

    @NonNull
    private static ShapeFactory setDelegateFactory(Context context) {
        ShapeFactory factory = new ShapeFactory();
        if (context instanceof AppCompatActivity) {
            final AppCompatDelegate delegate = ((AppCompatActivity) context).getDelegate();
            factory.setInterceptFactory(new LayoutInflater.Factory() {
                @Override
                public View onCreateView(String name, Context context, AttributeSet attrs) {
                    return delegate.createView(null, name, context, attrs);
                }
            });
        }
        return factory;
    }

    /**
     * used for activity which has addFactory
     * 如果因为其他库已经设置了factory，可以使用该方法去进行inject，在其他库的setFactory后面调用即可
     *
     * @param context
     */
    public static LayoutInflater inject2(Context context) {
        LayoutInflater inflater;
        if (context instanceof Activity) {
            inflater = ((Activity) context).getLayoutInflater();
        } else {
            inflater = LayoutInflater.from(context);
        }
        if (inflater == null) {
            return null;
        }
        forceSetFactory2(inflater);
        return inflater;
    }

    private static void forceSetFactory2(LayoutInflater inflater) {
        Class<LayoutInflaterCompat> compatClass = LayoutInflaterCompat.class;
        Class<LayoutInflater> inflaterClass = LayoutInflater.class;
        try {
            Field sCheckedField = compatClass.getDeclaredField("sCheckedField");
            sCheckedField.setAccessible(true);
            sCheckedField.setBoolean(inflater, false);
            Field mFactory = inflaterClass.getDeclaredField("mFactory");
            mFactory.setAccessible(true);
            Field mFactory2 = inflaterClass.getDeclaredField("mFactory2");
            mFactory2.setAccessible(true);
            ShapeFactory factory = new ShapeFactory();
            if (inflater.getFactory2() != null) {
                factory.setInterceptFactory2(inflater.getFactory2());
            } else if (inflater.getFactory() != null) {
                factory.setInterceptFactory(inflater.getFactory());
            }
            mFactory2.set(inflater, factory);
            mFactory.set(inflater, factory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

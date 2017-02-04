package com.customviewplus;

/**
 * Created by hiren.patel on 13-01-2016.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewPlus extends TextView {

    public TextViewPlus(Context context) {
        super(context);
    }

    public TextViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public TextViewPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray customFontNameTypedArray = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = customFontNameTypedArray.getString(R.styleable.TextViewPlus_nameTextView);
        float fontSize = customFontNameTypedArray.getFloat(R.styleable.TextViewPlus_sizeTextView, 20);
        setTextSize(pixelToSp(fontSize));
        setCustomFont(ctx, customFont);
        customFontNameTypedArray.recycle();
    }

    private boolean setCustomFont(Context ctx, String asset) {
        Typeface typeface;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(), asset);
            setTypeface(typeface);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void setFontSize(float fontSize) {
        setTextSize(pixelToSp(fontSize));

    }

    private static int pixelToSp(float pixel) {
        // divided by 3.0 as font size is provided for xxhdpi resolution in pixel
        return (int) (pixel / 3.0);
    }

}

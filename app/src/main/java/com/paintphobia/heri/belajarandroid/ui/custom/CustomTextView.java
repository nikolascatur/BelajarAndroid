package com.paintphobia.heri.belajarandroid.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.paintphobia.heri.belajarandroid.R;

/**
 * Created by heri on 6/11/2016.
 */
public class CustomTextView extends TextView{

    private AttributeSet attributeSet;
    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attributeSet = attributeSet;
        init();
    }

    private void init() {
        TypedArray styledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTextFont);
        int fontFamily = styledAttributes.getInt(R.styleable.CustomTextFont_fontFamily, CustomTextViewAttr.bebas);
        int fontStyle = styledAttributes.getInt(R.styleable.CustomTextFont_fontStyle, CustomTextViewAttr.regular);
        String fontName = null;

        switch (fontFamily) {
            case CustomTextViewAttr.bebas: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "BebasNeue-Regular.otf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "BebasNeue-Light.otf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "BebasNeue.otf";
                        break;
                }
            }
            break;

            case CustomTextViewAttr.openSans: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "OpenSans-Regular.ttf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "OpenSans-Light.ttf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "OpenSans-Bold.ttf";
                        break;
                }
            }
            break;

            case CustomTextViewAttr.roboto: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "Roboto-Regular.ttf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "Roboto-Light.ttf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "Roboto-Bold.ttf";
                        break;
                }
            }
            break;
        }

        Typeface typeface = Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/"+fontName);
        setTypeface(typeface);
    }

    public void setText(int fontFamily, int fontStyle) {
        String fontName = null;

        switch (fontFamily) {
            case CustomTextViewAttr.bebas: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "BebasNeue-Regular.otf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "BebasNeue-Light.otf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "BebasNeue.otf";
                        break;
                }
            }
            break;

            case CustomTextViewAttr.openSans: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "OpenSans-Regular.ttf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "OpenSans-Light.ttf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "OpenSans-Bold.otf";
                        break;
                }
            }
            break;

            case CustomTextViewAttr.roboto: {
                switch (fontStyle) {
                    case CustomTextViewAttr.regular:
                        fontName = "Roboto-Regular.ttf";
                        break;
                    case CustomTextViewAttr.light:
                        fontName = "Roboto-Light.ttf";
                        break;
                    case CustomTextViewAttr.bold:
                        fontName = "Roboto-Bold.otf";
                        break;
                }
            }
            break;
        }

        Typeface typeface = Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/"+fontName);
        setTypeface(typeface);
    }

    public static class CustomTextViewAttr {
        public static final int bebas        = 1;
        public static final int openSans     = 2;
        public static final int roboto       = 3;

        public static final int regular      = 0;
        public static final int light        = 1;
        public static final int bold         = 2;
    }
}

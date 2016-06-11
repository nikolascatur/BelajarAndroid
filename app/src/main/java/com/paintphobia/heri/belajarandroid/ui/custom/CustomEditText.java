package com.paintphobia.heri.belajarandroid.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;

import com.paintphobia.heri.belajarandroid.R;

/**
 * Created by heri on 6/11/2016.
 */
public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public interface BackPressedListener {
        void onImeBack(CustomEditText editText);
    }

    private BackPressedListener mOnImeBack;

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if(mOnImeBack != null) {
                mOnImeBack.onImeBack(this);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void setBackPressedListener(BackPressedListener listener) {
        mOnImeBack = listener;
    }

    private void init(AttributeSet attributeSet){
        if(attributeSet != null) {
            TypedArray styledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTextFont);
            int fontFamily = styledAttributes.getInt(R.styleable.CustomTextFont_fontFamily, CustomEditTextAttr.bebas);
            int fontStyle = styledAttributes.getInt(R.styleable.CustomTextFont_fontStyle, CustomEditTextAttr.regular);
            String fontName = null;

            switch (fontFamily) {
                case CustomEditTextAttr.bebas: {
                    switch (fontStyle) {
                        case CustomEditTextAttr.regular:
                            fontName = "BebasNeue-Regular.otf";
                            break;
                        case CustomEditTextAttr.light:
                            fontName = "BebasNeue-Light.otf";
                            break;
                        case CustomEditTextAttr.bold:
                            fontName = "BebasNeue.otf";
                            break;
                    }
                }
                break;

                case CustomEditTextAttr.openSans: {
                    switch (fontStyle) {
                        case CustomEditTextAttr.regular:
                            fontName = "OpenSans-Regular.ttf";
                            break;
                        case CustomEditTextAttr.light:
                            fontName = "OpenSans-Light.ttf";
                            break;
                        case CustomEditTextAttr.bold:
                            fontName = "OpenSans-Bold.ttf";
                            break;
                    }
                }
                break;

                case CustomEditTextAttr.roboto: {
                    switch (fontStyle) {
                        case CustomEditTextAttr.regular:
                            fontName = "Roboto-Regular.ttf";
                            break;
                        case CustomEditTextAttr.light:
                            fontName = "Roboto-Light.ttf";
                            break;
                        case CustomEditTextAttr.bold:
                            fontName = "Roboto-Bold.ttf";
                            break;
                    }
                }
                break;
            }

            Typeface typeface = Typeface.createFromAsset(getContext().getResources().getAssets(), "fonts/"+fontName);
            setTypeface(typeface);
        }
    }

    public static class CustomEditTextAttr {
        public static final int bebas        = 1;
        public static final int openSans     = 2;
        public static final int roboto       = 3;

        public static final int regular      = 0;
        public static final int light        = 1;
        public static final int bold         = 2;
    }
}

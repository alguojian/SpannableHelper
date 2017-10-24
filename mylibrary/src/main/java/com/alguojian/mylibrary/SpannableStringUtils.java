package com.alguojian.mylibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

/**
 * @author ALguojian
 *         on 2017/10/24.
 */

public class SpannableStringUtils extends SpannableString {

    public SpannableStringUtils(CharSequence source) {
        super(source);
    }

    /**
     * 设置字体颜色
     *
     * @param color
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setColor(int color, int start, int end) {

        ForegroundColorSpan span = new ForegroundColorSpan(color);
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置字体背景色
     *
     * @param color
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setBackGround(int color, int start, int end) {

        BackgroundColorSpan span = new BackgroundColorSpan(color);
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置字体大小
     *
     * @param ff
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setRelativeSize(float ff, int start, int end) {

        RelativeSizeSpan span = new RelativeSizeSpan(ff);
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置删除线
     *
     * @return
     */
    public SpannableStringUtils setStrikethroughSpan(int start, int end) {

        StrikethroughSpan span = new StrikethroughSpan();
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置下划线
     *
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setUnderlineSpan(int start, int end) {

        UnderlineSpan span = new UnderlineSpan();
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }


    /**
     * 设置上标
     *
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setSuperscriptSpan(int start, int end) {

        SuperscriptSpan span = new SuperscriptSpan();
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置下标
     *
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setSubscriptSpan(int start, int end) {

        SubscriptSpan span = new SubscriptSpan();
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置粗体
     *
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setBold(int start, int end) {

        StyleSpan span = new StyleSpan(Typeface.BOLD);
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 设置斜体
     *
     * @param start
     * @param end
     * @return
     */
    public SpannableStringUtils setItalic(int start, int end) {

        StyleSpan span = new StyleSpan(Typeface.ITALIC);
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    /**
     * 添加图片
     *
     * @param context 上下文，用于获得图片,使用Activity默认主题
     * @param id      图片id
     * @param start   开始索引
     * @param end
     * @param width   图片宽度
     * @param height  图片高度
     * @return
     */
    public SpannableStringUtils setImage(Context context, int id, int start, int end, int width, int height) {

        Drawable drawable = ContextCompat.getDrawable(context, id);
        drawable.setBounds(0, 0, width, height);
        ImageSpan imageSpan = new ImageSpan(drawable);
        setSpan(imageSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return this;
    }

    public SpannableStringUtils setOnClick(int start, int end, final int color) {

        ClickableSpan span = new ClickableSpan() {

            @Override
            public void onClick(View widget) {

                onClickSpanListener.OnClickSpanListener();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(color);
                ds.setUnderlineText(false);
            }
        };
        setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        return this;
    }

    private OnClickSpanListener onClickSpanListener;

    public void setOnClickSpanListener(OnClickSpanListener onClickSpanListener) {

        this.onClickSpanListener = onClickSpanListener;
    }

    /**
     * 添加回掉接口
     */
    public interface OnClickSpanListener {

        void OnClickSpanListener();
    }


}

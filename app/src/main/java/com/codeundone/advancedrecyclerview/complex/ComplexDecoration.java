package com.codeundone.advancedrecyclerview.complex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import com.codeundone.advancedrecyclerview.R;

public class ComplexDecoration extends RecyclerView.ItemDecoration {

    private final Callback mCallback;
    private final TextPaint mTextPaint;
    private final Paint mPaint;
    private final int mLeftGap;
    private final int mTopGap;
    private final int mRightGap;
    private Paint.FontMetrics mFontMetrics;

    public ComplexDecoration(Context context, Callback callback) {
        super();
        final Resources res = context.getResources();
        mTextPaint = new TextPaint();
        mPaint = new Paint();
        mCallback = callback;

        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(80);
        mTextPaint.setColor(res.getColor(R.color.colorPrimaryDark));
        mTextPaint.getFontMetrics(mFontMetrics);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(res.getColor(R.color.colorAccent));
        mFontMetrics = new Paint.FontMetrics();

        mLeftGap = res.getDimensionPixelSize(R.dimen.indent_pad_left);
        mRightGap = res.getDimensionPixelSize(R.dimen.indent_pad_right);
        mTopGap = res.getDimensionPixelSize(R.dimen.indent_pad_top);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Inset first item of a group on the top (TBD).
     * Inset all items left & right side (TBD).
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);
        long groupId = mCallback.getGroupId(pos);
        if (groupId < 0) return;

        outRect.left = mLeftGap;
        outRect.right = mRightGap;

        if (pos == 0 || isFirstInGroup(pos)) {
            outRect.top = mTopGap;
        } else {
            outRect.top = 0;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        final int totalItemCount = state.getItemCount();
        final int childCount = parent.getChildCount();
        if (childCount == 0) return;

        float left = parent.getPaddingLeft(), textY, viewBottom;
        float textHeight = mTextPaint.getTextSize();
        float textX = left + mLeftGap / 2;
        float lineHeight = textHeight + mFontMetrics.descent;
        View view;
        int position;

        String textLine;
        long groupId, prevGroupId = -1;
        for (int i = 0; i < childCount; i++) {
            view = parent.getChildAt(i);
            position = parent.getChildAdapterPosition(view);
            viewBottom = view.getBottom() + view.getPaddingBottom();

            // Ignore items without a group
            groupId = mCallback.getGroupId(position);
            if (groupId < 0 || groupId == prevGroupId) continue;

            // Ignore empty textline
            textLine = mCallback.getGroupFirstLine(position);
            if (TextUtils.isEmpty(textLine)) continue;

            // Keep the text on screen
            textY = Math.max(mTopGap, view.getTop() + textHeight);

            // Keep text above viewBottom of group if this is the last item in it's group
            if (position + 1 < totalItemCount) {
                long nextGroupId = mCallback.getGroupId(position + 1);
                if (nextGroupId != groupId && viewBottom < textY + lineHeight) {
                    textY = viewBottom - lineHeight;
                }
            }

            // draw text
            textLine = mCallback.getGroupFirstLine(position);
            c.drawText(textLine.toUpperCase(), textX, textY, mTextPaint);

            prevGroupId = groupId;
        }
    }

    private boolean isFirstInGroup(int position) {
        if (position == 0) {
            return true;
        } else {
            long prevGroupId = mCallback.getGroupId(position - 1);
            long groupId = mCallback.getGroupId(position);
            return prevGroupId != groupId;
        }
    }

    public interface Callback {
        long getGroupId(int position);

        String getGroupFirstLine(int position);
    }
}

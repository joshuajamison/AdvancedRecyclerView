package com.codeundone.advancedrecyclerview.simple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codeundone.advancedrecyclerview.R;

public class Simple2Decoration extends RecyclerView.ItemDecoration {

    private final int indentWidthPx;
    private final Paint indentPaintLeft;
    private final Paint indentPaintRight;

    public Simple2Decoration(Context context, @ColorInt int leftColor, @ColorInt int rightColor) {
        indentWidthPx = context.getResources().getDimensionPixelSize(R.dimen.indent_width);
        indentPaintLeft = new Paint();
        indentPaintLeft.setColor(leftColor);
        indentPaintRight = new Paint();
        indentPaintRight.setColor(rightColor);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int childPos = parent.getChildAdapterPosition(child);
            boolean isLeft = childPos % 2 == 0;

            if (isLeft) {
                float left = child.getLeft();
                float right = left + indentWidthPx;
                float top = child.getTop();
                float bottom = child.getBottom();
                c.drawRect(left, top, right, bottom, indentPaintLeft);
            } else {
                float right = child.getRight();
                float left = right - indentWidthPx;
                float top = child.getTop();
                float bottom = child.getBottom();
                c.drawRect(left, top, right, bottom, indentPaintRight);
            }
        }
    }
}

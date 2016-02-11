package com.codeundone.advancedrecyclerview.simple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codeundone.advancedrecyclerview.R;

public class Simple1Decoration extends RecyclerView.ItemDecoration{

    private final int dividerHeightPx;
    private final Paint dividerPaint;

    public Simple1Decoration(Context context, @ColorInt int dividerColor) {
        dividerHeightPx = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        dividerPaint = new Paint();
        dividerPaint.setColor(dividerColor);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);

        // Skipping first child
        if (pos == 0 || pos == RecyclerView.NO_POSITION) {
            return;
        }

        outRect.top = dividerHeightPx;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        final int childCount = parent.getChildCount();

        for (int i=0; i < childCount; i++) {
            View view = parent.getChildAt(i);

            // Skipping first child
            if (parent.getChildAdapterPosition(view) == 0) {
                continue;
            }

            float left = view.getLeft();
            float right = view.getRight();
            float top = view.getTop() - dividerHeightPx;
            float bottom = view.getTop();
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}

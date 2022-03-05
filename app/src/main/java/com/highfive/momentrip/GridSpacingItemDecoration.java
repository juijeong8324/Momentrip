package com.highfive.momentrip;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    // 그리드 뷰 수정
    private int spanCount;
    private int spacing;
    private int spacingLeft;

    public GridSpacingItemDecoration(int spanCount, int spacing, int spacingLeft) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.spacingLeft = spacingLeft;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); //item position 즉 item 개수라고 봐도 될듯
        int column = position % spanCount; // item column

        if(column == 0){
            // 짝수 번째일 때
                outRect.top = spacing;

        }
        else{

            outRect.top = spacing + 80;
            outRect.left = spacingLeft;
        }


    }
}

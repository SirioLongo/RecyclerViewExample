package com.example.recyclerviewexample

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacingItemDecoration(val spacing: Int, val context: Context): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val spacingPx = spacing * context.resources.displayMetrics.density
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.top = spacingPx.toInt()
        }
        outRect.bottom = spacingPx.toInt()
        outRect.left = spacingPx.toInt()
        outRect.right = spacingPx.toInt()
    }
}

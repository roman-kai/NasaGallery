package roman.kai.nasagallery.ui.base

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import java.lang.IllegalArgumentException

/**
 * Created by Roman K. on 15/02/2019
 */
class GridSpaceDecoration(val margin: Int, val spanCount: Int) : RecyclerView.ItemDecoration() {

    init {
        if (spanCount < 1) {
            throw IllegalArgumentException("Span count can't be less that 1")
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)

        outRect.top = margin

        if (position % spanCount == 0) {
            outRect.right = margin / 2
        } else {
            outRect.left = margin / 2
        }
    }
}
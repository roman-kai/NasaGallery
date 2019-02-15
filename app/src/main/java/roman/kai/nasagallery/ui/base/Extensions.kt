package roman.kai.nasagallery.ui.base

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * Created by Roman K. on 15/02/2019
 */
fun View.setVisible(visible: Boolean = true) { visibility = if (visible) View.VISIBLE else View.GONE }

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showToastLong(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Context.pxToDp(px: Float): Float {
    return px / this.resources.displayMetrics.density
}

fun Context.dpToPx(dp: Float): Int {
    return (dp * this.resources.displayMetrics.density).toInt()
}

fun ImageView.loadUrlCropped(url: String?) {
    Glide.with(context).load(url).centerCrop().into(this)
}

fun ImageView.loadUrlFit(url: String?) {
    Glide.with(context).load(url).fitCenter().into(this)
}


package roman.kai.nasagallery.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_gallery_image.view.*
import roman.kai.nasagallery.R
import roman.kai.nasagallery.data.api.model.PhotosItem
import roman.kai.nasagallery.ui.base.SimpleViewHolder

/**
 * Created by Roman K. on 13/02/2019
 */
class GalleryAdapter(val items: List<PhotosItem>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * Holder
     */
    class GalleryViewHolder(parent: ViewGroup): SimpleViewHolder(parent, R.layout.item_gallery_image) {

        var model: PhotosItem? = null


        fun bind(model: PhotosItem) {
            this.model = model

            Glide.with(itemView.context).load(model.imgSrc).centerCrop().into(itemView.ivPhoto)
        }
    }


}
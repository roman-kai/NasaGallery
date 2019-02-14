package roman.kai.nasagallery.ui.mvp

import roman.kai.nasagallery.data.api.model.PhotosItem

/**
 * Created by Roman K. on 13/02/2019
 */
interface GalleryView {

    fun photosLoaded(photos: List<PhotosItem>)

    fun showLoadingError()
}
package roman.kai.nasagallery.ui.mvp

import roman.kai.nasagallery.data.api.model.MainPhotoResponse
import roman.kai.nasagallery.data.api.model.PhotosItem

/**
 * Created by Roman K. on 13/02/2019
 */
interface GalleryView: LoadingErrorView {

    fun photosLoaded(photos: List<PhotosItem>)
}

interface MainPhotoView: LoadingErrorView {

    fun photoLoaded(photoInfo: MainPhotoResponse)
}

interface LoadingErrorView {
    fun showLoadingError()
}
package roman.kai.nasagallery.ui.mvp

import okhttp3.ResponseBody
import roman.kai.nasagallery.data.api.Api
import roman.kai.nasagallery.data.api.ApiCallback
import roman.kai.nasagallery.data.api.model.PhotosItem
import roman.kai.nasagallery.data.api.model.PhotosResponse
import java.lang.ref.WeakReference

/**
 * Created by Roman K. on 13/02/2019
 */
class GalleryPresenter {

    private var viewReference: WeakReference<GalleryView>? = null

    fun attachView(view: GalleryView) {
        viewReference = WeakReference(view)
    }

    fun loadPhotos(roverId: String) {
        Api.get().getPhotos(roverId).enqueue(object: ApiCallback<PhotosResponse>() {
            override fun onSuccess(response: PhotosResponse, code: Int) {
                if (response.photos?.isNotEmpty() == true) {
                    getView()?.photosLoaded(response.photos)
                } else {
                    getView()?.showLoadingError()
                }
            }

            override fun onFail(errorBody: ResponseBody?, code: Int) {
                getView()?.showLoadingError()
            }
        })
    }

    fun getView(): GalleryView? = viewReference?.get()
}
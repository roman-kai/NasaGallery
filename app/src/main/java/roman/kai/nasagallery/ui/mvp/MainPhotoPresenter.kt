package roman.kai.nasagallery.ui.mvp

import okhttp3.ResponseBody
import roman.kai.nasagallery.data.api.Api
import roman.kai.nasagallery.data.api.ApiCallback
import roman.kai.nasagallery.data.api.model.MainPhotoResponse
import roman.kai.nasagallery.data.api.model.PhotosItem
import roman.kai.nasagallery.data.api.model.PhotosResponse
import java.lang.ref.WeakReference

/**
 * Created by Roman K. on 13/02/2019
 */
class MainPhotoPresenter {

    private var viewReference: WeakReference<MainPhotoView>? = null

    fun attachView(view: MainPhotoView) {
        viewReference = WeakReference(view)
    }

    fun loadPhotoOfTheDay() {
        Api.get().getMainPhoto().enqueue(object: ApiCallback<MainPhotoResponse>() {
            override fun onSuccess(response: MainPhotoResponse, code: Int) {
                getView()?.photoLoaded(response)
            }

            override fun onFail(errorBody: ResponseBody?, code: Int) {
                getView()?.showLoadingError()
            }
        })
    }

    fun getView(): MainPhotoView? = viewReference?.get()
}
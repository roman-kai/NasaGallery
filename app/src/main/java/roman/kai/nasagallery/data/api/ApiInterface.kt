package roman.kai.nasagallery.data.api

import retrofit2.Call
import retrofit2.http.*
import roman.kai.nasagallery.data.api.model.MainPhotoResponse
import roman.kai.nasagallery.data.api.model.PhotosResponse

interface ApiInterface {

    @GET(ApiConstants.PHOTOS)
    fun getPhotos(@Path("rover_id") roverId: String): Call<PhotosResponse>

    @GET(ApiConstants.MAIN_PHOTO)
    fun getMainPhoto(): Call<MainPhotoResponse>
}
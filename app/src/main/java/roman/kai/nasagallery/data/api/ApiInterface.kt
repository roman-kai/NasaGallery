package roman.kai.nasagallery.data.api

import retrofit2.Call
import retrofit2.http.*
import roman.kai.nasagallery.data.api.model.PhotosResponse

interface ApiInterface {

    @GET(ApiConstants.PHOTOS)
    fun getPhotos(@Path("rover_id") roverId: String): Call<PhotosResponse>
}
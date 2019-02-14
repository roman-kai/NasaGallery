package roman.kai.nasagallery.data.api

import roman.kai.nasagallery.BuildConfig


object ApiConstants {

    private const val BASE_URL = " https://api.nasa.gov/mars-photos/api/v1/"

    val ENDPOINT by lazy { getEndpoint() }

    @JvmStatic fun getEndpoint(): String {
        return when(BuildConfig.BUILD_TYPE) {
            "debug" -> BASE_URL
            else -> BASE_URL
        }
    }

    /**
     * Api endpoints
     */

    const val PHOTOS = "rovers/{rover_id}/photos?sol=1900&camera=NAVCAM"
}
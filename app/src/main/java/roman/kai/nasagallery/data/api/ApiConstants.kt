package roman.kai.nasagallery.data.api

import roman.kai.nasagallery.BuildConfig


object ApiConstants {

    private const val BASE_URL = " https://api.nasa.gov"

    val SERVER by lazy { getServer() }

    @JvmStatic fun getServer(): String {
        return when(BuildConfig.BUILD_TYPE) {
            "debug" -> BASE_URL
            else -> BASE_URL
        }
    }

    /**
     * Api endpoints
     */

    const val PHOTOS = "/mars-photos/api/v1/rovers/{rover_id}/photos?sol=1000&camera=NAVCAM"
    const val MAIN_PHOTO = "/planetary/apod"
}
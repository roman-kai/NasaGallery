package roman.kai.nasagallery.data.api.model

import com.google.gson.annotations.SerializedName

data class PhotosResponse(

	@field:SerializedName("photos")
	val photos: List<PhotosItem>? = null
)
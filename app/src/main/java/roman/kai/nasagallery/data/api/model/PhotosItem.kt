package roman.kai.nasagallery.data.api.model

import com.google.gson.annotations.SerializedName

data class PhotosItem(

	@field:SerializedName("sol")
	val sol: Int? = null,

	@field:SerializedName("earth_date")
	val earthDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("camera")
	val camera: Camera? = null,

	@field:SerializedName("rover")
	val rover: Rover? = null,

	@field:SerializedName("img_src")
	val imgSrc: String? = null
)
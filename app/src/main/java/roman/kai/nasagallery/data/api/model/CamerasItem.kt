package roman.kai.nasagallery.data.api.model

import com.google.gson.annotations.SerializedName

data class CamerasItem(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)
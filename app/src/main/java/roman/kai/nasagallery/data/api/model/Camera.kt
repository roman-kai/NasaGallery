package roman.kai.nasagallery.data.api.model

import com.google.gson.annotations.SerializedName

data class Camera(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("rover_id")
	val roverId: Int? = null
)
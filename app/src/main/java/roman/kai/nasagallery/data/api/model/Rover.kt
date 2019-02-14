package roman.kai.nasagallery.data.api.model

import com.google.gson.annotations.SerializedName

data class Rover(

	@field:SerializedName("max_sol")
	val maxSol: Int? = null,

	@field:SerializedName("cameras")
	val cameras: List<CamerasItem?>? = null,

	@field:SerializedName("max_date")
	val maxDate: String? = null,

	@field:SerializedName("total_photos")
	val totalPhotos: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("launch_date")
	val launchDate: String? = null,

	@field:SerializedName("landing_date")
	val landingDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
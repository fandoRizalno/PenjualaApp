package iglo.indocyber.common.entity.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String
)
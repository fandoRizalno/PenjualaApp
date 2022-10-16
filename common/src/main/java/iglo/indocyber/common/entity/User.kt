package iglo.indocyber.common.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user")
    val user: String,
    @SerializedName("password")
    val password: String,
)
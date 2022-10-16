package iglo.indocyber.common.entity.productA


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("price")
    val price: Double,
    @SerializedName("productCode")
    val productCode: String,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("unit")
    val unit: String
)
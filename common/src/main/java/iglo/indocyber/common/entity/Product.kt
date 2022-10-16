package iglo.indocyber.common.entity

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Product(
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("unit")
    val unit: String
) {
}
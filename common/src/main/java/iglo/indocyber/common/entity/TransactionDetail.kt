package iglo.indocyber.common.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class TransactionDetail(
    @SerializedName("document_code")
    val documentCode: String,
    @SerializedName("document_number")
    val documentNumber: String,
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("sub_total")
    val subTotal: Double,
    @SerializedName("currency")
    val currency: String

) {
}
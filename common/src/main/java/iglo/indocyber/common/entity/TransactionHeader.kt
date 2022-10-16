package iglo.indocyber.common.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class TransactionHeader(
    @SerializedName("document_code")
    val documentCode: String,
    @SerializedName("document_number")
    val documentNumber: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("total")
    val total: Double,
    @SerializedName("date")
    val date: Date
)
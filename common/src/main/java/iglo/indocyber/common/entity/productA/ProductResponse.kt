package iglo.indocyber.common.entity.productA


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("content")
    val content: List<Content>,
    @SerializedName("empty")
    val empty: Boolean,
    @SerializedName("first")
    val first: Boolean,
    @SerializedName("last")
    val last: Boolean,
    @SerializedName("number")
    val number: Int,
    @SerializedName("numberOfElements")
    val numberOfElements: Int,
    @SerializedName("pageable")
    val pageable: Pageable,
    @SerializedName("size")
    val size: Int,
    @SerializedName("sort")
    val sort: SortX,
    @SerializedName("totalElements")
    val totalElements: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)
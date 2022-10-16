package iglo.indocyber.service.rService

import iglo.indocyber.common.entity.productA.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("product/list")
    suspend fun getProduct(): Response<ProductResponse>
}
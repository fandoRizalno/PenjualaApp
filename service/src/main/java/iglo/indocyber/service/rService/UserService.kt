package iglo.indocyber.service.rService

import iglo.indocyber.common.entity.login.LoginResponse
import iglo.indocyber.common.entity.productA.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("login/autheticate")
    suspend fun getLogin(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<LoginResponse>
}
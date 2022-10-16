package iglo.indocyber.service.usecase

import iglo.indocyber.common.entity.User
import iglo.indocyber.common.entity.login.LoginResponse
import iglo.indocyber.common.entity.productA.Content
import iglo.indocyber.service.rService.UserService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class LoginUseCase() {
    operator fun invoke(username: String, password:String) = callbackFlow<Boolean>{
        val userAccount = arrayListOf<User>(
            User("smit","smit"),
            User("wew","wew"),
            User("we","we")

        )
        userAccount.forEach {
            try {
                if(username.equals(it.user).and(password.equals(it.password))){
                    send(true)
                    awaitClose()
                } else {
                    send(false)

                }
            } catch (e:Exception){
                send(false)

            }
        }
        awaitClose()
    }



//    operator fun invoke(username: String, password: String) = flow<LoginResponse> {
//        val user = userService.getLogin(username, password)
//        if (user.isSuccessful) {
//            user.body()?.let {
//                emit(it)
//            }
//        }
//    }
}
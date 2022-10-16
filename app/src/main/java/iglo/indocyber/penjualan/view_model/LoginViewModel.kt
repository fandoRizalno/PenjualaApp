package iglo.indocyber.penjualan.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import iglo.indocyber.common.entity.login.LoginResponse
import iglo.indocyber.service.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application,
    val loginUseCase: LoginUseCase
) : AndroidViewModel(application)  {

    var loginInfo = MutableLiveData<Boolean>()
    val usernameLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()



    fun login(username: String,password : String){
        viewModelScope.launch {
            loginUseCase.invoke(username,password).collect{
                loginInfo.postValue(it)
            }
        }
    }

}
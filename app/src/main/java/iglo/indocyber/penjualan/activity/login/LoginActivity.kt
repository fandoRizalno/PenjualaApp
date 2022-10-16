package iglo.indocyber.penjualan.activity.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.activity.product.ProductListActivity
import iglo.indocyber.penjualan.databinding.LayoutLoginBinding
import iglo.indocyber.penjualan.view_model.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity() : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_login
    lateinit var binding : LayoutLoginBinding
    val vm:LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        binding.username.addTextChangedListener {
            vm.usernameLiveData.postValue( it.toString())

        }

        binding.password.addTextChangedListener {
            vm.passwordLiveData.postValue( it.toString())
        }



        binding.loginButton.setOnClickListener {
            val username = vm.usernameLiveData.value.orEmpty()
            val password = vm.passwordLiveData.value.orEmpty()
            vm.login(username,password)
//            val intent = Intent(this, ProductListActivity::class.java)
//            this.startActivity(intent)
        }

        vm.loginInfo.observe(this){
            val loginInfo = vm.loginInfo.value
            var dialog: ProgressDialog? = null
            if (loginInfo != null) {
                if (loginInfo.equals(true)){
                    val intent = Intent(this, ProductListActivity::class.java)
                    this.startActivity(intent)
                }else{
                    dialog?.dismiss()
                    Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
                }
            }
        }







    }
}
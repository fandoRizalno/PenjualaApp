package iglo.indocyber.penjualan.activity.product

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.databinding.LayoutProductDetailBinding
import iglo.indocyber.penjualan.databinding.LayoutProductListBinding
import iglo.indocyber.penjualan.view_model.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailActivity :  AppCompatActivity()  {
    val layoutResourceId = R.layout.layout_product_detail
    lateinit var binding : LayoutProductDetailBinding

    val vm: ProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        vm.productCode.value = intent.getStringExtra("EXTRA_DATA_PRODUCT_CODE")
        vm.productCode.observe(this@ProductDetailActivity){
            vm.getOnePoduct(it)
            binding.buy.setOnClickListener {
                val intent = Intent(this, ProductListActivity::class.java)
                val productCode = vm.productCode.value
                intent.putExtra("EXTRA_DATA_PRODUCT_CODE", productCode)
                this.startActivity(intent)
            }
        }

    }

}
package iglo.indocyber.penjualan.activity.product

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import iglo.indocyber.common.entity.Product
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.databinding.LayoutProductListBinding
import iglo.indocyber.penjualan.view_model.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListActivity : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_product_list
    lateinit var binding : LayoutProductListBinding

    val vm: ProductViewModel by viewModel()
    val adapter = ProductListAdapter(this, ::getSelectedProducts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        vm.productCode.postValue(intent.getStringExtra("EXTRA_DATA_PRODUCT_CODE"))
        vm.productCode.value?.let { vm.getOnePoduct(it) }
        vm.productOne.value?.let { vm.selectedProducts.add(it) }

        binding.recycler.adapter = adapter

        vm.productList.observe(this@ProductListActivity){
            adapter.submitData(it)
        }




        binding.Checkout.setOnClickListener {
            val selectedProducts = getSelectedProducts()
            val selectedProductIds = ArrayList<String>()
            selectedProductIds.addAll(selectedProducts.map { it.productCode })
            val intent = Intent(this, CheckoutProductActivity::class.java)
            intent.putStringArrayListExtra("EXTRA_DATA_PRODUCT_IDS", selectedProductIds)
            this.startActivity(intent)
        }


    }

    fun getSelectedProducts() = vm.selectedProducts

}
package iglo.indocyber.penjualan.activity.product

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import iglo.indocyber.common.entity.Product
import iglo.indocyber.penjualan.BR
import iglo.indocyber.penjualan.R
import iglo.indocyber.penjualan.databinding.LayoutCheckoutPageBinding
import iglo.indocyber.penjualan.view_model.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckoutProductActivity : AppCompatActivity() {
    val layoutResourceId = R.layout.layout_checkout_page
    lateinit var binding: LayoutCheckoutPageBinding


    val vm: ProductViewModel by viewModel()
    val adapter = CheckoutProductAdapter(::getTotalPrices)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this), layoutResourceId, null, false
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.setVariable(BR.vm, vm)

        binding.recycler.adapter = adapter

        val selectedProductIds = intent.getStringArrayListExtra("EXTRA_DATA_PRODUCT_IDS")

        vm.productList.observe(this@CheckoutProductActivity) {
            val dataCheckOut = ArrayList<Product>()
            val selectedTotalPrices= vm.listSubTotalPrices
            for (data in it) {
                if (selectedProductIds != null) {
                    if (data.productCode in selectedProductIds) {
                        dataCheckOut.add(data)
                        selectedTotalPrices.put(data.productCode,adapter.priceAfterDiscount(data.price,data.discount))
                    }
                }
            }
            binding.totalPriceValue = vm.getTotalPricesValue()
            adapter.submitData(dataCheckOut)
        }

        binding.Confirm.setOnClickListener {
            binding.totalPriceValue = vm.getTotalPricesValue()
        }

    }

    fun getTotalPrices() = vm.listSubTotalPrices
}
package iglo.indocyber.penjualan.activity.product

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import iglo.indocyber.common.entity.Product
import iglo.indocyber.penjualan.databinding.LayoutCheckoutPageItemBinding

class CheckoutProductAdapter(
    private val getListTotalPrices: () -> MutableMap<String,Double>
) : RecyclerView.Adapter<CheckoutListViewHolder>() {

    val dataDiffer = AsyncListDiffer<Product>(this, differProduct)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutListViewHolder {
        return CheckoutListViewHolder(
            LayoutCheckoutPageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CheckoutListViewHolder, position: Int) {
        var data = dataDiffer.currentList[position]
        holder.binding.data = data
        val selectedTotalPrices= getListTotalPrices()
        var price = priceAfterDiscount(data.price,data.discount)
        var subTotal = price*1
        holder.binding.totalPcs.addTextChangedListener {
            var pcs = it?.ifEmpty { "0"  }.toString()
            var pcsNumber = pcs.toDouble()
            subTotal = price*pcsNumber
            selectedTotalPrices.put(data.productCode,subTotal)
            holder.binding.subTotalValue = subTotal
        }
        selectedTotalPrices.put(data.productCode,subTotal)
        holder.binding.subTotalValue = subTotal

    }

    override fun getItemCount(): Int {
        return dataDiffer.currentList.size
    }


    fun submitData(list: List<Product>) {
        dataDiffer.submitList(list)
    }

    fun priceAfterDiscount(price: Double, discount: Int) =  price-(discount*price/100)


    companion object {
        val differProduct = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productCode == newItem.productCode
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return true
            }

        }
    }

}

class CheckoutListViewHolder(
    val binding: LayoutCheckoutPageItemBinding
) : RecyclerView.ViewHolder(binding.root)
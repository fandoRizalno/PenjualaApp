package iglo.indocyber.penjualan.activity.product

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import iglo.indocyber.common.entity.Product
import iglo.indocyber.common.entity.productA.Content
import iglo.indocyber.penjualan.databinding.LayoutProductListItemBinding

class ProductListAdapter(
    val context: Context,
    private val getSelectedProducts: () -> ArrayList<Product>
) : RecyclerView.Adapter<ProductListViewHolder>() {

    val dataDiffer = AsyncListDiffer<Product>(this, differProduct)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            LayoutProductListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        var data = dataDiffer.currentList[position]
        holder.binding.data = data
        holder.binding.cardView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("EXTRA_DATA_PRODUCT_CODE", data.productCode)
            context.startActivity(intent)
        }
        val selectedProducts = getSelectedProducts()

        if (data in selectedProducts) {
            holder.binding.cancel.visibility = View.VISIBLE
            holder.binding.buy.visibility = View.GONE

        } else {
            holder.binding.buy.visibility = View.VISIBLE
            holder.binding.cancel.visibility = View.GONE

        }

        if(data.discount > 0){
            holder.binding.priceStrike.visibility = View.VISIBLE
            holder.binding.price.visibility = View.GONE
            holder.binding.hargaDiscount = (data.price-(data.discount*data.price/100))
        }else{
            holder.binding.priceDiscount.visibility = View.GONE

        }

        holder.binding.buy.setOnClickListener {
            holder.binding.cancel.visibility = View.VISIBLE
            holder.binding.buy.visibility = View.GONE
            selectedProducts.add(data)
        }

        holder.binding.cancel.setOnClickListener {
            holder.binding.buy.visibility = View.VISIBLE
            holder.binding.cancel.visibility = View.GONE
            selectedProducts.remove(data)
        }


    }

    override fun getItemCount(): Int {
        return dataDiffer.currentList.size
    }

    fun submitData(list: List<Product>) {
        dataDiffer.submitList(list)
    }

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

class ProductListViewHolder(
    val binding: LayoutProductListItemBinding
) : RecyclerView.ViewHolder(binding.root)
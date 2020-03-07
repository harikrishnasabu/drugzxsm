package com.pms.drugzx.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pms.drugzx.R
import com.pms.drugzx.datamodels.Product
import com.pms.drugzx.ui.main.ProductListingVM
import kotlinx.android.synthetic.main.fragment_add_product.view.*
import kotlinx.android.synthetic.main.layout_selected_products_list.view.*

class SelectedProductsRecyclerAdapter(viewModel: ProductListingVM) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Product> =ArrayList()
    var selectedProducts:ArrayList<Product> =ArrayList()
    var productViewModel: ProductListingVM = viewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ProductVH(LayoutInflater.from(parent.context).inflate(R.layout.layout_selected_products_list,parent,false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println("onBindViewHolder"+items.get(position))
        when(holder){
            is ProductVH->{
                holder.bind(items.get(position))

            }
        }
    }
    fun setProductList(products:List<Product>){
        items=products
    }

    fun setSelectedProducts(){
        // productViewModel.setProducts()
        for (item in items){
            if(item.isProductChecked){
                selectedProducts.add(item)
            }
        }
        productViewModel.setProducts(selectedProducts)
    }
    override fun getItemCount(): Int {
        return items.size }

    class ProductVH constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val productId=itemView.tv_product_id
        val productName=itemView.tv_product_name
        val productPrice=itemView.tv_product_price
        val productQuantity=itemView.product_quantity

        fun bind(product: Product){
            productName.setText(product.productName)
            productId.setText(product.productId)
            productPrice.setText("$"+product.productId)
            productQuantity.setText("2")

        }
    }

}
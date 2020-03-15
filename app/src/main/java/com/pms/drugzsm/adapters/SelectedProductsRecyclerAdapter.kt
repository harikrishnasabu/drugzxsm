package com.pms.drugzsm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pms.drugzsm.R
import com.pms.drugzsm.datamodels.Product
import com.pms.drugzsm.datamodels.api.Products
import com.pms.drugzsm.ui.main.ProductListingVM
import kotlinx.android.synthetic.main.layout_selected_products_list.view.*

class SelectedProductsRecyclerAdapter(
    viewModel: ProductListingVM,
    adapter: ArrayAdapter<Int> ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Products> =ArrayList()
    var selectedProducts:ArrayList<Product> =ArrayList()
    var productViewModel: ProductListingVM = viewModel
    var spinnerAdapter:SpinnerAdapter=adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ProductVH(LayoutInflater.from(parent.context).inflate(R.layout.layout_selected_products_list,parent,false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println("onBindViewHolder"+items.get(position))
        when(holder){
            is ProductVH->{
                holder.bind(items.get(position),spinnerAdapter)
               holder.productQuantity.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        _position: Int,
                        id: Long
                    ) {
                        if (parent != null) {
                            items.get(position).pQuantity= spinnerAdapter.getItem(_position) as Int
                        }
                    }

                })

            }

        }

    }
    fun setProductList(products:List<Products>){
        items=products
    }

    fun setSelectedProducts(){
        productViewModel.setProducts(items)
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

        fun bind(product: Products,spinnerAdapter:SpinnerAdapter){
            productId.setText(product.pId.toString())
            productName.setText(product.pName)
            productPrice.setText("$"+product.pCostPrice)
            productQuantity.adapter=spinnerAdapter

        }
    }

}
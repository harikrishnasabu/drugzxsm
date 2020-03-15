package com.pms.drugzsm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pms.drugzsm.R
import com.pms.drugzsm.datamodels.api.Products
import com.pms.drugzsm.datamodels.api.Supplier
import com.pms.drugzsm.ui.main.ProductListingVM
import com.pms.drugzsm.ui.main.SupplierListingVM
import kotlinx.android.synthetic.main.layout_products_list_item.view.*
import kotlinx.android.synthetic.main.layout_supplier_list_item.view.*

class SupplierRecyclerAdapter(viewModel: SupplierListingVM) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<Supplier> =ArrayList()
    var supplierViewModel: SupplierListingVM = viewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return SupplierVH(LayoutInflater.from(parent.context).inflate(R.layout.layout_supplier_list_item,parent,false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is SupplierVH->{
                holder.bind(items.get(position))
                holder.cardSupplier.setOnClickListener {

    supplierViewModel.setSelectedSupplier(items.get(position))
}
            }
        }
    }
    fun setProductList(suppliers:ArrayList<Supplier>){
        items=suppliers
    }


    override fun getItemCount(): Int {
        return items.size }

    class SupplierVH constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val supplierName=itemView.tv_supplier_name
val cardSupplier=itemView.cv_supplier
        fun bind(supplier: Supplier){
            supplierName.setText(supplier.supplierName)


        }
    }

}
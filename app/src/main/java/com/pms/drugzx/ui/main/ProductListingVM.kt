package com.pms.drugzx.ui.main

import androidx.lifecycle.ViewModel
import com.pms.drugzx.datamodels.Product
import com.pms.drugzx.utils.InjectorUtils

class ProductListingVM : ViewModel() {

    var productsRepository= InjectorUtils.provideProductsRepository()
    fun setProducts(selectedProducts: ArrayList<Product>) {

    }

    fun getProducts(): List<Product> {


   return productsRepository.getProducts() }
}
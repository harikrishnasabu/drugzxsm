package com.pms.drugzsm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pms.drugzsm.datamodels.api.Products
import com.pms.drugzsm.repo.MainRepository
import com.pms.drugzsm.utils.InjectorUtils

class ProductListingVM : ViewModel() {
     var _products: LiveData<List<Products>> = MutableLiveData()
    private val _selectedProducts: MutableLiveData<List<Products>> = MutableLiveData()
    var productsRepository= InjectorUtils.provideProductsRepository()

    fun setProducts(selectedProducts: List<Products>) {
        _selectedProducts.value=selectedProducts
MainRepository._selectedProducts=selectedProducts
        println("_selectedProducts"+selectedProducts)
    }

    fun getProducts() {
        _products=MainRepository.getProducts()
 }
    fun getSelectedProducts(): List<Products>? {
        return  MainRepository._selectedProducts
    }
}
package com.pms.drugzsm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pms.drugzsm.datamodels.api.Supplier
import com.pms.drugzsm.repo.MainRepository

class SupplierListingVM: ViewModel() {
     var _suppliers:LiveData<List<Supplier>> = MutableLiveData()
    var _supplier:MutableLiveData<Supplier> = MutableLiveData()
fun setSelectedSupplier(supplier: Supplier){
    _supplier.value=supplier
    MainRepository._selectedSupplier=supplier
    println("SELECTED"+supplier)
}

    fun getSuppliersList(): LiveData<List<Supplier>> {
        _suppliers= MainRepository.getSuppliers()
        return _suppliers   }
}
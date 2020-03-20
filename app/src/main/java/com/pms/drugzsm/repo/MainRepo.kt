package com.pms.drugzsm.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pms.drugx.api.ApiService
import com.pms.drugzsm.api.MyRetrofitBuilder
import com.pms.drugzsm.datamodels.Login
import com.pms.drugzsm.datamodels.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainRepository {

    var job: CompletableJob? = null
lateinit var _selectedProducts:List<Products>
    lateinit var _selectedSupplier:Suppliers
    lateinit var _allProducts:List<Products>
    lateinit var _allSuppliers:List<Suppliers>
    var _updateProduct:MutableLiveData<Products> = MutableLiveData()
    var _updateSupplier:MutableLiveData<Suppliers> = MutableLiveData()
     var _customerOrder:MutableLiveData<CustomerOrder> = MutableLiveData()

    fun getProducts(): LiveData<List<Products>>{
        job = Job()
        return object: LiveData<List<Products>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        _allProducts = MyRetrofitBuilder.apiService.getProducts()
                        withContext(Main){
                            value = _allProducts
                            println("PRODUCT"+value)
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }
    fun searchProducts(search:String): LiveData<List<Products>>{
        job = Job()
        return object: LiveData<List<Products>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val list = MyRetrofitBuilder.apiService.searchProduct(search)
                        withContext(Main){
                            value = list
                            println("SEARCH"+value)
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }
    fun getUser(login: Login):LiveData<User> {

        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(ApiService.LoginPostData(login.userName,login.password))
//                        user.enqueue(object: Callback<User> {
//
//
//
//                            override fun onResponse(call: Call<User>, response: Response<User>) {
//                                if(response.isSuccessful){
//                                    println("onResponse"+response.body().toString())
//                                }
//                                else{
//                                   println("Failed to retrieve items")
//                                }
//                            }
//
//                            override fun onFailure(call: Call<User>, t: Throwable) {
//                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                            }
//
//                        })
                        withContext(Main){
                            value = user
                          //  println("USER"+value)
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }
    fun sendOrder(customerOrder: CustomerOrder){
        job = Job()
        _customerOrder.value=customerOrder

                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val addCustomer = MyRetrofitBuilder.apiService.postOrder(_customerOrder.value!!)
                        withContext(Main){

                            println("customerOrder"+addCustomer)
                            theJob.complete()
                        }
                    }


        }
    }
    fun getSuppliers(): LiveData<List<Suppliers>> {
        job = Job()
        return object: LiveData<List<Suppliers>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        _allSuppliers = MyRetrofitBuilder.apiService.getSuppliers()
                        withContext(Main){
                            value = _allSuppliers
                            println("PRODUCT"+value)
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

    fun addProduct(product: Product) {
        job = Job()

        job?.let{ theJob ->
            CoroutineScope(IO + theJob).launch {
                val addCustomer = MyRetrofitBuilder.apiService.addProduct(product = product)
                withContext(Main){
                    addCustomer.toString()
                    theJob.complete()
                }
            }


        }
    }

    fun addSupplier(supplier: Supplier) {
        job = Job()

        job?.let{ theJob ->
            CoroutineScope(IO + theJob).launch {
                val supplier = MyRetrofitBuilder.apiService.addSupplier(supplier = supplier)
                withContext(Main){
                    supplier.toString()
                    theJob.complete()
                }
            }


        }
    }

    fun updateProduct(product: Products, pId: Int) {

        job = Job()

        job?.let{ theJob ->
            CoroutineScope(IO + theJob).launch {
                val updateProduct = MyRetrofitBuilder.apiService.updateProduct(productId = pId,product = product)
                withContext(Main){
                    updateProduct.toString()
                    theJob.complete()
                }
            }


        }

    }

    fun updateSupplier(supplierId: Int, supplier: Suppliers) {



        job = Job()

        job?.let{ theJob ->
            CoroutineScope(IO + theJob).launch {
                val updateSupplier = MyRetrofitBuilder.apiService.updateSupplier(supplierId = supplierId,supplier = supplier)
                withContext(Main){
                    updateSupplier.toString()
                    theJob.complete()
                }
            }


        }


    }

   fun deleteProduct(id:Int){
       job = Job()

       job?.let{ theJob ->
           CoroutineScope(IO + theJob).launch {
               val updateSupplier = MyRetrofitBuilder.apiService.deleteProduct(id)
               withContext(Main){
                   updateSupplier.toString()
                   theJob.complete()
               }
           }


       }
   }

    fun deleteSupplier(id:Int){
        job = Job()

        job?.let{ theJob ->
            CoroutineScope(IO + theJob).launch {
                val updateSupplier = MyRetrofitBuilder.apiService.deleteSupplier(id)
                withContext(Main){
                    updateSupplier.toString()
                    theJob.complete()
                }
            }


        }
    }

    fun searchSuppliers(search: String) :LiveData<List<Suppliers>>{
        job = Job()
        // var list = ArrayList<Suppliers>()


        return object: LiveData<List<Suppliers>>(){
            override fun onActive() {


                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                      val list = MyRetrofitBuilder.apiService.searchSupplier(sName = search) as ArrayList<Suppliers>
                        withContext(Main){
                            value=list
                            theJob.complete()
                        }

                    }


                }

            }
        }
        }


}


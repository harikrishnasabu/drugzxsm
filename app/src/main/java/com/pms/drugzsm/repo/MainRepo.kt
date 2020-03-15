package com.pms.drugzsm.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pms.drugx.api.ApiService
import com.pms.drugzsm.api.MyRetrofitBuilder
import com.pms.drugzsm.datamodels.Login
import com.pms.drugzsm.datamodels.api.CustomerOrder
import com.pms.drugzsm.datamodels.api.Products
import com.pms.drugzsm.datamodels.api.Supplier
import com.pms.drugzsm.datamodels.api.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainRepository {

    var job: CompletableJob? = null
lateinit var _selectedProducts:List<Products>
    lateinit var _selectedSupplier:Supplier
     var _customerOrder:MutableLiveData<CustomerOrder> = MutableLiveData()
    fun getProducts(): LiveData<List<Products>>{
        job = Job()
        return object: LiveData<List<Products>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val products = MyRetrofitBuilder.apiService.getProducts()
                        withContext(Main){
                            value = products
                            println("PRODUCT"+value)
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
    fun getSuppliers(): LiveData<List<Supplier>>{
        job = Job()
        return object: LiveData<List<Supplier>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val suppliers = MyRetrofitBuilder.apiService.getSuppliers()
                        withContext(Main){
                            value = suppliers
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



}


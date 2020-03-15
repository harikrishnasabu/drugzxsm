package com.pms.drugx.api


import com.google.gson.annotations.SerializedName
import com.pms.drugzsm.datamodels.api.CustomerOrder
import com.pms.drugzsm.datamodels.api.Products
import com.pms.drugzsm.datamodels.api.Supplier
import com.pms.drugzsm.datamodels.api.User
import retrofit2.http.*


interface ApiService {

//    @GET("/products/{userId}")
//    suspend fun getProducts(
//        @Path("userId") userId: String
//    ): List<Product>




    @GET("supplier-managment-service/supplier/allSupplier/")
    suspend fun getSuppliers(
    ): List<Supplier>



    @GET("product-managment-service/product/allproducts")
    suspend fun getProducts(
    ): List<Products>

    @Headers("Content-Type: application/json")
    @POST("user-managment-service/users/login")
    suspend fun getUser(@Body login:LoginPostData

    ):User

    @Headers("Content-Type: application/json")
    @POST("sales-managment-service/order/addorder")
    suspend fun postOrder(@Body customerOrder: CustomerOrder

    )
    @Headers("Content-Type: application/json")
    @POST("supplier-managment-service/supplier/addSupplier")
    suspend fun addSupplier(@Body supplier:Supplier
    )
    @Headers("Content-Type: application/json")
    @POST("product-managment-service/product/addproduct")
    suspend fun addProduct(@Body products: Products

    )

    @Headers("Content-Type: application/json")
    @POST("supplier-managment-service/supplier/updateSupplier/{supplierId}")
    suspend fun updateSupplier(  @Path("supplierId") supplierId: String, @Body supplier:Supplier
    )
    @Headers("Content-Type: application/json")
    @POST("product-managment-service/product/updateproduct/{productId}")
    suspend fun updateProduct(@Path("productId") productId: String,@Body products: Products

    )
    @Headers("Content-Type: application/json")
    @POST("supplier-managment-service/supplier/delete/{supplierId}")
    suspend fun deleteSupplier(@Path("supplierId") supplierId: String
    )
    @Headers("Content-Type: application/json")
    @POST("product-managment-service/product/delete/{productId}")
    suspend fun deleteProduct(@Path("productId") productId: String

    )

    data class LoginPostData(
        @SerializedName("userName") var userName: String,
        @SerializedName("password") var password: String
    )
}
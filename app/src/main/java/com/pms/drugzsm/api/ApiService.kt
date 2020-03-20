package com.pms.drugx.api


import com.google.gson.annotations.SerializedName
import com.pms.drugzsm.datamodels.api.*
import retrofit2.http.*


interface ApiService {

//    @GET("/products/{userId}")
//    suspend fun getProducts(
//        @Path("userId") userId: String
//    ): List<Product>

    @Headers("Content-Type: application/json")
    @GET("supplier-managment-service/supplier/searchSupplierName/{sName}")
    suspend fun searchSupplier( @Path("sName") sName:String
    ): List<Suppliers>

    @Headers("Content-Type: application/json")
    @GET("product-managment-service/product/search/{pName}")
    suspend fun searchProduct( @Path("pName") pName:String
    ): List<Products>

    @GET("supplier-managment-service/supplier/allSupplier/")
    suspend fun getSuppliers(
    ): List<Suppliers>



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
    suspend fun addProduct(@Body product: Product

    )

    @Headers("Content-Type: application/json")
    @PUT("supplier-managment-service/supplier/updateSupplier/{supplierId}")
    suspend fun updateSupplier(  @Path("supplierId") supplierId: Int, @Body supplier:Suppliers
    )
    @Headers("Content-Type: application/json")
    @PUT("product-managment-service/product/updateproduct/{productId}")
    suspend fun updateProduct(@Path("productId") productId: Int,@Body product: Products

    )
    @Headers("Content-Type: application/json")
    @DELETE("supplier-managment-service/supplier/delete/{supplierId}")
    suspend fun deleteSupplier(@Path("supplierId") supplierId: Int
    )
    @Headers("Content-Type: application/json")
    @DELETE("product-managment-service/product/deleteproduct/{productId}")
    suspend fun deleteProduct(@Path("productId") productId: Int

    )

    data class LoginPostData(
        @SerializedName("userName") var userName: String,
        @SerializedName("password") var password: String
    )
}
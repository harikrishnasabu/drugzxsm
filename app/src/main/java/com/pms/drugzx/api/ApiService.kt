package com.pms.drugx.api


import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.pms.drugzx.datamodels.Login
import com.pms.drugzx.datamodels.api.Products
import com.pms.drugzx.datamodels.api.User
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

//    @GET("/products/{userId}")
//    suspend fun getProducts(
//        @Path("userId") userId: String
//    ): List<Product>

    @GET("/product/allproducts/")
    suspend fun getProducts(
    ): List<Products>

    @Headers("Content-Type: application/json")
    @POST("/users/login/")
    suspend fun getUser(@Body login:LoginPostData

        ):User
    data class LoginPostData(
        @SerializedName("userName") var userName: String,
        @SerializedName("password") var password: String
    )
}
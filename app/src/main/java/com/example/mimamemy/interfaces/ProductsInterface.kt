package com.example.mimamemy.interfaces

import com.example.mimamemy.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductsInterface {
    @Headers("Content-Type:application/json")
    @GET("/products")
    fun getAllProducts(): Call<ApiResponse>
}
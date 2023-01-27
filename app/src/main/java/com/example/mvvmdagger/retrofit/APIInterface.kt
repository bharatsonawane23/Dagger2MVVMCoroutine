package com.example.mvvmdagger.retrofit

import com.example.mvvmdagger.model.Products
import com.example.mvvmdagger.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET(Constant.PRODUCT_ENDPOINT)
    suspend fun getProducts(): Response<List<Products>>
}
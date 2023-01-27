package com.example.mvvmdagger.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdagger.db.ProductDB
import com.example.mvvmdagger.model.Products
import com.example.mvvmdagger.retrofit.APIInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: APIInterface,
    private val productDB: ProductDB
) {
    private val _productData = MutableLiveData<List<Products>>()

    val products: LiveData<List<Products>>
        get() = _productData


    suspend fun fetchProducts() {
        val response = apiInterface.getProducts()
        if (response.isSuccessful && response.body() != null) {
            productDB.productDao().insertProduct(response.body()!!)
            _productData.postValue(response.body())
        }
    }
}
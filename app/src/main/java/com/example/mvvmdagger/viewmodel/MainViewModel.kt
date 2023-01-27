package com.example.mvvmdagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdagger.Repository.ProductRepository
import com.example.mvvmdagger.model.Products
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    val productList: LiveData<List<Products>>
        get() = productRepository.products

    init {
        viewModelScope.launch {
            productRepository.fetchProducts()
        }
    }

}
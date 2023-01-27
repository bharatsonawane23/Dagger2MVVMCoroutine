package com.example.mvvmdagger.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmdagger.model.Products

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(products: List<Products>)

    @Query("SELECT * FROM Products")
    suspend fun getAllProducts(): List<Products>
}
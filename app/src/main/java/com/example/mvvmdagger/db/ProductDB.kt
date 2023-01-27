package com.example.mvvmdagger.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmdagger.model.Products

@Database(entities = [Products::class], version = 1)
abstract class ProductDB : RoomDatabase() {
    abstract fun productDao(): ProductDAO
}
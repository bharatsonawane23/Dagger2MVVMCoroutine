package com.example.mvvmdagger.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products(

    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var title: String,
    var price: Double,
    var description: String,
    var category: String,
    var image: String,
)

package com.example.mvvmdagger.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmdagger.db.ProductDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideProductDatabase(context: Context): ProductDB {
        return Room.databaseBuilder(context, ProductDB::class.java, "ProductDB").build()
    }
}
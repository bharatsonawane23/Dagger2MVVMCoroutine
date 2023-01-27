package com.example.mvvmdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdagger.viewmodel.MainViewModel
import com.example.mvvmdagger.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productTextView = findViewById<TextView>(R.id.products)
        (application as MyApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.productList.observe(this) {
            productTextView.text = it.joinToString { x -> x.title + "\n\n" }
        }
    }
}
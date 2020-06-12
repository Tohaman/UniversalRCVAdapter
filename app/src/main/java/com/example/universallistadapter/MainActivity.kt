package com.example.universallistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.universallistadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
            lifecycleOwner = this@MainActivity
            viewModel = myViewModel
        }
    }
}
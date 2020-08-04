package com.example.mvvm2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root,MainFrgmt()).commit()
    }
}
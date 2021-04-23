package com.sohyun.coroutinesampleapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commitNow()
    }
}
package com.devcomentry.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.devcomentry.noteapp.ui.theme.CleanArchitectureTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContent {
            CleanArchitectureTheme {
                // setup compose
            }
        }
    }
}
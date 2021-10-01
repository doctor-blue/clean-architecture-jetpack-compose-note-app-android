package com.devcomentry.noteapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.devcomentry.noteapp.presentation.navigation.Navigation
import com.devcomentry.noteapp.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContent {
            CleanArchitectureTheme {
                // setup compose
                Surface(
                    color = MaterialTheme.colors.background,
                    content = { Navigation() }
                )
            }
        }
    }
}
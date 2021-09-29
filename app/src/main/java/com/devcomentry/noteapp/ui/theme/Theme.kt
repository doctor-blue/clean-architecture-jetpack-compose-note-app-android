package com.devcomentry.noteapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CleanArchitectureTheme( content: @Composable() () -> Unit) {
    MaterialTheme(
        typography = Typography,
        content = content
    )
}
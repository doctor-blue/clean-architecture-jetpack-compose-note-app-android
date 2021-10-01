package com.devcomentry.noteapp.presentation.navigation

import com.devcomentry.lib.ComposeScreen

sealed class Screen(_route: String) : ComposeScreen(_route) {
    object NotesScreen : Screen("notes_screen")
    object AddNote : Screen("add_note")
    object UpdateNote : Screen("update_note")
}


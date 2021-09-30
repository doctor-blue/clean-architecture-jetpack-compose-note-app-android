package com.devcomentry.noteapp.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen : Screen("notes_screen")
    object AddNote : Screen("add_note")
    object UpdateNote : Screen("update_note")

}

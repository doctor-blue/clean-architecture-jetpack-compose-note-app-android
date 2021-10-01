package com.devcomentry.noteapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devcomentry.lib.composable
import com.devcomentry.noteapp.presentation.add_note.AddNoteScreen
import com.devcomentry.noteapp.presentation.notes.NotesScreen
import com.devcomentry.noteapp.presentation.update_note.UpdateNoteScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.NotesScreen.route
    ) {

        composable(
            screen = Screen.NotesScreen
        ) {
            NotesScreen(navController = navController)
        }

        composable(
            screen = Screen.AddNote
        ) {
            AddNoteScreen(navController = navController)
        }

        // update screen with argument
        composable(
            screen = Screen.UpdateNote,
            arguments = UpdateScreenArgument()
        ) {
            UpdateNoteScreen(
                navController = navController
            )
        }
    }
}
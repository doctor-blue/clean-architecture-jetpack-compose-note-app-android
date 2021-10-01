package com.devcomentry.noteapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable(Screen.NotesScreen.route) {
            NotesScreen(navController = navController)
        }
        composable(Screen.AddNote.route) {
            AddNoteScreen(navController = navController)
        }
        val screenParam = UpdateScreenParam()
        val route = Screen.UpdateNote.getRoute(screenParam)
        val list = Screen.UpdateNote.getNavArgs(screenParam)
        composable(
            route,
            arguments = list
        ) {
            UpdateNoteScreen(
                navController = navController
            )
        }
    }
}
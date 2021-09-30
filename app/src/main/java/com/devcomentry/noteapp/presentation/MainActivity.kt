package com.devcomentry.noteapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devcomentry.noteapp.presentation.add_note.AddNoteScreen
import com.devcomentry.noteapp.presentation.notes.NotesScreen
import com.devcomentry.noteapp.presentation.update_note.UpdateNoteScreen
import com.devcomentry.noteapp.presentation.util.Screen
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
                    color = MaterialTheme.colors.background
                ) {
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
                        composable(
                            Screen.UpdateNote.route
                                    + "?noteId={noteId}",
                            arguments = listOf(
                                navArgument("noteId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            UpdateNoteScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
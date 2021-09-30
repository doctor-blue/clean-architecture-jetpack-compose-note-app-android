package com.devcomentry.noteapp.presentation.add_note

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devcomentry.noteapp.presentation.util.AddEditNoteEvent

@Composable
fun AddNoteScreen(
    navController: NavController,
    viewModel: AddNoteViewModel = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (titleState.isBlank()){
                       Toast.makeText(context,"Title is empty",Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    if (contentState.isBlank()){
                        Toast.makeText(context,"Content is empty",Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                    navController.navigateUp()
                },
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "Save note"
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            OutlinedTextField(
                value = titleState,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.h5,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Title") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = contentState,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                },
                singleLine = false,
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxSize().padding(bottom = 60.dp),
                label = { Text("Content") }

            )

        }
    }
}
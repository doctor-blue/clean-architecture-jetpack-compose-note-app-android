package com.devcomentry.noteapp.presentation.notes

import com.devcomentry.noteapp.domain.model.Note

sealed class NotesEvent {
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
}
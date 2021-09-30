package com.devcomentry.noteapp.presentation.notes

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
}
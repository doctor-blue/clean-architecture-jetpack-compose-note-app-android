package com.devcomentry.noteapp.presentation.notes

import com.devcomentry.noteapp.domain.model.Note

data class NoteState(
    val notes: List<Note> = emptyList(),
)

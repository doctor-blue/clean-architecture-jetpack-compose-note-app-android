package com.devcomentry.noteapp.presentation.notes

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.util.NoteOrder
import com.devcomentry.noteapp.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
)

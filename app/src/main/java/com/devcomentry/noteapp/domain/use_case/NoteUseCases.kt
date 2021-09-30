package com.devcomentry.noteapp.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val updateNote: UpdateNote,
    val getNote: GetNote
)
package com.devcomentry.noteapp.domain.use_case

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}
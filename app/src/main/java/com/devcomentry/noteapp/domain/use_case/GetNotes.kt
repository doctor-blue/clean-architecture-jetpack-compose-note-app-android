package com.devcomentry.noteapp.domain.use_case

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}
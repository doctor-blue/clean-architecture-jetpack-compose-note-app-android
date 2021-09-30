package com.devcomentry.noteapp.domain.use_case

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}
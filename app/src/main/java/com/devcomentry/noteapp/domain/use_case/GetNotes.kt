package com.devcomentry.noteapp.domain.use_case

import com.devcomentry.noteapp.domain.model.Note
import com.devcomentry.noteapp.domain.repository.NoteRepository
import com.devcomentry.noteapp.domain.util.NoteOrder
import com.devcomentry.noteapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return noteRepository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> {
                            notes.sortedBy { it.timestamp }
                        }
                        is NoteOrder.Title -> {
                            notes.sortedBy { it.title.lowercase() }
                        }
                    }
                }
                OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> {
                            notes.sortedByDescending { it.timestamp }
                        }
                        is NoteOrder.Title -> {
                            notes.sortedByDescending { it.title.lowercase() }
                        }
                    }
                }
            }
        }
    }
}
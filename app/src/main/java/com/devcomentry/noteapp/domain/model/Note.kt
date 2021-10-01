package com.devcomentry.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
package com.devcomentry.noteapp.domain.util

sealed class NoteOrder(val orderType: OrderType) {
   data class Title(val titleOrderType: OrderType) : NoteOrder(titleOrderType)
   data class Date(val dateOrderType: OrderType) : NoteOrder(dateOrderType)
}
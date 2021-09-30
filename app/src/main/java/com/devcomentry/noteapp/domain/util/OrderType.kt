package com.devcomentry.noteapp.domain.util

sealed class OrderType{
    object Ascending : OrderType()
    object Descending: OrderType()
}
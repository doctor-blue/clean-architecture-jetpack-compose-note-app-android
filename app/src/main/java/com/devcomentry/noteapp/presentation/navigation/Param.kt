package com.devcomentry.noteapp.presentation.navigation

interface Param

data class UpdateScreenParam(val noteId: Int? = -1) : Param

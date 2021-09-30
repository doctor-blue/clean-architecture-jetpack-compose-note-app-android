package com.devcomentry.noteapp.di

import android.app.Application
import androidx.room.Room
import com.devcomentry.noteapp.data.data_source.NoteDatabase
import com.devcomentry.noteapp.data.repository.NoteRepositoryImpl
import com.devcomentry.noteapp.domain.repository.NoteRepository
import com.devcomentry.noteapp.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) = Room.databaseBuilder(
        application,
        NoteDatabase::class.java,
        NoteDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(noteDatabase.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases =
        NoteUseCases(
            getNotes = GetNotes(noteRepository),
            getNote = GetNote(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            updateNote = UpdateNote(noteRepository),
            addNote = AddNote(noteRepository)
        )
}
package org.om1chcode.mytrustednotebook.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.om1chcode.mytrustednotebook.db.NoteDatabase
import org.om1chcode.mytrustednotebook.db.NoteRepository
import org.om1chcode.mytrustednotebook.usecases.*
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class )
object AppModule
{
	// -----------------------------------------------------------------------------------------------------------------
	@Provides
	@Singleton
	fun provideNoteDatabase( app : Application) : NoteDatabase
	{
		return Room.databaseBuilder(
			app,
			NoteDatabase::class.java,
			NoteDatabase.DATABASE_NAME ).build()
	}

	// -----------------------------------------------------------------------------------------------------------------
	@Provides
	@Singleton
	fun provideNoteRepository( db : NoteDatabase ) : NoteRepository
	{
		return NoteRepository( db.noteDAO )
	}

	// -----------------------------------------------------------------------------------------------------------------
	@Provides
	@Singleton
	fun provideNoteUseCases( repository : NoteRepository ) : NoteUseCases
	{
		return NoteUseCases(
			getNotes =  GetNotesUseCase( repository ),
			deleteNote = DeleteNoteUseCase( repository ),
			addNote = AddNoteUseCase( repository ),
			getNote = GetNoteUseCase( repository )
		)
	}
}
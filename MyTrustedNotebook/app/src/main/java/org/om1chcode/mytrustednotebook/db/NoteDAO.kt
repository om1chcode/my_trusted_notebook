package org.om1chcode.mytrustednotebook.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO
{
	@Query("SELECT * FROM note")
	fun getNotes() : Flow<List<Note>>

	@Query("SELECT * FROM note WHERE id = :id")
	suspend fun getNoteById(id : Int) : Note?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertNote(note : Note)

	@Delete
	suspend fun deleteNote(note : Note)
}

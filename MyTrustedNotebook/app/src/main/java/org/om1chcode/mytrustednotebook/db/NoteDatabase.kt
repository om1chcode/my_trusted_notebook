package org.om1chcode.mytrustednotebook.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [Note::class],
	version = 3
)
abstract class NoteDatabase : RoomDatabase()
{
	abstract val noteDAO : NoteDAO

	companion object
	{
		const val DATABASE_NAME = "notes_db"
	}
}

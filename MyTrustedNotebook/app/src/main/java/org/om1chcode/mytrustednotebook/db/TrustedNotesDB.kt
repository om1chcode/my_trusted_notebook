package org.om1chcode.mytrustednotebook.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrustedNoteEntity::class], version = 1, exportSchema = false)
abstract class TrustedNotesDB : RoomDatabase()
{
	abstract fun trustedNotesDao(): TrustedNotesDAO
}

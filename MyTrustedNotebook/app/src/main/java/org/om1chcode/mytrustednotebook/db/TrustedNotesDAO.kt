package org.om1chcode.mytrustednotebook.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrustedNotesDAO {

	@Query("select * from trusted_note")
	fun getAllTrustedNotes() : List<TrustedNoteEntity>

	@Query("select * from trusted_note where id like :id")
	fun getTrustedNote(id : Long) : TrustedNoteEntity?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertTrustedNote(trustedNoteEntity : TrustedNoteEntity) : Long

	@Query("delete from trusted_note where id like :id")
	fun deleteTrustedNote(id : Long)
}

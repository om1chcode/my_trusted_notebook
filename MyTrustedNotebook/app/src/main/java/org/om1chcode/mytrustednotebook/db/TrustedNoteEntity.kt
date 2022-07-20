package org.om1chcode.mytrustednotebook.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trusted_note")
class TrustedNoteEntity
{
	@PrimaryKey( autoGenerate = true )
	var id : Long = 0

	var header : String = ""

	var text : String = ""
}
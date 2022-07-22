package org.om1chcode.mytrustednotebook.db

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
	val title : String,
	val content : String,
	val timestamp : Long,
	val color : Int,
	@PrimaryKey val id : Int? = null
)
{
	companion object {
		val noteColors = listOf( Color.Blue, Color.Cyan, Color.Gray, Color.Yellow )
	}
}

class InvalidNoteException( message : String ) : Exception( message )
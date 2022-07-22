package org.om1chcode.mytrustednotebook

import org.om1chcode.mytrustednotebook.db.Note

data class NotesState(
	val notes : List<Note> = emptyList(),
	val noteOrder : NoteOrder = NoteOrder.Date( OrderType.Descending ),
	val isOrderSelectionVisible : Boolean = false
)
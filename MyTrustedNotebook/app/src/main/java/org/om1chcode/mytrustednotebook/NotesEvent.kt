package org.om1chcode.mytrustednotebook

import org.om1chcode.mytrustednotebook.db.Note

sealed class NotesEvent
{
	data class Order( val noteOrder : NoteOrder ) : NotesEvent()
	data class DeleteNote( val note : Note ) : NotesEvent()
	object RestoreNote: NotesEvent()
	object ToggleOrderSelection : NotesEvent()
}

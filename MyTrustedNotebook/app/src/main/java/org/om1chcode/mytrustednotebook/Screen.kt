package org.om1chcode.mytrustednotebook

sealed class Screen( val route : String )
{
	object NotesScreen: Screen( "notes_screen" )
	object AddEditNoteScreen: Screen( "add_edit_note_screen" )
}

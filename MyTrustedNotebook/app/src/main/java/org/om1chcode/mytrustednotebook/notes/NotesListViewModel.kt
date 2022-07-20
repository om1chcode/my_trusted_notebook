package org.om1chcode.mytrustednotebook.notes

import androidx.lifecycle.ViewModel
import org.om1chcode.mytrustednotebook.TrustedNote

class NotesListViewModel : ViewModel() {

	var nodes = arrayListOf(
		TrustedNote( "FirstNote", "NoteText" ),
		TrustedNote( "SecondNote", "NoteText" ),
	)

	// -----------------------------------------------------------------------------------------------------------------
	fun getNotes() : List<TrustedNote> {

		return nodes
	}

	// -----------------------------------------------------------------------------------------------------------------
	fun addNote()
	{
		nodes.add( TrustedNote( "", "" ) )
	}
}
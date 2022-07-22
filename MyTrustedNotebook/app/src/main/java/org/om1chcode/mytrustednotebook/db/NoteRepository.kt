package org.om1chcode.mytrustednotebook.db

import kotlinx.coroutines.flow.Flow

class NoteRepository( private val dao : NoteDAO )
{
	// -----------------------------------------------------------------------------------------------------------------
	fun getNotes() : Flow<List<Note>>
	{
		return dao.getNotes()
	}

	// -----------------------------------------------------------------------------------------------------------------
	suspend fun getNoteById( id : Int ) : Note?
	{
		return dao.getNoteById( id )
	}

	// -----------------------------------------------------------------------------------------------------------------
	suspend fun insertNote( note : Note )
	{
		return dao.insertNote( note )
	}

	// -----------------------------------------------------------------------------------------------------------------
	suspend fun deleteNote( note : Note )
	{
		return dao.deleteNote( note )
	}
}
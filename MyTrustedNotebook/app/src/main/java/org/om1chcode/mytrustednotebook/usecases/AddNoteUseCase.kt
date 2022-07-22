package org.om1chcode.mytrustednotebook.usecases

import org.om1chcode.mytrustednotebook.db.InvalidNoteException
import org.om1chcode.mytrustednotebook.db.Note
import org.om1chcode.mytrustednotebook.db.NoteRepository

class AddNoteUseCase(
	private val repository : NoteRepository
)
{
	// -----------------------------------------------------------------------------------------------------------------
	@Throws( InvalidNoteException::class )
	suspend operator fun invoke( note : Note )
	{
		if( note.title.isBlank() )
		{
			throw InvalidNoteException( "Title can't be empty")
		}

		if( note.content.isBlank() )
		{
			throw InvalidNoteException( "Content can't be empty")
		}

		repository.insertNote( note )
	}
}
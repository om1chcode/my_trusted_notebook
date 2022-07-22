package org.om1chcode.mytrustednotebook.usecases

import org.om1chcode.mytrustednotebook.db.Note
import org.om1chcode.mytrustednotebook.db.NoteRepository

class GetNoteUseCase(
	private val repository : NoteRepository
)
{
	// -----------------------------------------------------------------------------------------------------------------
	suspend operator fun invoke( id: Int ): Note?
	{
		return repository.getNoteById( id )
	}
}
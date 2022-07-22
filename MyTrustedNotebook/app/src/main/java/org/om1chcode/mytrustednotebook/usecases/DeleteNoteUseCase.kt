package org.om1chcode.mytrustednotebook.usecases

import org.om1chcode.mytrustednotebook.db.Note
import org.om1chcode.mytrustednotebook.db.NoteRepository

class DeleteNoteUseCase(
	private val repository : NoteRepository
)
{
	// -----------------------------------------------------------------------------------------------------------------
	suspend operator fun invoke( note : Note )
	{
		repository.deleteNote( note )
	}
}
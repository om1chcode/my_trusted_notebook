package org.om1chcode.mytrustednotebook.usecases

data class NoteUseCases(
	val getNotes : GetNotesUseCase,
	val deleteNote : DeleteNoteUseCase,
	val addNote : AddNoteUseCase,
	val getNote : GetNoteUseCase
)
package org.om1chcode.mytrustednotebook.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.om1chcode.mytrustednotebook.NoteOrder
import org.om1chcode.mytrustednotebook.OrderType
import org.om1chcode.mytrustednotebook.db.Note
import org.om1chcode.mytrustednotebook.db.NoteRepository

class GetNotesUseCase(
	private val repository : NoteRepository
)
{
	// -----------------------------------------------------------------------------------------------------------------
	operator fun invoke(
		noteOrder : NoteOrder = NoteOrder.Date(OrderType.Descending)
	) : Flow<List<Note>>{
		return repository.getNotes().map { notes ->
			when( noteOrder.orderType ) {
				is OrderType.Ascending -> {
					when( noteOrder ) {
						is NoteOrder.Title -> notes.sortedBy{ it.title.lowercase() }
						is NoteOrder.Date -> notes.sortedBy{ it.timestamp }
						is NoteOrder.Color ->  notes.sortedBy{ it.color }
					}
				}
				is OrderType.Descending -> {
					when( noteOrder )
					{
						is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
						is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
						is NoteOrder.Color ->  notes.sortedByDescending { it.color }
					}
				}
			}
		}
	}
}
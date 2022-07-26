package org.om1chcode.mytrustednotebook.views.listnotes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.om1chcode.mytrustednotebook.db.Note
import org.om1chcode.mytrustednotebook.usecases.NoteUseCases
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
	private val noteUseCases : NoteUseCases
) : ViewModel()
{
	private val _state = mutableStateOf(NotesState())
	val state: State<NotesState> = _state

	private var recentlyDeletedNote : Note? = null

	private var getNotesJob : Job? = null

	init
	{
		getNotes(NoteOrder.Date(OrderType.Descending))
	}

	// -----------------------------------------------------------------------------------------------------------------
	fun onEvent( event : NotesEvent)
	{
		when( event )
		{
			is NotesEvent.Order ->
			{
				if( (state.value.noteOrder::class == event.noteOrder::class) &&
					(state.value.noteOrder.orderType == event.noteOrder.orderType) )
				{
					return
				}
				getNotes( event.noteOrder )
			}

			is NotesEvent.DeleteNote ->
			{
				viewModelScope.launch {
					noteUseCases.deleteNote( event.note )
					recentlyDeletedNote = event.note
				}
			}

			is NotesEvent.RestoreNote ->
			{
				viewModelScope.launch {
					noteUseCases.addNote( recentlyDeletedNote ?: return@launch )
					recentlyDeletedNote = null
				}
			}

			is NotesEvent.ToggleOrderSelection ->
			{
				_state.value = state.value.copy(
					isOrderSelectionVisible = !state.value.isOrderSelectionVisible
				)
			}

		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	private fun getNotes( noteOrder : NoteOrder)
	{
		getNotesJob?.cancel()
		getNotesJob = noteUseCases.getNotes( noteOrder )
			.onEach { notes ->
				_state.value = state.value.copy(
					notes = notes,
					noteOrder = noteOrder
				)
			}
		.launchIn( viewModelScope )
	}

}
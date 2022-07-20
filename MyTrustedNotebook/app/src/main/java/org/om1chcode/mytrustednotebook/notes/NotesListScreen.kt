package org.om1chcode.mytrustednotebook.notes

import android.content.res.Configuration
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import org.om1chcode.mytrustednotebook.TrustedNote
import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

import org.om1chcode.mytrustednotebook.R;
import org.om1chcode.mytrustednotebook.note.NoteScreen

// ---------------------------------------------------------------------------------------------------------------------
@Composable
fun TrustedNotesScreen() {

	val vm = remember{ NotesListViewModel() }
	val nodes = vm.getNotes();

	Scaffold(
		floatingActionButton = {
			FloatingActionButton( onClick = { vm.addNote() } )
			{
				Icon( Icons.Filled.Add, contentDescription = "Localized description")
			}
		}
	)
	{
		LazyColumn( modifier = Modifier.padding( vertical =  4.dp) ) {
			items( items = vm.getNotes() ) { item ->
				TrustedNoteView( note = item )
			}
		}
	}

}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
fun TrustedNoteView( note : TrustedNote ) {

	val expanded = remember { mutableStateOf( false ) }

	Surface(
		color = MaterialTheme.colors.primary,
		modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
	) {
		Row(modifier = Modifier.padding(24.dp)) {
			Column(modifier = Modifier
				.weight(1f)
				.padding(bottom = 0.dp)
			){
				Text(text = note.header, style = MaterialTheme.typography.h5.copy( fontWeight = FontWeight.ExtraBold) )
			}
			IconButton(onClick =  { expanded.value = !expanded.value })
			{
				if( expanded.value )
				{
					Icon(
						imageVector = Icons.Filled.ExpandLess,
						contentDescription = stringResource(R.string.show_less) )
				}
				else
				{
					Icon(
						imageVector = Icons.Filled.ExpandMore,
						contentDescription = stringResource(R.string.show_more) )
				}
			}
			if( expanded.value )
			{
				NoteScreen( note = note )
			}
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Preview(
	name ="Trusted Notes Light" )
@Preview(
	name = "Trusted Notes Dark",
	uiMode = Configuration.UI_MODE_NIGHT_YES,
	showBackground = true,
)
@Composable
fun PreviewMessageCard() {
	MyTrustedNotebookTheme {
		TrustedNotesScreen()
	}
}
package org.om1chcode.mytrustednotebook.note

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import org.om1chcode.mytrustednotebook.TrustedNote
import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

@Composable
fun NoteScreen( note : TrustedNote )
{
	var header by remember { mutableStateOf( note.header ) }
	var text by remember { mutableStateOf( note.text ) }

	Column() {
		TextField(
			value = header,
			onValueChange = { header = it },
			label = { Text("Заголовок") }
		)

		TextField(
			value = text,
			onValueChange = { text = it },
			label = { Text("Данные") }
		)

		Button( onClick =
		{
			note.header = header
			note.text = text
		} )
		{
			Text(text = "Save")
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Preview( name ="Note Screen" )
@Composable
fun PreviewMessageCard() {
	MyTrustedNotebookTheme {
		NoteScreen( TrustedNote( "test", "test") )
	}
}
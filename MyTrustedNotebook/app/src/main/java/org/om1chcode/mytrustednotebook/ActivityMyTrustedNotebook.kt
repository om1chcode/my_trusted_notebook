package org.om1chcode.mytrustednotebook

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

// ---------------------------------------------------------------------------------------------------------------------
class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)

		val notes = notesStub()

		setContent {
			MyTrustedNotebookTheme {
				MyTrustedNotebook( notes )
			}
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
fun notesStub() : List<TrustedNote>
{
	val list1 = arrayListOf(
		TrustedNote( "FirstNote", "NoteText" ),
		TrustedNote( "SecondNote", "NoteText" ),
	)

	val list2 = List(1000) { TrustedNote( "$it", "$it" ) }
	list1.addAll( list2 )
	return list1
}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
fun MyTrustedNotebook( notes : List<TrustedNote> )
{
	var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

	if( shouldShowOnboarding ) {
		OnboardingScreen( onContinueClicked = { shouldShowOnboarding = false } )
	}
	else {
		TrustedNotesScreen(notes = notes )
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
private fun TrustedNotesScreen( notes : List<TrustedNote>  ) {
	LazyColumn( modifier = Modifier.padding( vertical =  4.dp) ) {
		items( items = notes ) { item ->
			TrustedNoteView( note = item )
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
private fun TrustedNoteView( note : TrustedNote ) {
	val expanded = remember{ mutableStateOf( false ) }
	val extraPadding by animateDpAsState(
		if( expanded.value ) 48.dp else 0.dp,
		animationSpec = spring(
			dampingRatio = Spring.DampingRatioMediumBouncy,
			stiffness = Spring.StiffnessLow
		)
	)

	Surface(
		color = MaterialTheme.colors.primary,
		modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
	) {
		Row(modifier = Modifier.padding(24.dp)) {
			Column(modifier = Modifier
				.weight(1f)
				.padding(bottom = extraPadding.coerceAtLeast(0.dp))
			){
				Text(text = note.header, style = MaterialTheme.typography.h5.copy( fontWeight = FontWeight.ExtraBold) )
				if( expanded.value )
				{
					Text( text = note.text )
				}
			}
			IconButton(onClick =  { expanded.value = !expanded.value }) {
				Icon(
					imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
					contentDescription = if (expanded.value) {
						stringResource(R.string.show_less)
					} else {
						stringResource(R.string.show_more)
					}
				)

			}

		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
fun OnboardingScreen( onContinueClicked: () -> Unit ) {

	Surface {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text("Welcome to the Most Trusted* Notebook Ever!")
			Button(
				modifier = Modifier.padding(vertical = 24.dp),
				onClick = onContinueClicked
			) {
				Text("Continue?")
			}
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Preview(
	name = "Onboarding",
	showBackground = true,
	widthDp = 320,
	heightDp = 320 )
@Composable
fun OnboardingPreview() {
	MyTrustedNotebookTheme {
		OnboardingScreen( onContinueClicked = {} )
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
		TrustedNotesScreen( notesStub() )
	}
}
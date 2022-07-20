package org.om1chcode.mytrustednotebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import org.om1chcode.mytrustednotebook.intro.OnboardingScreen
import org.om1chcode.mytrustednotebook.notes.TrustedNotesScreen
import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

// ---------------------------------------------------------------------------------------------------------------------
class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContent {
			MyTrustedNotebookTheme {
				MyTrustedNotebook()
			}
		}
	}
}

// ---------------------------------------------------------------------------------------------------------------------
@Composable
fun MyTrustedNotebook()
{
	var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

	if( shouldShowOnboarding ) {
		OnboardingScreen( onContinueClicked = { shouldShowOnboarding = false } )
	}
	else {
		TrustedNotesScreen()
	}
}

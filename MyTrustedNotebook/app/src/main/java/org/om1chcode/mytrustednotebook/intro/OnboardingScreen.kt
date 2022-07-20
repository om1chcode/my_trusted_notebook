package org.om1chcode.mytrustednotebook.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

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
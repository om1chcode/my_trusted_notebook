package org.om1chcode.mytrustednotebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import org.om1chcode.mytrustednotebook.ui.theme.MyTrustedNotebookTheme

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContent {
			MyTrustedNotebookTheme { // A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					Greeting("some note")
				}
			}
		}
	}
}

@Composable
fun Greeting(name : String)
{
	Text(text = "Here it may be $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
	MyTrustedNotebookTheme {
		Greeting("Android")
	}
}
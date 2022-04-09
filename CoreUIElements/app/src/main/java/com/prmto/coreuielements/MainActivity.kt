package com.prmto.coreuielements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            HoritonzolColoredBar(Color.Yellow)
            HoritonzolColoredBar(Color.Blue)
            HoritonzolColoredBar(Color.Yellow)
            HoritonzolColoredBar(Color.Blue)
            HoritonzolColoredBar(Color.Yellow)
            HoritonzolColoredBar(Color.Blue)
        }
    }
}

@Composable
fun HoritonzolColoredBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(600.dp)
            .width(60.dp)
    ) {}
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
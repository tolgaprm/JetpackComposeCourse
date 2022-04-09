package com.prmto.coreuielements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            HoritonzolColoredBar(Color.Yellow)
//            HoritonzolColoredBar(Color.Blue)
//            HoritonzolColoredBar(Color.Yellow)
//            HoritonzolColoredBar(Color.Blue)
//            HoritonzolColoredBar(Color.Yellow)
//            HoritonzolColoredBar(Color.Blue)
//        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColoredSquare(Color.Cyan)
                ColoredSquare(Color.Magenta)
            }

            ColoredSquare(Color.Yellow)
            ColoredSquare(Color.Blue)
            ColoredSquare(Color.Cyan)
            ColoredSquare(Color.Magenta)
        }
    }
}

@Composable
fun ColoredSquare(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
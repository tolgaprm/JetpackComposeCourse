package com.prmto.basicsofjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prmto.basicsofjetpackcompose.ui.theme.BasicsOfJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsOfJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingText(name = "World")
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String) {
    Text(
        text = " Hello $name!",
        modifier = Modifier
            .height(240.dp)
            .width(200.dp)
            .clickable { }
            .padding(start = 24.dp, top = 24.dp)
            //.padding(24.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicsOfJetpackComposeTheme {
        GreetingText(name = "World")
    }
}
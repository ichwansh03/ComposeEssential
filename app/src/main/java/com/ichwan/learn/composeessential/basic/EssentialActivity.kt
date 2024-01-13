package com.ichwan.learn.composeessential.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class EssentialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingWorld()
        }
    }
}

@Composable
fun GreetingWorld(modifier: Modifier = Modifier){
    Greeting(name = "Ichwan", modifier = modifier)
}

@Composable
fun Greeting(name: String, modifier: Modifier) {
    Text(text = "Hello $name", modifier.padding(12.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting(){
    GreetingWorld()
}
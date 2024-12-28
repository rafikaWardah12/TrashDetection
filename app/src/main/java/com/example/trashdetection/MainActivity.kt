package com.example.trashdetection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.trashdetection.ui.theme.TrashDetectionTheme

//class MainActivity : AppCompatActivity() {
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrashDetectionTheme {
                TrashApp()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrashDetectionTheme {
    }
}
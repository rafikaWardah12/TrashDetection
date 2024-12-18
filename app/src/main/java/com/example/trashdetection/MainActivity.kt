package com.example.trashdetection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.trashdetection.ui.theme.TrashDetectionTheme

//import org.tensorflow.lite.support.image.TensorImage
//import org.tensorflow.lite.task.vision.detector.ObjectDetector
//import org.tensorflow.lite.task.vision.detector.ObjectDetector.ObjectDetectorOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrashDetectionTheme {
                TrashApp()
            }
//            TrashDetectionTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
        }
    }
}


//private fun runObjectDetection(bitmap: Bitmap){
//    //Membuat TFLite tensor objek
//    val image = TensorImage.fromBitmap(bitmap)
//    val option = ObjectDetector.ObjectDetectorOptions.builder()
//        .setMaxResults(5)
//        .setScoreThreshold(0.5f)
//        .build()
//    val detector = ObjectDetector.createFromFileAndOptions(
//        this,
//        "best_float32.tflite",
//        option
//    )
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrashDetectionTheme {
    }
}
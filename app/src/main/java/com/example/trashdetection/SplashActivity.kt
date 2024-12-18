package com.example.trashdetection

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.karier.presentation.SplashScreen.SplashScreen2
import com.example.trashdetection.ui.theme.TrashDetectionTheme


@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrashDetectionTheme {
                SplashScreen2(onTimeout = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                })
            }
        }
    }
}
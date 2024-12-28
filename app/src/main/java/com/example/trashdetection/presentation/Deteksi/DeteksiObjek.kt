package com.example.trashdetection.presentation.Deteksi

import android.util.Log
import android.view.LayoutInflater
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.trashdetection.databinding.ActivityMainBinding

@Composable
fun DeteksiObjek(modifier: Modifier = Modifier, navigateToDashboard: () -> Unit) {
    AndroidView(
        factory = { context ->
            val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

            binding.btnGoToDashboard.setOnClickListener {
                Log.d("Deteksi Obejk", "Clicked")
                navigateToDashboard()
            }
            binding.root
        },
        modifier = Modifier.fillMaxSize()
    )
}

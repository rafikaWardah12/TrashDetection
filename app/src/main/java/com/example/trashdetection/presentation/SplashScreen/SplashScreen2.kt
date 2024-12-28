package com.example.karier.presentation.SplashScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trashdetection.R
import com.example.trashdetection.ui.theme.PrimaryBlue200
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SplashScreen2(onTimeout: () -> Unit) {
    val alpha = remember { Animatable(0f) }
    val blurEffect = remember { Animatable(0f) }
    val translation = remember { Animatable(10f) }

    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f, animationSpec = tween(500))
        blurEffect.animateTo(1f, animationSpec = tween(1000))
        delay(1000) // Delay for 2 seconds
        onTimeout()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlue200)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.graphicsLayer(
                alpha = alpha.value,
                translationY = translation.value
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_no_bg), // Ganti dengan nama file yang di-upload
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Trash.id",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview2() {
    SplashScreen2(onTimeout = {})
}
package com.example.karier.presentation.SplashScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.ui.theme.PrimaryBlue200
import kotlinx.coroutines.delay

@Composable
fun SplashScreen1() {
    val alpha = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(1500)
        )
        delay(3000) // Delay for 3 seconds
        // Navigate to another screen if needed
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlue200)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_opening), // Ganti dengan nama file yang di-upload
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .alpha(alpha.value)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen1()
}
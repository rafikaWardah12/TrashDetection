package com.example.trashdetection.presentation.OnBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.ui.theme.PrimaryBlue200
import com.example.trashdetection.ui.theme.PrimaryBlue400
import com.example.trashdetection.ui.theme.TextSecondary
import com.example.trashdetection.ui.theme.TrashDetectionTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingItem(
    modifier: Modifier = Modifier,
    resource: Int,
    text: String,
    textSecondary: String,
    pagerState: PagerState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlue200)
    ) {
        Image(
            painter = painterResource(id = resource),
            contentDescription = "OnBoarding Screen",
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun CustomIndicator(isSelected: Boolean) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(
                color = if (isSelected) PrimaryBlue400 else TextSecondary, shape = CircleShape
            )
            .size(8.dp)
    )
}

@Composable
private fun Test() {
    TrashDetectionTheme {
        OnBoardingScreen(navigateToDetail = {})
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun OnBoardingScreenPreview() {
    TrashDetectionTheme {
        val text = "Mencari Pekerjaan Mudah dan Lebih Efektif"
        val textSecondary = "Meningkatkan pengalaman dengan berbagai lowongan pekerjaan"
        val resource = R.drawable.ic_ilustrasi_3
        val pagerState = rememberPagerState(0, 0F) { 3 }

        OnBoardingItem(
            text = text,
            textSecondary = textSecondary,
            resource = resource,
            pagerState = pagerState
        )
    }
}
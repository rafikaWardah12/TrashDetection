package com.example.trashdetection.presentation.OnBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.presentation.Component.TrashButton
import com.example.trashdetection.ui.theme.PrimaryBlue200
import com.example.trashdetection.ui.theme.TextPrimary
import com.example.trashdetection.ui.theme.TextSecondary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, navigateToDetail: () -> Unit) {
    val pagerState = rememberPagerState(0, 0F) { 3 }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(PrimaryBlue200)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> OnBoardingItem(
                        pagerState = pagerState,
                        resource = R.drawable.ic_ilustrasi_1,
                        text = "Welcome to our app",
                        textSecondary = "Get started by exploring the features."
                    )

                    1 -> OnBoardingItem(
                        pagerState = pagerState,
                        resource = R.drawable.ic_ilustrasi_2,
                        text = "Track your progress",
                        textSecondary = "Monitor your activities and stay motivated."
                    )

                    2 -> OnBoardingItem(
                        pagerState = pagerState,
                        resource = R.drawable.ic_ilustrasi_3,
                        text = "Achieve your goals",
                        textSecondary = "Set goals and achieve them with our help."
                    )
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = when (pagerState.currentPage) {
                            0 -> "Welcome to our app"
                            1 -> "Track your progress"
                            2 -> "Achieve your goals"
                            else -> ""
                        },
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimary
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = when (pagerState.currentPage) {
                            0 -> "Get started by exploring the features."
                            1 -> "Monitor your activities and stay motivated."
                            2 -> "Set goals and achieve them with our help."
                            else -> ""
                        },
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium,
                            color = TextSecondary
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Row {
                        repeat(3) {
                            CustomIndicator(isSelected = pagerState.currentPage == it)
                        }
                    }
                    if (pagerState.currentPage == 2) {
                        Spacer(modifier = Modifier.height(25.dp))
                        TrashButton(
                            text = {
                                Text(
                                    text = "Lanjutkan",
                                    style = MaterialTheme.typography.labelLarge.copy(fontStyle = FontStyle.Normal)
                                )
                            },
                            onClick = { navigateToDetail() },
                            varOutline = "",
                            isWide = true
                        )
                    }
                }
            }
        }
    }
}
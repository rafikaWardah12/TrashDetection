package com.example.trashdetection.domain

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.trashdetection.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val screen: Screen = Screen.Dashboard
)

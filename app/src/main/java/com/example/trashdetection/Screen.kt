package com.example.trashdetection

sealed class Screen(val route: String){
    data object OnBoardingScreen: Screen ("onBoarding")
    data object Dashboard: Screen("dashboard")

    data object Detection: Screen("detection")

}
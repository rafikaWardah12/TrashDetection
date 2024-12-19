package com.example.trashdetection

sealed class Screen(val route: String) {
    data object OnBoardingScreen : Screen("onBoarding")
    data object Dashboard : Screen("dashboard")

    data object Detection : Screen("dashboard/detection")

    data object ListArtikel : Screen("dashboard/article")
    object DetailArtikel : Screen("dashboard/article/{articleId}/{articleTitle}") {
        fun createRoute(articleId: String, articleTitle: String) =
            "dashboard/article/$articleId/$articleTitle"
    }
}
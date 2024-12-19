package com.example.trashdetection

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thrivein.ui.screen.article.detail.DetailArticleScreen
import com.example.thrivein.ui.screen.article.list.ListArticleScreen
import com.example.trashdetection.presentation.Component.BottomBar
import com.example.trashdetection.presentation.Dashboard.DashboardScreen
import com.example.trashdetection.presentation.OnBoarding.OnBoardingScreen

@Composable
fun TrashApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (
                currentRoute == Screen.Dashboard.route ||
                currentRoute == Screen.Detection.route
            ) {
                BottomBar(navHostController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.OnBoardingScreen.route) {
                OnBoardingScreen(
                    navigateToDetail = {
                        navController.navigate(Screen.Dashboard.route) {
                            popUpTo(Screen.OnBoardingScreen.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(route = Screen.Dashboard.route) {
                DashboardScreen(
                    navigateToListArtikel = { navController.navigate(Screen.ListArtikel.route) },
                    navigateToDetailArtikel = { articleId, articleTitle ->
                        navController.navigate(
                            Screen.DetailArtikel.createRoute(
                                articleId,
                                articleTitle
                            )
                        )
                    })
            }

            composable(route = Screen.Detection.route) {
            }

            composable(route = Screen.ListArtikel.route) {
                ListArticleScreen(navigateBack = {
                    navController.navigateUp()
                }, navigateToDetailArticle = { articleId, articleTitle ->
                    navController.navigate(
                        Screen.DetailArtikel.createRoute(
                            articleId,
                            articleTitle
                        )
                    )
                })
            }

            composable(
                route = Screen.DetailArtikel.route,
                arguments = listOf(
                    navArgument("articleId") { type = NavType.StringType },
                    navArgument("articleTitle") { type = NavType.StringType },
                )
            ) {
                val id = it.arguments?.getString("articleId") ?: ""
                val title = it.arguments?.getString("articleTitle") ?: ""

                DetailArticleScreen(id = id, title = title, navigateBack = {
                    navController.navigateUp()
                })
            }
        }
    }
}

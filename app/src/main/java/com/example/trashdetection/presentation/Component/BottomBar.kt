package com.example.trashdetection.presentation.Component

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trashdetection.R
import com.example.trashdetection.Screen
import com.example.trashdetection.domain.NavigationItem
import com.example.trashdetection.ui.theme.PrimaryGreen500
import com.example.trashdetection.ui.theme.SecondaryBackground
import com.example.trashdetection.ui.theme.TextPrimary
import com.example.trashdetection.ui.theme.PrimaryBlue300 as PrimaryBlue3001

@Composable
fun BottomBar(
    navHostController: NavController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier
            .shadow(
                elevation = 25.dp,
                spotColor = Color.White,
                ambientColor = SecondaryBackground,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                clip = true
            )
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        tonalElevation = 40.dp,
        containerColor = PrimaryBlue3001,
        contentColor = PrimaryGreen500,
    ) {

        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf<NavigationItem>(
            NavigationItem(
                title = "Beranda",
                icon = ImageVector.vectorResource(id = R.drawable.icon_beranda),
                screen = Screen.Dashboard,
                iconSelected = ImageVector.vectorResource(id = R.drawable.ic_filled_beranda),
            ),
        )

        navigationItems.map { item ->

            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = if (currentRoute == item.screen.route) {
                            modifier.offset(y = -3.dp)
                        } else {
                            modifier
                        }
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == item.screen.route) {
                            item.iconSelected
                        } else {
                            item.icon
                        },
                        contentDescription = item.title,
                        modifier = if (currentRoute == item.screen.route) {
                            modifier.offset(y = -3.dp)
                        } else {
                            modifier
                        }
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = TextPrimary,
                    selectedTextColor = TextPrimary,
                    indicatorColor = PrimaryBlue3001,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White
                ),
                onClick = {
                    navHostController.navigate(item.screen.route) {
                        if (item.screen.route == Screen.Dashboard.route) {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }

                            restoreState = true
                            launchSingleTop = true
                        } else {
                            popUpTo(Screen.Dashboard.route) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun BottomBarNavigationPreview() {
    BottomBar(navHostController = rememberNavController())
}
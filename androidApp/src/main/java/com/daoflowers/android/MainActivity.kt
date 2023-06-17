@file:OptIn(ExperimentalMaterial3Api::class)

package com.daoflowers.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daoflowers.android.ui.catalog.flower.FlowerTypesScreen
import com.daoflowers.android.ui.common.SingleLineText
import com.daoflowers.android.ui.common.TextStyles.InterTextStyle
import com.daoflowers.android.ui.navigation.model.BottomItemUI
import com.daoflowers.android.ui.navigation.model.toRoute
import com.daoflowers.android.ui.res.stringResource
import com.daoflowers.android.ui.res.toColor
import com.daoflowers.android.ui.theme.AppTheme
import com.daoflowers.android.ui.theme.ColorsProvider.navigationBarColors
import com.daoflowers.navigation.domain.model.BottomNavItem
import com.daoflowers.sharing_resources.SharedRes
import kotlinx.collections.immutable.ImmutableList
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val state by mainViewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                navController = navController,
                items = state.items
            )
        }
    ) { innerPadding ->
        NavigationGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController
        )
    }
}

@Composable
fun BottomBar(
    navController: NavController,
    items: ImmutableList<BottomItemUI>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = SharedRes.colors.NavigationBar_ContainerColor.toColor(),
        contentColor = SharedRes.colors.NavigationBar_ContentColor.toColor(),
        tonalElevation = 0.dp,
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                label = {
                    SingleLineText(
                        text = stringResource(id = item.title),
                        style = InterTextStyle.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp
                        )
                    )
                },
                selected = currentRoute == item.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SharedRes.colors.NavigationBar_SelectedIconColor.toColor(),
                    selectedTextColor = SharedRes.colors.NavigationBar_SelectedTextColor.toColor(),
                    indicatorColor = SharedRes.colors.NavigationBar_IndicatorColor.toColor(),
                    unselectedIconColor = SharedRes.colors.NavigationBar_UnselectedIconColor.toColor(),
                    unselectedTextColor = SharedRes.colors.NavigationBar_UnselectedTextColor.toColor(),
                ),
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavItem.Main.toRoute()
    ) {
        composable(BottomNavItem.Main.toRoute()) {
            FlowerTypesScreen()
        }

        composable(BottomNavItem.Menu.toRoute()) {
            Text(text = "Menu")
        }

        composable(BottomNavItem.Contacts.toRoute()) {
            Text(text = "Contacts")
        }
    }
}
package com.coderscastle.jetpack_bottomnavigationbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.coderscastle.jetpack_bottomnavigationbar.pages.HomeScreen
import com.coderscastle.jetpack_bottomnavigationbar.pages.NotificationScreen
import com.coderscastle.jetpack_bottomnavigationbar.pages.ProfileScreen

@Composable
fun MainScreen (){

    val navItemList =listOf(
        NavItem ("Home", Icons.Default.Home),
        NavItem ("Notification", Icons.Default.Notifications),
        NavItem ("Profile", Icons.Default.Person)
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index,navItem->

                    NavigationBarItem(
                        selected = selectedItem==index,
                        onClick = {selectedItem = index},
                        icon = {
                                Icon(imageVector = navItem.icon, contentDescription = navItem.level)
                        },
                        label = {
                            Text(text = navItem.level)
                        }
                    )
                }

            }
        }
    )
    {
        innerPadding ->
      ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex = selectedItem)

    }
}

@Composable
fun ContentScreen (modifier: Modifier = Modifier,selectedIndex: Int){

    when (selectedIndex){
        0 -> HomeScreen()
        1 -> NotificationScreen()
        2 -> ProfileScreen()
    }

}
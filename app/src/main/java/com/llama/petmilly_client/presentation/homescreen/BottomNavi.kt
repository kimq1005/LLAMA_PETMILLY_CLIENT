package com.llama.petmilly_client.presentation.homescreen

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.llama.petmilly_client.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("펫밀리", R.drawable.baseline_home_24,"home")
    object Chatting: BottomNavItem("채팅",R.drawable.baseline_chat_24,"my_network")
    object Heart: BottomNavItem("관심",R.drawable.baseline_heart_broken_24,"add_post")
    object Person: BottomNavItem("MY",R.drawable.baseline_person_24,"notification")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(navController)
            Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()

            Log.d(TAG, "NavigationGraph: Home")

        }
        composable(BottomNavItem.Chatting.screen_route) {
            NetworkScreen()
            Toast.makeText(context, "MyNetwork", Toast.LENGTH_SHORT).show()


        }
        composable(BottomNavItem.Heart.screen_route) {
            AddPostScreen()
            Toast.makeText(context, "AddPost", Toast.LENGTH_SHORT).show()

            Log.d(TAG, "NavigationGraph: AddPost")

        }
        composable(BottomNavItem.Person.screen_route) {
            NotificationScreen()
            Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()

            Log.d(TAG, "NavigationGraph: Notification")

        }

    }

}

@Composable
fun NetworkScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "My Network Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}


@Composable
fun AddPostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Add Post Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Notification Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun BottomNavigation(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Chatting,
        BottomNavItem.Heart,
        BottomNavItem.Person
    )

    androidx.compose.material.BottomNavigation(
        contentColor =  Color.Black
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
package the.end2024.carrotclone.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import the.end2024.carrotclone.presentation.ui.loginPage
import the.end2024.carrotclone.presentation.ui.mainPage
import the.end2024.carrotclone.presentation.ui.screen
import the.end2024.carrotclone.presentation.ui.searchLocation
import the.end2024.carrotclone.presentation.ui.signUpPage

object NavigationManager {
    lateinit var navController: NavController

    @Composable
    fun addNavigation(){
        val navController = rememberNavController()
        NavigationManager.navController = navController
        NavHost(
            navController = navController,
            startDestination = "start"
        ) {
            composable("start") {
                screen()
            }
            composable("firstUser") {
                searchLocation()
            }
            composable("login") {
                loginPage()
            }
            composable("signUp") {
                signUpPage()
            }
            composable("main") {
                mainPage()
            }
        }
    }
}
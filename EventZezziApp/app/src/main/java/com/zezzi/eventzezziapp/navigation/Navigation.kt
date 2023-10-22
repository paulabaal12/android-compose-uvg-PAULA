import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zezzi.eventzezziapp.navigation.NavigationState



@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mealsCategories") {
        composable("mealsCategories") {
            MealsCategoriesScreen(navController = navController)
        }
        composable(
            "mealDetails/{mealId}",
            arguments = listOf(navArgument("mealId") { type = NavType.StringType })
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            mealId?.let { id ->
                MealDetailsScreen(navController = navController, mealId = id)
            }
        }
    }
}

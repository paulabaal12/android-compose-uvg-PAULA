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
import com.zezzi.eventzezziapp.ui.meals.view.MealDetailsScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = MealsCategoriesViewModel()

    NavHost(
        navController = navController,
        startDestination = NavigationState.Meals.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Meals.route) {
            MealsCategoriesScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = "${NavigationState.MealDetails.route}/{mealId}",
            arguments = listOf(navArgument("mealId") { type = NavType.StringType })
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            mealId?.let { id ->
                MealDetailsScreen(navController = navController, viewModel = viewModel, mealId = id)
            }
        }
    }
}
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
import com.zezzi.eventzezziapp.ui.meals.view.FilteredMealsScreen
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationState.Meals.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Meals.route) {
            MealsCategoriesScreen(navController = navController, viewModel = viewModel())
        }
        composable(
            route = "${NavigationState.FilteredMeals.route}/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                FilteredMealsScreen(navController = navController, category = category, viewModel = viewModel())
            }
        }
    }
}

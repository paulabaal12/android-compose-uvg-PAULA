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
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = MealsCategoriesViewModel() // Inicializa el ViewModel aquí

    NavHost(
        navController = navController,
        startDestination = NavigationState.Meals.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.Meals.route) {
            MealsCategoriesScreen(navController = navController, viewModel = viewModel)
        }
    }
}

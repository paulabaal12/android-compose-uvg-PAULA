import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.navigation.AppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import com.zezzi.eventzezziapp.navigation.NavigationState

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = MealsCategoriesViewModel()
) {
    val rememberedMeals = remember { mutableStateListOf<MealResponse>() }
    val isLoading = remember { mutableStateOf(false) }
    val selectedCategory = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        isLoading.value = true
        val response = viewModel.getMealsByCategory(selectedCategory.value)
        val mealsFromTheApi = response?.meals
        rememberedMeals.addAll(mealsFromTheApi.orEmpty())
        isLoading.value = false
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categorías", navController = navController)
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = it
            ) {
                items(rememberedMeals) { meal ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(Color(0xFFFBFBEC))
                            .clickable {
                                navController.navigate(
                                    "${NavigationState.Meals.route}/${meal.id}"
                                )
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(data = meal.imageUrl),
                                contentDescription = meal.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f)
                            )
                            Text(
                                text = meal.name,
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                ),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                    }
                }
            }

            if (isLoading.value) {
                CircularProgressIndicator()
            }
        }
    }
}

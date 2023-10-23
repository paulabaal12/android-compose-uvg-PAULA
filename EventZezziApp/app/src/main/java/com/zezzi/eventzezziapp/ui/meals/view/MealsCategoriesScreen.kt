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
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import com.zezzi.eventzezziapp.data.networking.response.AreaResponse
import com.zezzi.eventzezziapp.data.networking.response.CategoryResponse
import com.zezzi.eventzezziapp.navigation.NavigationState
import com.zezzi.eventzezziapp.ui.meals.view.CategoryCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = MealsCategoriesViewModel()
) {
    val rememberedCategories = remember { mutableStateListOf<CategoryResponse>() }
    val rememberedMeals = remember { mutableStateListOf<MealResponse>() }
    val isLoading = remember { mutableStateOf(false) }
    val selectedCategory = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        isLoading.value = true
        val categoriesResponse = viewModel.getCategories()
        val categories = categoriesResponse?.categories
        rememberedCategories.addAll(categories.orEmpty())
        isLoading.value = false
    }

    LaunchedEffect(selectedCategory.value) {
        val mealsResponse = viewModel.getMealsByCategory(selectedCategory.value)
        val meals = mealsResponse?.meals
        rememberedMeals.clear()
        rememberedMeals.addAll(meals.orEmpty())
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categorías", navController = navController)
        },
        contentColor = Color(0xFFF9F97D)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading.value) {
                CircularProgressIndicator()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(rememberedCategories) { category ->
                        CategoryCard(
                            category = category,
                            onClick = {
                                selectedCategory.value = category.name
                            }
                        )
                    }
                }
            }
        }
    }
}

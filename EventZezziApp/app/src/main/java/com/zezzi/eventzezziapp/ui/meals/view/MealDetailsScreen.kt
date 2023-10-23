package com.zezzi.eventzezziapp.ui.meals.view

import MealsCategoriesViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.zezzi.eventzezziapp.data.networking.response.MealDetailsResponse
import com.zezzi.eventzezziapp.navigation.AppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDetailsScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = MealsCategoriesViewModel(),
    mealId: String
) {
    val mealDetails = remember { mutableStateOf<MealDetailsResponse?>(null) }

    LaunchedEffect(Unit) {
        mealDetails.value = viewModel.getMealDetails(mealId)
    }

    Scaffold(
        topBar = {
            AppBar(title = "Meal Details", navController = navController)
        }
    ) {
        mealDetails.value?.let { details ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = details.imageUrl),
                    contentDescription = details.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = details.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = details.instructions)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Ingredients:")
                details.ingredients.forEach { ingredient ->
                    Text(text = "- $ingredient")
                }
            }
        }
    }
}

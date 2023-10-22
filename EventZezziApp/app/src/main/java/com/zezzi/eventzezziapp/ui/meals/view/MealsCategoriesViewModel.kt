import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealDetailsResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsByCategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    suspend fun getCategories(): MealsCategoriesResponse? {
        return repository.getCategories()
    }

    suspend fun getMealsByCategory(category: String): MealsByCategoryResponse? {
        return repository.getMealsByCategory(category)
    }

    suspend fun getMealDetails(mealId: String): MealDetailsResponse? {
        return repository.getMealDetails(mealId)
    }
}
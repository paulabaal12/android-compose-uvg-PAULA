import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.Responsesss
import com.zezzi.eventzezziapp.data.repository.MealsRepository
class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    suspend fun getMeals(): MealsCategoriesResponse? {
        return repository.getMeals()
    }

    suspend fun getFilter(category: String): Responsesss? {
        return repository.getFilter(category)
    }
}

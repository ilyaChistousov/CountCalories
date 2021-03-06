package ilya.chistousov.countcalories.domain.repository

import androidx.lifecycle.LiveData
import ilya.chistousov.countcalories.domain.model.Food
import ilya.chistousov.countcalories.domain.model.Meal

interface FoodRepository {

    suspend fun addFood(food: Food)

    fun getFood(foodId: Int) : LiveData<Food>

    fun getAllFoods() : LiveData<List<Food>>

    suspend fun deleteFood(food: Food)

    fun getFoodByMeal(meal: Meal) : LiveData<List<Food>>
}
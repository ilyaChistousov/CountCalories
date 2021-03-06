package ilya.chistousov.countcalories.domain.usecases.food

import ilya.chistousov.countcalories.domain.repository.FoodRepository
import javax.inject.Inject

class GetAllFoodUseCase @Inject constructor(private val repository: FoodRepository) {

    operator fun invoke() = repository.getAllFoods()
}
package ilya.chistousov.countcalories.presentation.diary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ilya.chistousov.countcalories.presentation.util.convertToDate
import ilya.chistousov.countcalories.presentation.util.convertToLocalDate
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DateViewModel : ViewModel() {

    private val calendar = Calendar.getInstance()
    private val _currentDate = MutableLiveData(LocalDate.now())
    val currentDate: LiveData<LocalDate> = _currentDate


    fun selectNextDay() {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        _currentDate.value = calendar.convertToLocalDate()
    }

    fun selectPreviousDay() {
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        _currentDate.value = calendar.convertToLocalDate()
    }

    fun setDate(localDate: LocalDate) {
        val date = localDate.convertToDate()
        calendar.time = date
        _currentDate.value = calendar.convertToLocalDate()
    }
}
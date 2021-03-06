package ilya.chistousov.countcalories.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ilya.chistousov.countcalories.di.modeles.DataModule
import ilya.chistousov.countcalories.di.modeles.DomainModule
import ilya.chistousov.countcalories.presentation.diary.fragment.DiaryFragment
import ilya.chistousov.countcalories.presentation.meal.fragment.MealFragment
import ilya.chistousov.countcalories.presentation.register.fragment.RegisterFragment
import ilya.chistousov.countcalories.presentation.register.screen.*
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(diaryFragment: DiaryFragment)
    fun inject(registerFragment: RegisterFragment)
    fun inject(activityLevelScreen: ActivityLevelScreen)
    fun inject(birthDateScreen: BirthDateScreen)
    fun inject(currentGrowthScreen: CurrentGrowthScreen)
    fun inject(currentWeightScreen: CurrentWeightScreen)
    fun inject(desiredWeightScreen: DesiredWeightScreen)
    fun inject(genderScreen: GenderScreen)
    fun inject(goalScreen: GoalScreen)
    fun inject(mealFragment: MealFragment)

    @Component.Factory
    interface Factory {

        fun context(@BindsInstance context: Context) : AppComponent
    }
}
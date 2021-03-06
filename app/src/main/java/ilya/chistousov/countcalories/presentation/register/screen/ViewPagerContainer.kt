package ilya.chistousov.countcalories.presentation.register.screen

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.google.android.material.tabs.TabLayoutMediator
import ilya.chistousov.countcalories.databinding.FragmentViewpagerContainerBinding
import ilya.chistousov.countcalories.presentation.basefragment.BaseFragment
import ilya.chistousov.countcalories.presentation.register.adapter.ViewPagerAdapter

class ViewPagerContainer : BaseFragment<FragmentViewpagerContainerBinding>(
    FragmentViewpagerContainerBinding::inflate
) {

    private lateinit var adapter: ViewPagerAdapter

    private val screenList = mutableListOf(
        GoalScreen(),
        ActivityLevelScreen(),
        GenderScreen(),
        BirthDateScreen(),
        CurrentGrowthScreen(),
        CurrentWeightScreen(),
        DesiredWeightScreen(),
        EmailScreen()
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViewPager()
        backToPreviousScreen()
    }


    private fun setUpViewPager() {
        adapter = ViewPagerAdapter(screenList, childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabsIndicator, binding.viewPager) { _, _ ->
        }.attach()
    }


    private fun backToPreviousScreen() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.viewPager.currentItem != 0) {
                    binding.viewPager.currentItem = binding.viewPager.currentItem - 1
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        })
    }

}
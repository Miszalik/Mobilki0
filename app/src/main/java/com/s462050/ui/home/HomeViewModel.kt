package com.s462050.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.s462050.data.Child
import com.s462050.ui.BaseViewModel
import com.s462050.ui.NavigationCommand

class HomeViewModel : BaseViewModel() {

    private val _childList = MutableLiveData<List<Child>>()
    val childList : LiveData<List<Child>> = _childList

    init {
        fetchChildList()
    }

    private fun fetchChildList() {
        var newList = listOf(
            Child(name = "Andrzej", dutyPoints = 10, behaviorPoints = 15, drawableName = "icons8_circled_user_male_skin_type_7_50"),
            Child(name = "Monika", dutyPoints = 15, behaviorPoints = 5, drawableName = "icons8_circled_user_female_skin_type_6_50"),
            Child(name = "Marcin", dutyPoints = 33, behaviorPoints = 70, drawableName = "icons8_circled_user_female_skin_type_7_50"),
            Child(name = "Kuba", dutyPoints = 99, behaviorPoints = 69, drawableName = "icons8_circled_user_male_skin_type_6_50")
        )

        _childList.value = newList
    }

    private val _buttonName = MutableLiveData<String>().apply {
        run {
            value = "ADD CHILD"
        }
    }
    val buttonName: LiveData<String> = _buttonName
    fun addNewChild() {
        var direction : NavDirections = HomeFragmentDirections.actionNavigationHomeToDashboardFragment()
        navigateTo(NavigationCommand.To(direction));
    }
}
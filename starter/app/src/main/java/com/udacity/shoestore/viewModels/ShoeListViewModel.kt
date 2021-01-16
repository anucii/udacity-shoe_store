package com.udacity.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var _shoeList : MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf(
            Shoe("Demo One", 41.0, "Demo Makers", ""),
            Shoe("Demo One Jr", 34.0, "Demo Makers", ""),
            Shoe("Demo Two", 37.5, "Demo Makers", "")
        )
    }
}
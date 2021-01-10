package com.udacity.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    init {
    }

    private lateinit var _shoeList : MutableLiveData<MutableList<Shoe>>
    public lateinit var shoelist: LiveData<List<Shoe>>
}
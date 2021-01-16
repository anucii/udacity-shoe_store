package com.udacity.shoestore.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : BaseObservable(){

    private val _newShoe : MutableLiveData<Shoe> by lazy {
        MutableLiveData<Shoe>()
    }

    public val newShoe : LiveData<Shoe>
        get() = _newShoe

    init {
        _newShoe.value = Shoe("",0.0, "", "")
    }

    @Bindable
    fun getShoeName() : String {
        return _newShoe.value!!.name
    }

    fun setShoeName(name: String){
        _newShoe.value!!.name = name
    }

    @Bindable
    fun getShoeCompany() : String {
        return _newShoe.value!!.company
    }

    fun setShoeCompany(company: String) {
        _newShoe.value!!.company = company
    }

    @Bindable
    fun getShoeSize() : String {
        return _newShoe.value!!.size.toString()
    }

    fun setShoeSize(size: String) {
        _newShoe.value!!.size = size.toDoubleOrNull() ?: 0.0
    }
}
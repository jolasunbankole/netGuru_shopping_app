package com.example.netguru_shopping.shareviewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netguru_shopping.model.ShoppingListData

class SharedViewModel : ViewModel() {

    private var _shoppingList = MutableLiveData<ShoppingListData>()
    val shoppingList: LiveData<ShoppingListData> = _shoppingList




}



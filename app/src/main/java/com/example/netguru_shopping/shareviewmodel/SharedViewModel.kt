package com.example.netguru_shopping.shareviewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netguru_shopping.model.ShoppingListData
import com.example.netguru_shopping.model.ShoppingListData2

class SharedViewModel : ViewModel() {

    private var _shoppingList = MutableLiveData<ShoppingListData>()
    val shoppingList: LiveData<ShoppingListData> = _shoppingList

    private var _shoppingDetail = MutableLiveData<ShoppingListData2>()
    val shoppingDetail: LiveData<ShoppingListData2> = _shoppingDetail






}



package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.example.mvvmshoppinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
// viewmodel get data from repository. argument inherits from repository
class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun upsert(item: ShoppingItems) = GlobalScope.launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItems) = GlobalScope.launch {
        repository.delete(item)
    }
    fun getALlShoppingItem() = repository.getAllShoppingItems()
}
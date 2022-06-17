package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmshoppinglist.data.repository.ShoppingRepository

//class ShopingViewModelProviderFactory(private val repository: ShoppingRepository) : ViewModelProvider.Factory{
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return ShoppingViewModel(repository) as T
//    }
//}
@Suppress("UNCHECKED_CAST")
class ShopingViewModelProviderFactory (
    private val repository: ShoppingRepository
    ) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}
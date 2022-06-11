package com.example.mvvmshoppinglist.ui.shoppinglist

import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems

interface AddDialogListener {
    fun onAddButton(item : ShoppingItems)
}
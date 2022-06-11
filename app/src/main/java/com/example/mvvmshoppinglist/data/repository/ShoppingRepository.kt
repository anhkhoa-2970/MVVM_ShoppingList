package com.example.mvvmshoppinglist.data.repository

import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems

class ShoppingRepository(private val db : ShoppingDatabase) {
// for viewmodel call method from repository
    suspend fun upsert(item : ShoppingItems) = db.getShoppingDao().upsert(item)
    suspend fun delete(item : ShoppingItems) = db.getShoppingDao().delete(item)
    fun getAllShoppingItems() =  db.getShoppingDao().getAllShoppingItems()
}
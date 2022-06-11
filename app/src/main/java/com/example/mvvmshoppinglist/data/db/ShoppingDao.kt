package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItems)
    @Delete
    suspend fun delete(item : ShoppingItems)
    @Query("Select * from shopping_item")
    fun getAllShoppingItems() : LiveData<List<ShoppingItems>>
}
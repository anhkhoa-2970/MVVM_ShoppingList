package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.adapters.ShoppingItemAdapter
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.example.mvvmshoppinglist.data.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val database = ShoppingDatabase(context = this)
        val repository = ShoppingRepository(database)
        val factory = ShopingViewModelProviderFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingListItem.layoutManager = LinearLayoutManager(this)
        rvShoppingListItem.adapter = adapter

        viewModel.getALlShoppingItem().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener{
            AddShoppingItemDialog(this, object : AddDialogListener{
                override fun onAddButton(item: ShoppingItems) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }

}
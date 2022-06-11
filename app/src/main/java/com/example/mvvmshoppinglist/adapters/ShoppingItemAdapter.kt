package com.example.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_items.view.*

class ShoppingItemAdapter (
    var items: List<ShoppingItems>,
    private val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_items,parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]
        holder.itemView.apply {
            tvName.text = curShoppingItem.name
            tvAmount.text = "${curShoppingItem.amount}"
            ivDelete.setOnClickListener {
                viewModel.delete(curShoppingItem)
            }
            ivPlus.setOnClickListener {
                curShoppingItem.amount++
                viewModel.upsert(curShoppingItem)
            }
            ivMinus.setOnClickListener {
                if(curShoppingItem.amount > 0){
                    curShoppingItem.amount--
                    viewModel.upsert(curShoppingItem)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

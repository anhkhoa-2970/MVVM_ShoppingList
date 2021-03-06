package com.example.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItems
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context : Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = edtName.text.toString()
            val amount = edtAmount.text.toString()
            if(name.isEmpty() ||  amount.isEmpty()){
                Toast.makeText(context, " Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItems(name, amount.toInt())
            addDialogListener.onAddButton(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}
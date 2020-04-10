package com.example.recyclerviewtask

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewtask.MyRecyclerViewAdapter.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*


abstract class MainActivity : AppCompatActivity(), ItemClickListener {
    var adapter: MyRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // data to populate the RecyclerView with
        val animalNames: ArrayList<String> = ArrayList()
        ShoppingList.add("Grocery")
        ShoppingList.add("Shoes")
        ShoppingList.add("Dresses")
        ShoppingList.add("Makeup")
        ShoppingList.add("Goat")

        // set up the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rvAnimals)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        adapter = MyRecyclerViewAdapter(this, animalNames)
        adapter!!.setClickListener(this)
        recyclerView.setAdapter(adapter)
    }

    fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter!!.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
    }
}
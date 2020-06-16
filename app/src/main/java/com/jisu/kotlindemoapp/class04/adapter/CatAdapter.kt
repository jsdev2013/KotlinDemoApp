package com.jisu.kotlindemoapp.class04.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.entity.Cat

class CatAdapter(val context: Context, val cats: List<Cat>, val itemClick: (Cat) -> Unit) : RecyclerView.Adapter<CatAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_class04_db_room_recycler_view_item_cat, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return cats.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(cats[position])
    }

    inner class Holder(itemView: View?, itemClick: (Cat) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
        val nameTv = itemView?.findViewById<TextView>(R.id.itemName)
        val lifeTv = itemView?.findViewById<TextView>(R.id.itemLifeSpan)
        val originTv = itemView?.findViewById<TextView>(R.id.itemOrigin)

        fun bind(cat: Cat) {
            nameTv?.text = cat.catName
            lifeTv?.text = cat.lifeSpan.toString()
            originTv?.text = cat.origin

            // recyclerview item click 시 발생하는 이벤트
            itemView.setOnClickListener { itemClick(cat) }
        }
    }
}
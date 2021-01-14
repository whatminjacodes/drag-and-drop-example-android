package com.minjee.stretchingapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minjee.stretchingapp.databinding.RecyclerviewItemRowBinding
import com.minjee.stretchingapp.model.ListData

class RecyclerViewAdapter(private val items: ListData) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StretchMoveHolder {
        val binding = RecyclerviewItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StretchMoveHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder.viewBinding.itemName.text = items.listOfMoves[position].nameOfTheMove
        val itemViewHolder = holder as StretchMoveHolder
        holder.viewBinding.itemName.text = "asdasdads"
        holder.itemView.setOnClickListener {
            Log.d("Recyclerview", "CLICK!")
        }
    }

    override fun getItemCount() = items.listOfMoves.size

    inner class StretchMoveHolder(var viewBinding: RecyclerviewItemRowBinding) : RecyclerView.ViewHolder(viewBinding.root)
}

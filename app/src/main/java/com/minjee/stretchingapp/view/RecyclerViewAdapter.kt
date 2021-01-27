package com.minjee.stretchingapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minjee.stretchingapp.databinding.RecyclerviewItemRowBinding
import com.minjee.stretchingapp.model.ListData
import com.minjee.stretchingapp.model.StretchMove

class RecyclerViewAdapter(private val items: ListData, private val clickListener: (StretchMove) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerviewItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StretchMoveHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StretchMoveHolder).bind(items.listOfMoves[position], clickListener)
    }

    override fun getItemCount() = items.listOfMoves.size

    inner class StretchMoveHolder(private val binding: RecyclerviewItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(move: StretchMove, clickListener: (StretchMove) -> Unit) {
            binding.itemName.text = move.nameOfTheMove
            binding.root.setOnClickListener { clickListener(move) }
        }
    }
}

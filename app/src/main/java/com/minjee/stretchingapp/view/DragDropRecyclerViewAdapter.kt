package com.minjee.stretchingapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minjee.stretchingapp.R
import com.minjee.stretchingapp.databinding.LayoutRecyclerviewItemBinding
import com.minjee.stretchingapp.databinding.RecyclerviewItemRowBinding
import com.minjee.stretchingapp.model.ListData
import com.minjee.stretchingapp.model.StretchMove
import com.minjee.stretchingapp.utils.ItemMoveCallbackListener
import java.util.*
import kotlin.math.log

class DragDropRecyclerViewAdapter(private val startDragListener: OnStartDragListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ItemMoveCallbackListener.Listener
{

    private val dragListener = startDragListener
    private var users = emptyList<String>().toMutableList()
    fun setUsers(newUsers: List<String>) {
        users.addAll(newUsers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       // val binding = RecyclerviewItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding = LayoutRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StretchMoveHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       // (holder as StretchMoveHolder).bind(items.listOfMoves[position], clickListener)
        val user = users[position]
        (holder as StretchMoveHolder).bind(user)

    }

    override fun getItemCount() = users.size

    inner class StretchMoveHolder(private val binding: LayoutRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //fun bind(move: StretchMove, clickListener: (StretchMove) -> Unit) {
        fun bind(text: String) {
            //binding.itemName.text = move.nameOfTheMove
            //binding.root.setOnClickListener { clickListener(move) }

            binding.textView.text = text

            binding.imageView.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    //this.startDragListener.onStartDrag(holder)
                    dragListener.onStartDrag(this)
                }
                return@setOnTouchListener true
            }
        }
    }


   // override fun getItemCount(): Int {
   //     return users.size
   // }

   /* override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        holder.itemView.imageView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                this.startDragListener.onStartDrag(holder)
            }
            return@setOnTouchListener true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.textView.text = text

        }
    }*/

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(users, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(users, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(itemViewHolder: StretchMoveHolder) {
        Log.d("recyclerviewadapter", "row selected")
    }

    override fun onRowClear(itemViewHolder: StretchMoveHolder) {
        Log.d("recyclerviewadapter", "row cleared")
    }

    interface OnStartDragListener {
        fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
    }

}
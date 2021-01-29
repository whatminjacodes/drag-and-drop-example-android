package com.minjee.stretchingapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minjee.stretchingapp.databinding.FragmentMainBinding
import com.minjee.stretchingapp.model.StretchMove
import com.minjee.stretchingapp.utils.ItemMoveCallbackListener
import com.minjee.stretchingapp.viewmodel.MainViewModel

/*
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment : Fragment(), DragDropRecyclerViewAdapter.OnStartDragListener {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var touchHelper: ItemTouchHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    lateinit var adapter: DragDropRecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initializeListOfMoves()
        binding.listener = ClickHandler()

       // adapter = DragDropRecyclerViewAdapter(this)

        adapter =
            DragDropRecyclerViewAdapter(this) { stretchMove: StretchMove ->
                moveListItemClicked(
                    stretchMove
                )
            }
        adapter.setMoves(viewModel.getListOfMoves())

        linearLayoutManager = LinearLayoutManager(context)
        binding.apply {
            recyclerView.layoutManager = linearLayoutManager

            adapter.setMoves(viewModel.getListOfMoves())
            val callback: ItemTouchHelper.Callback = ItemMoveCallbackListener(adapter)
            touchHelper = ItemTouchHelper(callback)
            touchHelper.attachToRecyclerView(recyclerView)

            recyclerView.adapter = adapter
            invalidateAll()
        }
    }

    private fun moveListItemClicked(stretchMove: StretchMove) {
        Log.d("main fragment: ", "CLICK!")
        binding.blockClicksView.visibility = View.VISIBLE
        binding.cardParent.visibility = View.VISIBLE
        binding.cardMoveName.text = stretchMove.nameOfTheMove
        binding.cardMoveDescription.text = stretchMove.descriptionOfTheMove

    }

    inner class ClickHandler {
        fun onCardCloseButtonClicked(view: View) {
            Log.d("main fragment", "close button CLICK")
            binding.cardParent.visibility = View.GONE
            binding.blockClicksView.visibility = View.GONE
        }
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        touchHelper.startDrag(viewHolder)
    }
}


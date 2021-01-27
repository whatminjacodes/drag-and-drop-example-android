package com.minjee.stretchingapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjee.stretchingapp.databinding.FragmentMainBinding
import com.minjee.stretchingapp.model.StretchMove
import com.minjee.stretchingapp.viewmodel.MainViewModel

/*
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initializeListOfMoves()
        binding.listener = ClickHandler()

        linearLayoutManager = LinearLayoutManager(context)
        binding.apply {
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.adapter =
                RecyclerViewAdapter(viewModel.getListOfMoves()) { stretchMove: StretchMove ->
                    moveListItemClicked(
                        stretchMove
                    )
                }
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
}


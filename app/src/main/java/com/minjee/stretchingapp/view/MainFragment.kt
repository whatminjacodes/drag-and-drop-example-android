package com.minjee.stretchingapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjee.stretchingapp.databinding.FragmentMainBinding
import com.minjee.stretchingapp.viewmodel.MainViewModel

/*
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    // Create a viewModel
    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        //binding.imageAddFood.setOnClickListener {
          //  println("The CLICK###")
        //}
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Start setups
        setupClickListeners()
        viewModel.initializeListOfMoves()

        // Recyclerview setup
        linearLayoutManager = LinearLayoutManager(context)
        binding.apply {
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.adapter = RecyclerViewAdapter(viewModel.getListOfMoves())
            invalidateAll()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    // Setup the button in our fragment to call getUpdatedText method in viewModel
    private fun setupClickListeners() {

    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {

    }
}
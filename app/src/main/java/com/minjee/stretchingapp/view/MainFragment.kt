package com.minjee.stretchingapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjee.stretchingapp.databinding.FragmentMainBinding
import com.minjee.stretchingapp.viewmodel.MainViewModel

/*
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment: Fragment() {

    // View Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    // Create a viewModel
    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // This is needed for view binding
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        viewModel.initializeListOfMoves()

        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerViewAdapter(viewModel.getListOfMoves())

        //fragmentTextUpdateObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Setup the button in our fragment to call getUpdatedText method in viewModel
    private fun setupClickListeners() {
       //binding.fragmentButton.setOnClickListener { viewModel.getUpdatedText() }
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {
        //viewModel.uiTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            //binding.fragmentTextView.text = updatedText
        //})
    }
}
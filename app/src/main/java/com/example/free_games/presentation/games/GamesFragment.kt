package com.example.free_games.presentation.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.free_games.R
import com.example.free_games.databinding.FragmentGamesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamesFragment : Fragment() {
    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GamesViewModel>()
    private val adapter = GameAdapter { id ->
        GameDetailFragment.gameId = id
        findNavController().navigate(R.id.to_game_detail)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) { forecast ->
            adapter.submitList(forecast)
        }
    }

    private fun initRecyclerView() {
        binding.gameRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.gameRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
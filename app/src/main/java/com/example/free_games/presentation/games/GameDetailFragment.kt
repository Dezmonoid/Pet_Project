package com.example.free_games.presentation.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.free_games.R
import com.example.free_games.databinding.FragmentGameDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailFragment : Fragment() {

    companion object {
        var gameId = 0
    }

    private val adapter = GameDetailAdapter()
    private var _binding: FragmentGameDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GamesDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) { detail ->
            Glide
                .with(binding.gameImage)
                .load(detail.thumbnail)
                .into(binding.gameImage)
            binding.gameName.text = detail.title
            binding.gameType.text = detail.genre
            binding.gameStatus.text = detail.status
            binding.gameDescription.text = detail.description
            binding.gamePublisher.text =
                binding.root.context.getString(R.string.publisher, detail.publisher)
            binding.gameDeveloper.text =
                binding.root.context.getString(R.string.developer, detail.developer)
            binding.gameReleaseDate.text =
                binding.root.context.getString(R.string.release_date, detail.releaseDate)
            binding.gameSystemOs.text = binding.root.context.getString(R.string.os, detail.os)
            binding.gameSystemProcessor.text =
                binding.root.context.getString(R.string.processor, detail.processor)
            binding.gameSystemMemory.text =
                binding.root.context.getString(R.string.memory, detail.memory)
            binding.gameSystemGraphics.text =
                binding.root.context.getString(R.string.graphics, detail.graphics)
            binding.gameSystemStorage.text =
                binding.root.context.getString(R.string.storage, detail.storage)
            binding.gameLink.text = detail.gameUrl
            adapter.submitList(detail.screenshots)
        }
    }

    private fun initRecyclerView() {
        binding.gameDetailScreenshots.layoutManager = LinearLayoutManager(binding.root.context)
        binding.gameDetailScreenshots.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
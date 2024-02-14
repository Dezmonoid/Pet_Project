package com.example.free_games.presentation.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.free_games.databinding.GameItemBinding
import com.example.free_games.domain.model.Game

class GameAdapter(
    private val onItemClick: (id: Int) -> Unit
) : ListAdapter<Game, GameViewHolder>(GameItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding =
            GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position),onItemClick)
    }

}

class GameViewHolder(private val binding: GameItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(game: Game,onItemClick: (id: Int) -> Unit) {
        Glide
            .with(itemView)
            .load(game.image)
            .into(binding.gameImage)
        binding.gameName.text = game.name
        binding.gameDate.text = game.releaseDate
        binding.gamePlatform.text = game.platform
        binding.gameCompany.text = game.developer
        binding.gameImage.setOnClickListener {
            onItemClick(game.id)
        }

    }
}

class GameItemDiffCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(
        oldItem: Game,
        newItem: Game
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Game,
        newItem: Game
    ): Boolean {
        return oldItem == newItem
    }
}
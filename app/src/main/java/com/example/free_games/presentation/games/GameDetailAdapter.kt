package com.example.free_games.presentation.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.free_games.databinding.ScreenshotItemBinding
import com.example.free_games.domain.model.GameDetail

class GameDetailAdapter() :
    ListAdapter<GameDetail.Screenshot, ScreenshotViewHolder>(ScreenshotItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        val binding =
            ScreenshotItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScreenshotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ScreenshotViewHolder(private val binding: ScreenshotItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(game: GameDetail.Screenshot) {
        Glide
            .with(itemView)
            .load(game.image)
            .into(binding.screenshotImage)
    }
}

class ScreenshotItemDiffCallback : DiffUtil.ItemCallback<GameDetail.Screenshot>() {
    override fun areItemsTheSame(
        oldItem: GameDetail.Screenshot,
        newItem: GameDetail.Screenshot
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: GameDetail.Screenshot,
        newItem: GameDetail.Screenshot
    ): Boolean {
        return oldItem == newItem
    }
}
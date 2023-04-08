package com.lukman.madesubmission.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lukman.madesubmission.core.R
import com.lukman.madesubmission.core.databinding.ItemListGameBinding
import com.lukman.madesubmission.core.domain.model.Game
import java.util.ArrayList

class GameAdapter: RecyclerView.Adapter<GameAdapter.ListViewHolder>() {
    var onItemClick: ((Game) -> Unit)? = null

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListGameBinding.bind(itemView)
        fun bind(data: Game) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.background_image)
                    .into(gameImage)
                tvGamename.text = data.name
            }

            binding.root.setOnClickListener {
                onItemClick?.invoke(data)
            }
        }


//        init {
//            binding.root.setOnClickListener {
//                onItemClick?.invoke(listData[adapterPosition])
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_game, parent, false))

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.bind(data)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Game>(){
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.gameId == newItem.gameId
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.gameId == newItem.gameId
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
}
package com.lukman.madesubmission.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.lukman.madesubmission.R
import com.lukman.madesubmission.core.domain.model.Game
import com.lukman.madesubmission.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    private val detailGameViewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailGame(detailGame)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetailGame(detailGame: Game?) {
        detailGame?.let {
            binding.tvGamename.text = detailGame.name
            binding.tvGamereleased.text = detailGame.released
            binding.tvRating.text = "${detailGame.rating}/${detailGame.rating_top}"
            Glide.with(this@DetailActivity)
                .load(detailGame.background_image)
                .into(binding.ivGameimage)

            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGameViewModel.setFavoriteGame(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite_border_24))
        }
    }
}
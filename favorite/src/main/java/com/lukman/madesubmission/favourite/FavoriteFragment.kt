package com.lukman.madesubmission.favourite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukman.madesubmission.core.ui.GameAdapter
import com.lukman.madesubmission.favourite.databinding.FragmentFavoriteBinding
import com.lukman.madesubmission.detail.DetailActivity
import com.lukman.madesubmission.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteFragment : Fragment() {

  @Inject
  lateinit var factory: ViewModelFactory

  private val favoriteViewModel: FavouriteViewModel by viewModels {
    factory
  }

  private var _binding: FragmentFavoriteBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    DaggerFavoriteComponent.builder()
      .context(requireContext())
      .appDependencies(
        EntryPointAccessors.fromApplication(
          requireContext(),
          FavoriteModuleDependencies::class.java
        )
      )
      .build()
      .inject(this)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    if (activity != null) {

      val gameAdapter = GameAdapter()
      gameAdapter.onItemClick = { selectedData ->
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
        startActivity(intent)
      }

      favoriteViewModel.favoriteGame.observe(viewLifecycleOwner) { dataGame ->
        gameAdapter.differ.submitList(dataGame)
        binding.viewEmpty.root.visibility =
          if (dataGame.isNotEmpty()) View.GONE else View.VISIBLE
      }

      with(binding.rvGame) {
        layoutManager = LinearLayoutManager(context)
        setHasFixedSize(true)
        adapter = gameAdapter
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}